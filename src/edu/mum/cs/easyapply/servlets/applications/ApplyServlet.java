package edu.mum.cs.easyapply.servlets.applications;

import edu.mum.cs.easyapply.daos.applications.ApplicationDAO;
import edu.mum.cs.easyapply.daos.vacancies.VacancyDAO;
import edu.mum.cs.easyapply.model.Application;
import edu.mum.cs.easyapply.model.User;
import edu.mum.cs.easyapply.model.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApplyServlet", urlPatterns = {"/apply"})
public class ApplyServlet extends HttpServlet {

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
        // todo: get userId value from session else redirect to login/signup
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                int userId = user.getUserId();
                Integer vacancyId = Integer.parseInt(request.getParameter("vid"));
                appDAO.saveApplication(new Application(new User().setUserId(userId), new Vacancy().setVacancyId(vacancyId)));
            }
        } else {
            response.sendRedirect(request.getServletContext().getAttribute("baseUrl") + "/applicant-login");
        }
    }
}
