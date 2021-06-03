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
public class ClientDashboardDao {

    public int DisplayTables() {
        int totalUsers = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "Select count(*) from user";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalUsers = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalUsers;
    }

    public int DisplayAdmins() {
        int totalAdmins = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "select count(*) from user where is_admin =1";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalAdmins = rs.getInt(1);
                System.out.println(totalAdmins);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalAdmins;

    }

    public int DisplayClients() {
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

    public int DisplayBlockeds() {

        int totalBlockeds = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connecting to database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            // retriving data from database
            String sql = "select count(*) from user where is_blocked =1";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalBlockeds = rs.getInt(1);
                System.out.println(totalBlockeds);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return totalBlockeds;
    }

}
