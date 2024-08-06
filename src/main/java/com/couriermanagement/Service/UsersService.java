package com.couriermanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couriermanagement.Repository.UsersRepository;
import com.couriermanagement.entity.User;
import com.couriermanagement.entity.Users;

@Service
public class UsersService {
    @Autowired
	private UsersRepository uRepo;
    
    
    public Users saveUsers(Users users) {
    	return uRepo.save(users);
    }
    public Users userslogin(String email, String password) {
    	 Users usersList= uRepo.findByEmail(email);
        if (usersList!=null && usersList.getPassword().equals(password)) {
        	
                return usersList;
 
    }
        return null;	
}
    
}
