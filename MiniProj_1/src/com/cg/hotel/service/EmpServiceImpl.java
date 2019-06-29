package com.cg.hotel.service;

import com.cg.hotel.dao.Empdao;
import com.cg.hotel.dao.EmpdaoImpl;
import com.cg.hotel.dao.HotelDao;
import com.cg.hotel.dao.HotelDaoImpl;
import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.exception.HotelException;

public class EmpServiceImpl  implements EmpService{
	Empdao dao;
	public void setDao(Empdao dao)
	{
	this.dao = dao;
	}
	public EmpServiceImpl()
	{
	dao = new EmpdaoImpl();
	}
	@Override
	public EmpProject login() throws HotelException {
		// TODO Auto-generated method stub
		return dao.login();
	}
	@Override
	public EmpProject login1() throws HotelException {
		// TODO Auto-generated method stub
		return dao.login1 ();
	}
}
