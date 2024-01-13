package com.example.bookingapp.model;

import java.util.List;

public class BookingResponse {

	Integer code;
	String message;
	
	List<Booking> bookings;
	
	Booking	booking;
	
	public BookingResponse() {
		// TODO Auto-generated constructor stub
	}	

	public BookingResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public BookingResponse(Integer code, String message, List<Booking> bookings) {
		this.code = code;
		this.message = message;
		this.bookings = bookings;
	}

	public BookingResponse(Integer code, String message, Booking booking) {
		this.code = code;
		this.message = message;
		this.booking = booking;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "BookingResponse [code=" + code + ", message=" + message + ", bookings=" + bookings + ", booking="
				+ booking + "]";
	}	
	
}
