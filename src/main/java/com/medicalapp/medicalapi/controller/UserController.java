package com.medicalapp.medicalapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.medicalapp.medicalapi.model.User;
import com.medicalapp.medicalapi.repository.UserRepository;





@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("user/save")
	public User save(@RequestBody User user) {
		User user1=userRepository.save(user);
		return user1;
	}

	@GetMapping("user/listuser")
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}

	@PutMapping("user/{id}") // update
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
	}

	@DeleteMapping("user/{Id}")
	public void delete(@PathVariable("id") Integer id, @RequestBody User user) {
		userRepository.deleteById(id);

	}

	@GetMapping("user/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User userobj = user.get();
			return userobj;
		} else {
			return null;
		}
	}
//		@GetMapping("users/login")
//		public User login(
//				@RequestParam("email") String email,
//				@RequestParam("password") String password) {
//			User user = userDAO.findByEmailAndPassword(email, password);
//			if(user == null) {
//				//throw new Exception("Invalid Login Credentials");
//			}
//			return user;

//	}
	
	@PostMapping("users/login")
	public User login(@RequestBody User user) {
		Optional<User> userObj=userRepository.findByEmailAndPass(user.getEmail(),user.getPass());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
		return null;
		}
		
	}
	
//	@GetMapping("user/email")
//	public User getUserByEmail(@RequestParam("email")String email) {
//		
//		return userDAO(email);
//	}
//	
//	@PutMapping("user/{id}")
//	public void updateResetPassword@pathVariable("id") Integer id, @RequestBody User user) {
//		User users=userDAO.findByEmail(user.getPassword());
//		System.out.println(user);
//		if(user !=null) {
//			user.setPassword(user.getPassword());
//			userDAO.save(user);
//		}else {
//			System.out.println("no match found in emailId");
//		}
//	}

}
