package org.itcast.controller.role;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.itcast.common.AddResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.role.RoleDTO;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.dto.role.RoleUpdateDTO;
import org.itcast.dto.role.RoleUpdateStatusDTO;
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

    @PostMapping
    public Result addRole(@RequestBody RoleDTO dto){
        log.info("新增角色，参数为：{}",dto);
        return roleService.addRole(dto);
    }

    @PutMapping
    public Result updateRole(@RequestBody RoleUpdateDTO dto){
        log.info("修改角色，参数为：{}",dto);
        return roleService.updateRole(dto);
    }

    @PutMapping("/changeStatus")
    public Result updateStatus(@RequestBody RoleUpdateStatusDTO dto){
        log.info("状态修改，参数为：{}",dto);
        return roleService.updateStatus(dto);
    }

    @DeleteMapping("{roleId}")
    public Result delete(@PathVariable Long roleId){
        log.info("删除角色，参数为：{}",roleId);
        roleService.delete(roleId);
        return Result.success();
    }


    @GetMapping("/optionselect")
    public Result optionSelect(){
        log.info("查询角色下拉列表");
       return roleService.optionSelect();
    }




}
