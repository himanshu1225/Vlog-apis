package com.vlogger.blog.services;

import java.util.List;

import com.vlogger.blog.entities.Post;
import com.vlogger.blog.payloads.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostDto getPostById(Integer postId);
	
	List<Post> getAllPost();
	
	List<Post> getAllPostByUser(Integer userId);
	
	List<Post> getAllPostByCategory(Integer categoryId);
	
	List<Post> searchPost(String keyword);
 
}
