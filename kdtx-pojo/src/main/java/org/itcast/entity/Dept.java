package org.itcast.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    //创建人
    private String createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //部门id
    private Long deptId;
    //父部门id
    private Integer parentId;
    //祖级列表
    private String ancestors;
    //部门名称
    private String deptName;
    //显示顺序
    private String orderNum;
    //负责人
    private String leader;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //状态
    private String status; //0正常，1停用
    //删除标志
    private String delFlag; //0存在，2删除
    //该部门用户
    private List<User> users;
    //子部门
    private List<Dept> children;

}
