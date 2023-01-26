package com.sportyshoes.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.eshop.Entity.ShoeEntity;
import com.sportyshoes.eshop.Entity.UserEntity;
import com.sportyshoes.eshop.repo.UserRepo;


@Service
public class UserImp {
	
	@Autowired
	private UserRepo ur;

	public void addUser(UserEntity ue) {
		if(ur.findByUsername(ue.getUsername())==null){
			ur.save(ue);
		}else {
			System.out.println("User already exists");
		}
		
		
	}
	
	
	public UserEntity getUserbyName(String name) {
		return ur.findByUsername(name);
		 
	}


	public List<UserEntity> getalltheuser() {
		
		return ur.findAll();
	}
	
	
	

}
