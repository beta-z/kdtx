package org.itcast.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Business {


    private Long id;    // 商机id
    private String name;    // 客户姓名
    private String phone;   // 手机号
    private String channel;   // 渠道
    private Long activityId;   // 活动id
    private String provinces;   // 省
    private String city;    // 城市
    private String sex; // 性别
    private Integer age;    // 年龄
    private String weixin;    // 微信
    private String qq;    // qq
    private String level;    // 意向等级
    private String subject;    // 意向学科
    private Long courseId;  // 课程
    private String createBy;    // 创建人
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;    // 创建时间
    private String occupation;    // 职业
    private String education;    // 学历
    private String job;    // 在职情况
    private String salary;  // 当前薪资
    private String major; // 专业
    private String expectedSalary; // 目标薪资
    private String reasons; // 学习原因
    private String plan;    // 职业计划
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planTime;     // 时间计划
    private String otherIntention;  // 其他意向
    private String status;  // 状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateTime; // 最后更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime; // 回收时间
    private String remark;  // 备注
    private String transfer;  // 是否转派
    private String clueId;  // 线索
    private String owner;   // 归属人
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ownerTime;   // 归属时间
    private String keyItems;    // 沟通重点
    private String record;  // 沟通纪要
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime nextTime; // 下次跟进时间
    private String trackStatus; // 跟进状态
}
