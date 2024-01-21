package org.itcast.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Business;



import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessFollowVO {

    private Integer code; // 编码
    private String msg; // 信息
    private List<Business> data;
}
