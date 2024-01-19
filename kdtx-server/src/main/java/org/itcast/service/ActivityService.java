package org.itcast.service;

import org.itcast.dto.ActivityDTO;
import org.itcast.dto.PageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;

public interface ActivityService {

    //新增活动
    void save (ActivityDTO activityDTO);

    //删除活动
    void deleteById(Long id);

    //根据id查询
    Result getById(Integer id);

    //分页
    PageResult pageQuery(org.itcast.dto.PageQueryDTO pageQueryDTO);

    //修改
    void update(ActivityDTO activityDTO);
}
