package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMenuDTO {
    private String icon;
    private String isCache;
    private String isFrame;
    private String menuName;
    private String menuType;
    private Integer orderName;
    private Long parentId;
    private String path;
    private String status;
    private String visible;

}
