package org.itcast.controller;

import org.apache.ibatis.annotations.Delete;
import org.itcast.dto.DictDataListDTO;
import org.itcast.entity.DictData;
import org.itcast.service.DictDataService;
import org.itcast.vo.DictDataInfoResult;
import org.itcast.vo.DictDataResult;
import org.itcast.vo.DictResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/dict/data")
public class DictDataController {
    @Autowired
    DictDataService dictDataService;

    @GetMapping("/list")
    public DictDataResult list(DictDataListDTO dto){
        return dictDataService.list(dto);
    }

    @GetMapping("/{dictCode}")
    public DictDataInfoResult getByDictCode(@PathVariable Long dictCode){
        return dictDataService.getByDictCode(dictCode);
    }

    @GetMapping("/type/{dictType}")
    public DictResult getByDictType(@PathVariable String dictType){
        return dictDataService.getByDictType(dictType);
    }

    @PostMapping
    public void addData(@RequestBody DictData data){
        dictDataService.addData(data);
    }

    @PutMapping
    public void updateData(@RequestBody DictData data){
        dictDataService.updateData(data);
    }

    @DeleteMapping("/{dictCode}")
    public void delData(@PathVariable Long dictCode){
        dictDataService.delData(dictCode);
    }
}
