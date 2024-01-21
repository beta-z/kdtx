package org.itcast.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName
public class TbActivity implements Serializable {

    @TableId
    private Long id;

    private String channel;

    private String name;

    private String info;

    private String type;

    private Float discount;

    private Integer vouchers;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime endTime;

    private Integer code;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime createTime;

}
