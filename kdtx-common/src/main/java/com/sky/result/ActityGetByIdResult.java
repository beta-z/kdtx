package com.sky.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.vo.ActivityVo;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActityGetByIdResult {
    private String msg;
    private Integer code;
    private ActivityVo data;
}
