package com.cg.hotel.dao;

import java.sql.Connection;

import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.exception.HotelException;
import com.cg.hotel.util.DBUtil;

public interface Empdao {
	EmpProject login() throws HotelException;
	EmpProject login1() throws HotelException;
}
