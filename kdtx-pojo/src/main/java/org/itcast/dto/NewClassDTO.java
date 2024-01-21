package org.itcast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewClassDTO {
    //课程学科
    private Character subject;

    //课程名称
    private String name;

    //适用人群
    private Character applicablePerson;

    //课程价格
    Integer price;

    //课程介绍
    String info;
    //创建时间
    LocalDateTime createTime;

    Integer isDelete;
}
