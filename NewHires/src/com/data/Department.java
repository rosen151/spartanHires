package com.data;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.data.Creation;

public class Department extends ActionForm {
	public int depId;
	public static final String[] DEPARTMENT_NAMES = { "Controller's", "EBS",
			"IT Services" };
	public String department_name;

	public Department() {

	}

	public Department(int depId, String department_name) {
		super();

		for (int i = 0; i < DEPARTMENT_NAMES.length; i++) {
			if (department_name.equals(DEPARTMENT_NAMES[i])) {
				department_name = DEPARTMENT_NAMES[i];
				break;
			} else {
				department_name = ("Please enter a valid department name");
			}

		}

		this.depId = depId;
		this.department_name = department_name;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {

		this.department_name = department_name;

	}

	public String toString() {
		return ("Department ID: " + depId + "Department Name: " + department_name);
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if ((department_name.equals(null)) || (department_name.isEmpty())) {
			ActionMessage departmentName = new ActionMessage(
					"error.department.name");
			errors.add("error.department.name", departmentName);

		} else if (department_name.length() > 45) {
			ActionMessage departmentLength = new ActionMessage(
					"error.department.length");
			errors.add("error.department.length", departmentLength);
		}

		return errors;
	}
}
