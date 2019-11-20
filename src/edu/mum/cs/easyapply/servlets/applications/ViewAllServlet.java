package edu.mum.cs.easyapply.servlets.applications;

import edu.mum.cs.easyapply.daos.applications.ApplicationDAO;
import edu.mum.cs.easyapply.model.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        // todo: get userId value from session -- it could be a user or a company
        Integer companyId = 1;
        String vacancyId = request.getParameter("vid");
        List<Application> applications = appDAO.getApplicationsForVacancy(companyId, Integer.parseInt(vacancyId));
        request.setAttribute("size", applications.size());
        request.setAttribute("applications", applications);
        request.getRequestDispatcher("applications/view-all.jsp").forward(request, response);
    }
}
