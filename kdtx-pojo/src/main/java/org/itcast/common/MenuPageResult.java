package org.itcast.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPageResult implements Serializable {

    private Integer code;

    private String msg;
    private long total; //总记录数

    private List data; //当前页数据集合

}
