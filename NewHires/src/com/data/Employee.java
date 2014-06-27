package com.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import com.dao.NewHireImpl;

import java.io.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.validator.ValidatorForm;


public class Employee extends ActionForm {
	public int id;
	private ArrayList employeeTypeList;
	public static final String[] EMPLOYEE_TYPES = { "Full Time", "Part-Time",
			"Flex-Time" };
	public static final String[] EMPLOYEE_STATUSES = { "Probationary",
			"Permenant" };
	public int salary;
	public String employeeStatus;
	public String employeeType;

	public Employee() {

	}

	public Employee(int id, String type, String status, int salary) {
		super();
		this.id = id;
		this.employeeStatus = status;
		this.employeeType = type;
		this.salary = salary;
		
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public ArrayList getEmployeeTypeList() {
		return employeeTypeList;
	}

	public void setEmployeeTypeList(ArrayList employeeTypeList) {
		employeeTypeList = new ArrayList();
		employeeTypeList.add(new LabelValueBean("Full Time", "1"));
		employeeTypeList.add(new LabelValueBean("Part Time", "2"));
		employeeTypeList.add(new LabelValueBean("Student", "3"));
		this.employeeTypeList = employeeTypeList;
	}

	public String toString() {
		return ("Employee: ID = " + this.id + " Status = "
				+ this.employeeStatus + " Type = " + this.employeeType);
	}

	/**
	 * @param args
	 * @throws IOException 
	 *@category
	 *This is a sample web application for New Hires
	 *Calls EmployeeUpdate method to update the Employee table.
	 *Calls personUpdate method to update the Person table.
	 *Calls departmentUpdate method to update the Department table.
	 *
	 */
	/*public static void main(String[] args) throws IOException {

		NewHire nh = new NewHireImpl();
		

		//nh.employeeUpdate();
		//nh.personUpdate();
		//nh.departmentUpdate();
		//nh.personDelete();
		
		//HashSet<String> netIDs = nh.netSelect();
		//System.out.println(netIDs);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Person p1 = new Person(123, dateFormat.format(date), "11111111",
				"333 Test st. ", "John ", "Doe ", "doejohn1", "doejohn1@msu.edu");
		// p1.setDob(date);
		Department d1 = new Department(1212, "Controller's");
	//	Creation c = new Creation(date, "creator");
		Employee e = new Employee(1, "full time", "probationary", 15000);

		System.out.println(p1.toString());
		System.out.println(e.toString());
		System.out.println(d1.toString());
		//System.out.println(c.toString());
		
	//	String records = (p1.toString() + e.toString() + d1.toString() + c.toString());
		
		//writeToFile(records);
		

	}
	
	public static void writeToFile(String text) throws IOException {
		
		BufferedWriter br = new BufferedWriter(new FileWriter("records.txt"));
		
		try {
		br.write(text);
		br.newLine();
		br.close();
		
		}
		
		catch (Exception e) {
		}
		
	}*/

}
