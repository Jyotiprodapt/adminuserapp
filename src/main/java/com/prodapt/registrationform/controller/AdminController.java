package com.prodapt.registrationform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.registrationform.entities.User;
import com.prodapt.registrationform.entities.UserDetails;
import com.prodapt.registrationform.exceptions.InvalidCredentialsException;
import com.prodapt.registrationform.service.UserDetailsService;
import com.prodapt.registrationform.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/index")
	public String showAdminForm(@ModelAttribute("user") User user) {
		return "index";
	}

	@GetMapping("/update")
	public String update(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "update";
	}

	@PutMapping("/updated")
	public ModelAndView updatedUser(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userdetails) {
		user.setUserDetails(userdetails);
		User userData = userService.updateUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		mv.addObject("updatedData", userData);
		return mv;
	}

	@GetMapping("/delete")
	public String delete(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "delete";
	}

	@DeleteMapping("/deleteuser")
	public ModelAndView deletesUser(@ModelAttribute("user") User user) {

		userService.deleteUserById(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		mv.addObject("msg", "Deleted Successfully");
		return mv;

	}

	@PostMapping("/adminlogin")
	public ModelAndView loginAdmin(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("adminlogged");
		} catch (InvalidCredentialsException e) {
			mv.addObject("errormsg", "Username or Password incorrect");
			mv.setViewName("admin");
		}

		return mv;
	}

	@GetMapping("/admin")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "admin";
	}

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("userdetails") UserDetails userdetails) {
		ModelAndView mv = new ModelAndView();

		List<UserDetails> users =  userDetailsService.getList();
		mv.setViewName("list");
		mv.addObject("listOfUsers", users);
		return mv;
	}

//	@GetMapping("/list")
//	public ModelAndView list( @ModelAttribute("userdetails") UserDetails userdetails) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("list");
//		mv.addObject("listOfUsers", userService.getList());
//		return mv;
//	}

}
