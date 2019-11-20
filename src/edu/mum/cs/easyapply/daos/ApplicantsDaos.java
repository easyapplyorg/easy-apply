package edu.mum.cs.easyapply.daos;

import edu.mum.cs.easyapply.model.ApplicantData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class ApplicantsDaos {


  private static DataSource dataSource = DataSourceFactory.getInstance();
  
  public static void saveApplicantFormData(ApplicantData applicantFormData) {
	  try {
		  Connection connection = dataSource.getConnection();
		  System.out.println("connected");
		  PreparedStatement pstmt = connection.prepareStatement("insert into user (first_name,last_name,address,phone_number,email,password) values (?, ?, ?, ?, ?, ?)");
		  pstmt.setString(1, applicantFormData.getFirstName());
		  pstmt.setString(2, applicantFormData.getLastName());
        pstmt.setString(3, applicantFormData.getAddress());
        pstmt.setString(4, applicantFormData.getPhoneNumber());
        pstmt.setString(5, applicantFormData.getEmail());
        pstmt.setString(6, applicantFormData.getPassword());
        pstmt.executeUpdate();
        System.out.println("query executed");
        pstmt.close();
        connection.close();
	  }
	  catch(SQLException e){
		  e.printStackTrace();
	  }
  }


//  public static saveApplicantFormData(ApplicantData applicantFormData) {
//      try {
//          Connection connection = dataSource.getConnection();
//          System.out.println("Database connected");
//          PreparedStatement pstmt = connection.prepareStatement("insert into user (first_name,last_name,address,phone_number) values (?, ?, ?, ?)");
//          pstmt.setString(1, applicantFormData.getFirstName());
//          pstmt.setString(1, applicantFormData.getLastName());
//          pstmt.setString(2, applicantFormData.getAddress());
//          pstmt.setString(3, applicantFormData.getPhoneNumber());
//          pstmt.setString(4, applicantFormData.getEmail());
//          pstmt.executeUpdate();
//          System.out.println("query executed");
//          pstmt.close();
//          connection.close();
//      } catch (SQLException e) {
//          System.err.println(e);
//      }
//      return applicantFormData;
//     
//  }
}
