package org.itcast.entity;

import java.util.Date;

public class Contract {
    /**
     * 线索id
     */
    private Long id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动名称
     */
    private String activityInfo;

    /**
     * 1 男 0 女
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 微信
     */
    private String weixin;

    /**
     * qq
     */
    private String qq;

    /**
     * 意向等级
     */
    private String level;

    /**
     * 意向学科
     */
    private String subject;

    /**
     * 状态(已分配1  进行中2  回收3  伪线索4)
     */
    private String status;

    /**
     * 分配人
     */
    private String assignBy;

    /**
     * 分配时间
     */

    private Date assignTime;

    /**
     * 所属人
     */
    private String owner;

    private Date ownerTime;


    /**
     * 伪线索失败次数(最大数3次)
     */
    private int falseCount;

    /**
     * 下次跟进时间
     */
    private Date nextTime;

    private Date endTime;

    /**
     * 创建人id
     */
    private Long userId;

    private String createTimeStr;

    private String transfer; //是否转派 默认0
}
