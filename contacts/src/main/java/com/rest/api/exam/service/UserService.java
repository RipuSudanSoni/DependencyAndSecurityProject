package com.rest.api.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.exam.entity.User;


@Service
public interface UserService {
	
	public User createUser(User user);
	public User getUser(Long id);
	public List<User> getAllUser();
	public User updateContact(User user, Long id);
	public String deleteUser(Long id);
	
}
