package org.itcast.controller.role;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("system/role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public PageResult list(RolePageDTO dto){
        log.info("查询角色列表，参数为：{}",dto);
        return roleService.list(dto);
    }

    @GetMapping("{roleId}")
    public Result getRole(@PathVariable Long roleId){
        log.info("查询角色详细，参数为：{}",roleId);
        return roleService.getRole(roleId);
    }




}
