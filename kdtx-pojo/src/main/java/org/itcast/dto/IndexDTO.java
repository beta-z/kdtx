package org.itcast.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IndexDTO {
    Long deptId;
    LocalDateTime beginCreateTime;
    LocalDateTime endCreateTime;
}
