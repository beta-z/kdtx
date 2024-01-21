package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.CluePageResult;
import org.itcast.common.MenuPageResult;
import org.itcast.common.Result;
import org.itcast.dto.AddMenuDTO;
import org.itcast.dto.MenuSelectDTO;
import org.itcast.entity.Menu;
import org.itcast.mapper.MenuMapper;
import org.itcast.service.MenuService;
import org.itcast.vo.MenuListVO;
import org.itcast.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {


    @Autowired
    private MenuMapper menuMapper;
    @Override
    public MenuPageResult listMenu(MenuSelectDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<MenuListVO> page = menuMapper.listMenu(dto);
        return  new MenuPageResult(200," ",page.getTotal(),page.getResult());
    }

    @Override
    public Result getMenu(Long menuId) {
        MenuVO vo = menuMapper.getMenuById(menuId);
        return Result.success(vo);
    }

    @Override
    public Result addMenu(AddMenuDTO dto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(dto,menu);
        menuMapper.addMenu(menu);
        return Result.success();
    }


}
