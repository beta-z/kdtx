package org.itcast.controller;

import org.itcast.dto.IndexDTO;
import org.itcast.service.IndexService;
import org.itcast.vo.IndexResult;
import org.itcast.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IndexService indexService;
    @GetMapping
    public IndexResult index(IndexDTO dto){
        IndexVO data = indexService.index(dto);
        return new IndexResult("success",200,data);
    }
}
