package org.itcast.service;

import org.itcast.common.PostResult;
import org.itcast.common.Result;
import org.itcast.dto.post.PostDTO;
import org.itcast.entity.Post;

import java.util.List;

public interface PostService {
    PostResult postList(PostDTO dto);

    PostResult deletePost(List<Integer> ids);

    PostResult addPost(Post dto);

    Result getPost(Integer id);
}
