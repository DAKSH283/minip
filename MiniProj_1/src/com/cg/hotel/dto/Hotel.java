package com.cg.hotel.dto;

import java.time.LocalDate;





public class Hotel {
	   

		private String Cust_name;
		private  String Cust_phone;
		private  int room_no;
		 private String Cust_id;
		 private LocalDate Booked_from;
		 private LocalDate Booked_to;
		 private int no_of_adult;
		 private int no_of_children;
		 private int amount;
		 
		 public String getCust_id() {
				return Cust_id;
			}
			public LocalDate getBooked_from() {
			return Booked_from;
		}
		public void setBooked_from( LocalDate booked_from) {
			Booked_from = booked_from;
		}
		public  LocalDate getBooked_to() {
			return Booked_to;
		}
		public void setBooked_to( LocalDate booked_to) {
			Booked_to = booked_to;
		}
		public int getNo_of_adult() {
			return no_of_adult;
		}
		public void setNo_of_adult(int no_of_adult) {
			this.no_of_adult = no_of_adult;
		}
		public int getNo_of_children() {
			return no_of_children;
		}
		public void setNo_of_children(int no_of_children) {
			this.no_of_children = no_of_children;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
			public void setCust_id(String cust_id) {
				Cust_id = cust_id;
			}
		public String getCust_name() {
			return Cust_name;
		}
		public void setCust_name(String cust_name) {
			Cust_name = cust_name;
		}
		public String getCust_phone() {
			return Cust_phone;
		}
		public void setCust_phone(String cust_phone) {
			Cust_phone = cust_phone;
		}
//		public String getCust_address() {
//			return Cust_address;
//		}
//		public void setCust_address(String cust_address) {
//			Cust_address = cust_address;
//		}
		public int getRoom_no() {
			return room_no;
		}
		public void setRoom_no(int room_no) {
			this.room_no = room_no;
		}
		
		
	
		@Override
		public String toString() {
			return "Hotel [Cust_id=" + Cust_id + ", Cust_name="
					+ Cust_name 
					+ ", room_no=" + room_no + ", Cust_phone=" + Cust_phone
					+ ", Booked_from=" + Booked_from + ", Booked_to="
					+ Booked_to + ", no_of_adult=" + no_of_adult
					+ ", no_of_children=" + no_of_children + ", amount="
					+ amount + "]";
		}
		
		public Hotel(String cust_name, String cust_phone,
				int room_no, String cust_id, LocalDate booked_from,
				LocalDate booked_to, int no_of_adult, int no_of_children,
				int amount) {
			super();
			Cust_name = cust_name;
			Cust_phone = cust_phone;
			
			this.room_no = room_no;
			Cust_id = cust_id;
			Booked_from = booked_from;
			Booked_to = booked_to;
			this.no_of_adult = no_of_adult;
			this.no_of_children = no_of_children;
			this.amount = amount;
		}
		public Hotel() {
			super();
			// TODO Auto-generated constructor stub
		}
		
			// TODO Auto-generated constructor stub
		}
		
	
		

	


