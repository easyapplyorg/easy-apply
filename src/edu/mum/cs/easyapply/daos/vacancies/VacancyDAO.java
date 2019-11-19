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
            PreparedStatement pstmt = connection.prepareStatement("insert into Vacancy (title, description, company_id) values (?, ?, ?)");
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
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Vacancy, Company WHERE Vacancy.company_id = Company.company_id order by date_posted DESC");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int vacancyId = rs.getInt("vacancy_id");
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

                Vacancy data = new Vacancy(vacancyId, title, description, company, datePosted);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    String formatDate(Date date) {
        return new SimpleDateFormat("E, MMM dd YYYY HH:mm:ss, z").format(new Date());
    }
}
