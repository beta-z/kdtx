package org.itcast.dto.dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.common.PageResult;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptAddDTO {

    private Long parentId;
    private String deptName;
    private String orderNum;
    private String leader;
    private String phone;
    private String email;
    private String status;
}
