package com.cg.hotel.dto;

public class EmpProject {
	private String uname;
	private String pwd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public EmpProject(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	public EmpProject() {
		
	}
	@Override
	public String toString() {
		return "EmpProject [uname=" + uname + ", pwd=" + pwd + "]";
	}

}
