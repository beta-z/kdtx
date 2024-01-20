package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDataListDTO {
    Integer pageNum;
    Integer pageSize;
    String dictType;
}
