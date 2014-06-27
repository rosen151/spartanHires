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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.dao.NewHireImpl;
import com.data.Creation;
import com.data.Department;
import com.data.Email;
import com.data.Employee;
import com.data.NewHire;
import com.data.Person;

/**
 * Servlet implementation class SubmitServlet
 */
public class PersonAction extends Action {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/JavaTunesDataSource")
	DataSource ds;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {

		Person pForm = (Person) form;
		NewHire nh = new NewHireImpl();

		ActionForward forward = null;
		ActionMessages errors = new ActionMessages();
		request.setAttribute("fname", pForm.fname);
		request.setAttribute("lname", pForm.lname);
		request.setAttribute("dob", pForm.dob);
		request.setAttribute("ssn", pForm.ssn);
		request.setAttribute("email", pForm.email);
		request.setAttribute("netid", pForm.netId);
		request.setAttribute("address", pForm.address);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		nh.netSelect(ds);
		HttpSession session = null;
		if (nh.netSelect(ds).contains(pForm.netId)) {
			session = request.getSession(true);
			session.setAttribute("message",
					"This netid already exists in the system");
			forward = mapping.findForward("error");

		} else if ((!pForm.dob.isEmpty()) || (!pForm.ssn.isEmpty()) || (!pForm.address.isEmpty()) || (!pForm.fname.isEmpty()) || (!pForm.lname.isEmpty()) || (!pForm.netId.isEmpty()) || (!pForm.email.isEmpty())){

			Person p = new Person(nh.personSeq(), pForm.dob, pForm.ssn, pForm.address,
					pForm.fname, pForm.lname, pForm.netId, pForm.email);
			nh.personUpdate(ds, p, nh.employeeId(), "New Hire", df.format(dt));

			Email emailMessage = new Email();
			emailMessage.sendEmail(pForm.fname, pForm.netId, pForm.email);

			forward = mapping.findForward("success");

		} else {
			ActionMessage oo = new ActionMessage("error.fields.enter",
					pForm.dob);
			errors.add("error.fields.enter", oo);
			forward = mapping.findForward("error");
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
			}
		}
		return (forward);
	}
	
	
}
