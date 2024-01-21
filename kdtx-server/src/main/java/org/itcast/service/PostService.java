package org.itcast.service;

import org.itcast.common.PostResult;
import org.itcast.common.Result;
import org.itcast.dto.post.PostDTO;
import org.itcast.dto.post.PostListDTO;
import org.itcast.entity.Post;

import java.util.List;

public interface PostService {
    PostResult postList(PostListDTO dto);

    PostResult deletePost(List<Integer> ids);

    PostResult addPost(Post dto);

    Result getPost(Integer id);

    Result updatePost(Post dto);
}
