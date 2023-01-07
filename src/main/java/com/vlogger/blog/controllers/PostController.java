package com.vlogger.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vlogger.blog.payloads.ApiResponse;
import com.vlogger.blog.payloads.PostDto;
import com.vlogger.blog.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService  postService;
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
											  @RequestParam("userId") Integer userId, 
											  @RequestParam("categoryId") Integer categoryId){
		PostDto createdPost = postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}
	
	@GetMapping("userId/{userId}")
	public ResponseEntity<List<PostDto>> getAllPostByUser(@PathVariable("userId") Integer userId){
		List<PostDto> postDtos = postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("categoryId/{categoryId}")
	public ResponseEntity<List<PostDto>> getAllPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> postDtos = postService.getAllPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> postDtos = postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto post = postService.getPostById(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post is deleted Successfully", true), HttpStatus.OK);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto post = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
}