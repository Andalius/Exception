package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date chekin, Date chekout) throws DomainException{
		if (checkOut.before(checkIn)){
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = chekin;
		this.checkOut = chekout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getChekin() {
		return checkIn;
	}

	public Date getChekout() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() -checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public void UpdateDate(Date checkIn, Date checkOut) throws DomainException {
		Date now1 = this.checkIn;
		Date now2 = this.checkOut;
		if (checkIn.before(now1) || checkOut.before(now2)) {
			throw new DomainException("Error in reservation: Reservation dates for updates must be future dates");     
		}
		if (checkOut.before(checkIn)){
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}
	
	@Override
	public String toString() {
		return "Room: " 
				+ roomNumber 
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
	
	
	
}
