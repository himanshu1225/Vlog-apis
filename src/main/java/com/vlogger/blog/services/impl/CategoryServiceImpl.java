package com.vlogger.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlogger.blog.entities.Category;
import com.vlogger.blog.exceptions.ResourceNotFoundException;
import com.vlogger.blog.payloads.CategoryDto;
import com.vlogger.blog.repositories.CategoryRepo;
import com.vlogger.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = toDomain(categoryDto);
		Category addedCategory = this.categoryRepo.save(category);
		return fromDomain(addedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(category);
		return fromDomain(updatedCategory);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		return fromDomain(this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId)));
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = categories.stream().map((cat) -> this.fromDomain(cat)).collect(Collectors.toList());
		return catDtos;
	}

	private Category toDomain(CategoryDto categoryDto) {
		return this.modelMapper.map(categoryDto,Category.class);
	}
	
	private CategoryDto fromDomain(Category category) {
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
