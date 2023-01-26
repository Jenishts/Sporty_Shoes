package com.sportyshoes.eshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportyshoes.eshop.Entity.ShoeEntity;

public interface ShoeServices {

	void add(ShoeEntity se);

	public List<ShoeEntity> getallproduct();

	public void deleteproductbyId(int id);

	public ShoeEntity getbyid(int id);

	
	
	
}
