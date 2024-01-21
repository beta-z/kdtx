package org.itcast.service.impl;

import org.itcast.dto.ContractDTO;
import org.itcast.entity.Contract;
import org.itcast.mapper.ContractMapper;
import org.itcast.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public void save(ContractDTO contractDTO) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO,contract);
        contractMapper.save();
    }


//    @Override
//    public PageResult page(PageQueryDTO pageQueryDTO) {
//        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
//        List<ContractDTO> list = contractMapper.page(pageQueryDTO.getName());
//        Page<ContractDTO> page = (Page<ContractDTO>) list;
//        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
//        return Result.success(pageResult);
//    }
}
