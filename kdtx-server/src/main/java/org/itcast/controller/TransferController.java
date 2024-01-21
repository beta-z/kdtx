package org.itcast.controller;


import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.TransferlistDTO;
import org.itcast.service.TransferServers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    TransferServers transferServerslmpl;

    @GetMapping("/list")
    public Fenye transferlist(TransferlistDTO params) {

        return transferServerslmpl.getTransferlist(params);
    }

    @PutMapping("/assignment/{type}/{userId}/{transferUserId}")
    public Result divertLeads(@PathVariable String type,@PathVariable Long userId, @PathVariable Long transferUserId){
        //type是分派的线索还是商机
        //第一个id是用户id
        //第二个id是要被转派的id
        transferServerslmpl.divertLeads(type,userId,transferUserId);
        return Result.success();
    }
}
