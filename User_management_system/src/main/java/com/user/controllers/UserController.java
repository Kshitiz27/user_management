package com.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.repositories.UserRepo;
import com.user.entities.User;
import com.user.exceptions.ResourceNotFoundException;

import java.util.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/")
	public List<User> getAllUser(){
		List<User> user = this.userrepo.findAll();
		return user;
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return this.userrepo.save(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId){
		User usr = this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this id: " + userId));
		return ResponseEntity.ok(usr);
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable Integer userId) {
		User usr = this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this id: " + userId));
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setEmailId(user.getEmailId());
		
		return this.userrepo.save(usr);
	}
	
	@DeleteMapping("/deleteUser/{userid}")
	public String deleteUser(@PathVariable Integer userid) {
		this.userrepo.deleteById(userid);
		return "DELETED SUCCESSFULLY!";
	}
	
}
