package org.itcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowClueDTO {
    private Long id;
    private Long clueId;
    private String name;
    private Integer sex;
    private Integer age;
    private String weixin;
    private String qq;
    private Integer level;
    private String subject;
    private String record;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime nextTime;

}
