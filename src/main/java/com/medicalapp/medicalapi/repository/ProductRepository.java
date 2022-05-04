package com.medicalapp.medicalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalapp.medicalapi.model.Product;







@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
  
  //@Query("select u from com.medicalapp.medicalapi.controller.ListProducts u")
  //List<ListProducts> findAllProducts();
	

	
//  @Query ("select u from Student u where name like %ListProductsName%")
//	
//	List<ListProducts> findByName(String ListProductsName); 
  

	List<Product> findByProductNameContaining(String listProductsName);
}
 

