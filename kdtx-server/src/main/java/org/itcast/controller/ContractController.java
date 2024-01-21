package org.itcast.controller;


import com.sky.result.PageResult;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.itcast.dto.ContractDTO;
import org.itcast.dto.PageQueryDTO;
import org.itcast.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;


//    @GetMapping("list")
//    public PageResult list(PageQueryDTO pageQueryDTO){
//        return contractService.page(pageQueryDTO);
//    }

    @PostMapping("/contract")
    public Result<String> save(@RequestBody ContractDTO contractDTO){
        log.info("新增合同：{}",contractDTO);
        contractService.save(contractDTO);
        return Result.success();
    }

}
