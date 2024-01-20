package org.itcast.service;

import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RolePageDTO;

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
}
