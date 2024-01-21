package org.itcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ActivityDto {
    private Integer pageNum = 1;
    private Integer pageSize =10;
    //编码
    private String code;
    private String channel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    private List<LocalDateTime> activityTime;


}
