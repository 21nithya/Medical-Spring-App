package com.medicalapp.medicalapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medicalapp.medicalapi.model.Product;
import com.medicalapp.medicalapi.service.MedicalService;


@RestController
public class ProductController {
	
	
	@Autowired
	MedicalService medicalService;


	@PostMapping("Product/save")
	public ResponseEntity<String> save(@RequestBody Product product) {
		//String result ="Successs";
		try {
			
			medicalService.save(product);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("Product/list")//product
	public List<Product> findAllMedicines() {
		List<Product> list = null;
		try {
			list=medicalService.findAll();
		}catch(Exception e) {
			
			e. printStackTrace();
		}
		return list;
	}

	@PutMapping("Product/{id}") // update
	public void update(@PathVariable("id") Integer id, @RequestBody Product product) {
		product.setId(id);
		try {
			medicalService.save(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping("Product/{id}")
	public void delete(@PathVariable("id") Integer id, @RequestBody Product product) {
		medicalService.deleteById(id);

	}

	@GetMapping("Product/{id}")//find user by id
	public Product findById(@PathVariable("id") Integer id) {
		System.out.println("findById"+ id);
		Optional<Product> list = medicalService.findById(id);
		if(list.isPresent()) {
		 Product obj = list.get();
		 return obj;
		}
		else {
			return null;
		}
   }
	@GetMapping("ListProducts/name")
	public List<Product> findByName(@RequestParam("name") String ListProductsName) throws Exception {
		System.out.println(ListProductsName);
		List<Product> list= medicalService.findAll();
		List<Product> filteredlist = list.stream().filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase())).collect(Collectors.toList());
//				.filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase()).collectors.tolist());
		
	    //List<ListProducts> list=productDAO.findByProductNameContaining(ListProductsName);
	    return filteredlist;
}
	
	
		
	

	}
