package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineChartVO {
    private List<String> xAxis = new ArrayList<>();
    private List<LineSeriesVO> series = new ArrayList<>();
}
