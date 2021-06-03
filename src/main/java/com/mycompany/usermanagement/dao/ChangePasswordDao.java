/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.dao;

import com.mycompany.usermanagement.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sasmi
 */
public class ChangePasswordDao {
    
    public boolean insert(User user) {
        boolean result = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt1 = con.prepareStatement("update user set password =? where username =? ");

            
            stmt1.setString(1, user.getPword());
            stmt1.setString(2, user.getUname());
            
            PreparedStatement stmt3 = con.prepareStatement("SELECT user_id from `user` WHERE username = ?");
            stmt3.setString(1, user.getUname());

            int rs = 0;
            rs = stmt1.executeUpdate();
            
            if (rs == 1) {
                ResultSet rs3 = stmt3.executeQuery();
                if (rs3.next()) {
                    int id = rs3.getInt(1);
                    System.out.println(id);
                    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO `history` (`user_id`, `username`, `activity`) VALUES (?,?,?)");
                    stmt2.setInt(1, id);
                    stmt2.setString(2, user.getUname());
                    stmt2.setString(3, "Changed Password");
                    int rs2 = stmt2.executeUpdate();
                    System.out.println("Success");
                }

                return true;

            }
            System.out.println("Failed");
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        return result;

    }
//        public static void main(String[] args){
//        
//            ChangePassword obj = new ChangePassword();
//            
//            User user = new User();
//        

//            user.setPword("12345");
//            user.setPwordconf("12345");
//            
//
//            boolean result = obj.insert(user);
//        
//        }
    
}
