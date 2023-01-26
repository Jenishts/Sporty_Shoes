package com.sportyshoes.eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.eshop.Entity.ShoeEntity;
import com.sportyshoes.eshop.repo.ShoeRepo;

@Service
public class ShoeServiceImplement implements ShoeServices {
	
	
	@Autowired
	ShoeRepo sr;

	@Override
	public void add(ShoeEntity se) {
		sr.save(se);
	}

	@Override
	public List<ShoeEntity> getallproduct() {
		
		return sr.findAll();
	}

	@Override
	public void deleteproductbyId(int id) {
		
		if(sr.findById(id).isPresent()) {
			sr.deleteById(id);;
		}
		
		
	}

	@Override
	public ShoeEntity getbyid(int id) {
		
		return sr.findById(id).orElse(null);
		
		
	}

	
	
}
