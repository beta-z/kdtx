package org.itcast.service;

import org.itcast.common.CluePageResult;
import org.itcast.common.MenuPageResult;
import org.itcast.common.Result;
import org.itcast.dto.AddMenuDTO;
import org.itcast.dto.MenuSelectDTO;

public interface MenuService {
    MenuPageResult listMenu(MenuSelectDTO dto);

    Result getMenu(Long menuId);

    Result addMenu(AddMenuDTO dto);


}
