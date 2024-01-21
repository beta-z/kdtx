package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.common.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDTO extends Entity {
    /**
     * 活动信息
     */
    private String activityId;
    private String businessId;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 课程id
     */
    private String courseId;
    /**
     * 课程价格
     */
    private String coursePrice;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String deptId;
    /**
     * 活动折扣类型
     */
    private String discountType;
    /**
     * 文件名称
     */
    private String fileName;
    private String finishTime;
    /**
     * 合同id
     */
    private String id;
    /**
     * 客户姓名
     */
    private String name;
    private String order;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 状态(待审核0，已完成1，已驳回2)
     */
    private String status;
    /**
     * 意向学科
     */
    private String subject;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */

    private Integer pageNum;
    private Integer pageSize;


}
