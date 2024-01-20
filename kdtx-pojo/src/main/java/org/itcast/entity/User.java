package org.itcast.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //更新人
    private String updateBy;
    //更新时间
    private LocalDateTime updateTime;
    //创建人
    private String createBy;
    //创建时间
    private LocalDateTime createTime;
    //用户id
    private Long userId;
    //部门id
    private Long deptId;
    //用户名称
    private String userName;
    //用户昵称
    private String nickName;
    //邮箱
    private String email;
    //手机号号码
    private String phonenumber;
    //性别
    private String sex;
    //头像地址
    private String avatar;
    //状态
    private String status;
    //删除标志
    private String delFlag;
    //登录ip
    private String loginIp;
    //登陆时间
    private LocalDateTime loginDate;
    //备注
    private String remark;
    //密码
    private String password;
    //部门
    private Dept dept;
    //角色
    private Role role;
    //是否是超级管理员
    private final Boolean admin = true;
}
