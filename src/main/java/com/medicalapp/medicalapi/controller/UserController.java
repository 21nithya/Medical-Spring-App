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



@Repository
@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;

	@PostMapping("user/save")
	public User save(@RequestBody User user) {
		userDAO.save(user);
		return user;
	}

	@GetMapping("user/listuser")
	public List<User> findAll() {
		List<User> listUser = userDAO.findAll();
		return listUser;
	}

	@PutMapping("user/{id}") // update
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userDAO.save(user);
	}

	@DeleteMapping("user/{Id}")
	public void delete(@PathVariable("id") Integer id, @RequestBody User user) {
		userDAO.deleteById(id);

	}

	@GetMapping("user/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userDAO.findById(id);
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
		Optional<User> userObj=userDAO.findByEmailAndPass(user.getEmail(),user.getPass());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
		return null;
		}
		
	}

}
