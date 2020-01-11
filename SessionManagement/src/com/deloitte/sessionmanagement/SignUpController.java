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
 * Servlet implementation class SignUpController
 */
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String userName=request.getParameter("signupname");
		  String password=request.getParameter("signuppwd");
		  Person person=new Person(userName,password);
		  PersonService ps=new PersonServiceImpl();
		  
		  try {
			if(ps.addPerson(person))
			{
				
				System.out.println("product added");
				HttpSession ssn=request.getSession();
				ssn.setAttribute("user",userName);
				response.sendRedirect("welcome.jsp");
			}

			else
			{

				response.sendRedirect("error.jsp");	
			}
		}
		  catch (Exception e)
		  {
			
			e.printStackTrace();

		  }
		  
	}

}
