package org.itcast.controller.post;

import lombok.extern.slf4j.Slf4j;
import org.itcast.common.PostResult;
import org.itcast.common.Result;
import org.itcast.dto.post.PostDTO;
import org.itcast.dto.post.PostListDTO;
import org.itcast.entity.Post;
import org.itcast.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/post")
@Slf4j
public class PostController {



    @Autowired
    private PostService postService;
    @GetMapping("/list")
    public PostResult postList(PostListDTO dto){
        return postService.postList(dto);
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public PostResult deletePost(@PathVariable List<Integer> ids){
        return postService.deletePost(ids);
    }

    /**
     * 新增岗位
     */
    @PostMapping
    public  PostResult addPost(@RequestBody Post dto){
        return postService.addPost(dto);

    }

    /**
     * 修改数据回显
     */
    @GetMapping("/{id}")
    public Result getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }

    /**
     * 修改数据
     */
    @PutMapping
    public Result updatePost(@RequestBody Post dto){
        return postService.updatePost(dto);

    }

}
