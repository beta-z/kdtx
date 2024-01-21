package org.itcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Data

public class TransferlistDTO {
    //页码
    private int pageNum = 1;

    //每页记录数
    private int pageSize = 10;

    //用户名
    private String userName ;

    //用户ID
    private Long userId;
    //开始时间集合
    Map<String,Object> params;

    //开始时间
    private Object beginTime ;

    //结束时间
    private Object endTime;


    //电话号码
    private String phonenumber;
}
