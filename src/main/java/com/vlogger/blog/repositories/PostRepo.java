package com.vlogger.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlogger.blog.entities.Category;
import com.vlogger.blog.entities.Post;
import com.vlogger.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
