package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdateVO extends RoleVO{
    private List<Long> menuIds;

}
