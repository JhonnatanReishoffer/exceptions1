package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	
	DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		Duration t1 = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return t1.toDays();
		
	}
	public String updateDates(LocalDate checkIn2, LocalDate checkOut2) {
		
		LocalDate now = LocalDate.now();
		
			if (checkIn2.isBefore(now) || checkOut2.isBefore(now)) {
				return "Reservation dates for update must be future dates";
			}
			else if(!checkOut.isAfter(checkIn) || !checkOut2.isAfter(checkOut) || !checkIn2.isAfter(checkIn)) {
				return "Check-out date must be after check-in date";
			}
			else {			
				this.checkIn = checkIn2;
				this.checkOut = checkOut2;
				return null;
			}
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", check-in: "
				+ fm1.format(checkIn)
				+ ", check-out: "
				+ fm1.format(checkOut)
				+", "
				+ duration()
				+ " nights";
	}
	

	
	
}
