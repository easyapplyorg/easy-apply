package edu.mum.cs.easyapply.daos.applications;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.model.Application;
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

public class ApplicationDAO {

    static DataSource dataSource = DataSourceFactory.getInstance();

    public void saveApplication(Application data) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into Application (user_id, vacancy_id) values (?, ?)");
            pstmt.setInt(1, data.getUserId());
            pstmt.setInt(2, data.getVacancyId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    String formatDate(Date date) {
        return new SimpleDateFormat("E, MMM dd YYYY HH:mm:ss, z").format(new Date());
    }
}
