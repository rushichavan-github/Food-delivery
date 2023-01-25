package com.example.onlinefooddelivery.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	@NotNull
	@Size(min=5)
	private String name;
	@NotNull
	@Size(min=5,max=20)
	private String password;
	@NotNull
	private String address;
	@NotNull
	private long mobileNumber;
	@NotNull
	private String emailId;
	

}
