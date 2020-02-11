package com.capgemini.storemanagement.service;

import java.util.List;

import com.capgemini.storemanagement.dao.AdminDAO;
import com.capgemini.storemanagement.dto.Users;

public class AdminServiceImpl implements AdminService{

	
	private AdminDAO dao;

	@Override
	public List<String> loginAdmin(String userId, String password) {
		return dao.loginAdmin(userId, password);
	}

	@Override
	public boolean addManufactur(Users user) {
		return dao.addManufactur(user);
	}

	@Override
	public boolean updateManufactur(String user) {
		return dao.updateManufactur(user);
	}

	@Override
	public boolean deleteManufactur(String userId) {
		return dao.deleteManufactur(userId);
	}

	@Override
	public List<String> viewAllManufacturs(String role) {
		return dao.viewAllManufacturs(role);
	}
}
