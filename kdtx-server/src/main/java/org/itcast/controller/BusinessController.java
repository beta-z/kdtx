package org.itcast.controller;

import org.itcast.dto.BusinessBatchDTO;
import org.itcast.dto.BusinessDTO;
import org.itcast.entity.Business;
import org.itcast.entity.BusinessFollow;
import org.itcast.vo.BusinessFollowVO;
import org.itcast.vo.BusinessPageResultVO;
import org.itcast.common.Result;
import org.itcast.dto.BusinessPoolPageQueryDTO;
import org.itcast.dto.BusinessPageQueryDTO;
import org.itcast.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    // 查询商机列表
    @GetMapping("/list")
    public BusinessPageResultVO listBusiness(BusinessPageQueryDTO dto) {

        return businessService.listBusiness(dto);
    }

    // 查询公海池列表
    @GetMapping("/pool")
    public BusinessPageResultVO listBusinessPool(BusinessPoolPageQueryDTO dto) {

        return businessService.listBusinessPool(dto);
    }

    // 查看商机详情
    @GetMapping("{id}")
    public Result getBusinessById(@PathVariable Long id) {

        return businessService.getBusinessById(id);
    }

    // 新增商机
    @PostMapping
    public Result addBusiness(@RequestBody Business business) {

        return businessService.addBusiness(business);
    }

    // 修改商机
    @PutMapping
    public Result updateBusiness(@RequestBody BusinessDTO dto) {

        return businessService.updateBusiness(dto);
    }

    // 捞取商机
    @PutMapping("/gain")
    public Result gainBusiness(@RequestBody BusinessBatchDTO dto) {

        return businessService.gainBusiness(dto.getIds());
    }

    // 新增跟进
    @PostMapping("/record")
    public Result addBusinessRecord(@RequestBody BusinessDTO dto) {

        return businessService.addBusinessRecord(dto);
    }

    // 商机沟通记录列表
    @GetMapping("/record/list")
    public BusinessFollowVO listBusinessRecord(Long businessId) {

        return businessService.listBusinessRecord(businessId);
    }

    // 分配商机
    @PutMapping("/assignment")
    public Result assignmentBusiness(@RequestBody BusinessBatchDTO dto, Long userId) {

        return businessService.assignmentBusiness(dto.getIds(), userId);
    }

    //退回公海池
    @PutMapping("/back/{id}/{backReason}")
    public Result backBusiness(@PathVariable Long id, @PathVariable String backReason) {

        return businessService.backBusiness(id, backReason);
    }
}
