package com.example.bookingapp.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookingapp.model.Booking;
import com.example.bookingapp.model.BookingResponse;
import com.example.bookingapp.repository.BookingRepository;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {

	@Autowired
	BookingRepository repository;	

	Integer id;

	@PostMapping(path = "/add")
	public ResponseEntity<BookingResponse> addBooking(
			@RequestParam Time atWhatTime,
			@RequestParam String startLocation,
			@RequestParam String endLocation,
			@RequestParam String typeOfCab,
			@RequestParam Integer intialFare,
			@RequestParam Integer farePerKm,
			@RequestParam Integer userID
			) {
		
		// To generate random number of kilometers to calculate the fare
		Random randomKm = new Random();
		int upperbound = 25;			// Max number of kilometers generated randomly
		Integer totalFare = (randomKm.nextInt(upperbound) * farePerKm) +  intialFare;		
		
		Booking booking = new Booking(
				null, atWhatTime, startLocation, endLocation, typeOfCab, intialFare, farePerKm, totalFare, userID
				);
		System.out.println("Booking: " + booking);
		
		try {
			repository.save(booking);
			
			BookingResponse response = new BookingResponse(201, "Booking id: " + booking.getBookID() + " added successfuly.");			
			return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			BookingResponse response = new BookingResponse(
					400, "Booking id: " + booking.getBookID() + " not added. Exception: " + e.getMessage()
					);
			return new ResponseEntity<BookingResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping(path = "/listBookings")
	public ResponseEntity<BookingResponse> fetchAllBookings() {		
		try {
			List<Booking> bookingList = new ArrayList<Booking>();
			repository.findAll().forEach((booking) -> bookingList.add(booking));
			
			BookingResponse response = new BookingResponse(
					201, "All bookings [" + bookingList.size() + "] fetched successfuly.", bookingList
					);			
			return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			BookingResponse response = new BookingResponse(400, "unable to fecth bookings. Exception: " + e.getMessage());
			return new ResponseEntity<BookingResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping(path = "/getBooking")
	public ResponseEntity<BookingResponse> fetchBooking(
			@RequestParam Integer bookID
			) {
		
		Booking booking = new Booking();
		
		try {
			booking =  repository.findById(bookID).get();
			System.out.println("Booking: " + booking);
			
			BookingResponse response = new BookingResponse(
					201, "Booking " + booking.getUserID() + " fetched successfuly.", booking
					);			
			return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			BookingResponse response = new BookingResponse(
					400, "Booking " + booking.getUserID() + " not fetched. Exception: " + e.getMessage()
					);
			return new ResponseEntity<BookingResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<BookingResponse> updateBooking(
			@RequestParam Integer bookID,
			@RequestParam Time atWhatTime,
			@RequestParam String startLocation,
			@RequestParam String endLocation,
			@RequestParam String typeOfCab,
			@RequestParam Integer intialFare,
			@RequestParam Integer farePerKm,
			@RequestParam Integer totalFare,
			@RequestParam Integer userID
			) {
		
		Booking booking = new Booking(
				bookID, atWhatTime, startLocation, endLocation, typeOfCab, intialFare, farePerKm, totalFare, userID
				);
		
		try {
			repository.save(booking);
			
			BookingResponse response = new BookingResponse(201, "User " + booking.getUserID() + " updated successfuly.");			
			return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			BookingResponse response = new BookingResponse(
					400, "User " + booking.getUserID() + " not updated. Exception: " + e.getMessage()
					);
			return new ResponseEntity<BookingResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping(path = "/delete")
	public ResponseEntity<BookingResponse> deleteBooking(
			@RequestParam Integer bookID
			) {
		
		Booking booking = new Booking();
		
		booking = repository.findById(bookID).get();
		
		System.out.println("User: " + booking);
		
		try {
			booking =  repository.findById(bookID).get();
			System.out.println("User: " + booking);
			
			repository.delete(booking);
			
			BookingResponse response = new BookingResponse(201, "User " + booking.getBookID() + " deleted successfuly.");			
			return new ResponseEntity<BookingResponse>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			BookingResponse response = new BookingResponse(
					400, "User " + booking.getBookID() + " not deleted. Exception: " + e.getMessage()
					);
			return new ResponseEntity<BookingResponse>(response, HttpStatus.BAD_REQUEST);
		}		
	}
	
}
