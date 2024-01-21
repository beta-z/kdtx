package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitJia {
    private Long total;
    private Integer pass;
    private Integer reject;
    private Integer toAudit;
    private Integer finish;
}
