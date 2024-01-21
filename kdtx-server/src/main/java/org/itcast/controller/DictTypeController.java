package org.itcast.controller;

import org.itcast.dto.DictTypeListDTO;
import org.itcast.entity.DictType;
import org.itcast.service.DictTypeService;
import org.itcast.vo.DictTypeInfoResult;
import org.itcast.vo.DictTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/dict/type")
public class DictTypeController {
    @Autowired
    DictTypeService dictTypeService;
    @GetMapping("/list")
    public DictTypeResult list(@DateTimeFormat(pattern = "yyyy-MM-dd") DictTypeListDTO dto){
        return dictTypeService.list(dto);
    }
    @GetMapping("/{dictId}")
    public DictTypeInfoResult getById(@PathVariable Long dictId){
        return dictTypeService.getById(dictId);
    }
    @PostMapping()
    public void addDict(@RequestBody DictType dictType){
        dictTypeService.addDict(dictType);
    }
    @PutMapping
    public void updateDict(@RequestBody DictType dictType){
        dictTypeService.updateDict(dictType);
    }
    @DeleteMapping("/{dictId}")
    public void delType(@PathVariable Long dictId){
        dictTypeService.delType(dictId);
    }


}
