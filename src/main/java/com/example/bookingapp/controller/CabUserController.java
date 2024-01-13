package com.example.bookingapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookingapp.model.CabUser;
import com.example.bookingapp.model.CabUserResponse;
import com.example.bookingapp.repository.CabUserRepository;

@RestController
@RequestMapping(path = "/users")
public class CabUserController {
	
	@Autowired
	CabUserRepository repository;	

	Integer id;

	@PostMapping(path = "/add")
	public ResponseEntity<CabUserResponse> addUser(
			@RequestParam String userName,
			@RequestParam String phone,
			@RequestParam String email,
			@RequestParam String userPassword
			) {
		
		CabUser cabUser = new CabUser(null, userName, phone, email, userPassword);
		System.out.println("User: " + cabUser);
		
		try {
			repository.save(cabUser);
			
			CabUserResponse response = new CabUserResponse(201, "User " + cabUser.getUserName() + " added successfuly.");			
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			CabUserResponse response = new CabUserResponse(
					400, "User " + cabUser.getUserName() + " not added. Exception: " + e.getMessage()
					);
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping(path = "/listUsers")
	public ResponseEntity<CabUserResponse> fetchAllUsers() {		
		try {
			List<CabUser> usersList = new ArrayList<CabUser>();
			repository.findAll().forEach((cabUser) -> usersList.add(cabUser));
			
			CabUserResponse response = new CabUserResponse(
					201, "All users [" + usersList.size() + "] fetched successfuly.", usersList
					);			
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			CabUserResponse response = new CabUserResponse(400, "unable to fecth users. Exception: " + e.getMessage());
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping(path = "/getUser")
	public ResponseEntity<CabUserResponse> fetchUser(
			@RequestParam String email
			) {
		
		CabUser cabUser = new CabUser();
		
		repository.findAll().forEach((user) -> {
			if (user.getEmail().equals(email)) {
				id = user.getUserID();
			}	
		});
		
		try {
			cabUser =  repository.findById(id).get();
			System.out.println("User: " + cabUser);
			
			CabUserResponse response = new CabUserResponse(
					201, "User " + cabUser.getUserName() + " fetched successfuly.", cabUser
					);			
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			CabUserResponse response = new CabUserResponse(
					400, "User " + cabUser.getUserName() + " not fetched. Exception: " + e.getMessage()
					);
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<CabUserResponse> updateUser(
			@RequestParam String userName,
			@RequestParam String phone,
			@RequestParam String email,
			@RequestParam String userPassword
			) {
		
		CabUser cabUser = new CabUser(null, userName, phone, email, userPassword);
		
		repository.findAll().forEach((user) -> {
			if (user.getEmail().equals(email)) {
				id = user.getUserID();
			}	
		});
		
		cabUser =  repository.findById(id).get();
		cabUser.setUserName(userName);
		cabUser.setPhone(phone);
		cabUser.setUserPassword(userPassword);
		
		System.out.println("User: " + cabUser);
		
		try {
			repository.save(cabUser);
			
			CabUserResponse response = new CabUserResponse(201, "User " + cabUser.getUserName() + " updated successfuly.");			
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			CabUserResponse response = new CabUserResponse(
					400, "User " + cabUser.getUserName() + " not updated. Exception: " + e.getMessage()
					);
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping(path = "/delete")
	public ResponseEntity<CabUserResponse> deleteUser(
			@RequestParam String email
			) {
		
		CabUser cabUser = new CabUser();
		
		repository.findAll().forEach((user) -> {
			if (user.getEmail().equals(email)) {
				id = user.getUserID();
			}	
		});
		
		cabUser =  repository.findById(id).get();
		
		System.out.println("User: " + cabUser);
		
		try {
			repository.delete(cabUser);
			
			CabUserResponse response = new CabUserResponse(201, "User " + cabUser.getUserName() + " deleted successfuly.");			
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			CabUserResponse response = new CabUserResponse(
					400, "User " + cabUser.getUserName() + " not deleted. Exception: " + e.getMessage()
					);
			return new ResponseEntity<CabUserResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
}
