package com.sportyshoes.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.eshop.Entity.ShoeEntity;

@Repository
public interface ShoeRepo extends JpaRepository<ShoeEntity, Integer> {

}
