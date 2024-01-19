package org.itcast.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity implements Serializable {

    private Long id;

    private String channel;

    private String name;

    private String info;

    private String type;

    private Float discount;

    private Integer vouchers;

    private Data beginTime;

    private Data endTime;

}
