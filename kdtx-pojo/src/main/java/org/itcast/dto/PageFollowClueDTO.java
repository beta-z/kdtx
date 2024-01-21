package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageFollowClueDTO {


    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
