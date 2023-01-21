package com.example.onlinefooddelivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinefooddelivery.entities.Admin;
import com.example.onlinefooddelivery.exceptions.AdminAlreadyExistsException;
import com.example.onlinefooddelivery.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	private AdminRepository adRepo;
	
	@Override
	public Admin saveAdmin(Admin ad) throws AdminAlreadyExistsException {
		// TODO Auto-generated method stub
		if(adRepo.existsById(ad.getId())) {
			throw new AdminAlreadyExistsException();
		}
		
		return adRepo.save(ad);
	}

	@Override
	public String loginAdmin(Admin ad) {
		// TODO Auto-generated method stub
		Optional<Admin> admin =adRepo.findById(ad.getId());
		if(admin.isPresent()) {
			if(admin.get().getAdminPassword().equals(ad.getAdminPassword()))
				return "Successfully Logged In";
		}
		return "Invalid Credentials";
	}

	@Override
	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return adRepo.findAll();
	}

}
