package com.example.testProject.controller;

import com.example.testProject.controller.request.RequestPost;
import com.example.testProject.dto.ResultDto;
import com.example.testProject.model.PostModel;
import com.example.testProject.service.PostService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/v1")
@Slf4j
@Data
public class ApiController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public List<PostModel> getPost() {
        return postService.getPost();
    }

    @GetMapping("/{id}")
    public PostModel getPostId(@PathVariable Long id) {
        return postService.getPostId(id);
    }
    @DeleteMapping("/{id}")
    public ResultDto deletePostId(@PathVariable Long id) {
        return postService.deletePostId(id);
    }
    @PostMapping("/")
    public ResultDto setPost(@RequestBody RequestPost post) {
       return postService.setPost(post.title(), post.content());
    }
}
