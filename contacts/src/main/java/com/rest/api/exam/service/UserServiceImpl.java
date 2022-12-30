package com.rest.api.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.exam.entity.User;
import com.rest.api.exam.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUser(Long id) {
		User user = userRepo.findById(id).get();
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User updateContact(User contact, Long id) {
		User preContact = userRepo.findById(id).get();
		preContact.setId(contact.getId());
		preContact.setName(contact.getName());
		preContact.setPhoneNumber(contact.getPhoneNumber());
		preContact.setEmail(contact.getEmail());
		preContact.setPassword(contact.getPassword());
		return userRepo.save(preContact);

	}

	@Override
	public String deleteUser(Long id) {
		userRepo.deleteById(id);
		return "contact Deleted successfully";
	}
	
	
}
