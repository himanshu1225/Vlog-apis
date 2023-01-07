package com.vlogger.blog.services;

import java.util.List;

import com.vlogger.blog.payloads.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getAllPost();
	
	List<PostDto> getAllPostByUser(Integer userId);
	
	List<PostDto> getAllPostByCategory(Integer categoryId);
	
	List<PostDto> searchPost(String keyword);
 
}
