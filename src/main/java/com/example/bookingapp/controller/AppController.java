package com.example.bookingapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bookingapp.model.CabUser;
import com.example.bookingapp.repository.CabUserRepository;

@Controller
@RequestMapping(path = "/app")
public class AppController {
	
	@Autowired
	CabUserRepository repository;
	
	String templatePage = "";

	@PostMapping(path = "/login")
	public String loginUser(@RequestParam String email, @RequestParam String userPassword, Model model) {
		
		CabUser cabUser = new CabUser(null, null, null, email, userPassword);
		
		repository.findAll().forEach((user) -> {
			if (user.getUserPassword().equals(userPassword)) {				
				templatePage = "home";
				
				System.out.println("[AppController] - User logged in successfuly: " + cabUser.getEmail() + " at " + new Date());
				
				model.addAttribute("title", "User " + cabUser.getEmail() + " logged in!!");
				model.addAttribute("message", "Welcome " + cabUser.getUserName() + "!!. You've were logged in at " + new Date());
			} else {
				templatePage = "error";

				System.out.println("[AppController] - An error ocurred: " + cabUser.getEmail() + " at " + new Date());
				
				model.addAttribute("title", "Invalid credentials");
				model.addAttribute("message", "Please try again!!");
			}	
		});
		
		return templatePage;
	}
}
