package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.DictData;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDataResult {
    Long total;
    List<DictData> rows;
}
