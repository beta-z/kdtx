package org.itcast.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.CourselistDTO;
import org.itcast.dto.NewClassDTO;
import org.itcast.mapper.courseMapper.CourseMapper;
import org.itcast.service.CourseServers;
import org.itcast.vo.CourselistVO;
import org.itcast.vo.TransferlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class CourseServerslmpl implements CourseServers {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public Fenye getCourselist(CourselistDTO dto) {
        //设置分页参数
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        //获取时间，设置时间
        Map<String, Object> params1 = dto.getParams();
        dto.setBeginTime(params1.get("beginCreateTime"));
        dto.setEndTime(params1.get("endCreateTime"));
        //调用mapper层进行查询
        Page<CourselistDTO> vo = courseMapper.getCourselist(dto);
        PageResult pageResult = new PageResult(vo.getTotal(), vo.getResult());
        return new Fenye(200,"ok",vo.getResult(),vo.getTotal());
    }

    @Override
    public List<CourselistVO> getPushCourseList() {


        List<CourselistVO> vo = courseMapper.getPushCourseList();
        for (CourselistVO courselistVO : vo) {
            //Character subject = courselistVO.getSubject();
            //String classname = courseMapper.getclassname(subject);
            //courselistVO.setDictLabel(classname);
        }
        return vo;
    }

    @Override
    public CourselistVO getCoursebyid(Long id) {
        CourselistVO vo = courseMapper.getCoursebyid(id);

        return vo;
    }

    @Override
    public void newClass(NewClassDTO dto) {
        dto.setCreateTime(LocalDateTime.now());
        dto.setIsDelete(0);
        courseMapper.newClass(dto);
    }

    //删除课程
    @Override
    public Result deleteClass(List<Long> id) {
        for (Long aLong : id) {
            courseMapper.deleteClass(aLong);
        }
        return Result.success();
    }
}
