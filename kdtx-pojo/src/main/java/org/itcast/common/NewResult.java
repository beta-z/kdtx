package org.itcast.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Post;
import org.itcast.entity.Role;
import org.itcast.entity.User;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewResult implements Serializable {
    private Integer code;
    private String msg;
    private User data;
    private List<Long> roleIds; // 角色id
    private List<Long> postIds; //岗位id
    private List<Role> roles; //角色
    private List<Post> posts; //岗位
    public static NewResult success(User user,
                                 List<Long> roleIds,
                                 List<Long> postIds,
                                 List<Role> roles,
                                 List<Post> posts){

        return new NewResult(1,null,user,roleIds,postIds,
                roles,posts);



    }

}
