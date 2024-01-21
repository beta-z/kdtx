package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuSelectDTO {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String menuName;
    private String visible;
}
