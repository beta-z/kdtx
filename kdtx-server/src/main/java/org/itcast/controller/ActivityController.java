package org.itcast.controller;



import com.sky.result.ActityGetByIdResult;
import com.sky.result.ActityPageResult;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.itcast.dto.ActivityDto;
import org.itcast.dto.ActivtyAddDto;
import org.itcast.entity.TbActivity;
import org.itcast.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clues/activity")
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    //新增活动管理
    @PostMapping
    public Result addActivity(@RequestBody ActivtyAddDto dto) {

        return Result.success(activityService.insertActivity(dto));

    }

    ////获取渠道下活动管理列表
    @GetMapping("/listselect/{channel}")
    public Result getActivityList(@PathVariable String channel) {
        return activityService.getActivityList(channel);
    }

    //查询活动管理列表
    @GetMapping("/list")
    public ActityPageResult listActivity(ActivityDto dto) {

        return activityService.selectListActivity(dto);

    }

    //删除活动管理

    @DeleteMapping("/{id}")
    public Result delActivity(@PathVariable Long id) {

        activityService.delActivity(id);

        return Result.success();

    }

    @GetMapping("/{id}")
    public ActityGetByIdResult getByIdActivity(@PathVariable Long id) {



        return activityService.getById(id);

    }
    //修改活动管理
    @PutMapping
    public Result setActivity(@RequestBody ActivtyAddDto dto) {

        return  Result.success( activityService.setActivity(dto));
    }

}
