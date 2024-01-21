package org.itcast.dto.dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptPageDTO {

    //部门名称
    private String deptName;

    //状态
    private String status; //0正常，1停用

}
