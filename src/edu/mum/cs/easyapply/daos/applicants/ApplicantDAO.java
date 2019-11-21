package edu.mum.cs.easyapply.daos.applicants;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.daos.PassUtils;
import edu.mum.cs.easyapply.model.ApplicantData;
import edu.mum.cs.easyapply.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicantDAO {

    private static DataSource dataSource = DataSourceFactory.getInstance();

    public static void saveApplicantFormData(ApplicantData applicantFormData) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into user (first_name,last_name,address,phone_number,email,password) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, applicantFormData.getFirstName());
            pstmt.setString(2, applicantFormData.getLastName());
            pstmt.setString(3, applicantFormData.getAddress());
            pstmt.setString(4, applicantFormData.getPhoneNumber());
            pstmt.setString(5, applicantFormData.getEmail());
            pstmt.setString(6, applicantFormData.getPassword());
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authenticate(String email, String pwd) {
        User user = new User();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            pstmt.setString(1, email);
            String hashedPwd = PassUtils.getPasswordHash(pwd);
            pstmt.setString(2, hashedPwd);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setEmail(email)
                    .setUserId(rs.getInt("user_id"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setJoinedDate(rs.getString("joined_date"))
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
