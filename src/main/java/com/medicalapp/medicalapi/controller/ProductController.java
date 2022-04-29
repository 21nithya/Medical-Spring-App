package com.medicalapp.medicalapi.controller;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("Product/list")
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

//	@GetMapping("Product/{id}")//find user by id
//	public ListProducts findById(@PathVariable("id") Integer id) {
//		Optional<ListProducts> list = productDAO.findById(id);
//		if(list.isPresent()) {
//		 ListProducts obj = list.get();
//		 return obj;
//		}
//		else {
//			return null;
//		}
//   }
//	@GetMapping("ListProducts/{ListProductsName}")
//	public List<ListProducts> findAll(@RequestParam String ListProductsName) {
//		return productDAO.findByName(ListProductsName);
//}
	}
