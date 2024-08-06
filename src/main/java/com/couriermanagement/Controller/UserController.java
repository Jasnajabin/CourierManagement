package com.couriermanagement.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.couriermanagement.Service.CostService;
import com.couriermanagement.Service.UserService;
import com.couriermanagement.entity.Branch;
import com.couriermanagement.entity.Cost;
import com.couriermanagement.entity.Role;
import com.couriermanagement.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
    @Autowired
	private CostService cService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "registerpage";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		String role = "USER";
		userService.saveUser(user, role);
		model.addAttribute("message", "Registered successfully");
		return "registerpage";
	}
	 @GetMapping("/login")
	    public String showLoginPage(@RequestParam(required = false) String role, Model model) {
		    model.addAttribute("user", new User());
	        model.addAttribute("role", new Role());
	        return "loginpage";
	    }

	 @PostMapping("/login")
	    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	        User user = userService.login(email, password);
	        if (user != null) {
	            model.addAttribute("user", user);
	            return "redirect:/admin ";
	        } else {
	            model.addAttribute("error", "Invalid email or password");
	            return "login";
	        }
	    }
	 @GetMapping("/admin")
		public String adminFunction(Model model) {
			return "adminpage";
		}

	   

	 @GetMapping("/pricing")
	    public String showAdminPricing(Model model) {
		 Cost currentCost = cService.getCurrentCost();
	        model.addAttribute("cost",currentCost );
	        return "updatepricing";
	    }

	    @PostMapping("/pricesave")
	    public String updateAdminPricing(@ModelAttribute("cost") Cost updatedCost) {
	        cService.updateCost(updatedCost);
	        return "redirect:/priceview"; 
	    }
	    @GetMapping("/priceview")
	     public String viewPricing(Model model) {
	    	model.addAttribute("costs", cService.getCurrentCost());
	    	 return"viewpricing";
	     }
	    @GetMapping("/userpricing")
	    public String viewUserPricing(Model model) {
	        model.addAttribute("costs", cService.getCurrentCost());
	        return "userpricing"; 
	    }
	  

}
