package com.example.testProject.repository;

import com.example.testProject.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostModelRepository extends JpaRepository<PostModel, Long> {
}
