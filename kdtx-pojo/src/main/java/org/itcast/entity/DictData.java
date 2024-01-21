package org.itcast.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictData {
    Long dictCode;
    Integer dictSort;
    String dictLabel;
    String dictValue;
    String dictType;
    String status;
    String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createTime;
    String updateBy;
    LocalDateTime updateTime;
    String remark;
}
