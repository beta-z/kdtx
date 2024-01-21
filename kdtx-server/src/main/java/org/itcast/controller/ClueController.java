package org.itcast.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.itcast.common.CluePageResult;
import org.itcast.common.Result;
import org.itcast.dto.ClueDTO;
import org.itcast.dto.CluePoolDTO;
import org.itcast.dto.FollowClueDTO;
import org.itcast.dto.GainDTO;
import org.itcast.entity.Clue;
import org.itcast.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clues/clue")
@Api("线索相关接口")
public class ClueController {

    @Autowired
    private ClueService clueService;

    @GetMapping("/list")
    @ApiOperation("线索管理列表")
    public CluePageResult listClue(ClueDTO dto){
       return clueService.listClue(dto);
    }

    @GetMapping("/pool")
    @ApiOperation("查询线索管理线索池列表")
    public CluePageResult listCluePool(CluePoolDTO dto){
        return clueService.listCluePool(dto);
    }

    @GetMapping("/{id}")
    @ApiOperation("查询线索管理详细")
    public Result getClue(@PathVariable Long id){
        return clueService.getClue(id);
    }


    @PostMapping
    @ApiOperation("新增线索管理")
    public Result addClue(Clue clue){
        return clueService.addClue(clue);
    }

    @PutMapping()
    @ApiOperation("修改线索管理")
    public Result updateClue(FollowClueDTO dto){
        return clueService.updateClue(dto);
    }

    @PutMapping("/assignment")
    @ApiOperation("批量分配线索")
    public Result assignmentClue(@RequestBody GainDTO dto,Long userId){
        return clueService.assignmentClue(dto,userId);
    }
    @PutMapping("/gain")
    @ApiOperation("批量捞取线索")
    public Result gainClue(@RequestBody GainDTO dto){
        return clueService.gainClue(dto.getIds());
    }

    @PutMapping("/changeBusiness/{id}")
    @ApiOperation("线索转商机")
    public Result turnBusiness(@PathVariable Long id){
        return clueService.turnBusiness(id);
    }

    @PutMapping("false/{id}")
    @ApiOperation("伪线索上报")
    public Result reportClue(@PathVariable Long id,String reason,String remark){
        return clueService.reportClue(id,reason,remark);
    }




}
