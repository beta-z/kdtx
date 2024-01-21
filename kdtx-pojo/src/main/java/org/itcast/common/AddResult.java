package org.itcast.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Post;
import org.itcast.entity.Role;
import org.itcast.entity.User;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddResult {
    private Integer code;
    private String msg;
    private List<Role> roles = new ArrayList<>(); //角色
    private List<Post> posts = new ArrayList<>(); //岗位
    public static AddResult success(List<Role> roles,
                                    List<Post> posts){
        return new AddResult(200,"操作成功",roles,posts);

    }
}
