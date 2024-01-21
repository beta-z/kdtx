package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.Result;
import org.itcast.dto.dept.DeptAddDTO;
import org.itcast.dto.dept.DeptPageDTO;
import org.itcast.entity.Dept;
import org.itcast.entity.User;
import org.itcast.exception.ParamsIllegalException;
import org.itcast.mapper.DeptMapper;
import org.itcast.mapper.UserMapper;
import org.itcast.service.DeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result list(DeptPageDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("查询部门列表时参数异常");
        }

        Page<Dept> page = deptMapper.list(dto);
        for (Dept dept : page) {
            List<User> users = userMapper.getUser(dept.getDeptId());
            dept.setUsers(users);
            List<Dept> depts = deptMapper.getDept(dept.getDeptId());
            dept.setChildren(depts);
        }
        return Result.success(page);
    }

    @Override
    public Result listExclude(Long deptId) {
        if (deptId == null){
            throw new ParamsIllegalException("查询部门列表（排除节点）时参数异常");
        }
        List<Dept> list = deptMapper.getDeptParent(deptId);
        for (Dept dept : list) {
            List<User> users = userMapper.getUser(deptId);
            dept.setUsers(users);
            List<Dept> depts = deptMapper.getDeptParent(deptId);
            dept.setChildren(depts);
        }
        return Result.success(list);
    }

    @Override
    public Result getDept(Long deptId) {
        if (deptId == null){
            throw new ParamsIllegalException("查询部门详细时参数异常");
        }
        List<Dept> dept = deptMapper.getDept(deptId);
        return Result.success(dept.get(0));
    }

    @Override
    public Result addDept(DeptAddDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("新增用户时参数异常");
        }

        Dept dept = new Dept();
        BeanUtils.copyProperties(dto,dept);
        //todo 当前用户
        dept.setCreateBy("admin");
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
        return Result.success();

    }

    @Override
    public Result updateDept(Dept dept) {
        if (dept == null){
            throw new ParamsIllegalException("修改部门时参数异常");
        }
        //todo
        dept.setUpdateBy("admin");
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);

        return Result.success();

    }
}
