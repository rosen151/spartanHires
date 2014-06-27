package com.newhires.submit;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dao.NewHireImpl;
import com.data.NewHire;
import com.data.Person;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends Action {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/JavaTunesDataSource")
	DataSource ds;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		ActionForward forward = null;
		String PID = request.getParameter("PID");

		HttpSession session = request.getSession();
		NewHire nh = new NewHireImpl();
		System.out.println("works");

		nh.personDelete(ds, PID);

		forward = mapping.findForward("success");
		return forward;

	}

}
