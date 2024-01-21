package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineSeriesVO {

    private List<Map<String, Object>> data;
    private String name;

    public List<Map<String, Object>> getData() { return data; }
    public void setData(List<Map<String, Object>> value) { this.data = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
