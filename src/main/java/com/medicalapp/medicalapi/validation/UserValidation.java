package com.medicalapp.medicalapi.validation;

import javax.validation.ValidationException;

import org.springframework.stereotype.Component;

import com.medicalapp.medicalapi.model.User;


@Component
public class UserValidation {
 
	public void userValidator(User user) throws Exception{
		if(user.getName()==null|| (user.getName()).trim()=="") {
			throw new Exception("Name must not be null");
		}
		if(user.getEmail()==null ||!(user.getEmail()).contains("@gamil.com")) {
			throw new Exception("Mail must contain @ and gamil");
		}
		if(user.getPass().length()<=8) {
			throw new Exception("password must be above 8");
		}
	}
	
	public static void validateLogin(User userLogin) throws ValidationException {
		if (userLogin.getEmail() == null || userLogin.getEmail().trim().equals("")) {
			throw new ValidationException ("Invalid email");
		} else if (!userLogin.getEmail().contains("@")) {
			throw new ValidationException ("Email should contain @");
		}
		if (userLogin.getPass() == null || userLogin.getPass().trim().equals("")) {
			throw new ValidationException ("Invalid password");
		} else if (userLogin.getPass().length() < 8) {
			throw new ValidationException ("Password must be minimum 8 characters");
		}
	}
}
