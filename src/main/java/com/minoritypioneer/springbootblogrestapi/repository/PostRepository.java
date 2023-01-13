package com.minoritypioneer.springbootblogrestapi.repository;

import com.minoritypioneer.springbootblogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
