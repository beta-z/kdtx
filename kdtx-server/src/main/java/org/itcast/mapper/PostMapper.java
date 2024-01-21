package org.itcast.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.itcast.dto.post.PostDTO;
import org.itcast.dto.post.PostListDTO;
import org.itcast.entity.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select post_id from sys_user_post where user_id = #{userId}")
    List<Long> getPostIds(Long userId);

    @Select("select post_id, post_code, post_name, post_sort, status, create_by, create_time, update_by, update_time, remark from sys_post")
    List<Post> list();


    void deleteIDS(List<Integer> ids);

    @Insert("INSERT INTO sys_post (post_id, post_code, post_name, post_sort, status, create_by, update_by, remark,create_Time)\n" +
            "VALUES (#{postId},#{postCode},#{postName},#{postSort},#{status},#{createrBy},#{updateBy},#{remark},#{createTime})")
    void addPost(Post dto);

    @Select("select * from sys_post where post_id=#{id}")
    Post getPost(Integer id);

//    @Update("update sys_post set post_name=#{postName},post_code=#{postCode},post_sort=#{postSort},status=#{status},remark=#{remark} where post_id=#{postId}")
    void update(Post dto);

    List<Post> listhaha(PostListDTO dto);
}
