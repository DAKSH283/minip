package com.cg.hotel.service;


import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.hotel.dao.HotelDao;
import com.cg.hotel.dao.HotelDaoImpl;
import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.dto.Hotel;
import com.cg.hotel.exception.HotelException;

public class HotelServiceImpl  implements HotelService {
	HotelDao dao;
	public void setDao(HotelDao dao)
	{
	this.dao = dao;
	}
	public HotelServiceImpl()
	{
	dao = new HotelDaoImpl();
	}

	@Override
	public int addHotel(Hotel hel) throws HotelException {
		// TODO Auto-generated method stub
		return dao.addHotel(hel);
	}
	@Override
	public boolean validatePhoneno(String phone_no) {
		String pattern = "[0-9]{4,10}";
		if(Pattern.matches(pattern,phone_no))
		{
		return true;
		}
		else
		return false;
		}
	
	@Override
	public boolean validateName(String name) {
		
		String pattern = "[A-Z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,name))
		{
		return true;
		}
		else
		return false;
	}
	
//	public boolean validateAddress(String address) {
//		// TODO Auto-generated method stub
//		String pattern = "[A-Z]{1}[a-z]";
//		if(Pattern.matches(pattern,address))
//		{
//		return true;
//		}
//		else
//		return false;
//	}
	@Override
	public boolean validateRoom_no(int room_no) {
		// TODO Auto-generated method stub
		if(room_no > 0 && room_no <= 10)
		{
			return true;
			
		}
		else
		{
			System.out.println("Only 10 Rooms are availble");
			return false;
		}
	}
	@Override
	public Hotel getCustByName(String Cust_name) throws HotelException {
		// TODO Auto-generated method stub
		return dao.getCustByName(Cust_name);
	}
	@Override
	public Hotel removeCustName(String Cust_name) throws HotelException {
		// TODO Auto-generated method stub
		return dao.removeCustName( Cust_name);
	}
	@Override
	public ArrayList<Hotel> getAllCustomer() throws HotelException {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}
	
	@Override
	public boolean validateNo_of_adult(int no_of_adult) {
		// TODO Auto-generated method stub
		String pattern = "[0-9]{1,2}";
		String adult = ""+no_of_adult;
		if(Pattern.matches(pattern,adult))
		{
		return true;
		}
		else 
		return false;
	}
	@Override
	public boolean validateNo_of_Children(int no_of_children) {
		String pattern = "[0-9]{1,2}";
		String children = ""+no_of_children;
		if(Pattern.matches(pattern,children))
		{
		return true;
		}
		else 
		return false;
		
	}
	@Override
	public boolean validateAmount(int amount) {
		// TODO Auto-generated method stub
		String pattern = "[0-9]{1,5}";
		String amt = ""+amount;
		if(Pattern.matches(pattern,amt))
		{
		return true;
		}
		else 
		return false;
		
	}
	

}
