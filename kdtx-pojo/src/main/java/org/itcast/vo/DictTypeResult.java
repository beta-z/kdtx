package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.DictData;
import org.itcast.entity.DictType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictTypeResult {
    Long total;
    List<DictType> rows;
}
