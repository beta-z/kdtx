package org.itcast.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateStatusDTO {
    private Long roleId;
    private String status;
}
