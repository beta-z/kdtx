package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.dto.LoginDTO;
import org.itcast.dto.TransferlistDTO;
import org.itcast.mapper.transferMapper.TransferMapper;
import org.itcast.service.TransferServers;
import org.itcast.vo.TransferlistVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class TransferServerslmpl implements TransferServers {
    @Autowired
    TransferMapper transferMapper;

    @Override
    public Fenye getTransferlist(TransferlistDTO params) {
        //设置分页参数
        PageHelper.startPage(params.getPageNum(), params.getPageSize());

        //TODO
        //从当前临时空间中获取到到用户id
        Map<String, Object> params1 = params.getParams();
        params.setBeginTime(params1.get("beginTime"));
        params.setEndTime(params1.get("endTime"));
        //调用mapper层进行查询
        Page<TransferlistVO> vo = transferMapper.getTransferlist(params);
        for (TransferlistVO transferlistVO : vo) {
            Long userId = transferlistVO.getUserId();
            //使用名字获取线索
            Long clueNum = transferMapper.getclue(userId);
            transferlistVO.setClueNum(clueNum);
            //使用名字获取商机
            Long businessNum = transferMapper.getbusiness(userId);
            transferlistVO.setBusinessNum(businessNum);
        }
        //遍历获取到的用户取到名字，将名字作为参数在表中查询线索和商机

        //PageResult pageResult = new PageResult(vo.getTotal(), vo.getResult());
        return new Fenye(200,"ok",vo.getResult(),vo.getTotal());
    }

    @Override
    public void divertLeads(String type, Long userId, Long transferUserId) {
        if(type.equals("clue")){
            //修改线索
            String name = transferMapper.getname(userId);
            String receptionName = transferMapper.getname(transferUserId);
            transferMapper.upClue(name,receptionName);
        }else{
            //修改商机
            String name = transferMapper.getname(userId);
            String receptionName = transferMapper.getname(transferUserId);
            transferMapper.upBusiness(name,receptionName);
        }

    }

}
