package com.prodapt.registrationform.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.registrationform.entities.Role;
import com.prodapt.registrationform.entities.User;
import com.prodapt.registrationform.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private User user;
	@Autowired
	private RoleService roleService;

	@GetMapping("/roleform")
	public String showRegistrationForm(@ModelAttribute("role") Role role) {
		return "role";
	}

	
	@PostMapping("/saverole")
	public ModelAndView saveRole(@ModelAttribute("user") User user, @ModelAttribute("role") Set<Role> role) {
		 user.setRoles(role);
//		Role rol =roleService.addRole(role);
		ModelAndView mv = new ModelAndView();
//		mv.addObject("roleData", rol);
		mv.setViewName("role");
		return mv;
	}
}
