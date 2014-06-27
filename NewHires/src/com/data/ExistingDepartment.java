package com.data;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class ExistingDepartment extends ActionForm {
	
	private String departmentName = null;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

}
