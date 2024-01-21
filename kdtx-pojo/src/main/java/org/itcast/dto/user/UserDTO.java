package org.itcast.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Post;
import org.itcast.entity.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

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
    private List<Post> postIds;
    //角色
    private List<Role> roleIds;
    //备注
    private String remark;
}
