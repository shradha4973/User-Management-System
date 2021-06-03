/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.dao;

import com.mycompany.usermanagement.model.AdminReport;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sasmi
 */
public class AdminReportDao {

    ArrayList<AdminReport> arr = new ArrayList();
    String query = "select * from user";
    String url = "jdbc:mysql://localhost:3306/usermanagement";
    String username = "root";
    String password = "";

    public ArrayList<AdminReport> getCreatedUser() throws ClassNotFoundException, SQLException {

        //Reference to connection interface 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

        PreparedStatement stmt = con.prepareStatement("SELECT user_id,username,date FROM report where activity = ?");
        stmt.setString(1, "User Created");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String uname = rs.getString(2);
            Date date = rs.getDate(3);
            

            AdminReport ar = new AdminReport(id, uname, date);
            arr.add(ar);

        }
        return arr;

    }

    public ArrayList<AdminReport> getBlockedUser() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection(url, username, password);
        PreparedStatement st = con.prepareStatement("SELECT user_id,username,date FROM report where activity = ?");
        st.setString(1, "Blocked a User");

        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String uname = rs.getString(2);
            Date date = rs.getDate(3);
            

            AdminReport ar = new AdminReport(id, uname, date);
            arr.add(ar);

        }
        return arr;

    }

}
