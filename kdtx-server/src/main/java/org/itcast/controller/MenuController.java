package org.itcast.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.itcast.common.CluePageResult;
import org.itcast.common.MenuPageResult;
import org.itcast.common.Result;
import org.itcast.dto.AddMenuDTO;
import org.itcast.dto.MenuSelectDTO;
import org.itcast.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/menu")
@Api("菜单相关接口")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @ApiOperation("查询菜单列表")
    public MenuPageResult listMenu(MenuSelectDTO dto) {
        return menuService.listMenu(dto);
    }

    @GetMapping("/{menuId}")
    @ApiOperation("查询菜单详情")
    public Result getMenu(@PathVariable Long menuId){
        return menuService.getMenu(menuId);
    }



    @PostMapping()
    @ApiOperation("新增菜单")
    public Result addMenu(@RequestBody AddMenuDTO dto){
      return   menuService.addMenu(dto);
    }



}
