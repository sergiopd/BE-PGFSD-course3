package com.example.bookingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bookingapp.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
