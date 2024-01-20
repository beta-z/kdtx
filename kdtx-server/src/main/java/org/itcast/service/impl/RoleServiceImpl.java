package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.entity.Role;
import org.itcast.exception.ParamsIllegalException;
import org.itcast.mapper.RoleMapper;
import org.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResult list(RolePageDTO dto) {
        if (dto == null) {
            throw new ParamsIllegalException("查询角色列表时参数异常");
        }

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<Role> page = roleMapper.list(dto);
        return PageResult.success(page.getTotal(),page.getResult());



    }

    @Override
    public Result getRole(Long roleId) {
        if (roleId == null){
            throw new ParamsIllegalException("查询角色详细时参数异常");
        }
        Role role = roleMapper.getRole(roleId);
        return Result.success(role);
    }
}
