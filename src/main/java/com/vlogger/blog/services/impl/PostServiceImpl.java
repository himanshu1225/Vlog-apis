package com.vlogger.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlogger.blog.entities.Category;
import com.vlogger.blog.entities.Post;
import com.vlogger.blog.entities.User;
import com.vlogger.blog.exceptions.ResourceNotFoundException;
import com.vlogger.blog.payloads.PostDto;
import com.vlogger.blog.repositories.CategoryRepo;
import com.vlogger.blog.repositories.PostRepo;
import com.vlogger.blog.repositories.UserRepo;
import com.vlogger.blog.services.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private CategoryRepo categoryrepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepo postRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		
		User user  = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));

		Category category  = this.categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		Post post = this.toDomain(postDto);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post createdPost = this.postRepo.save(post);
		return this.fromDomain(createdPost);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Post toDomain(PostDto postDto) {
		return this.modelMapper.map(postDto, Post.class);
	}
	
	private PostDto fromDomain(Post post) {
		return this.modelMapper.map(post, PostDto.class);
	}

}
