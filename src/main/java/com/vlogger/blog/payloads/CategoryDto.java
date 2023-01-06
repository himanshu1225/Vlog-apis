package com.vlogger.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min = 3, message = "Title should be min of 3 charactes.")
	private String categoryTitle;
	
	@NotEmpty
	private String categoryDescription;
}
