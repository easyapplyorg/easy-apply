package edu.mum.cs.easyapply.daos.applications;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.model.Application;
import edu.mum.cs.easyapply.model.Company;
import edu.mum.cs.easyapply.model.User;
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

public class ApplicationDAO {

    static DataSource dataSource = DataSourceFactory.getInstance();

    public void saveApplication(Application data) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into Application (user_id, vacancy_id) values (?, ?)");
            pstmt.setInt(1, data.getUser().getUserId());
            pstmt.setInt(2, data.getVacancy().getVacancyId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public List<Application> getApplicationsForVacancy(int companyId, int vacancyId) {
        List<Application> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from Application, User, Vacancy where " +
                    "Application.user_id = User.user_id AND Application.vacancy_id = Vacancy.vacancy_id AND Application.vacancy_id = ? AND Vacancy.company_id = ?");
            pstmt.setInt(1, vacancyId);
            pstmt.setInt(2, companyId);
            list = organizeData(pstmt);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    List<Application> organizeData(PreparedStatement pstmt) throws SQLException {
        List<Application> list = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Application data = new Application();
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setAddress(rs.getString("address"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setEmail(rs.getString("email"));
            user.setJoinedDate(formatDate(rs.getTimestamp("joined_date")));

            Vacancy vacancy = new Vacancy();
            vacancy.setVacancyId(rs.getInt("vacancy_id"));
            vacancy.setTitle(rs.getString("title"));
            vacancy.setDescription(rs.getString("description"));
            vacancy.setCompany(new Company().setCompanyId(Integer.parseInt(rs.getString("company_id"))));
            vacancy.setDatePosted(formatDate(rs.getTimestamp("date_posted")));

            int applicationId = rs.getInt("application_id");
            String applicationDate = formatDate(rs.getTimestamp("application_date"));

            data.setApplicationId(applicationId).setUser(user).setVacancy(vacancy).setApplicationDate(applicationDate);
            list.add(data);
        }
        return list;
    }

    String formatDate(Date date) {
        return new SimpleDateFormat("E, MMM dd YYYY HH:mm:ss, z").format(new Date());
    }
}