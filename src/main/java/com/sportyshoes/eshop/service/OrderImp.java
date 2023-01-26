package com.sportyshoes.eshop.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.eshop.Entity.OrderEntity;
import com.sportyshoes.eshop.repo.OrderRepo;

@Service
public class OrderImp {
	
	@Autowired
	OrderRepo or;
	
	public void purchase(OrderEntity oe) {
		or.save(oe);
	}

	public List<OrderEntity> getAllOrder() {
		return or.findAll();
	}

	public List<OrderEntity> filterbybrandName(String brand) {
		
		return or.findByProductName(brand);
	}
	
	
//	public List<OrderEntity> filterbydate(Timestamp startDate, Timestamp endDate){
//		return or.findByOrderDateBetween(startDate, endDate);
//	}
	

}
