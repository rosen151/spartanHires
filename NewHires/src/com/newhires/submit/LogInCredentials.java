package com.newhires.submit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.data.LogonForm;

/**
 * Servlet implementation class LogInCredentials
 */
public class LogInCredentials extends Action {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		LogonForm lf = (LogonForm) form;
		String username = lf.getName();
		String password = lf.getPassword();
		if (username.equals("ITservices") && password.equals("Admin")) {
			forward = mapping.findForward("success");

		} else if (username.equals("ebs") && password.equals("Admin")) {
			forward = mapping.findForward("success");

		} else if (username.equals("controller") && password.equals("Admin")) {
			forward = mapping.findForward("success");

		} else {
			forward = mapping.findForward("error");

		}
		return (forward);

	}

}
