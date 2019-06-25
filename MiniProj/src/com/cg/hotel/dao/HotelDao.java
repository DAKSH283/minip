package com.cg.hotel.dao;


import java.util.ArrayList;




import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.dto.Hotel;
import com.cg.hotel.exception.HotelException;



public interface HotelDao {

	int addHotel(Hotel hel)throws HotelException;
	Hotel getCustByName(String Cust_name)throws HotelException;
	Hotel removeCustName(String  Cust_name)throws HotelException;
	ArrayList<Hotel>getAllCustomer()throws HotelException;
	
}
