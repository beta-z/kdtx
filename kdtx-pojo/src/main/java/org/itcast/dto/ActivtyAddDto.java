package org.itcast.dto;

import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivtyAddDto {
    private String name;
    private Character channel;
    private String info;
    private Character type;
    private Double discount;
    private Double vouchers;
    private Character status = '0';
    private String beginTime;
    private String endTime;
    private String code;

    //生成随机活动编号
    public static String generationCode(){
        String code = RandomUtil.randomString(8);
        return code;
    }

}


