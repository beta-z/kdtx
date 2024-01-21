package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    private Long menuId;
    private Long parentId;
    private String menuName;
    private String icon;
    private String menuType;
    private Integer orderNum;
    private String isFrame;
    private String isCache;
    private String visible;
    private String status;
}
