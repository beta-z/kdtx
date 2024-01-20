package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageDTO {

    private Integer pageNum;
    private Integer pageSize;

    //用户名称
    private String userName;
    //手机号
    private String phonenumber;
    //状态
    private String status;
    //创建时间-起始
    private LocalDateTime begin;
    //创建时间-截止
    private LocalDateTime end;
    //部门id
    private Long deptId;





}
