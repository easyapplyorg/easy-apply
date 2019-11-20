package edu.mum.cs.easyapply.servlets;

import edu.mum.cs.easyapply.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "companyServlet", urlPatterns = {"/company-servlet"})
public class CompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String website = request.getParameter("website");
        String location = request.getParameter("location");
        String industry = request.getParameter("industry");

        Company company = new Company(name,location,industry,email,website,"", "");

        List<String> errors = new ArrayList<>();
        if (company.getName()==null || company.getName().equals("")||isWhiteSpace(company.getName())){
            errors.add("Company name");
        }
        if (company.getEmail()==null || company.getEmail().equals("")||isWhiteSpace(company.getEmail())){
            errors.add("Company email");
        }
        if (company.getWebsite()==null || company.getWebsite().equals("")||isWhiteSpace(company.getWebsite())){
            errors.add("Company website");
        }
        if (company.getLocation()==null || company.getLocation().equals("")||isWhiteSpace(company.getLocation())){
            errors.add("Company location");
        }
        if (company.getIndustry()==null || company.getIndustry().equals("")||isWhiteSpace(company.getIndustry())){
            errors.add("Company industry");
        }
        request.setAttribute("errors", errors);
        request.setAttribute("company",company);
        if(errors.size()>0){
            request.getRequestDispatcher("company.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("saving-company").forward(request,response);
        }
    }
    private boolean isWhiteSpace(String s){
        return s.chars().allMatch(Character::isWhitespace);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
