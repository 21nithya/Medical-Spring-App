package com.medicalapp.medicalapi.model;
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
	@Table(name= "register")
	public class User{
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(name="name", nullable=false,length=100)
		private String name;
		@Column(name="email", unique= true)
		private String email;
		@Column(name="pass", nullable=false)
		private String pass;
	}
