package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.dept.DeptPageDTO;
import org.itcast.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {


    Page<Dept> list(DeptPageDTO dto);

    @Select("select dept_id, parent_id, ancestors, dept_name, order_num, leader, phone, email, status, del_flag, create_by, create_time, update_by, update_time from sys_dept where dept_id = #{deptId}")
    List<Dept> getDept(Long deptId);


    void addDept(Dept dept);

    void updateDept(Dept dept);

    @Select("select dept_id, parent_id, ancestors, dept_name, order_num, leader, phone, email, status, del_flag, create_by, create_time, update_by, update_time from sys_dept where" +
            " dept_id = (select parent_id from sys_dept where dept_id = #{deptId})")
    List<Dept> getDeptParent(Long deptId);
}
