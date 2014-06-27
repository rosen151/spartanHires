package com.data;

import java.util.HashSet;
import java.util.List;

import javax.sql.DataSource;

import com.data.Creation;

public interface NewHire {

	public void personUpdate(DataSource ds, Person p, int eid, String creator, String creationDate) throws ClassNotFoundException;

	public void departmentUpdate(DataSource ds, Department d, int eid, String creator, String creationDate) throws ClassNotFoundException;

	public void employeeUpdate(DataSource ds, Employee e, String creator, String creationDate);

	public List<Person> personSelect(DataSource ds, String name) throws ClassNotFoundException;

	public List<Department> departmentSelect(DataSource ds) throws ClassNotFoundException;

	public void employeeSelect(DataSource ds) throws ClassNotFoundException;
	
	public void personDelete(DataSource ds, String name) throws ClassNotFoundException;
	
	public HashSet<String> netSelect(DataSource ds) throws ClassNotFoundException;
	
	//public void personNewUpdate(DataSource ds, Person p);
	//public void connection();
	//SET DOB = ?, ssn = ?, Address = ?, FirstName = ?, LastName = ?, NETID = ?, EMAIL = ?" + " " + "WHERE PID = ?";
	public void personNewUpdate(DataSource ds, String dob, String ssn,
			String address, String fname, String lname, String netid,
			String email, int pid) throws ClassNotFoundException;

	public int employeeId() throws ClassNotFoundException;

	public int employeeSeq() throws ClassNotFoundException;

	public int personSeq() throws ClassNotFoundException;

	public int departmentSeq() throws ClassNotFoundException;
}
