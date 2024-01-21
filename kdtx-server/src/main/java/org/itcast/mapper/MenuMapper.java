package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.MenuSelectDTO;
import org.itcast.entity.Menu;
import org.itcast.vo.MenuListVO;
import org.itcast.vo.MenuVO;

@Mapper
public interface MenuMapper {


    Page<MenuListVO> listMenu(MenuSelectDTO dto);

    MenuVO getMenuById(Long menuId);

    void addMenu(Menu menu);
}
