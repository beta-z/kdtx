package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.common.PageResult;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleOptVO {
    private Long roleId;
    private String roleName;
}
