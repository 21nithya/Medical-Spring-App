package com.medicalapp.medicalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalapp.medicalapi.model.Order;

@Repository
	public interface OrderRepository extends JpaRepository<Order, Integer> {

		List<Order> findByuserId(Integer userid);


	 /*   @Transactional
		@Modifying
		@Query("update medical_orders o set o.status = :status where o.id=:id")
	    void changestatus(@Param("id") Integer id, @Param("status") String status);*/
		}











