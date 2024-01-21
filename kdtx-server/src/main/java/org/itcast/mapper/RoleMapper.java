package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.vo.RoleUpdateVO;
import org.itcast.vo.RoleVO;
import org.itcast.dto.role.RolePageDTO;
import org.itcast.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {

    Page<RoleVO> list(RolePageDTO dto);

    @Select("select role_id from sys_user_role where user_id = #{userId}")
    List<Long> getRoleIds(Long userId);


    RoleVO getRole(Long roleId);

    void addRole(RoleVO roleVO);

    void updateRole(RoleUpdateVO vo);

    @Delete("delete from sys_role where role_id = #{roleId}")
    void delete(Long roleId);

}
