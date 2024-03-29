package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.itcast.common.AddResult;
import org.itcast.common.NewResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.user.*;
import org.itcast.entity.Post;
import org.itcast.entity.Role;
import org.itcast.entity.User;
import org.itcast.exception.ParamsIllegalException;
import org.itcast.mapper.PostMapper;
import org.itcast.mapper.RoleMapper;
import org.itcast.mapper.UserMapper;
import org.itcast.service.UserService;
import org.itcast.vo.RoleVO;
import org.itcast.vo.UserListSelectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

        return PageResult.success(page.getTotal(),page.getResult());
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
        List<RoleVO> roles = roleMapper.list(null);
        List<Long> roleIds = roleMapper.getRoleIds(userId);
        List<Role> roles1 = new ArrayList<>();
        for (RoleVO roleVO : roles) {
            Role role = new Role();
            try {
                BeanUtils.copyProperties(roleVO,role);
            } catch (Exception e) {
                log.warn("copy时因类型不同出现异常");
            }
            if (roleVO.getMenuCheckStrictly() == 1){
                role.setMenuCheckStrictly(true);
            }else {
                role.setMenuCheckStrictly(false);
            }
            if (roleVO.getDeptCheckStrictly() == 1){
                role.setDeptCheckStrictly(true);
            }
            else {
                role.setDeptCheckStrictly(false);
            }

            roles1.add(role);
        }
        return NewResult.success(user,roleIds,postIds,roles1,posts);

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
        if(dto.getRoleIds() != null && dto.getPostIds().size() != 0){
            userMapper.addUserRole(userId,dto.getRoleIds());
        }
        if (dto.getPostIds() != null && dto.getPostIds().size() !=0){
            userMapper.addUserPost(userId,dto.getPostIds());
        }

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
        if (dto.getRoleIds() != null && dto.getRoleIds().size() != 0){
            userMapper.addUserRole(dto.getUserId(),dto.getRoleIds());
        }
        userMapper.delectUserPosts(dto.getUserId());
        if (dto.getPostIds() !=null && dto.getPostIds().size() != 0){
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
    public Result updatePwd(UserUpdatePwdDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改用户密码时参数异常");
        }
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        userMapper.updateUser(user);
        return Result.success();
    }

    @Override
    public Result updateStatus(UserUpdateStatusDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改用户状态时参数异常");
        }
        User user = new User();
        BeanUtils.copyProperties(dto,user);
        userMapper.updateUser(user);
        return Result.success();

    }

    @Override
    public Result prUpdatePwd(PrUserUpdatePwdDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改密码（个人）时参数异常");
        }
        //todo 获取当前用户id
        Long userId = null;
        User user = userMapper.getUserId(userId);

        if (user.getPassword() != dto.getOldPassword()){
            throw new ParamsIllegalException("旧密码数据错误，请重试");
        }
        user.setPassword(dto.getNewPassword());
        userMapper.updateUser(user);
        return Result.success();
    }

    @Override
    public Result selectProfile() {

        //todo 当前用户id
        Long userId = null;

        User user = userMapper.getUserId(userId);
        //fixme
        return Result.success(user);
    }

    @Override
    public AddResult add() {
        List<RoleVO> roles = roleMapper.list(null);
        List<Role> roles1 = new ArrayList<>();
        for (RoleVO roleVO : roles) {
            Role role = new Role();
            try {
                BeanUtils.copyProperties(roleVO,role);
            } catch (Exception e) {
                log.warn("copy时因类型不同出现异常");
            }
            if (roleVO.getMenuCheckStrictly() == 1){
                role.setMenuCheckStrictly(true);
            }else {
                role.setMenuCheckStrictly(false);
            }
            if (roleVO.getDeptCheckStrictly() == 1){
                role.setDeptCheckStrictly(true);
            }
            else {
                role.setDeptCheckStrictly(false);
            }

            roles1.add(role);
        }
        List<Post> posts = postMapper.list();
        return AddResult.success(roles1,posts);
    }
}
