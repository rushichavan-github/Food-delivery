package com.example.onlinefooddelivery.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Delivery {
		
	 	@Id
	    private long id;
	    
	    @Column(nullable = false)
	    private String deliveryAddress;
	    
	    @Column(nullable = false)
	    private String deliveryPhoneNumber;
	    
	    @Column(nullable = false)
	    private String deliveryName;
	    
	    @Column(nullable = false)
	    private String deliveryStatus;
	    
	    @Column(nullable = false)
	    private LocalDate deliveryDate;
	 
	    // getters and setters
	
}
