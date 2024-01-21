package org.itcast.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Dept;
import org.itcast.entity.Post;
import org.itcast.entity.Role;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    //创建人
    private String createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //删除标志
    private String delFlag;


    private LocalDateTime loginDate;

    private List<Role> roles;

    private Boolean admin = true;

    private Dept dept;

    //更新人
    private String updateBy;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //用户Id
    private Long userId;
    //用户昵称
    private String nickName;
    //归属部门
    private Long deptId;
    //手机号码
    private String phonenumber;
    //邮箱
    private String email;
    //用户名称
    private String userName;
    //用户密码
    private String password;
    //用户性别
    private String sex;
    //状态
    private String status;
    //岗位
    private List<Long> postIds;
    //角色
    private List<Long> roleIds;
    //备注
    private String remark;


}
