package org.itcast.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    private Long beginTime;

    private Long endTime;

}
