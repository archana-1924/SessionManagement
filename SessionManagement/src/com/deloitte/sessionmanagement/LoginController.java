package com.deloitte.sessionmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.session.service.PersonService;
import com.deloitte.session.service.PersonServiceImpl;
import com.deloitte.sessionmanagement.model.Person;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("txtuname");
		String upwd=request.getParameter("txtpassword");
		PersonService ps=new PersonServiceImpl();
		try {

			Person p = ps.getPersonById(uname);
		    String pwd=p.getPassword();
           
		    if(pwd.equals(upwd))
		    {	
			  HttpSession ssn=request.getSession();
			  ssn.setAttribute("user",uname);
			  response.sendRedirect("welcome.jsp");
		    }
		    
		   else
		   {
		     response.sendRedirect("login.jsp");
		   }

	}
		catch (Exception e) 
		{
           
			e.printStackTrace();

		}
	}

}
