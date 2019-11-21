package edu.mum.cs.easyapply.servlets.applications;

import edu.mum.cs.easyapply.daos.applications.ApplicationDAO;
import edu.mum.cs.easyapply.model.Application;
import edu.mum.cs.easyapply.model.Company;
import edu.mum.cs.easyapply.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewApplicationsServlet", urlPatterns = {"/view-applications"})
public class ViewAllServlet extends HttpServlet {

    private ApplicationDAO appDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        appDAO = new ApplicationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Application> applications = new ArrayList<>();
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            Company company = (Company) session.getAttribute("company");
            if (user != null) {
                int userId = user.getUserId();
                applications = appDAO.getApplicationsForVacancy(userId);
                request.setAttribute("size", applications.size());
                request.setAttribute("applications", applications);
            } else if (company != null) {
                Integer companyId = company.getCompanyId();
                String vacancyId = request.getParameter("vid");
                applications = appDAO.getApplicationsForVacancy(companyId, Integer.parseInt(vacancyId == null ? "1" : vacancyId));
                request.setAttribute("size", applications.size());
                request.setAttribute("applications", applications);
            }
        } else { // so that we still display something at least
            request.setAttribute("size", applications.size());
            request.setAttribute("applications", applications);
        }
        request.getRequestDispatcher("applications/view-all.jsp").forward(request, response);
    }
}
