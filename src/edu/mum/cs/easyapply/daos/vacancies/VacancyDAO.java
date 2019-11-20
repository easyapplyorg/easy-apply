package edu.mum.cs.easyapply.daos.vacancies;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.model.Company;
import edu.mum.cs.easyapply.model.Vacancy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VacancyDAO {

    static DataSource dataSource = DataSourceFactory.getInstance();

    public void saveVacancy(Vacancy data) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into vacancy (title, description, company_id) values (?, ?, ?)");
            pstmt.setString(1, data.getTitle());
            pstmt.setString(2, data.getDescription());
            pstmt.setInt(3, data.getCompany().getCompanyId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public List<Vacancy> getExistingVacancies() {
        List<Vacancy> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM vacancy, company WHERE vacancy.company_id = company.company_id order by date_posted DESC");
            ResultSet rs = pstmt.executeQuery();
            list = getVacancies(rs);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<Vacancy> searchExistingVacancies(String searchTerms) {
        List<Vacancy> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM vacancy, company WHERE " +
                    "vacancy.company_id = company.company_id AND (vacancy.title LIKE ? OR company.name LIKE ? " +
                    "OR company.industry LIKE ? OR company.location LIKE ?) order by date_posted DESC");
            String terms = String.format("%%%s%%", searchTerms);
            pstmt.setString(1, terms);
            pstmt.setString(2, terms);
            pstmt.setString(3, terms);
            pstmt.setString(4, terms);
            ResultSet rs = pstmt.executeQuery();
            list = getVacancies(rs);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<Vacancy> getExistingVacancies(int companyId) {
        List<Vacancy> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM vacancy, company WHERE vacancy.company_id = company.company_id AND company.company_id = ? order by date_posted DESC");
            pstmt.setInt(1, companyId);
            ResultSet rs = pstmt.executeQuery();
            list = getVacancies(rs);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    List<Vacancy> getVacancies(ResultSet rs) throws SQLException {
        List<Vacancy> list = new ArrayList<>();
        while (rs.next()) {
            int vacancyId = rs.getInt("vacancy_id");
            String title = rs.getString("title");
            String desc = rs.getString("description");
            String description = desc.length() > 300 ? desc.substring(0, 300) + "..." : desc;
            String datePosted = formatDate(rs.getTimestamp("date_posted"));

            Company company = new Company();
            company.setCompanyId(rs.getInt("company_id"));
            company.setName(rs.getString("name"));
            company.setLocation(rs.getString("location"));
            company.setIndustry(rs.getString("industry"));
            company.setWebsite(rs.getString("website"));
            company.setJoinedDate(formatDate(rs.getTimestamp("joined_date")));

            Vacancy data = new Vacancy(vacancyId, title, description, company, datePosted);
            list.add(data);
        }
        return list;
    }

    public Vacancy viewVacancyDetail(Integer vacancyId) {
        Vacancy data = new Vacancy();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM vacancy, company WHERE vacancy.vacancy_id = ? AND vacancy.company_id = company.company_id order by date_posted DESC");
            pstmt.setInt(1, vacancyId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                String datePosted = formatDate(rs.getTimestamp("date_posted"));

                Company company = new Company();
                company.setCompanyId(rs.getInt("company_id"));
                company.setName(rs.getString("name"));
                company.setLocation(rs.getString("location"));
                company.setIndustry(rs.getString("industry"));
                company.setWebsite(rs.getString("website"));
                company.setJoinedDate(formatDate(rs.getTimestamp("joined_date")));

                data = new Vacancy(vacancyId, title, description, company, datePosted);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return data;
    }

    String formatDate(Date date) {
        return new SimpleDateFormat("E, MMM dd YYYY HH:mm:ss, z").format(new Date());
    }
}
