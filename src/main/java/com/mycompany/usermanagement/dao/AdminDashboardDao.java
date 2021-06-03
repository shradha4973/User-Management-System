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
import javax.swing.JOptionPane;

/**
 *
 * @author simdo
 */
public class AdminDashboardDao {

    public int DisplayTable() {
        int totalUser = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "Select count(*) from user";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalUser = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalUser;
    }

    public int DisplayAdmin() {
        int totalAdmin = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "select count(*) from user where is_admin =1";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalAdmin = rs.getInt(1);
                System.out.println(totalAdmin);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalAdmin;

    }

    public int DisplayClient() {
        int totalClient = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "select count(*) from user where is_admin =0";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalClient = rs.getInt(1);
                System.out.println(totalClient);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalClient;

    }

    public int DisplayBlocked() {

        int totalBlocked = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "select count(*) from user where is_blocked =1";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalBlocked = rs.getInt(1);
                System.out.println(totalBlocked);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalBlocked;
    }

}
