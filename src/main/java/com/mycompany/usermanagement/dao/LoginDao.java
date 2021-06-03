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
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author sonam
 */
public class LoginDao {

    public boolean check(String uname, String pword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt1 = con.prepareStatement("select username,password from user where username=? and password=?");
            stmt1.setString(1, uname);
            stmt1.setString(2, pword);

            ResultSet rs = stmt1.executeQuery();

            if (rs.next()) {

                PreparedStatement stmt3 = con.prepareStatement("SELECT user_id from `user` WHERE username = ?");
                stmt3.setString(1, uname);
                ResultSet rs3 = stmt3.executeQuery();
                if (rs3.next()) {
                    int id = rs3.getInt(1);

                    PreparedStatement stmt4 = con.prepareStatement("DELETE FROM `history` WHERE `username`= ? and `activity` = ?");
                    stmt4.setString(1, uname);
                    stmt4.setString(2, "Last logged in");
                    int rs4 = stmt4.executeUpdate();

                    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO `history` (`user_id`, `username`, `activity`) VALUES (?,?,?)");
                    stmt2.setInt(1, id);
                    stmt2.setString(2, uname);
                    stmt2.setString(3, "Last logged in");

                    int rs2 = stmt2.executeUpdate();
                    
                }
                return true;
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

        return false;
    }

    public boolean checkAdmin(String uname) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        //Reference to connection interface 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

        PreparedStatement stmt = con.prepareStatement("select is_admin from user where username=?");
        stmt.setString(1, uname);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int is_admin = rs.getInt("is_admin");
            
            if (is_admin == 1) {
                return true;
            }
        }

        return false;
    }

    public boolean checkBlocked(String uname) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        //Reference to connection interface 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

        PreparedStatement stmt = con.prepareStatement("select is_blocked from user where username=?");
        stmt.setString(1, uname);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int is_blocked = rs.getInt("is_blocked");
            
            if (is_blocked == 1) {
                return true;
            }
        }

        return false;
    }
}
