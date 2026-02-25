package com.akp.area.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.akp.area.Repository.UserRepo;
import com.akp.area.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User insertEmp(User user) {
		User SavedUser=userRepo.save(user);
		return SavedUser;
	}
	
	public List<User> getAllEmp(){
		List<User> users=userRepo.findAll();
		return users;
		
	}
	
	public String deleteEmp(long id) {
		if(!userRepo.existsById(id)) {
			return "ID NOT FOUND";
		}
		userRepo.deleteById(id);
		return "deleted successfully";
	}
	
	public User updateEmp(User user,Long id) {
		if(!userRepo.existsById(id)) {
			return null;
		}
		User newUser=userRepo.findById(id).orElseThrow();
		newUser.setName(user.getName());
		newUser.setAddress(user.getAddress());
		User updateUser=userRepo.save(newUser);
		return updateUser;
	}

}
