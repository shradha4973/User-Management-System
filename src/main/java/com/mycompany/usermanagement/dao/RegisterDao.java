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
 * @author sonam
 */
public class RegisterDao {

    public boolean insert(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt1 = con.prepareStatement("INSERT INTO `user` (`fname`, `lname`, `username`, `email`,`dob`, `password`, `address`, `gender`,`contact`) VALUES (?,?,?,?,?,?,?,?,?)");

            stmt1.setString(1, user.getFname());
            stmt1.setString(2, user.getLname());
            stmt1.setString(3, user.getUname());
            stmt1.setString(4, user.getEmail());
            stmt1.setString(5, user.getDob());
            stmt1.setString(6, user.getPword());
            stmt1.setString(7, user.getAddress());
            stmt1.setString(8, user.getGender());
            stmt1.setLong(9, user.getContact());

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
                    stmt2.setString(3, "Created a new account");
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
        return false;

    }
}
