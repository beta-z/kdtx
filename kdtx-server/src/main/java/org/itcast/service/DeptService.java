package org.itcast.service;

import org.itcast.common.Result;
import org.itcast.dto.dept.DeptAddDTO;
import org.itcast.dto.dept.DeptPageDTO;
import org.itcast.entity.Dept;

public interface DeptService {
    /**
     * 查询部门列表
     *
     * @param dto
     * @return
     */
    Result list(DeptPageDTO dto);

    /**
     * 查询部门列表
     *
     * @param deptId
     * @return
     */
    Result listExclude(Long deptId);

    /**
     * 查询部门详细
     *
     * @param deptId
     * @return
     */
    Result getDept(Long deptId);

    /**
     * 新增部门
     *
     * @param dto
     * @return
     */
    Result addDept(DeptAddDTO dto);

    /**
     * 修改部门
     *
     * @param dept
     * @return
     */
    Result updateDept(Dept dept);
}
