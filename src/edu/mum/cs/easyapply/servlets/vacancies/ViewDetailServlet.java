package edu.mum.cs.easyapply.servlets.vacancies;

import edu.mum.cs.easyapply.daos.vacancies.VacancyDAO;
import edu.mum.cs.easyapply.model.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewDetailServlet", urlPatterns = {"/view-detail"})
public class ViewDetailServlet extends HttpServlet {

    private VacancyDAO vacancyDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        vacancyDAO = new VacancyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vacancyParam = request.getParameter("vacancy_id");
        Integer vacancyId = Integer.parseInt(vacancyParam);
        Vacancy vacancy = vacancyDAO.viewVacancyDetail(vacancyId);
        request.setAttribute("vacancy", vacancy);
        request.getRequestDispatcher("vacancies/view-detail.jsp").forward(request, response);
    }
}
