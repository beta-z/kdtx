package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.PostResult;
import org.itcast.common.Result;
import org.itcast.dto.post.PostDTO;
import org.itcast.dto.post.PostListDTO;
import org.itcast.entity.Post;
import org.itcast.mapper.PostMapper;
import org.itcast.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Override
    public PostResult postList(PostListDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<Post> list=postMapper.listhaha(dto);

        Page<Post> page= (Page<Post>) list;
        PostResult postResult = new PostResult();
        postResult.setCode(200);
        postResult.setMsg("查询成功");
        postResult.setRows(list);
        postResult.setTotal(page.getTotal());
        return postResult;
    }

    @Override
    public PostResult deletePost(List<Integer> ids) {

        postMapper.deleteIDS(ids);
        PostResult postResult = new PostResult();
        return postResult;
    }


    /**
     * 新增岗位
     * @param
     * @return
     */
    @Override
    public PostResult addPost(Post postVO) {
        postVO.setCreateTime(LocalDateTime.now());
        postVO.setUpdateTime(LocalDateTime.now());
        postMapper.addPost(postVO);
        PostResult postResult = new PostResult();
        return postResult;
    }


    /**
     * 数据回显
     * @param id
     * @return
     */
    @Override
    public Result getPost(Integer id) {
        Post postVO=postMapper.getPost(id);

        return Result.success(postVO) ;
    }

    @Override
    public Result updatePost(Post dto) {
        postMapper.update(dto);
        return Result.success();
    }
}
