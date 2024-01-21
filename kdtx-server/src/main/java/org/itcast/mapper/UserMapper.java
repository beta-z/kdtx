package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.LoginDTO;
import org.itcast.dto.user.UserPageDTO;
import org.itcast.entity.Post;
import org.itcast.entity.Role;
import org.itcast.entity.User;
import org.itcast.vo.UserListSelectVO;

import java.util.List;

@Mapper
public interface UserMapper {

    Page<User> list(UserPageDTO dto);


    @Select("select user_id , user_name from sys_user where dept_id = #{deptId}")
    List<UserListSelectVO> listSelect(Long deptId);

    @Select("select user_id, dept_id, user_name, nick_name, user_type, email, phonenumber, sex, avatar, password, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark from sys_user where user_id = #{userId}")
    User getUserId(Long userId);


    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void addUser(User user);

    void addUserRole(Long userId, List<Role> roleIds);

    void addUserPost(Long userId, List<Post> postIds);

    void updateUser(User user);

    @Delete("delete from sys_user_role where user_id = #{userId}")
    void delectUserRoles(Long userId);

    @Delete("delete from sys_user_post where user_id = #{userId}")
    void delectUserPosts(Long userId);

    @Delete("delete from sys_user where user_id = #{userId}")
    void deleteUser(Long userId);

    @Select("select user_id from sys_user where user_name = #{username} and password =#{password}")
    User login(LoginDTO dto);
    @Select("select user_name from sys_user where user_id = #{id}")
    String getNameById(Long id);

    @Select("select user_id, dept_id, user_name, nick_name, user_type, email, phonenumber, sex, avatar, password, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark from sys_user where dept_id = #{deptId}")
    List<User> getUser(Long deptId);
}
