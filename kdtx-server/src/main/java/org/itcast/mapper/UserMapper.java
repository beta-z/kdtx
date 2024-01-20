package org.itcast.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.LoginDTO;
import org.itcast.entity.User;

@Mapper
public interface UserMapper {
    @Select("select user_id from sys_user where user_name = #{username} and password =#{password}")
    User login(LoginDTO dto);
    @Select("select user_name from sys_user where user_id = #{id}")
    String getNameById(Long id);
}
