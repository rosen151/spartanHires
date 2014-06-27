package com.newhires.submit;

import java.io.IOException;
import java.util.Date;
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
import com.data.ExistingDepartment;
import com.data.NewHire;
import com.data.Person;

/**
 * Servlet implementation class Department
 */
public class Department extends Action {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/JavaTunesDataSource")
	DataSource ds;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		ActionForward forward = null;
		ExistingDepartment d = (ExistingDepartment) form;
		String department = d.getDepartmentName();
		if (department.equals("ITservices")) {

			NewHire nh = new NewHireImpl();

			List<Person> list = nh.personSelect(ds, department);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			forward = mapping.findForward("itservices");

		} else if (department.equals("ebs")) {

			NewHire nh = new NewHireImpl();

			List<Person> list = nh.personSelect(ds, department);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);

			forward = mapping.findForward("ebs");

		} else if (department.equals("controller")) {

			NewHire nh = new NewHireImpl();

			List<Person> list = nh.personSelect(ds, department);
			HttpSession session = request.getSession();
			session.setAttribute("list", list);

			forward = mapping.findForward("controllers");

		} else {
			forward = mapping.findForward("error");
		}

		return forward;
	}
}
