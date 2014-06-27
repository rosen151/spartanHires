/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-11 LearningPatterns Inc.
 */

package com.data;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * Form bean for a Struts application. Users may access 2 fields on this form:
 * <ul>
 * <li>name -
 * <li>password -
 * </ul>
 */

public class LogonForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	// TODO: Add attributes and getters/setters for name and password

	String username = null;
	String password = null;

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
