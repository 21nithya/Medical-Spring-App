package com.medicalapp.medicalapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalapp.medicalapi.model.Product;
import com.medicalapp.medicalapi.repository.ProductRepository;
import com.medicalapp.medicalapi.validation.MedicalValidation;

@Service
public class MedicalService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	MedicalValidation medicalValidation;

	public void save(Product product) throws Exception {
		try {
			medicalValidation.medicalValidation(product);
			productRepository.save(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> findAll() throws Exception {
		List<Product> listproduct;
		try {
			listproduct=productRepository.findAll();
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return listproduct;
	} 
}
