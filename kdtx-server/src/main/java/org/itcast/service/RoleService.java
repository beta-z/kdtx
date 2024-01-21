package org.itcast.service;

import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RoleDTO;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.dto.role.RoleUpdateDTO;
import org.itcast.dto.role.RoleUpdateStatusDTO;

public interface RoleService {
    /**
     * 查询角色列表
     *
     * @param dto
     * @return
     */
    PageResult list(RolePageDTO dto);

    /**
     * 查询角色详细
     *
     * @param roleId 角色id
     * @return
     */
    Result getRole(Long roleId);

    /**
     * 新增角色
     *
     * @param dto
     * @return
     */
    Result addRole(RoleDTO dto);

    /**
     * 修改角色
     *
     * @param dto
     * @return
     */
    Result updateRole(RoleUpdateDTO dto);

    /**
     * 状态修改
     *
     * @param dto
     * @return
     */
    Result updateStatus(RoleUpdateStatusDTO dto);

    /**
     * 删除数据
     *
     * @param roleId
     */
    void delete(Long roleId);

    /**
     * 查询角色下拉
     *
     * @return
     */
    Result optionSelect();
}
