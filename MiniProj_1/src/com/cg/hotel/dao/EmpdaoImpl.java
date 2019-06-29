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
		
		    System.out.println("Enter credential for user login:");
		    System.out.println("username: ");
		    String uname = input.next();

		    System.out.println("password: ");
		    String pwd = input.next();
			
		   
			   
			    try{
					String query="select * from user_u where uname = ? and pwd = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, uname);
					pst.setString(2, pwd);
					
					ResultSet rs = pst.executeQuery();

					if(rs.next()){
						 String userdbName = rs.getString("uname");

						 String userdbPsw = rs.getString("pwd");
                         System.out.println("Uname :"+uname);
                         System.out.println("pwd :"+pwd);
                         System.out.println("UserName :"+userdbName);
 						System.out.println("pwd :"+userdbPsw);
						if(uname.equals(userdbName) && pwd.equals(userdbPsw))
						{
							System.out.println("UserName :"+userdbName);
							System.out.println("pwd :"+userdbPsw);
							
						System.out.println("valid");
		            }	
						
					}	
					
					else 
					{    
					
						System.out.println("Invalid User Name and Password");
						
					
					}	  
			  }
			    catch(Exception e)
			    {
					throw new HotelException(e.getMessage());
					}
			  
				return null;
			    }
			
			
	@Override
	public EmpProject login1() throws HotelException {
		Scanner input = new Scanner(System.in);
		 Console console = System.console();

	   System.out.println("Enter credential for User admin:");
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
			if(rs.next()){
				 String userdbName = rs.getString("uname");

				 String userdbPsw = rs.getString("pwd");
                System.out.println("Uname :"+uname);
                System.out.println("pwd :"+pwd);
                System.out.println("UserName :"+userdbName);
				System.out.println("pwd :"+userdbPsw);
				if(uname.equals(userdbName) && pwd.equals(userdbPsw))
				{
					System.out.println("UserName :"+userdbName);
					System.out.println("pwd :"+userdbPsw);
					
				System.out.println("valid");
           }	
				
			}	
			
			else 
			{    
			
				System.out.println("Invalid User Name and Password");
				
			
			}	  
	  }
	   catch(Exception e){
			throw new HotelException(e.getMessage());

		}
	   
	   
		return null;
	}


}
