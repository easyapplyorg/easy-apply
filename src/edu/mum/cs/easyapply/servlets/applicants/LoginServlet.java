package edu.mum.cs.easyapply.servlets.applicants;

import edu.mum.cs.easyapply.daos.applicants.ApplicantDAO;
import edu.mum.cs.easyapply.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/applicant-login"})
public class LoginServlet extends HttpServlet {

    private ApplicantDAO applicantDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        applicantDAO = new ApplicantDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<String> errors = new ArrayList<>();
        if (email == null || email != null && email.equals("")) {
            errors.add("Please add an email");
        }

        if (password == null || password != null && password.equals("")) {
            errors.add("Please add a password");
        }

        if (errors.size() > 0) {
            request.setAttribute("email", email);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("applicants/log-in.jsp").forward(request, response);
        } else {
            User user = applicantDAO.authenticate(email, password);
            if (user.getFirstName() == null) {
                errors.add("Invalid email or password");
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("applicants/log-in.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("forward", true);
                request.getRequestDispatcher("/view-vacancies").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("applicants/log-in.jsp").forward(request, response);
    }
}
