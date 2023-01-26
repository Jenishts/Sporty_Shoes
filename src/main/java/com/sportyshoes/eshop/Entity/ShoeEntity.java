package com.sportyshoes.eshop.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	private String bandName;
	private String shoeColor;
	private int shoeSize;

	
	
	
	

}
