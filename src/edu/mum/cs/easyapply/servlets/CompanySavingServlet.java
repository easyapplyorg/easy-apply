package edu.mum.cs.easyapply.servlets;

import edu.mum.cs.easyapply.daos.company.CompanyDAO;
import edu.mum.cs.easyapply.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactSavingServlet" , urlPatterns = {"/saving-company"})
public class CompanySavingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Company company = (Company) request.getAttribute("company");
        if (company!=null){
            CompanyDAO.saveCompany(company);
            response.sendRedirect("companylogin.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
