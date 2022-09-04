package com.prodapt.registrationform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.registrationform.entities.User;
import com.prodapt.registrationform.exceptions.InvalidCredentialsException;
import com.prodapt.registrationform.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ModelAndView loginUser(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("userlogged");
		} catch (InvalidCredentialsException e) {
			mv.addObject("errormsg", "Username or Password incorrect");
			mv.setViewName("login");
		}

		return mv;
	}

	@GetMapping("/loginform")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "login";
	}

}
