package org.itcast.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ActivityVo {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;


    /**
     * id
     */
    private Long id;

    //编码
    private String code;

    private String name;

    /**
     * 渠道来源
     */

    private String channel;

    /**
     * 活动简介
     */
    private String info;

    /**
     * 活动类型
     */

    private String type;

    /**
     * 课程折扣
     */

    private Float discount;

    /**
     * 课程代金券
     */

    //private Integer vouchers;

    private String status;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

}
