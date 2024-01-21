package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictTypeListDTO {
    Integer pageNum;
    Integer pageSize;
    String dictName;
    String dictType;
    Integer status;

    LocalDateTime beginTime;
    LocalDateTime endTime;
}
