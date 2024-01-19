package org.itcast.dto;

import lombok.Data;

@Data
public class PageQueryDTO {
    //页码
    private int page;

    //每页记录数
    private int pageSize;
}
