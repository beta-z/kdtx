package org.itcast.service;

import com.sky.result.PageResult;
import com.sky.result.Result;
import org.itcast.dto.ContractDTO;
import org.itcast.dto.PageQueryDTO;

public interface ContractService {

    //新增合同
    void save(ContractDTO contractDTO);


//    PageResult page(PageQueryDTO pageQueryDTO);
}
