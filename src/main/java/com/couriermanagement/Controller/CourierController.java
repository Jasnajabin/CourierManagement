package com.couriermanagement.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.couriermanagement.Repository.CostRepository;
import com.couriermanagement.Service.BranchService;
import com.couriermanagement.Service.CourierService;
import com.couriermanagement.Service.StaffService;
import com.couriermanagement.entity.Branch;
import com.couriermanagement.entity.Cost;
import com.couriermanagement.entity.Courier;
import com.couriermanagement.entity.Payment;
import com.couriermanagement.entity.Staff;

@Controller
public class CourierController {
    @Autowired
	private CourierService courierService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private BranchService branchService;
    @GetMapping("/courier")
    public String addCourier(Model model) {
    	model.addAttribute("courier", new Courier());
    	model.addAttribute("branches", branchService.getAllBranch());
    	return "addcourier";
    }
    @PostMapping("/courier/save")
    public RedirectView saveCourier(@RequestParam("weight") int weight,@ModelAttribute("courier") Courier courier,Model model) {
    	 courierService.saveCourier(courier);
    	double totalPrice = courierService.calculateTotalPrice(weight);
        return new RedirectView("/courier/payment?totalPrice=" + totalPrice);
    }
    @GetMapping("/courier/payment")
    public String paymentForm(@RequestParam("totalPrice") double totalPrice,Model model) {
    	model.addAttribute("pay", new Payment());
    	 model.addAttribute("totalPrice", totalPrice);
    	return "courierpayment";
    }
    @PostMapping("/payment/save")
    public String savePayment(@ModelAttribute("pay")Payment pay,Model model) {
    	 double totalPrice = calculateTotalPrice(pay.getWeight());
    	    pay.setTotalPrice(totalPrice);
	    courierService.savePay(pay);
         model.addAttribute("message", "Payment processed successfully");
     	return "courierpayment";
    }
	private double calculateTotalPrice(Object weight) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	  @GetMapping("/viewcourier")
	    public String viewCourier(Model model) {
		  model.addAttribute("couriers", courierService.getAllCourier());
	    	return "viewcourier";
	    }
	  
	  @GetMapping("/viewcourier/delete/{id}")
	    public String deleteCourier(@PathVariable long id) {
	        courierService.deleteCourier(id);
	        return "redirect:/viewcourier";
	    }
	 
	  
	  @GetMapping("/assignStaff/{id}")
	    public String showAssignStaffForm(@PathVariable("id") Long courierId, Model model) {
	        Courier courier = courierService.getCourierById(courierId);
	         model.addAttribute("courier", courier);
	        model.addAttribute("branches", branchService.getAllBranch());
	        model.addAttribute("staffes", staffService.getAllStaff());

	        return "assignstaff";
	    }


	  @PostMapping("/assignStaff")
	    public String assignStaff(@RequestParam("courierId") Long courierId,
	                              @RequestParam("staffId") int staffId) {
	        courierService.assignStaffToCourier(courierId, staffId);
	        return "redirect:/viewcourier";
	    }
	  
	  @GetMapping("/viewstaffcourier")
	    public String viewStaffCourier(Model model) {
		  model.addAttribute("couriers", courierService.getAllCourier());
	    	return "staffviewcourier";
	    }
	  
	  
	  
	  
	  
	  @GetMapping("/updatestatus/{id}")
	  public String updateCourier(@PathVariable ("id") Long courierId,Model model) {
		  
		  Courier courier = courierService.getCourierById(courierId);
	         model.addAttribute("courier", courier);
	         model.addAttribute("staffes", staffService.getAllStaff());

		  return "updatestatus";
	  }
	  
	  @PostMapping("/updatestatus")
	    public String saveViewStaffCourier(@RequestParam("courierId") Long courierId,@RequestParam("updatestatus")String updatestatus) {
	       courierService.updateCourierStatus(courierId, updatestatus);
	       
	        return "redirect:/viewstaffcourier";
	    }
	  
	  @GetMapping("/track")
	    public String trackCouriers(
	            @RequestParam(value = "trackingNo", required = false, defaultValue = "") String trackingNumber,
	            @RequestParam(value = "updatestatus", required = false, defaultValue = "") String status,
	            Model model) {

	       
	        List<Courier> couriers = courierService.searchCouriers(trackingNumber, status);
	        model.addAttribute("couriers", couriers);

	        return "viewcourier"; 
	    }
	  
	  @GetMapping("/viewcourier/courierdetails/{id}")
      public String courierDetailsForm(@PathVariable("id") Long id,Model model) {
		  Courier courier = courierService.getCourierById(id);
		  model.addAttribute("couriers", courier);
    	  return "courierdetails";
      }
	  @GetMapping("/trackcourier")
	  public String trackCourier(Model model){
		  model.addAttribute("couriers", courierService.getAllCourier());
		  return "trackcourier";
	  }
	  @GetMapping("/usertrack")
	    public String usertrackCouriers(
	            @RequestParam(value = "trackingNo", required = false, defaultValue = "") String trackingNumber,
	            @RequestParam(value = "updatestatus", required = false, defaultValue = "") String status,
	            Model model) {

	       
	        List<Courier> couriers = courierService.searchCouriers(trackingNumber, status);
	        model.addAttribute("couriers", couriers);

	        return "trackcourier"; 
	    }
	  @GetMapping("/stafftrack")
	    public String staffViewCouriers(
	            @RequestParam(value = "trackingNo", required = false, defaultValue = "") String trackingNumber,
	            @RequestParam(value = "updatestatus", required = false, defaultValue = "") String status,
	            Model model) {

	       
	        List<Courier> couriers = courierService.searchCouriers(trackingNumber, status);
	        model.addAttribute("couriers", couriers);

	        return "staffviewcourier"; 
	    }
}
