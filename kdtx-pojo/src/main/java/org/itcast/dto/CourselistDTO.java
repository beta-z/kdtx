package org.itcast.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CourselistDTO {
    //页码
    private int page = 1;

    //每页记录数
    private int pageSize = 10;

    //课程编号
    private String code;

    //课程名称
    private String name;

    //开始时间
    Map<String,Object> params;

    private Object beginTime ;

    //结束时间
    private Object endTime;

    //适用人群
    private Long applicablePerson;

    //课程学科
    private Long subject;
}
