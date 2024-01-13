package com.example.bookingapp.model;

import java.sql.Time;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer bookID;
	
	Time atWhatTime;
	String startLocation;
	String endLocation;
	String typeOfCab;
    Integer intialFare;
    Integer farePerKm;
	Integer totalFare;
	Integer userID;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookID, Time atWhatTime, String startLocation, String endLocation, String typeOfCab,
			Integer intialFare, Integer farePerKm, Integer totalFare, Integer userID) {
		this.bookID = bookID;
		this.atWhatTime = atWhatTime;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.typeOfCab = typeOfCab;
		this.intialFare = intialFare;
		this.farePerKm = farePerKm;
		this.totalFare = totalFare;
		this.userID = userID;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public Time getAtWhatTime() {
		return atWhatTime;
	}

	public void setAtWhatTime(Time atWhatTime) {
		this.atWhatTime = atWhatTime;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public String getTypeOfCab() {
		return typeOfCab;
	}

	public void setTypeOfCab(String typeOfCab) {
		this.typeOfCab = typeOfCab;
	}

	public Integer getIntialFare() {
		return intialFare;
	}

	public void setIntialFare(Integer intialFare) {
		this.intialFare = intialFare;
	}

	public Integer getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(Integer farePerKm) {
		this.farePerKm = farePerKm;
	}

	public Integer getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Booking [bookID=" + bookID + ", atWhatTime=" + atWhatTime + ", startLocation=" + startLocation
				+ ", endLocation=" + endLocation + ", typeOfCab=" + typeOfCab + ", intialFare=" + intialFare
				+ ", farePerKm=" + farePerKm + ", totalFare=" + totalFare + ", userID=" + userID + "]";
	}
	
}
