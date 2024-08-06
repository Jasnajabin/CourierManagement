package com.couriermanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.couriermanagement.Service.BranchService;
import com.couriermanagement.Service.StaffService;
import com.couriermanagement.entity.Branch;
import com.couriermanagement.entity.Staff;
import com.couriermanagement.entity.User;

@Controller
public class StaffController {
    @Autowired
	private StaffService staffService;
    @Autowired
    private BranchService branchService;
    
    @GetMapping("/staff/form")
	public String staffForm(Model model) {
		model.addAttribute("staff", new Staff());
		model.addAttribute("branches", branchService.getAllBranch());
		return "addstaff";
	}
	 @PostMapping("/staff/save")
	    public String saveStaff(@ModelAttribute("staff") Staff staff) {
	        staffService.saveStaff(staff);
	        return "redirect:/staff/list";
	    }
	 @GetMapping("/staff/list")
	    public String getAllStaff(Model model) {
		 List<Staff>list=staffService.getAllStaff();
		    model.addAttribute("staffes", list);
	        return "stafflist";
	    }
	 @GetMapping("/staff/edit/{id}")
	    public String editStaff(@PathVariable int id, Model model) {
	       Staff staff = staffService.getStaff(id);
	        model.addAttribute("staff", staff);
	        return "edit-staff";
	    }
	  @PostMapping("/staff/edit/{id}")
	    public String updateStaff(@PathVariable int id, @ModelAttribute("staff")Staff staff) {
	        staffService.saveStaff(staff);
	        return "redirect:/staff/list";
	    }
	  @GetMapping("/staff/delete/{id}")
	    public String deleteBranch(@PathVariable int id) {
	        staffService.deleteStaff(id);
	        return "redirect:/staff/list";
	    }
	  @GetMapping("/stafflogin")
	  public String staffLogin(Model model) {
		  model.addAttribute("staff", new Staff());
		  return "staffloginpage";
	  }
	  @PostMapping("/stafflogin")
	    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	       Staff staff = staffService.login(email, password);
	        if (staff != null) {
	            model.addAttribute("staff", staff);
	            return "redirect:/staff";
	        } else {
	            model.addAttribute("error", "Invalid email or password");
	            return "stafflogin";
	        }
	    }
	  @GetMapping("/staff")
	  public String showStaffpage() {
		  return "staffpage";
	  }
}
