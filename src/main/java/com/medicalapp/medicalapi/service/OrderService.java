package com.medicalapp.medicalapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalapp.medicalapi.model.Order;
import com.medicalapp.medicalapi.repository.OrderRepository;



@Service
public class OrderService {
	
	

		@Autowired
		OrderRepository orderRepository;

		public void save(Order order) throws Exception {
			try {

				orderRepository.save(order);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

		public List<Order> findAll() throws Exception {
			List<Order> listorder = null;
			try {
				listorder = orderRepository.findAll();

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
			return listorder;
		}

		public Order findById(Integer id) {

			Optional<Order> order = orderRepository.findById(id);
			if (order.isPresent()) {
				Order orderObj = order.get();
				return orderObj;
			} else {
				return null;
			}
		}

		/*public Order changeStatus(Integer id, String status) {

			Optional<Order> order = orderRepository.save(id, status);
			if (order.isPresent()) {
				Order orderObj = order.get();
				return orderObj;
			} else {
				return null;
			}*/
		}


