package org.itcast.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateDTO extends Role {
    private List<Long> menuIds;
}
