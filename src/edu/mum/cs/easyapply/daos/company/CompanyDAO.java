package edu.mum.cs.easyapply.daos.company;

import edu.mum.cs.easyapply.daos.DataSourceFactory;
import edu.mum.cs.easyapply.daos.PassUtils;
import edu.mum.cs.easyapply.model.Company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


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
            String hashedPwd = PassUtils.getPasswordHash(company.getPassword());
            statement.setString(7,hashedPwd);
            statement.executeUpdate();
            System.out.println("statement executed");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean companyExists(String name,String email,String password){
        if (companyList()!=null){
            String hashedPwd = PassUtils.getPasswordHash(password);
            Iterator<Company> iterator = companyList().iterator();
            while (iterator.hasNext()){
                Company company=iterator.next();
                if (company.getName().equals(name)&&company.getEmail().equals(email)&&company.getPassword().equals(hashedPwd)){
                    return true;
                }
            }
        }
        return false;
    }
    public static Company getCompany(String name,String email,String password){
        if (companyList()!=null){
            String hashedPwd = PassUtils.getPasswordHash(password);
            Iterator<Company> iterator = companyList().iterator();
            while (iterator.hasNext()){
                Company company=iterator.next();
                if (company.getName().equals(name)&&company.getEmail().equals(email)&&company.getPassword().equals(hashedPwd)){
                    return company;
                }
            }
        }
        return null;
    }
    public static int companyId(Company company){
        return company.getCompanyId();
    }
    private static java.sql.Date formatDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    private static List<Company> companyList(){
        try {
            List<Company> companies = new ArrayList<>();
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from company");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("company_id");
                String cname = resultSet.getString("name");
                String location=resultSet.getString("location");
                String industry=resultSet.getString("industry");
                String website=resultSet.getString("website");
                String date = resultSet.getString("joined_date");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Company company = new Company(cname,location,industry,email,website,date,password);
                company.setCompanyId(id);
                companies.add(company);
            }
            statement.close();
            connection.close();
            return companies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
