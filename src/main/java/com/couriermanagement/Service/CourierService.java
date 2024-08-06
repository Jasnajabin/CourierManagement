package com.couriermanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couriermanagement.Repository.CostRepository;
import com.couriermanagement.Repository.CourierRepository;
import com.couriermanagement.Repository.PaymentRepository;
import com.couriermanagement.Repository.StaffRepository;
import com.couriermanagement.entity.Branch;
import com.couriermanagement.entity.Cost;
import com.couriermanagement.entity.Courier;
import com.couriermanagement.entity.Payment;
import com.couriermanagement.entity.Staff;

@Service
public class CourierService {
    @Autowired
	private CourierRepository cRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
	private CostRepository costRepository;
    @Autowired
    private StaffRepository staffRepository;
    
    public Courier saveCourier(Courier courier) {
    	 
    	return cRepository.save(courier);
    }
    public void savePay(Payment pay) {
    	 paymentRepository.save(pay);
    }
    public double calculateTotalPrice(int weight) {
        Cost cost = costRepository.findTopByOrderByIdDesc();
        if (cost == null) {
            throw new IllegalArgumentException("No pricing information available.");
        }

        double totalPrice;
        if (weight <= 100) {
            totalPrice = cost.getCostlessthan() * weight;
        } else {
            totalPrice = cost.getCostgreaterthan() * weight;
        }

        return totalPrice;
    }
    
    public List<Courier> getAllCourier(){
  		return cRepository.findAll();
  	}
    public void deleteCourier(long id) {
       cRepository.deleteById(id);
    }
    public Courier getCourierById(Long id) {
        return cRepository.findById(id).orElse(null);
    }

    public void assignStaffToCourier(Long courierId, int staffId) {
        Courier courier = cRepository.findById(courierId).orElse(null);
        if (courier != null) {
            Staff staff = staffRepository.findById(staffId).orElse(null);
            if (staff != null) {
                courier.setAssignstaff(staff);
                cRepository.save(courier);
            } else {
                // Handle case where staff is not found
                throw new RuntimeException("Staff with id " + staffId + " not found");
            }
        } else {
            // Handle case where courier is not found
            throw new RuntimeException("Courier with id " + courierId + " not found");
        }
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
   
    public void updateCourierStatus(Long courierId, String updatestatus) {
        Courier courier = getCourierById(courierId);
        courier.setUpdatestatus(updatestatus);
        cRepository.save(courier);
    }
    
    public void save(Courier courier) {
        cRepository.save(courier);
    }
    
// 
//   
    public List<Courier> searchCouriers(String trackingNo, String updatestatus) {
   
    if (trackingNo.isEmpty()) {
        trackingNo = null;
    }
    if (updatestatus.isEmpty()) {
        updatestatus = null;
    }
    return cRepository.searchByTrackingNumberAndStatus(trackingNo, updatestatus);
}
    
    }

