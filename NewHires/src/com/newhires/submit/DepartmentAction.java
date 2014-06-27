package com.newhires.submit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.data.Creation;
import com.data.Department;
import com.data.Employee;
import com.data.NewHire;
import com.data.Person;

/**
 * Servlet implementation class SubmitServlet
 */
public class DepartmentAction extends Action {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/JavaTunesDataSource")
	DataSource ds;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		ActionForward forward = null;
		Department dform = (Department) form;
		NewHire nh = new NewHireImpl();
		dform.setDepId(nh.departmentSeq());
		

		request.setAttribute("departmentName", dform.department_name);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		nh.departmentUpdate(ds, dform, nh.employeeId(), "New Hire", df.format(dt));

		nh.departmentSelect(ds);

		forward = mapping.findForward("success");

		return (forward);
	}
}
