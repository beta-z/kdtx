package org.itcast.controller;

import org.itcast.dto.IndexDTO;
import org.itcast.vo.IndexVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping
    public IndexVO index(IndexDTO dto){
return null;
    }
}
