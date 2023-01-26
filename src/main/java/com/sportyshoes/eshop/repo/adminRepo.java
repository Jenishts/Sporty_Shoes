package com.sportyshoes.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.eshop.Entity.AdminEntity;

@Repository
public interface adminRepo extends JpaRepository<AdminEntity, Integer>{

}
