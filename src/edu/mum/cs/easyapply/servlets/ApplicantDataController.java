package edu.mum.cs.easyapply.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.mum.cs.easyapply.daos.ApplicantsDaos;
import edu.mum.cs.easyapply.model.ApplicantData;


/**
 * Servlet implementation class ApplicantDataController
 */
@WebServlet("/ApplicantDataController")
public class ApplicantDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private ApplicantsDaos applicantsDaos;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicantData applicantFormData = (ApplicantData)request.getAttribute("applicantFormData");
		System.out.println(applicantFormData);
		
		ApplicantsDaos.saveApplicantFormData(applicantFormData);
		System.out.println("saved");
		
		//ApplicantData savedFormData =  ApplicantsDaos.saveApplicantFormData(applicantFormData);
		
		//request.setAttribute("savedFormData", "helo");
		RequestDispatcher rd = request.getRequestDispatcher("ThankYou.jsp");
        rd.forward(request, response);
        
        
        

		
	}

}
