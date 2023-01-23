package com.example.onlinefooddelivery.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Size(min=5)
		private String adminUserName;
		@Size(min = 5)
		private String adminPassword;
}
