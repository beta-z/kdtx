package org.itcast.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fenye {
    int code;
    String msg;
    List rows;
    Long total;
}
