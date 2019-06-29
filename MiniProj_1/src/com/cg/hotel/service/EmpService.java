package com.cg.hotel.service;

import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.exception.HotelException;

public interface EmpService {

	EmpProject login()throws HotelException;
	EmpProject login1()throws HotelException;
}
