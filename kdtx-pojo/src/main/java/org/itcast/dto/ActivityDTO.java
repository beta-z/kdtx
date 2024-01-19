package org.itcast.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityDTO implements Serializable {


    private Long id;

    //渠道
    private String channel;

    //活动名称
    private String name;

    //详情
    private String info;

    //类型
    private String type;

    //折扣
    private Float discount;

    //
    private Integer vouchers;

    //开始时间
    private Data beginTime;

    //结束时间
    private Data endTime;



}
