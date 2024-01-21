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
public class BusinessFollow {

    private Long id;    // 沟通记录id
    private Long businessId;    // 商机id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime nextTime; // 跟进时间
    private String keyItems; // 沟通重点
    private String record; // 沟通纪要
    private String trackStatus; // 跟进状态
    private String owner;   // 跟进人
}
