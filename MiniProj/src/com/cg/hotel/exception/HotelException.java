package com.cg.hotel.exception;

public class HotelException extends Exception {
	String message;
	public HotelException(String message){
		this.message = message;
	}
	
@Override
public String getMessage()
{
	return this.message;
	
}
	
	
}


