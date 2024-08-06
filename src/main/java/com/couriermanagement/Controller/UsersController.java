package com.couriermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.couriermanagement.Service.UsersService;
import com.couriermanagement.entity.User;
import com.couriermanagement.entity.Users;

@Controller
public class UsersController {
    @Autowired
	private UsersService uService;
    
    
    @GetMapping("/usersregister")
    public String userRegisterForm(Model model) {
    	model.addAttribute("users", new Users());
    	return "userregisterpage";
    }
    
    @PostMapping("/usersregister")
	public String registerUsers(@ModelAttribute("users") Users users, Model model) {
		uService.saveUsers(users);
		model.addAttribute("message", "Registered successfully");
		return "userregisterpage";
	}
   
    @GetMapping("/userslogin")
    public String usersLogin(Model model) {
    	model.addAttribute("users", new Users());
    	return "usersloginpage";
    }
    @PostMapping("/userslogin")
    public String userslogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        Users users = uService.userslogin(email, password);
        if (users != null) {
            model.addAttribute("users", users);
            return "redirect:/usersf ";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "userslogin";
        }
    }
    @GetMapping("/usersf")
    public String userFunction() {
    	return "usersfunctionpage";
    }
}
