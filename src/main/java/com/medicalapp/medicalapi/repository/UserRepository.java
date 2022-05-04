package com.medicalapp.medicalapi.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalapp.medicalapi.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByEmailAndPass(String email, String pass);
	//@Transactional
	//@Modifying
	
	//@Query("upade register u set u.password=:password where u.id=:id")
	//void changePassword(@Param("id") Integer id,@Param("password") String password);

	User findByEmail(String email);
	
    //User findByEmailAndPassword(String email, String Pssword);
}

