package edu.mum.cs.easyapply.servlets;

import edu.mum.cs.easyapply.daos.company.CompanyDAO;
import edu.mum.cs.easyapply.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CompanyLoginServlet", urlPatterns = {"/company-login"})
public class CompanyLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("name");
        String cemail = request.getParameter("email");
        String cpassword = request.getParameter("password");
        ArrayList list = new ArrayList();

        if (cname==null || cname.equals("") || isWhiteSpace(cname)){
            list.add("name");
        }
        if (cemail==null || cemail.equals("") || isWhiteSpace(cemail)){
            list.add("email");
        }
        if (cpassword==null || cpassword.equals("") || isWhiteSpace(cpassword)){
            list.add("password");
        }

        if (list.size()>0 || !CompanyDAO.companyExists(cname,cemail,cpassword)){
            request.setAttribute("error",list);
            request.getRequestDispatcher("companylogin.jsp").forward(request,response);
        }
        else {
            HttpSession session = request.getSession();
            Company company=CompanyDAO.getCompany(cname,cemail,cpassword);
            int id = CompanyDAO.companyId(company);
            session.setAttribute("company",company);
            request.setAttribute("forward", true);
            request.getRequestDispatcher("/view-vacancies?cid=" + id).forward(request, response);
        }
    }

    private boolean isWhiteSpace(String s){
        return s.chars().allMatch(Character::isWhitespace);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Company company = (Company) session.getAttribute("company");
            if (company != null) { // forward if already logged in
                request.setAttribute("forward", true);
                request.getRequestDispatcher("/view-vacancies?cid=" + company.getCompanyId()).forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("/companylogin.jsp").forward(request, response);
    }

}
