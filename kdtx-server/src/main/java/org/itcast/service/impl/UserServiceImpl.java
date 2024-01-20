package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.NewResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.UserDTO;
import org.itcast.dto.UserPageDTO;
import org.itcast.dto.UserUpdatePasswordDTO;
import org.itcast.entity.Post;
import org.itcast.entity.Role;
import org.itcast.entity.User;
import org.itcast.exception.ParamsIllegalException;
import org.itcast.mapper.PostMapper;
import org.itcast.mapper.RoleMapper;
import org.itcast.mapper.UserMapper;
import org.itcast.service.UserService;
import org.itcast.vo.UserListSelectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    public PageResult list(UserPageDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("查询用户列表时参数异常");
        }
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<User> page = userMapper.list(dto);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Result listselect(Long deptId) {
        if (deptId == null){
            throw new ParamsIllegalException("获取用户下拉列表时参数异常");
        }

        List<UserListSelectVO> list  = userMapper.listSelect(deptId);

        return Result.success(list);
    }

    @Override
    public NewResult getUserId(Long userId) {
        if (userId == null){
            throw new ParamsIllegalException("查询用户详细时参数异常");
        }
        User user = userMapper.getUserId(userId);
        List<Long> postIds = postMapper.getPostIds(userId);
        List<Post> posts = postMapper.list();
        List<Role> roles = roleMapper.list();
        List<Long> roleIds = roleMapper.getRoleIds(userId);
        return NewResult.success(user,roleIds,postIds,roles,posts);

    }

    @Override
    @Transactional
    public Result addUser(UserDTO dto) {

        if (dto == null){
            throw new ParamsIllegalException("新增用户时参数异常");
        }

        User user = new User();
        BeanUtils.copyProperties(dto,user);
        //todo 需要获取当前登录用户，暂时使用假数据
        user.setCreateBy("admin");
        user.setCreateTime(LocalDateTime.now());
        userMapper.addUser(user);
        Long userId = user.getUserId();
        userMapper.addUserRole(userId,dto.getRoleIds());
        userMapper.addUserPost(userId,dto.getPostIds());


        return null;
    }

    @Override
    @Transactional
    public Result updateUser(UserDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改数据时参数异常");
        }
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        //todo 需要获取当前用户，暂时使用假数据
        user.setUpdateBy("admin");
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(user);
        userMapper.delectUserRoles(dto.getUserId());
        if (dto.getRoleIds() != null){
            userMapper.addUserRole(dto.getUserId(),dto.getRoleIds());
        }
        userMapper.delectUserPosts(dto.getUserId());
        if (dto.getPostIds() !=null){
            userMapper.addUserPost(dto.getUserId(),dto.getPostIds());
        }
        return Result.success();
    }

    @Override
    @Transactional
    public Result deleteUser(Long userId) {
        if (userId == null){
            throw new ParamsIllegalException("删除用户时参数异常");
        }
        userMapper.deleteUser(userId);
        userMapper.delectUserPosts(userId);
        userMapper.delectUserRoles(userId);

        return Result.success();
    }

    @Override
    public Result updatePwd(UserUpdatePasswordDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改用户密码时参数异常");
        }
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        userMapper.updateUser(user);
        return Result.success();
    }
}
