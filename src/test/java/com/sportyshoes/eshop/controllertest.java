package com.sportyshoes.eshop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sportyshoes.eshop.Entity.AdminEntity;
import com.sportyshoes.eshop.Entity.OrderEntity;
import com.sportyshoes.eshop.Entity.ShoeEntity;
import com.sportyshoes.eshop.Entity.UserEntity;
import com.sportyshoes.eshop.repo.UserRepo;
import com.sportyshoes.eshop.service.AdminService;
import com.sportyshoes.eshop.service.OrderImp;
import com.sportyshoes.eshop.service.ShoeServices;
import com.sportyshoes.eshop.service.UserImp;


@SpringBootTest
class controllertest {

	
	@Autowired
	private ShoeServices shoservice;
	
	@Autowired
	private UserImp ui;
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private OrderImp oi;
	
	@Autowired
	AdminService as;
	
	
	
	@Test
	public void addproduct() {
		
//		UserEntity ue=UserEntity.builder().address("Banglore").phoneNumber(84565255).username("Mac").build();		
//		ui.addUser(ue);
//		
//		ShoeEntity se=	ShoeEntity.builder().bandName("Nike").shoeColor("Yellow").shoeSize(8).build();	
//		shoservice.add(se);
		
		
//		UserEntity ue=ui.getUserbyName("Jenish");
//		ShoeEntity se=shoservice.getbyid(1);		
//		OrderEntity oe=OrderEntity.builder().customerName(ue.getUsername()).productName(se.getBandName()).productId(se.getProductID()).build();		
//		oi.purchase(oe);
		
		AdminEntity ae=AdminEntity.builder().userName("admin").password("pass").build();
		as.userID(ae);
		

	}
	
	
	


}
