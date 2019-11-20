package edu.mum.cs.easyapply.servlets.vacancies;

import edu.mum.cs.easyapply.daos.vacancies.VacancyDAO;
import edu.mum.cs.easyapply.model.Vacancy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewAllServlet", urlPatterns = {"/view-vacancies"})
public class ViewAllServlet extends HttpServlet {

    private VacancyDAO vacancyDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        vacancyDAO = new VacancyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // handles search submission
        String terms = request.getParameter("btSearch");
        if (terms !=null && terms.equals("")) {
            doGet(request, response);
        } else {
            List<Vacancy> vacancies = vacancyDAO.searchExistingVacancies(terms);
            request.setAttribute("terms", terms);
            request.setAttribute("size", vacancies.size());
            request.setAttribute("vacancies", vacancies);
            request.getRequestDispatcher("vacancies/view-all.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyId = request.getParameter("cid");
        List<Vacancy> vacancies;
        RequestDispatcher dispatcher;
        if (companyId != null && !companyId.equals("")) { // pick for a single company
            vacancies = vacancyDAO.getExistingVacancies(Integer.parseInt(companyId));
            dispatcher = request.getRequestDispatcher("vacancies/view-co.jsp");
        } else { // pick for all
            vacancies = vacancyDAO.getExistingVacancies();
            dispatcher = request.getRequestDispatcher("vacancies/view-all.jsp");
        }
        request.setAttribute("size", vacancies.size());
        request.setAttribute("vacancies", vacancies);
        dispatcher.forward(request, response);
    }
}
