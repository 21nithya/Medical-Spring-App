package com.medicalapp.medicalapi.validation;

import org.springframework.stereotype.Component;

import com.medicalapp.medicalapi.model.Product;




@Component


public class MedicalValidation {
	public void medicalValidation(Product product ) throws Exception{
		if(product.getProductName()==null || (product.getProductName()).trim()=="") {
			throw new Exception("No Product is avalable");
			
	}
		if(product.getBrandName()==null) {
			throw new Exception("select Brand name");
		}
		if(product.getPrice()== null || product.getPrice()<=0) {
			throw new Exception("Price Must not be null");
		}
}
}

