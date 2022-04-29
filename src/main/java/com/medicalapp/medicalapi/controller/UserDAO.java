package com.medicalapp.medicalapi.controller;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends JpaRepository<User,Integer>{
	//@Transactional
	//@Modifying
	//@Query("upade register u set u.password=:password where u.id=:id")
	//void changePassword(@Param("id") Integer id,@Param("password") String password);
	
    //User findByEmailAndPassword(String email, String Pssword);
}

