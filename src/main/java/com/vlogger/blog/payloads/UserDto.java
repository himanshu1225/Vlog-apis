package com.vlogger.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "User name must be min of 4 characters.")
	private String name;
	
	@Email(message = "Email is not valid.")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 12, message = "Password must be min of 3 characters and max of 12 characters.")
	private String password;
//	Can add @Pattern(regexPattern) for password. 
	
	@NotEmpty
	private String about;

}
