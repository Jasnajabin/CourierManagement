package com.couriermanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couriermanagement.Repository.CostRepository;
import com.couriermanagement.entity.Branch;
import com.couriermanagement.entity.Cost;

@Service
public class CostService {
    @Autowired
	private CostRepository costRepository;
    
   
    public Cost getCurrentCost() {
    	return costRepository.findById(1L).orElse(new Cost());
    }

    public void updateCost(Cost cost) {
    	cost.setId(1L);
        costRepository.save(cost);
    }
    
}
