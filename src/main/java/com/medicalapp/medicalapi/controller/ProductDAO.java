package com.medicalapp.medicalapi.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<ListProducts,Integer>{
  
  //@Query("select u from com.medicalapp.medicalapi.controller.ListProducts u")
  //List<ListProducts> findAllProducts();
	

	
//  @Query ("select u from Student u where name like %ListProductsName%")
//	
//	List<ListProducts> findByName(String ListProductsName); 
  

	List<ListProducts> findByProductNameContaining(String listProductsName);
}
 

