package com.example.testProject.service;

import com.example.testProject.dto.ResultDto;
import com.example.testProject.model.PostModel;
import com.example.testProject.utils.DataBaseUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@NoArgsConstructor
public class PostService {
    @Autowired
    private DataBaseUtils dataBaseUtils;
    public List<PostModel> getPost(){
        return dataBaseUtils.getPosts();
    }

    public ResultDto setPost(String title, String content) {
        if (title.isEmpty() && content.isEmpty()) {
            return new ResultDto(false, "Значение пустое");
        }
        dataBaseUtils.addPost(title, content);
        return new ResultDto(true, "Пост добавлен");
    }

    public PostModel getPostId(Long id) {
        return dataBaseUtils.getPost(id);
    }
    public ResultDto deletePostId(Long id) {
        dataBaseUtils.deletePost(id);
        return new ResultDto(true, "Запись удалена");
    }
}
