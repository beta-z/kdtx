package org.itcast.dto.post;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListDTO {
    private Integer pageNum;
    private Integer pageSize;
    private String postCode;
    private String postName;
    private Integer status;
}
