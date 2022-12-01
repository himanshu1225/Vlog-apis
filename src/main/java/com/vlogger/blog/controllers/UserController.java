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
import org.springframework.web.bind.annotation.RestController;

import com.vlogger.blog.payloads.ApiResponse;
import com.vlogger.blog.payloads.UserDto;
import com.vlogger.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST - createUser
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUserDto = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
	}

	// PUT - updateUser
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
											  @PathVariable("userId") Integer uid) {
		UserDto updatedUserDto = userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUserDto);
	}
	
	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	
  // GET - All users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> usersDtos = userService.getAllUsers();
		return ResponseEntity.ok(usersDtos);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		UserDto userDto = userService.getUserById(userId);
		return ResponseEntity.ok(userDto);
	}

}
