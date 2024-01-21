package org.itcast.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.itcast.common.CluePageResult;
import org.itcast.common.MyResult;
import org.itcast.common.Result;
import org.itcast.dto.FollowClueDTO;
import org.itcast.dto.PageFollowClueDTO;
import org.itcast.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clues/record")
@Api("线索跟进管理")
public class FollowClueController {
    @Autowired
    private ClueService clueService;

    @PostMapping()
    @ApiOperation("新增跟进记录管理")
    public Result addClueRecord(@RequestBody  FollowClueDTO dto){
        return clueService.addClueRecord(dto);
    }

    @GetMapping("/list")
    @ApiOperation("线索任务列表")
    public MyResult listClueRecord(@RequestParam Long clueId){
        return clueService.listClueRecord(clueId);
    }

}
