package com.sportyshoes.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.eshop.Entity.AdminEntity;
import com.sportyshoes.eshop.repo.adminRepo;

@Service
public class AdminService {
	
	@Autowired
	adminRepo ar;
	
	
	public String userID(AdminEntity ae) {
		ar.save(ae);
		return "Login done";
	}
	
	public boolean isValid(AdminEntity ae) {
		return ar.findAll().contains(ae);
	}
}
