package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO{

    private Integer code; //编码：200成功，0和其它数字为失败
    private String msg; //错误信息
    private String  token;


}
