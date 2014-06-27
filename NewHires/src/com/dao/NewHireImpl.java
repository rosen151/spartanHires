package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.data.Creation;
import com.data.Department;
import com.data.Employee;
import com.data.NewHire;
import com.data.Person;

public class NewHireImpl implements NewHire {

	String employeeInsert1 = "INSERT INTO Employee (ID, EmployeeType, Status, Salary, CreationDate,CreatedBy) VALUES (?,?,?,?,?,?)";
	String personInsert1 = "INSERT INTO Person (PID, ID, DOB, ssn, Address, FirstName, LastName, CreationDate, CreatedBy, NETID, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String departmentInsert1 = "INSERT INTO Department (DID, ID, DepartmentName, CreationDate, CreatedBy) VALUES (?,?,?,?,?)";

	String employeeSelect1 = "SELECT ID, EmployeeType, Status, Salary, CreationDate, CreatedBy"
			+ " " + "FROM Employee";
	String personSelect1 = "SELECT PID, ID, DOB, ssn, Address, FirstName, LastName, netID, email"
			+ " " + "FROM Person" + " " + "WHERE ID IN (SELECT ID FROM DEPARTMENT WHERE DepartmentName=?)";
	String netSelect = "SELECT netID" + " " + "FROM Person";
	String departmentSelect1 = "SELECT DID, ID, DepartmentName" + " "
			+ "FROM Department";
	String personDelete = "delete from Person where PID = (?)";
	
   String personUpdate = "UPDATE PERSON SET DOB = ?, ssn = ?, Address = ?, FirstName = ?, LastName = ?, NETID = ?, EMAIL = ?" + " " + "WHERE PID = ?";
	
   String employeeId = "SELECT MAX(ID) ID FROM EMPLOYEE";
   
   String employeeSeq = "Select (MAX(ID) + 1) ID FROM EMPLOYEE";
   
   String personSeq = "Select (MAX(PID) + 1) PID FROM PERSON";
   
   String departmentSeq = "SELECT (MAX(DID) + 1) DID FROM DEPARTMENT";
   
   Connection conn = null;

	@Override
	public void personUpdate(DataSource ds, Person p, int eid, String creator, String creationDate) throws ClassNotFoundException {

		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
		
			System.out.println("connected");
		PreparedStatement pstmt = conn.prepareStatement(personInsert1);

			pstmt.setLong(1, p.getPid());
			pstmt.setLong(2, eid);
			pstmt.setString(3, p.getDob().toString());
			pstmt.setString(4, p.getSsn());
			pstmt.setString(5, p.getAddress());
			pstmt.setString(6, p.getFname());
			pstmt.setString(7, p.getLname());
			pstmt.setString(8,creationDate.toString());
			pstmt.setString(9, creator);
			pstmt.setString(10, p.getNetId());
			pstmt.setString(11, p.getEmail());
			pstmt.executeUpdate();
		}

	catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}

	}
	
	public void personDelete(DataSource ds, String PID) throws ClassNotFoundException {
		
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			PreparedStatement pstmt = null;
					
		

			try {
				
				pstmt = conn.prepareStatement(personDelete);
				pstmt.setString(1, PID);
				int output = pstmt.executeUpdate();
				if (output > 0) {
					System.out.println(output + "record deleted");
				}
				else {
					System.out.println("There was no record with the given ID to delete");
				}
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}

		}

		catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}

	}
		
	
	

	@Override
	public void departmentUpdate(DataSource ds, Department d, int eid, String creator, String creationDate) throws ClassNotFoundException {
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			//DID, ID, DepartmentName, CreationDate, CreatedBy
		PreparedStatement pstmt = conn.prepareStatement(departmentInsert1);

			pstmt.setLong(1, d.getDepId());
			pstmt.setLong(2, eid);
			pstmt.setString(3, d.getDepartment_name());
			pstmt.setString(4, creationDate.toString());
			pstmt.setString(5, creator);
			
			pstmt.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}

	}

	@Override
	public void employeeUpdate(DataSource ds, Employee e, String creator, String creationDate) {
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			//Statement stmt = conn.createStatement();
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(employeeInsert1);
			
	
					pstmt.setLong(1, e.getid());
					pstmt.setString(2, e.getEmployeeType());
					pstmt.setString(3, e.getEmployeeStatus());
					pstmt.setInt(4, e.getSalary());
					pstmt.setString(5, creationDate);
					pstmt.setString(6, creator);
					pstmt.executeUpdate();
			
					
			
		}
		
		
		catch (SQLException sqle) {	
			
			System.out.println(sqle);
			
			
		}
		catch (Exception ex) {
			if (conn == null) {
				System.out.println("you are not connected to the database");
				
			}
		}

		
		finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}

	}

	@Override
	public void personNewUpdate(DataSource ds, String dob, String ssn,
			String address, String fname, String lname, String netid,
			String email, int pid) throws ClassNotFoundException{
		try {
			//SET DOB = ?, ssn = ?, Address = ?, FirstName = ?, LastName = ?, NETID = ?, EMAIL = ?" + " " + "WHERE PID = ?";
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			PreparedStatement stmt = conn.prepareStatement(personUpdate);
			stmt.setString(1, dob);
			stmt.setString(2, ssn);
			stmt.setString(3, address);
			stmt.setString(4, fname);
			stmt.setString(5, lname);
			stmt.setString(6, netid);
			stmt.setString(7,email);
			stmt.setLong(8, pid);
			stmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	finally {
		try {
			conn.close();
		} catch (SQLException sqle) {
		}
	}
	}

	@Override
	public List<Person> personSelect(DataSource ds, String name) throws ClassNotFoundException {
		List<Person> lp = new ArrayList<Person>();
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			PreparedStatement stmt = conn.prepareStatement(personSelect1);
		
            stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					   Person p = new Person();
					   p.setPid( rs.getInt("PID"));
					   p.setNetId(rs.getString("netID"));
					   p.setDob(rs.getDate("DOB").toString());
					   p.setSsn(rs.getString("ssn"));
					   p.setFname(rs.getString("FirstName"));
					   p.setLname(rs.getString("LastName"));
					   p.setAddress(rs.getString("Address"));
					   p.setEmail(rs.getString("email"));
					   int i = rs.getInt("PID");
					   String a = rs.getString("netID");
					   String dob = rs.getDate("DOB").toString();
					   String ssn = rs.getString("ssn");
					   String fname = rs.getString("FirstName");
					   String lname = rs.getString("LastName");
					   String address = rs.getString("Address");
					   String email = rs.getString("email");
					   
					lp.add(p);
					System.out.println("id=" +  i + " netID = '" + a
							+ "' DOB = '" + dob + "' ssn = '"
							+ ssn + "' FirstName = '" + fname
							+ "' LastName = '" + lname + "'" + "Address" + address + "email" + email);
				}
			}

			catch (SQLException sqle) {
				System.out.println(sqle);
			}

		finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return lp;
	}

	@Override
	public List<Department> departmentSelect(DataSource ds) throws ClassNotFoundException {
		List<Department> ld = new ArrayList<Department>();
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			Statement stmt = conn.createStatement();
		

				ResultSet rs = stmt.executeQuery(departmentSelect1);
				while (rs.next()) {
					Department d = new Department();
					d.setDepId(rs.getInt("DID"));
					d.setDepartment_name(rs.getString("DepartmentName"));
					ld.add(d);
				
			} }catch (SQLException sqle) {
				System.out.println(sqle);
			}
		 finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return ld;

	}

	@Override
	public void employeeSelect(DataSource ds) throws ClassNotFoundException {
		try {
		
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			Statement stmt = conn.createStatement();
			
			try {

				ResultSet rs = stmt.executeQuery(employeeSelect1);
				while (rs.next()) {
					int id = rs.getInt("ID");
					String empType = rs.getString("EmployeeType");
					String empStatus = rs.getString("Status");
					Date cDate = rs.getDate("CreationDate");
					String cby = rs.getString("CreatedBy");
					int salary = rs.getInt("Salary");
					System.out.println("id=" + id + " EmpType = '" + empType
							+ "' empStatus = '" + empStatus + "' Salary = '"
							+ salary + "' Creation Date = '" + cDate
							+ "' Creator = '" + cby + "'");
				}
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}
		}

		catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
	}
	
	@Override
	public HashSet<String> netSelect(DataSource ds) throws ClassNotFoundException {
		
		HashSet<String> netIDs = new HashSet<String>();
		
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
			System.out.println("connected");
			Statement stmt = conn.createStatement();
			try {

				ResultSet rs = stmt.executeQuery(netSelect);
				while (rs.next()) {
					netIDs.add(rs.getString("NETID"));
				
				}
				System.out.println(netIDs);
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}
		}

		catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return netIDs;
	}
		
	@Override
	public int employeeSeq() throws ClassNotFoundException {
		int i = 0;
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
		

		Statement stmt = conn.createStatement();
	ResultSet rs = 	stmt.executeQuery(employeeSeq);
	while (rs.next()){
		 i = rs.getInt("ID");
		System.out.println(i + "i");
	}
		}

	catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return i;

	}
	
	@Override
	public int personSeq() throws ClassNotFoundException {
		int i = 0;
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
		
			System.out.println("connected");

		Statement stmt = conn.createStatement();
	ResultSet rs = 	stmt.executeQuery(personSeq);
	while (rs.next()){
		 i = rs.getInt("PID");
		System.out.println(i + "i");
	}
		}

	catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return i;

	}

	
	@Override
	public int departmentSeq() throws ClassNotFoundException {
		int i = 0;
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
		
			System.out.println("connected");

		Statement stmt = conn.createStatement();
	ResultSet rs = 	stmt.executeQuery(departmentSeq);
	while (rs.next()){
		 i = rs.getInt("DID");
		System.out.println(i + "i");
	}
		}

	catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return i;

	}

	
	@Override
	public int employeeId() throws ClassNotFoundException {
		int i = 0;
		try {
			//conn = ds.getConnection();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/JavaTunesDB", "guest",
					"password");
		
			System.out.println("connected");

		Statement stmt = conn.createStatement();
	ResultSet rs = 	stmt.executeQuery(employeeId);
	while (rs.next()){
		 i = rs.getInt("ID");
		System.out.println(i + "i");
	}
		}

	catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				conn.close();
			} catch (SQLException sqle) {
			}
		}
		return i;

	}


	


}
