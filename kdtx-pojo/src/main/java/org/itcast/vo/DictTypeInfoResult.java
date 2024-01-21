package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.DictType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictTypeInfoResult {
    String msg;
    Integer code;
    DictType data;
}
