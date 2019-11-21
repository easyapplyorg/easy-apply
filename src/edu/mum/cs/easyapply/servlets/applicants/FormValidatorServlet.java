package edu.mum.cs.easyapply.servlets.applicants;

import edu.mum.cs.easyapply.model.ApplicantData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class ApplicantFormControllerServlet
 */
@WebServlet(name = "/FormValidatorServlet", urlPatterns = {"/applicant-signup"})
public class FormValidatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("applicants/sign-up.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");

        ApplicantData applicantFormData = new ApplicantData(firstName, lastName, address, phoneNumber, email, password);
        request.setAttribute("applicantFormData", applicantFormData);
        Map<String, String> errors = new HashMap<>();
        Map<String, String> formValues = new HashMap<>();

        boolean hasError = false;

        //first name
        if (firstName == null || firstName == "") {
            errors.put("firstName", "Please Enter your first name");
            hasError = true;
        } else {
            formValues.put("firstName", firstName);
        }

        //last name
        if (lastName == null || lastName == "") {
            errors.put("lastName", "Please Enter your last name");
            hasError = true;
        } else {
            formValues.put("lastName", lastName);
        }

		//email
		if (email == null || email == "") {
			errors.put("email", "Please Enter your email");
			hasError = true;
		} else {
			formValues.put("email", email);
		}

		//password
		if (password == null || password.equals("")) {
			errors.put("password", "Please Enter your password");
			hasError = true;
		} else {
			formValues.put("password", password);
		}

		//confirm password
		if (passwordConfirm == null || passwordConfirm.equals("") || !password.equals(passwordConfirm)) {
			errors.put("passwordConfirm", "Please confirm your password");
			hasError = true;
		} else {
			formValues.put("passwordConfirm", password);
		}

        if (hasError) {
            request.setAttribute("myErrors", errors);
            request.setAttribute("values", formValues);
            RequestDispatcher view = request.getRequestDispatcher("applicants/sign-up.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/applicant-save");
            view.forward(request, response);
        }

    }
}
