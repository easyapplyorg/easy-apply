package edu.mum.cs.easyapply.daos.company;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.model.Company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CompanyDAO {
    static DataSource dataSource = DataSourceFactory.getInstance();

    public static void saveCompany(Company company){
        try {
            Connection connection = dataSource.getConnection();
            System.out.println("Database connected");
            PreparedStatement statement = connection.prepareStatement("insert into company(name,location,industry,email,website,joined_date,password) values (?,?,?,?,?,?,?)");
            statement.setString(1,company.getName());
            statement.setString(2,company.getLocation());
            statement.setString(3,company.getIndustry());
            statement.setString(4,company.getEmail());
            statement.setString(5,company.getWebsite());
            statement.setDate(6,formatDate(new Date()));
            statement.setString(7,company.getPassword());
            statement.executeUpdate();
            System.out.println("statement executed");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static java.sql.Date formatDate(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
