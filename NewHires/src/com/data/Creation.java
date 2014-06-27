package com.data;
import java.util.*;
public class Creation {
	public String creationDate;
	public String creator;
	
	public Creation(){
		
	}
	public Creation(String creationDate, String creator) {
		super();
		this.creationDate = creationDate;
		this.creator = creator;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String toString(){
		return("Creation: date = " + creationDate + ", creator = " + creator);
		
	}
}
