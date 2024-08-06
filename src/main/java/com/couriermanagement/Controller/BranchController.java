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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.couriermanagement.Service.BranchService;
import com.couriermanagement.entity.Branch;




@Controller
public class BranchController {
	@Autowired
	private BranchService bService;
	

	@GetMapping("/branch/form")
	public String branchForm(Model model) {
		model.addAttribute("branch", new Branch());
		return "branch";
	}
	 @PostMapping("/branch/save")
	    public String saveBranch(@ModelAttribute("branch") Branch branch) {
	        bService.saveBranch(branch);
	        return "redirect:/branch/list";
	    }
	 @GetMapping("/branch/list")
	    public String getAllBranch(Model model) {
		 List<Branch>list=bService.getAllBranch();
		    model.addAttribute("branches", list);
	        return "branchlist";
	    }
	 @GetMapping("/branch/edit/{id}")
	    public String editBranch(@PathVariable int id, Model model) {
	        Branch branch = bService.getBranch(id);
	        model.addAttribute("branch", branch);
	        return "edit-branches";
	    }
	  @PostMapping("/branch/edit/{id}")
	    public String updateBranch(@PathVariable int id, @ModelAttribute("branch") Branch branch) {
	        bService.saveBranch(branch);
	        return "redirect:/branch/list";
	    }
	  @GetMapping("/branch/delete/{id}")
	    public String deleteBranch(@PathVariable int id) {
	        bService.deleteBranch(id);
	        return "redirect:/branch/list";
	    }

}
