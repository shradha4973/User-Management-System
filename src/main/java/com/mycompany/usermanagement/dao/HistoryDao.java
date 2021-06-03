/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.dao;

import com.mycompany.usermanagement.model.History;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sonam
 */
public class HistoryDao {

    ArrayList<History> al = new ArrayList();

    public ArrayList<History> getHistory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT user_id,username,date,activity FROM history");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                Date date = rs.getDate(3);
                String activity = rs.getString(4);

                History history = new History(id, username, date, activity);

                al.add(history);
                System.out.println(history.getUname());

            }
            System.out.println("Failed");
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

        return al;
    }
    
    public ArrayList<History> getClientHistory(String uname) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT date,activity FROM history where username=?");
            stmt.setString(1,uname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                Date date = rs.getDate(1);
                String activity = rs.getString(2);

                History history = new History(date, activity);

                al.add(history);
                System.out.println(history.getUname());

            }
            System.out.println("Failed");
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

        return al;
    }

}
