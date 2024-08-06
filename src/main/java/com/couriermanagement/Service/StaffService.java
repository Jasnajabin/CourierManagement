package com.couriermanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couriermanagement.Repository.StaffRepository;

import com.couriermanagement.entity.Staff;
import com.couriermanagement.entity.User;

@Service
public class StaffService {
    @Autowired
	private StaffRepository staffRepository;
    
    public Staff saveStaff(Staff staff) {
    	 
    	return staffRepository.save(staff);
    }
    public List<Staff> getAllStaff(){
		return staffRepository.findAll();
	}
    public Staff getStaff(int id) {
        return staffRepository.findById(id).orElse(null);
    }

    public void deleteStaff(int id) {
        staffRepository.deleteById(id);
    }
    public Staff login(String email, String password) {
        Staff staff= staffRepository.findByEmail(email);
        if (staff != null && staff.getPassword() != null && staff.getPassword().equals(password)) {
            return staff;
        }
        return null;
    }
    
}
