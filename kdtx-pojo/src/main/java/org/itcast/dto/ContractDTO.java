package org.itcast.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContractDTO {

    private String id;

    private String contractNo;

    private String phone;

    private String name;

    private String subject;

    private String channel;

    private Long activityId;

    private Long courseId;

    private String status;

    private String fileName;

    private float coursePrice;

    private String discountType;

    private float order;

    // "yyyy-MM-dd HH:mm:ss"
    private Date finishTime;

    private Long businessId;

    private Long deptId;



}
