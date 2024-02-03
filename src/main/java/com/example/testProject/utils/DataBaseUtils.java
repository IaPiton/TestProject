package com.example.testProject.utils;

import com.example.testProject.model.PostModel;
import com.example.testProject.repository.PostModelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@NoArgsConstructor
public class DataBaseUtils {
    @Autowired
    private PostModelRepository postModelRepository;

    public void addPost(String title, String content) {
        PostModel postModel = new PostModel();
        postModel.setTitle(title);
        postModel.setContent(content);
        postModelRepository.saveAndFlush(postModel);
    }

    public PostModel getPost(Long id) {
        try {
            return postModelRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        return new PostModel();
    }

    public List<PostModel> getPosts() {
        return postModelRepository.findAll();
    }

    public void deletePost(Long id) {
        postModelRepository.deleteById(id);
    }

}
