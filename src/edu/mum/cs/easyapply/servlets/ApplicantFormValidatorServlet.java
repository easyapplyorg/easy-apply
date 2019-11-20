package edu.mum.cs.easyapply.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.cs.easyapply.model.ApplicantData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class ApplicantFormControllerServlet
 */
@WebServlet("/ApplicantFormValidatorServlet")
public class ApplicantFormValidatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicantData applicantFormData= new ApplicantData();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantFormValidatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.sendRedirect("ApplicantSignUp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

String date=LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String address= request.getParameter("address");
		String phoneNumber= request.getParameter("phoneNumber");
		String email= request.getParameter("email");
		
		
		ApplicantData applicantFormData= new ApplicantData(firstName, lastName, address, phoneNumber, email, "");
		request.setAttribute("applicantFormData", applicantFormData);
		Map<String, String>errors =new HashMap<>();
		Map<String, String>formValues =new HashMap<>();
		
		
		boolean hasError = false;
		
		
	//first name
		if (firstName==null||firstName=="") {
			errors.put("firstName", "Please Enter your first name");
		hasError = true;
		}
		else {
			formValues.put("firstName", firstName);
		}
		
		
		
		//last name
				if (lastName==null||lastName=="") {
					errors.put("lastName", "Please Enter your last_name");
				hasError = true;
				}
				else {
					formValues.put("lastName", lastName);
				}
				
		//address
				if (address==null || address=="") {
					errors.put("address", "Please Enter your address");
				hasError = true;
				}
				else {
					formValues.put("address",address);
				}	
		//phone_number
				if (phoneNumber==null || phoneNumber=="") {
					errors.put("phoneNumber", "Please Enter your phone_number");
				hasError = true;
				}
				else {
					formValues.put("phoneNumber",phoneNumber);
				}	
				
	//email
				if (email==null || email=="") {
					errors.put("email", "Please Enter your email");
				hasError = true;
				}
				else {
					formValues.put("email",email);
				}	
		
	
		

		if (hasError) {
			
			
			request.setAttribute("myErrors", errors);
			request.setAttribute("values", formValues);
			
		
			RequestDispatcher view = request.getRequestDispatcher("/ApplicantSignUp.jsp");
			view.forward(request, response);
		} 
		
		else {
		
		
		RequestDispatcher view = request.getRequestDispatcher("/ApplicantDataController");
	view.forward(request, response);
	
		
		
		
//	HttpSession session = request.getSession();	
//		session.setAttribute("today", date);
//	session.setAttribute("values", formValues);
//	
//		response.sendRedirect("ThankYou.jsp");
	

	}

	}
}