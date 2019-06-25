package com.cg.hotel.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cg.hotel.dto.EmpProject;
import com.cg.hotel.exception.HotelException;
import com.cg.hotel.util.DBUtil;

public class EmpdaoImpl implements Empdao {
	private static Connection con;
//	Logger logger;
	private String qry;
	public EmpdaoImpl()
	{
		
	con = DBUtil.getConnect();
	
//	logger =MyLogger.getLogger();
	}
	@Override
	public EmpProject login() throws HotelException {
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
		 boolean checkUser = false;
		    System.out.println("Enter credential for Admin login:");
		    System.out.println("username: ");
		    String uname = input.next();

		    System.out.println("password: ");
		    String pwd = input.next();
		   
		    try{
				String query="select * from admin where uname = ? and pwd = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, uname);
				pst.setString(2, pwd);
				
				ResultSet rs = pst.executeQuery();
				System.out.println("enter");
				while(rs.next()){
					checkUser = true;
					
				}
				
			}
		    catch(Exception e){
				throw new HotelException(e.getMessage());

			}
		 
		return null;
	}
	@Override
	public EmpProject login1() throws HotelException {
		Scanner input = new Scanner(System.in);
		 Console console = System.console();

	   System.out.println("Enter credential for User login:");
	   System.out.println("username: ");
	   String uname = input.next();

	   System.out.println("password: ");
	   String pwd = input.next();
	   
	   
	   try{
			String query="select * from login where uname = ? and pwd = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pwd);
			
			ResultSet rs = pst.executeQuery();
			int count = 0;
			while(rs.next()){
				count = count + 1;
			}
			if (count == 1){
				System.out.println("Valid");
				System.out.println("Logged in as User....");
				
			}
			else if(count > 1){
				System.out.println("Duplicate");
				}
			else{
				System.out.println("Invalid");
			}
			
			
			
			rs.close();
			pst.close();
		}
	   catch(Exception e){
			throw new HotelException(e.getMessage());

		}
	   
	   
		return null;
	}


}
