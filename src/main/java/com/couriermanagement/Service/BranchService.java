package com.couriermanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.couriermanagement.Repository.BranchRepository;
import com.couriermanagement.entity.Branch;

@Service
public class BranchService {
    @Autowired
	private BranchRepository branchRepository;
    
    public Branch saveBranch(Branch b) {
    	return branchRepository.save(b);
    }
    public List<Branch> getAllBranch(){
		return branchRepository.findAll();
	}
    public Branch getBranch(int id) {
        return branchRepository.findById(id).orElse(null);
    }

    public void deleteBranch(int id) {
        branchRepository.deleteById(id);
    }
    
}
