package org.itcast.service;


import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.CourselistDTO;
import org.itcast.dto.NewClassDTO;
import org.itcast.vo.CourselistVO;

import java.util.List;

public interface CourseServers {
    Fenye getCourselist(CourselistDTO dto);

    List<CourselistVO> getPushCourseList();

    CourselistVO getCoursebyid(Long id);

    void newClass(NewClassDTO dto);

    Result deleteClass(List<Long> id);
}
