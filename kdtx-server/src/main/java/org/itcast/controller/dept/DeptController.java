package org.itcast.controller.dept;

import lombok.extern.slf4j.Slf4j;
import org.itcast.common.Result;
import org.itcast.dto.dept.DeptAddDTO;
import org.itcast.dto.dept.DeptPageDTO;
import org.itcast.entity.Dept;
import org.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 部门
 */

@RestController
@RequestMapping("/system/dept")
@Slf4j
public class DeptController {


    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public Result list(DeptPageDTO dto){
        log.info("查询部门列表，{}",dto);
        return deptService.list(dto);
    }

    @GetMapping("/list/exclude/{deptId}")
    public Result listExclude(@PathVariable Long deptId){
        log.info("查询部门列表（排除节点），{}",deptId);
       return deptService.listExclude(deptId);
    }

    @GetMapping("{deptId}")
    public Result getDept(@PathVariable Long deptId){
        log.info("查询部门详细，参数为：{}",deptId);
        return deptService.getDept(deptId);
    }


    @PostMapping
    public Result addDept(@RequestBody DeptAddDTO dto){
        log.info("新增用户，参数为：{}",dto);
        return deptService.addDept(dto);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("修改用户，参数为：{}",dept);
        return deptService.updateDept(dept);
    }



}



