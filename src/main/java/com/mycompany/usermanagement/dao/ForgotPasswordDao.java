/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sasmi
 */
public class ForgotPasswordDao {
    
    String userName;
    

    public boolean check(String email) throws ClassNotFoundException, SQLException {
        

        Class.forName("com.mysql.jdbc.Driver");

        //Reference to connection interface 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

        PreparedStatement stmt1 = con.prepareStatement("SELECT email FROM user where email= ? ");
        stmt1.setString(1, email);

        ResultSet rs = stmt1.executeQuery();

        if (rs.next()) {
            return true;
        }

        con.close();
        return false;
        
    }
    
    public String getUserName(String email) throws ClassNotFoundException, SQLException{
        
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
        PreparedStatement stmt1 = con.prepareStatement("SELECT username FROM user where email= ?");
        stmt1.setString(1, email);
        
        ResultSet rs = stmt1.executeQuery();
        
     
        
        while (rs.next()){
          
            userName = rs.getString("username");
        
        }
        
//         System.out.println("Dubbugging outside DAO=" + userName);
    
        con.close();
        } catch (ClassNotFoundException | SQLException ex){
        System.err.println(ex);
        }
        return userName;
        
        
    
    }
    
}

//    public static void main(String[] args) {
//
//        ForgotPasswordDao a = new ForgotPasswordDao();
//        a.check("sasmigrg93@gmail.com", "sasmigrg93@gmail.com");
//    }


//            Statement st=con.createStatement();
//String email=request.getParameter("email");
//String strQuery = "SELECT password FROM users where email='"+email+"'";
//ResultSet rs = st.executeQuery(strQuery);
//rs.next();
//String Countrow = rs.getString(1);
//if(Countrow.equals("1")){
///*mail code
//paste your mail code here
//------------------
//Mail code*/
//System.out.println("Password send to your email id successfully !");
//}
//else{
//System.out.println("Invalid Email Id !");
//}
//}
//catch (Exception e){
//e.printStackTrace();
//}
