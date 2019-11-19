package edu.mum.cs.easyapply.daos;

import edu.mum.cs.easyapply.model.Vacancy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VacancyDAO {

    static DataSource dataSource = DataSourceFactory.getInstance();

    public void saveVacancy(Vacancy data) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into Vacancy (title, description, company_id) values (?, ?, ?)");
            pstmt.setString(1, data.getTitle());
            pstmt.setString(2, data.getDecription());
            pstmt.setInt(3, data.getCompanyId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
