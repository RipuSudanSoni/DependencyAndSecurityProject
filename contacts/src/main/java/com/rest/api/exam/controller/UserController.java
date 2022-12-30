package com.rest.api.exam.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.exam.entity.User;
import com.rest.api.exam.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getContact(@PathVariable Long id) {
		User contact = userService.getUser(id);
		return new ResponseEntity<User>(contact, HttpStatus.OK);
	}
	
	@GetMapping("/getAll/user/")
	public ResponseEntity<List<User>> getAllContact() {
		List<User> contacts = userService.getAllUser();
		return new ResponseEntity<List<User>>(contacts, HttpStatus.OK);
	}
	
	@PostMapping("/create/user")
	public ResponseEntity<HttpStatus> createContact(@RequestBody User contact) {
		userService.createUser(contact);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/user/{id}")
	public ResponseEntity<User> updateContact(@PathVariable Long id, @RequestBody User contact) {
		userService.updateContact(contact, id);
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/user/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
