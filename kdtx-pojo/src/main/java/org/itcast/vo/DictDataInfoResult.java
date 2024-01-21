package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.DictData;
import org.itcast.entity.DictType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDataInfoResult {
    String msg;
    Integer code;
    DictData data;
}
