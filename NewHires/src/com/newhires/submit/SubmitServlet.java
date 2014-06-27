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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.dao.NewHireImpl;
import com.data.Creation;
import com.data.Department;
import com.data.Employee;
import com.data.NewHire;
import com.data.Person;

/**
 * Servlet implementation class SubmitServlet
 */
public class SubmitServlet extends Action {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/JavaTunesDataSource")
	DataSource ds;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		Employee eForm = (Employee) form;
		ActionForward forward = null;
		ActionMessages errors = new ActionMessages();
		NewHire nh = new NewHireImpl();
		int salary = (int)(Math.round( (eForm.salary) / 10.0) * 10);
		if (salary > 0) {
			request.setAttribute("employeestatus", eForm.employeeStatus);
			request.setAttribute("employeeType", eForm.employeeType);
			request.setAttribute("salary", eForm.salary);

			Employee e = new Employee(nh.employeeSeq(), eForm.employeeType,
					eForm.employeeStatus, eForm.salary);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = new Date();

			nh.employeeUpdate(ds, e, "New Hire", df.format(dt));

			forward = mapping.findForward("success");
		} else {
			
			if (salary < 1){
			ActionMessage oo = new ActionMessage("error.salary.enter",
					eForm.salary);
			errors.add("eerror.salary.enter", oo);
			
			} else if(eForm.employeeStatus.equals(0)){
				ActionMessage oo = new ActionMessage("error.employeeStatus.enter",
						eForm.salary);
				errors.add("eerror.employeeStatus.enter", oo);
			}
					
					forward = mapping.findForward("error");
					if (!errors.isEmpty()) {
						saveErrors(request, errors);
					}
		} 
		
		return (forward);
	}
}
