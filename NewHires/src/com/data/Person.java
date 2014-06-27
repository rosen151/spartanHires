package com.data;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.data.Creation;

public class Person extends ActionForm {

	public int pid;
	public String dob;
	public String ssn;
	public String address;
	public String fname;
	public String lname;
	public String netId;
	public String email;
	
	

	public Person(int pid, String dob, String ssn, String address, String fname,
			String lname, String netId, String email) {
		super();
		this.pid = pid;
		this.dob = dob;
		this.ssn = ssn;
		this.address = address;
		this.fname = fname;
		this.lname = lname;
		this.netId = netId;
		this.email = email;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Person() {

	}

	public String toString() {
		return ("Person: " + "First Name = " + this.fname + " Last Name = "
				+ this.lname + "Address = " + this.address + "DOB = "
				+ this.dob + " SSN = " + this.ssn + " Person ID = " + this.pid + " NetID = " + this.netId + " Email = " + this.email);
	}
	
	
}
