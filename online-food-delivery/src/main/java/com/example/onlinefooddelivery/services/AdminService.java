package com.example.onlinefooddelivery.services;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.onlinefooddelivery.entities.Admin;
import com.example.onlinefooddelivery.exceptions.AdminAlreadyExistsException;

import jakarta.validation.Valid;

@Validated
public interface AdminService {

	Admin saveAdmin(@Valid Admin ad)throws AdminAlreadyExistsException;

	String loginAdmin(Admin ad);

	List<Admin> getAdmin();

}
