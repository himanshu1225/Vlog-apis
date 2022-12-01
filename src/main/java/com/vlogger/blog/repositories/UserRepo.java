package com.vlogger.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlogger.blog.entities.User;

public interface UserRepo extends  JpaRepository<User, Integer>{
	
}
