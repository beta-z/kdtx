package org.itcast.service.impl;

import org.itcast.dto.IndexDTO;
import org.itcast.exception.ParamIllegalException;
import org.itcast.mapper.IndexMapper;
import org.itcast.service.IndexService;
import org.itcast.vo.IndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    IndexMapper indexMapper;

    @Override
    public IndexVO index(IndexDTO dto) {
        if (dto == null){
            throw new ParamIllegalException("参数不合法");
        }
        return null;
    }
}
