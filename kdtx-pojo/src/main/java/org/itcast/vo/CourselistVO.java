package org.itcast.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourselistVO {
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //课程id
    private Long id;

    //课程名称
    private String name;

    //课程编号
    private String code;

    //学科
    private Character subject;

    //学科名称
    //private String   dictLabel;

    //价格
    private Integer price;

    //适用人群
    private Character applicablePerson;

    //课程介绍
    private String info;

    //是否删除
    private Integer isDelete;
}
