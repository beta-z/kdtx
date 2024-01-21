package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryDTO {
    //页码
    private int pageNum;

    //每页记录数
    private int pageSize;

    private String code;

    private String channel;

    private Map<String,Object> params;
}
