package com.medicalapp.medicalapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;

	@PostMapping("Product/save")
	public ListProducts save(@RequestBody ListProducts product) {
		productDAO.save(product);
		return product;
	}

	@GetMapping("Product/list")//product
	public List<ListProducts> findAllMedicines() {
		List<ListProducts> list = productDAO.findAll();
		return list;
	}

	@PutMapping("Product/{id}") // update
	public void update(@PathVariable("id") Integer id, @RequestBody ListProducts product) {
		product.setId(id);
		productDAO.save(product);
	}

	@DeleteMapping("Product/{id}")
	public void delete(@PathVariable("id") Integer id, @RequestBody ListProducts product) {
	   productDAO.deleteById(id);

	}

	@GetMapping("Product/{id}")//find user by id
	public ListProducts findById(@PathVariable("id") Integer id) {
		System.out.println("findById"+ id);
		Optional<ListProducts> list = productDAO.findById(id);
		if(list.isPresent()) {
		 ListProducts obj = list.get();
		 return obj;
		}
		else {
			return null;
		}
   }
	@GetMapping("ListProducts/name")
	public List<ListProducts> findByName(@RequestParam("name") String ListProductsName) {
		System.out.println(ListProductsName);
		List<ListProducts> list= productDAO.findAll();
		List<ListProducts> filteredlist = list.stream().filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase())).collect(Collectors.toList());
//				.filter(m->m.getProductName().toLowerCase().contains(ListProductsName.toLowerCase()).collectors.tolist());
		
	    //List<ListProducts> list=productDAO.findByProductNameContaining(ListProductsName);
	    return filteredlist;
}
	
	
		
	

	}
