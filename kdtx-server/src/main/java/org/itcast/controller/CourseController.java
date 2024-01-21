package org.itcast.controller;

import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.CourselistDTO;
import org.itcast.dto.NewClassDTO;
import org.itcast.service.CourseServers;
import org.itcast.vo.CourselistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clues/course")
public class CourseController {
    @Autowired
    CourseServers courseServerslmpl;

    //分页查询
    @GetMapping("/list")
    public Fenye getCourseList( CourselistDTO dto) {
        return courseServerslmpl.getCourselist(dto);
    }

    //课程下拉列表
    @GetMapping("/listselect")
    public Result getPushCourseList() {
        List<CourselistVO> vo = courseServerslmpl.getPushCourseList();
        return Result.success(vo);
    }

    //查询课程详情
    @GetMapping("/{id}")
    public Result getCoursebyid(@PathVariable Long id) {
        CourselistVO vo = courseServerslmpl.getCoursebyid(id);
        return Result.success(vo);
    }

    //新增
    @PostMapping()
    public Result newClass(@RequestBody NewClassDTO dto) {
        courseServerslmpl.newClass(dto);
        return Result.success();
    }

//删除课程
    @DeleteMapping("/{id}")
    public Result deleteClass(@PathVariable List<Long> id){
        return courseServerslmpl.deleteClass(id);
    }
}
