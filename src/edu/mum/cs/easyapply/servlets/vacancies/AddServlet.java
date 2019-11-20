package edu.mum.cs.easyapply.servlets.vacancies;

import edu.mum.cs.easyapply.daos.vacancies.VacancyDAO;
import edu.mum.cs.easyapply.model.Company;
import edu.mum.cs.easyapply.model.Vacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServlet", urlPatterns = {"/add-vacancy"})
public class AddServlet extends HttpServlet {

    private VacancyDAO vacancyDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        vacancyDAO = new VacancyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("jobTitle");
        String description = request.getParameter("jobDescription");
        List<String> errors = new ArrayList<>();
        if (title != null && title.equals("")) {
            errors.add("Please add a job title");
        }
        if (description != null && description.equals("")) {
            errors.add("Please add a job description");
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("vacancies/add.jsp").forward(request, response);
        } else {
            // todo: companyId should come from session
            int companyId = 1;
            Company company = new Company();
            company.setCompanyId(companyId);
            String formatted = description.replace("\n", "<br/>");
            vacancyDAO.saveVacancy(new Vacancy(title, formatted, company));
            request.getRequestDispatcher("/view-vacancies?cid=" +companyId).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("vacancies/add.jsp").forward(request, response);
    }
}
