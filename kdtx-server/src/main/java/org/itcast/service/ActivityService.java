package org.itcast.service;

import com.sky.result.ActityGetByIdResult;
import com.sky.result.ActityPageResult;
import com.sky.result.Result;
import org.itcast.dto.ActivityDto;
import org.itcast.dto.ActivtyAddDto;
import org.itcast.dto.PageQueryDTO;
import com.sky.result.PageResult;
import org.itcast.entity.TbActivity;

public interface ActivityService {


    /**
     * 新增
     * @param dto
     * @return
     */
    Object insertActivity(ActivtyAddDto dto);

    /**
     * 查询活动管理列表
     * @param dto
     * @return
     */
    ActityPageResult selectListActivity(ActivityDto dto);

    /**
     * 删除活动
     * @param id
     */
    void delActivity(Long id);

    ActityGetByIdResult getById(Long id);

    Object setActivity(ActivtyAddDto dto);

    Result getActivityList(String channel);
}
