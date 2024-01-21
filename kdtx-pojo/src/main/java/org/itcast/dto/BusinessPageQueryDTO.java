package org.itcast.dto;

import lombok.Data;


import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class BusinessPageQueryDTO {

    private int pageNum = 1;
    private int pageSize = 10;
    private Long id;    // 商机id
    private String name;    // 客户姓名
    private String phone;   // 手机号
    private String owner;    // 创建人
    private String status;  // 跟进状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
