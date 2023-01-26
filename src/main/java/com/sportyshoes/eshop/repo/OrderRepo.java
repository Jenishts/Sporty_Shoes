package com.sportyshoes.eshop.repo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.eshop.Entity.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{
	
	public List<OrderEntity> findByProductName(String brand);
	
//	List<OrderEntity> findByOrderDateBetween(Timestamp startDate, Timestamp endDate);

	
}
