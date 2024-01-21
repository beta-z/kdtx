package org.itcast.service;

import org.itcast.dto.DictDataListDTO;
import org.itcast.entity.DictData;
import org.itcast.vo.DictDataInfoResult;
import org.itcast.vo.DictDataResult;
import org.itcast.vo.DictResult;

public interface DictDataService {
    DictDataResult list(DictDataListDTO dto);

    DictDataInfoResult getByDictCode(Long dictCode);

    DictResult getByDictType(String dictType);

    void addData(DictData data);

    void updateData(DictData data);

    void delData(Long dictCode);
}
