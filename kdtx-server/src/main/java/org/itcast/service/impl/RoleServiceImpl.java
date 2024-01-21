package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RoleDTO;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.dto.role.RoleUpdateDTO;
import org.itcast.dto.role.RoleUpdateStatusDTO;
import org.itcast.entity.Role;
import org.itcast.exception.ParamsIllegalException;
import org.itcast.mapper.RoleMapper;
import org.itcast.service.RoleService;
import org.itcast.vo.RoleOptVO;
import org.itcast.vo.RoleUpdateVO;
import org.itcast.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResult list(RolePageDTO dto) {
        if (dto == null) {
            throw new ParamsIllegalException("查询角色列表时参数异常");
        }

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<RoleVO> page = roleMapper.list(dto);
        Page<Role> page1 = new Page<>();
        for (RoleVO roleVO : page) {
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
            page1.add(role);
        }
        return PageResult.success(page1.getTotal(),page1.getResult());



    }

    @Override
    public Result getRole(Long roleId) {
        if (roleId == null){
            throw new ParamsIllegalException("查询角色详细时参数异常");
        }
        RoleVO roleVO = roleMapper.getRole(roleId);
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
        return Result.success(role);
    }

    @Override
    public Result addRole(RoleDTO dto) {
        if(dto == null){
            throw new ParamsIllegalException("新增角色参数异常");
        }
        RoleVO roleVO = new RoleVO();
        try {
            BeanUtils.copyProperties(dto,roleVO);
        } catch (Exception e) {
            log.warn("copy时因类型不同出现异常");
        }
        if (dto.getMenuCheckStrictly() == true){
            roleVO.setMenuCheckStrictly(1);
        }else {
            roleVO.setMenuCheckStrictly(0);
        }
        if (dto.getDeptCheckStrictly() == true){
            roleVO.setDeptCheckStrictly(1);
        }
        else {
            roleVO.setDeptCheckStrictly(0);
        }
        //todo 获取当前用户暂时用假数据
        roleVO.setCreateBy("admin");
        roleVO.setCreateTime(LocalDateTime.now());
        roleMapper.addRole(roleVO);
        return Result.success();
    }

    @Override
    public Result updateRole(RoleUpdateDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("修改角色时参数异常");
        }
        RoleUpdateVO vo = new RoleUpdateVO();
        try {
            BeanUtils.copyProperties(dto,vo);
        } catch (BeansException e) {
            log.warn("copy时因类型不同出现异常");
        }
        if (dto.getMenuCheckStrictly() == true){
            vo.setMenuCheckStrictly(1);
        }else {
            vo.setMenuCheckStrictly(0);
        }
        if (dto.getDeptCheckStrictly() == true){
            vo.setDeptCheckStrictly(1);
        }
        else {
            vo.setDeptCheckStrictly(0);
        }
        //todo 获取当前用户暂用假数据
        vo.setUpdateBy("admin");
        vo.setUpdateTime(LocalDateTime.now());
        roleMapper.updateRole(vo);

        return Result.success();
    }

    @Override
    public Result updateStatus(RoleUpdateStatusDTO dto) {
        if (dto == null){
            throw new ParamsIllegalException("状态修改时参数异常");
        }
        RoleUpdateVO vo = new RoleUpdateVO();
        BeanUtils.copyProperties(dto,vo);
        roleMapper.updateRole(vo);

        return Result.success();
    }

    @Override
    public void delete(Long roleId) {
        if (roleId == null){
            throw new ParamsIllegalException("删除角色时参数异常");
        }
        roleMapper.delete(roleId);

    }

    @Override
    public Result optionSelect() {
        Page<RoleVO> list = roleMapper.list(null);
        List<RoleOptVO> vo = new ArrayList<>();
        for (RoleVO roleVO : list) {
            RoleOptVO roleOptVO = new RoleOptVO();
            roleOptVO.setRoleId(roleVO.getRoleId());
            roleOptVO.setRoleName(roleVO.getRoleName());
            vo.add(roleOptVO);
        }
        return Result.success(vo);
    }

}
