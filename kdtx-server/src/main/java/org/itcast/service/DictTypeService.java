package org.itcast.service;

import org.itcast.dto.DictTypeListDTO;
import org.itcast.entity.DictType;
import org.itcast.vo.DictTypeInfoResult;
import org.itcast.vo.DictTypeResult;


public interface DictTypeService {
    DictTypeResult list(DictTypeListDTO dto);

    DictTypeInfoResult getById(Long dictId);

    void addDict(DictType dictType);

    void updateDict(DictType dictType);

    void delType(Long dictId);


}
