package com.medicalapp.medicalapi.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;



@Data
@ToString 
@Entity
@Table(name="medical_display")
public class ListProducts {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer id;
	
	@Column(name="product_name", nullable=false, length= (100))
	private String productName;
	
	@Column(name="brand_name", unique= true)
	private String brandName;
	
	@Column(name="price", nullable=false)
	private String price;
	
	@Column(name="image", nullable=false)
	private String image;

}
