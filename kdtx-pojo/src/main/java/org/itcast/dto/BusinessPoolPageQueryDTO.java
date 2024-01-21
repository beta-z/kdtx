package org.itcast.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class BusinessPoolPageQueryDTO {

    private int pageNum = 1;
    private int pageSize = 10;
    private Long businessId;    // 商机id
    private String name;    // 客户姓名
    private String phone;   // 手机号
    private String subject; // 意向学科
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
