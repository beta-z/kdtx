package org.itcast.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select role_id, role_name, role_key, role_sort, data_scope, menu_check_strictly, dept_check_strictly, status, del_flag, create_by, create_time, update_by, update_time, remark from sys_role")
    List<Role> list();

    @Select("select role_id from sys_user_role where user_id = #{userId}")
    List<Long> getRoleIds(Long userId);
}
