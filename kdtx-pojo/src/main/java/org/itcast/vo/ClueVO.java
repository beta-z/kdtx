package org.itcast.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClueVO {
    private String createBy;
    private Long id;
    private String name;
    private String phone;
    private String channel;
    private Integer activityId;
    private String weixin;
    private String qq;
    private String level;
    private String subject;
    private String status;
    private String assignBy;
    private String owner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ownerTime;
    private Integer falseCount;
}
