package com.cg.hotel.service;


import java.util.ArrayList;

import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.dto.Hotel;
import com.cg.hotel.exception.HotelException;


public interface HotelService {
	int addHotel(Hotel hel)throws HotelException;
	Hotel getCustByName(String Cust_name)throws HotelException;
	Hotel removeCustName(String Cust_name )throws HotelException;
	ArrayList<Hotel>getAllCustomer()throws HotelException;
	
	public boolean validatePhoneno(String phone_no);

	 public boolean validateName(String name);

//	 public boolean validateAddress(String address);
	 
	 public boolean validateRoom_no(int room_no);
	
	 public boolean validateNo_of_adult(int no_of_adult);
	 
	 public boolean validateNo_of_Children(int no_of_children);
	 public boolean validateAmount(int amount);
  

}



