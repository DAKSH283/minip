package com.cg.hotel.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;






import com.cg.hotel.dto.Hotel;
import com.cg.hotel.exception.HotelException;
import com.cg.hotel.service.EmpService;
import com.cg.hotel.service.EmpServiceImpl;
import com.cg.hotel.service.HotelService;
import com.cg.hotel.service.HotelServiceImpl;


public class MainClass {
		
	static  HotelService service =new HotelServiceImpl();
	static EmpService service1 =new EmpServiceImpl();
	public static void main (String[] args){
		
			int choice =0;
			try(Scanner sc =new Scanner (System.in)){
				int choice1 = 0;
				try(Scanner sc1 = new Scanner (System.in))
				{
				do
				{
				System.out.println("1-Login As a User");
				System.out.println("2-Login As a Admin");
				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice)
				{
				case 1:

					
					try {
						service1.login();
					
						
					
				do
				{
					System.out.println("Welcome to  Hotel Book Services" );
					System.out.println("1-Book Room");
					System.out.println("2- Search  Booked Room by Name");
					System.out.println("3- Delete Booking ");
//				System.out.println("4-View Booking Status");
					
					
			        System.out.println("Enter choice ");
			        choice =sc.nextInt();
					switch (choice ) 
					
					
					{ 
				case 1:
			
				
					Hotel hel=acceptHotelDetails();
					if(hel!=null){
								
					
				try
				{
					
				int cust_id = service.addHotel(hel);
				System.out.println("Inserted and Cust_id = "+cust_id);
				}
				
				catch(HotelException e)
				{
					System.out.println(e.getMessage());
				}
				
				
			}
					break;
				case 2:
					System.out.println("Enter Cust_Name");
					String Cust_name=sc.next();
					Hotel hel1 = new Hotel();
				
					try
					{
						
						hel1 = service.getCustByName(Cust_name);
						System.out.println(hel1);
				
					}
					
					catch(HotelException e)
					{
						
					System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Enter name");
					String Cust_name1 =sc.next();
					Hotel hel2 = new Hotel();
				
					try
					{
						
					hel2 = service. removeCustName(Cust_name1);
				
					}
					
					catch(HotelException e)
					{
						
					System.out.println(e.getMessage());
					}
					break;
				
					
					}
					System.out.println("Do u want to continue 1 - yes 0-No");
					choice = sc.nextInt();
				
				}while(choice!=0);
					}
					catch (HotelException e) 
					{
						// TODO Auto-generated catch block
						e.getMessage();
					}
					break;
				 
				case 2:
					try {
						service1.login1();
	
					System.out.println("1-View Booking Status");
				
				
		        System.out.println("Enter choice ");
		        choice =sc.nextInt();
				switch (choice )
				{
				case 1	:
					try{
						ArrayList<Hotel> list=service.getAllCustomer();
						System.out.println("All Customer:" +list);
						
					}
					catch(HotelException e)
					{
						
					System.out.println(e.getMessage());
					}
				
				}
				}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}	
					
				
				}	while(choice1!=0);
			
		        	}
			     }
			}
	public static Hotel acceptHotelDetails()
	{
		Hotel hel = null;
/////////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter name::");
			String name = sc.next();
			if(!service.validateName(name))
			{
				continue;
			}
/////////////////////////////////////////////////////////////////			
			else
			{
				while(true)
				{
					System.out.println("Enter phone_no::");
					String phone_no= sc.next();
					if(!service.validatePhoneno(phone_no))
					{
						continue;
					}
////////////////////////////////////////////////////////////////////					
					else
					{
						while(true)
						{
							System.out.println("Enter Room No.:");
							int room_no;
							
								 room_no = sc.nextInt();
							
							
							if(!service.validateRoom_no(room_no))
							{
								continue;
							
						}
//////////////////////////////////////////////////////////////////						
							else
							{
								while(true)
								{
									System.out.println("Enter no.of.adult:");
									int no_of_adult;
									
										 no_of_adult = sc.nextInt();
									
									
									if(!service.validateNo_of_adult(no_of_adult))
									{
										continue;
									}
////////////////////////////////////////////////////////////////////////////////////									
									else
									{
									while(true)
									{
										System.out.println("Enter no.of.children:");
										int no_of_children;
										
											 no_of_children = sc.nextInt();
										
										
										if(!service.validateNo_of_Children(no_of_children))
										{
											continue;
										}
/////////////////////////////////////////////////////////////////////////////////////										
										else
										{
											while(true)
											{
												System.out.println("Enter amount:");
												int amount;
												
													 amount = sc.nextInt();
												
												
												if(!service.validateAmount(amount))
												{
													continue;
												}
///////////////////////////////////////////////////////////////////////////////////												
//												else
//												{
//													while(true)
//													{
//														System.out.println("Enter address::");
//														String address = sc.next();
//														
//														if(!service.validateAddress(address))
//															
//													{
//														continue;
//														}
													
///////////////////////////////////////////////////////////////////////////////															
														else
														{
															while(true)
															{
																System.out.println("Enter booked date from");
																String date_from = sc.next();
																DateTimeFormatter format1 = 
																		DateTimeFormatter.ofPattern("dd/MM/yyyy");
																LocalDate bdate1 = LocalDate.parse(date_from, format1);
/////////////////////////////////////////////////////////////////////////////////////////////////////																
																if (bdate1!=null)
																{
																System.out.println("Enter booked date to");
																String date_to = sc.next();
																DateTimeFormatter formmat = 
																		DateTimeFormatter.ofPattern("dd/MM/yyyy");
																LocalDate bdate = LocalDate.parse(date_from, format1);
																
//////////////////////////////////////////////////////////////////////////////////////////////////////////////						
																
                       	if (bdate!=null)
						{
							hel = new Hotel();
							hel.setCust_name(name);
//							hel.setCust_address(address);
							hel.setCust_phone(phone_no);
							hel.setRoom_no(room_no);
							hel.setNo_of_adult(no_of_adult);
							hel.setNo_of_children(no_of_children);
							hel.setAmount(amount);
							hel.setBooked_from(bdate1);
							hel.setBooked_to(bdate);
							break;
	
					}
						System.out.println();
				}
			}
			return hel;
		}
					}
				}
		
		}
	}
 }
	}
}
	}
}
	}
}
	}
}
	

	

					
			


		

