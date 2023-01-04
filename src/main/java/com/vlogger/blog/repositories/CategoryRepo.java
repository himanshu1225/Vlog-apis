package com.vlogger.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlogger.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
