package org.itcast.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateRecordVO {
    private Long id;
    private String level;
    private String subject;
    private String falseReason;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime nextTime;
    private String createBy;
    private String record;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
