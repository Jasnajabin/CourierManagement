package com.couriermanagement.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couriermanagement.Repository.RoleRepository;
import com.couriermanagement.Repository.UserRepository;
import com.couriermanagement.entity.Role;
import com.couriermanagement.entity.User;

@Service
public class UserService{
    @Autowired
	private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    
    
    public User saveUser(User user,String role) {
    	userRepository.save(user);
    	return user;
    }
    
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    
   
    

}
	
