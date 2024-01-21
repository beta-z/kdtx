package com.sky.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.vo.ActivitJia;
import org.itcast.vo.ActivityVo;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActityPageResult {
    private Long total;
    private List<ActivityVo> rows;

    private Integer code;
    private String msg;

    private List<ActivitJia> params;
}