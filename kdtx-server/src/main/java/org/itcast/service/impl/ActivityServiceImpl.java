package org.itcast.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.result.ActityGetByIdResult;
import com.sky.result.ActityPageResult;
import com.sky.result.Result;
import org.itcast.dto.ActivityDto;
import org.itcast.dto.ActivtyAddDto;
import org.itcast.entity.TbActivity;
import lombok.extern.slf4j.Slf4j;
import org.itcast.mapper.ActivityMapper;
import org.itcast.service.ActivityService;
import org.itcast.vo.ActivitJia;
import org.itcast.vo.ActivityList;
import org.itcast.vo.ActivityVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityMapper activityMapper;

    /**
     * 新增
     * @param dto
     * @return
     */
    @Override
    public Object insertActivity(ActivtyAddDto dto) {
        TbActivity activity = new TbActivity();
        BeanUtils.copyProperties(dto, activity);
        activityMapper.insertActivity(activity);
        return Result.success();
    }

    /**
     * 活动管理
     * @param dto
     * @return
     */
    @Override
    public ActityPageResult selectListActivity(ActivityDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        Page<ActivityVo> voList = activityMapper.selectListActivityList(dto.getCode(), dto.getChannel(), dto.getBeginCreateTime(), dto.getEndCreateTime(), dto.getBeginTime(), dto.getEndTime());

        List<ActivitJia> list = new ArrayList<>();
        return new ActityPageResult(voList.getTotal(), voList.getResult(), 200, "查询成功", list);
    }

    /**删除活动
    @Override
    */
    public void delActivity(Long id) {
        activityMapper.deleteById(id);
    }

    @Override
    public ActityGetByIdResult getById(Long id) {
        ActivityVo data = activityMapper.getById(id);
        return new ActityGetByIdResult("操作成功",200,data);
    }

    @Override
    public Object setActivity(ActivtyAddDto dto) {
        activityMapper.setActivity(dto);
        return Result.success();
    }

    @Override
    public Result getActivityList(String channel) {
        LambdaQueryWrapper<TbActivity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TbActivity::getChannel, channel);
        List<TbActivity> activities = activityMapper.selectList(wrapper);
        List<ActivityList> list = new ArrayList<>();
        Integer i = 0;
        for (TbActivity activity : activities) {
            ActivityList act = new ActivityList();
            act.setId(i.toString());
            act.setName(activity.getName());
            i++;
            list.add(act);
        }
        return Result.success(list);
    }
}
