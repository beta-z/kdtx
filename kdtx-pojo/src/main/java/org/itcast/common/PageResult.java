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
public class PageResult implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息

    private long total; //总记录数
    private List records; //当前页数据集合
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private List rows; //当前页数据集合
    public static PageResult success(Long total,List rows) {
        return new PageResult(200,"查询成功",total,rows);
    }

    public static PageResult success(Long total,List rows) {
        return new PageResult(200,"查询成功",total,rows);
    }

}
