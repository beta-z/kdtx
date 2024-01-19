package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.dto.ActivityDTO;

import org.itcast.dto.PageQueryDTO;
import org.itcast.entity.Activity;
import com.sky.result.PageResult;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.itcast.mapper.ActivityMapper;
import org.itcast.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    //新增活动
    @Override
    public void save(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityDTO,activity);
        activityMapper.s(activity);
    }

    //根据id删除活动
    @Override
    public void deleteById(Long id) {
        activityMapper.deleteById(id);
    }

    @Override
    public Result getById(Integer id) {
        return null;
    }

    //分页
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<Activity> page = activityMapper.pageQuery(pageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    //修改活动
    @Override
    public void update(ActivityDTO activityDTO) {
        activityMapper.update(activityDTO);

    }
}
