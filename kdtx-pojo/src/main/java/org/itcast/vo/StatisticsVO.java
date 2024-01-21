// ApifoxModel.java

package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.MapObject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 表格分页数据对象
 * <p>
 * TableDataInfo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    private Map<String,Object> params;


}

