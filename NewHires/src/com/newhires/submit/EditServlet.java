package com.newhires.submit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dao.NewHireImpl;
import com.data.NewHire;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
				
		ActionForward forward = null;
		String PID = request.getParameter("PID");
		
		HttpSession session = request.getSession();
		NewHire nh = new NewHireImpl();
		
		
		
		return null;
		
	}
}
	
	
	
