package com.cg.hotel.dao;

import java.io.Console;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.time.LocalDate;
import java.util.ArrayList;





import java.util.Date;
import java.util.Scanner;

import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.dto.Hotel;
import com.cg.hotel.exception.HotelException;
import com.cg.hotel.util.DBUtil;


public class HotelDaoImpl implements HotelDao{

	private static Connection con;
//	Logger logger;
	private String qry;
	public HotelDaoImpl()
	{
		
	con = DBUtil.getConnect();
	
//	logger =MyLogger.getLogger();
	}
	//to return current empId i.e. sequence current value
	public int getHotelId()throws HotelException
	{
//	logger.info("In get EmployeId");	
	int cust_id = 0;
	String qry = "select tid_seq.CURRVAL from dual";
	try {
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(qry);
	if(rs.next())
	{
	cust_id= rs.getInt(1);
//	logger.info("getEmployeeId with id"+id);
	}
	} 
	catch (SQLException e) 
	{
	throw new HotelException(e.getMessage());
	}

//	logger.info("completed get EmployeeId");
	return cust_id;
	}
	///////////////////////
@Override
public int addHotel(Hotel hel) throws HotelException {
	// TODO Auto-generated method stub
//	logger.info("In add Employee");
//	logger.info("Input is:"+emp);
	
	int cust_id = 0;
	String qry = "insert into hotel values(tid_seq.NEXTVAL,?,?,?,?,?,?,?,?)";
	String name = hel.getCust_name();
	String phone = hel.getCust_phone();

	int no_of_adult=hel.getNo_of_adult();
	int no_of_children=hel.getNo_of_children();
	int amount=hel.getAmount();
    int room_no=hel.getRoom_no();
   LocalDate Booked_to = hel.getBooked_to();
    java.sql.Date date_to = java.sql.Date.valueOf(Booked_to);
    LocalDate Booked_from = hel.getBooked_from();
    java.sql.Date date_from = java.sql.Date.valueOf(Booked_from);
	try
	{
	PreparedStatement pstmt = con.prepareStatement(qry);
	pstmt.setString(1,name);
	pstmt.setString(2,phone);

    pstmt.setInt(3,room_no);
    pstmt.setInt(4,no_of_adult);
    pstmt.setInt(5,no_of_children);
    pstmt.setInt(6,amount);
    pstmt.setDate(7,date_to);
    pstmt.setDate(8,date_from);
	int row = pstmt.executeUpdate();
	if(row > 0)
	{
 cust_id = getHotelId();
//	logger.info("inserted succesfully id is "+id);
     }
	else
	throw new HotelException("Unable to insert"+hel);
	}
	catch(SQLException e)
	{
//		logger.error(e.getMessage());
//	throw new HotelException(e.getMessage());
	throw new HotelException(e.getMessage());

	}
	return cust_id;
}
@Override
public Hotel getCustByName(String Cust_name) throws HotelException {
	Hotel hel = null;
	String qry = "select * from hotel where Cust_name=?";
	try
	{
	PreparedStatement pstmt = con.prepareStatement(qry);
	pstmt.setString(1,Cust_name);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next())
	{
	String Cust_id = rs.getString(1);
	String name = rs.getString(3);
	String phone = rs.getString(2);
	int room_no=rs.getInt(4);
	int no_of_adult=rs.getInt(5);
	int no_of_children=rs.getInt(6);
	int amount=rs.getInt(7);
	java.sql.Date date_from = rs.getDate(8);
	java.time.LocalDate bDate = date_from.toLocalDate();
	java.sql.Date date_to = rs.getDate(9);
	java.time.LocalDate bDate1 = date_from.toLocalDate();
	

	hel =new Hotel(phone,name,room_no,Cust_id,bDate,bDate1,no_of_adult,no_of_children,amount);
	}
	else 
	throw new HotelException("Customer with name "+Cust_name+" not found");
	}catch(SQLException e)
	{
	throw new HotelException(e.getMessage());
	}
	return hel;
	}
@Override
public Hotel removeCustName(String Cust_name) throws HotelException {
	Hotel hel = null;
	String qry = "DELETE  FROM Hotel where Cust_name=?";
	try{
	PreparedStatement pstmt = con.prepareStatement(qry);
	pstmt.setString(1,Cust_name);
	int row = pstmt.executeUpdate();
	if(row > 0)
	{
	System.out.println(" Booking Deleted  with name "+Cust_name);
	}
	else if(hel== null)
	{
	throw new HotelException("Booking name "+Cust_name+"not found");
	}
	}
	catch(SQLException e)
	{
	throw new HotelException(e.getMessage());
	}
	return hel;
	}
@Override
public ArrayList<Hotel> getAllCustomer() throws HotelException {
	ArrayList<Hotel>list=new ArrayList<Hotel>();
	String qry="SELECT * FROM Hotel";
	try
	{
		Statement stmt=con.createStatement();
		ResultSet rs =stmt.executeQuery(qry);
		while(rs.next())
		{
			String Cust_id =rs.getString(1);
			String Cust_name=rs.getString(2);
			String Cust_phone=rs.getString(3);

			int room_no=rs.getInt(4);
			
			int no_of_adult=rs.getInt(5);
			int no_of_children=rs.getInt(6);
			int amount=rs.getInt(7);
			java.sql.Date date_from = rs.getDate(8);
			java.time.LocalDate bDate = date_from.toLocalDate();
			java.sql.Date date_to = rs.getDate(9);
			java.time.LocalDate bDate1 = date_from.toLocalDate();
		Hotel hel = new Hotel( Cust_name,  Cust_phone, 
				 room_no,  Cust_id, bDate,
				 bDate1,  no_of_adult,  no_of_children,
				 amount);
			list.add(hel);
			
			
			
			
		}
	}	
	catch(SQLException e)
	{
	throw new HotelException(e.getMessage());
	}
	
return list;
}

}







