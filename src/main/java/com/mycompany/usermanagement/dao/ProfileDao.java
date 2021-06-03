/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.dao;

import com.mycompany.usermanagement.model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sonam
 */
public class ProfileDao {

    public ArrayList<User> getProfile(String uname) throws FileNotFoundException, IOException {
        ArrayList<User> profile = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * from user where username = ?");
            stmt.setString(1, uname);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String username = rs.getString("username");
                String address = rs.getString("address");
                long contact = rs.getLong("contact");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String info = rs.getString("info");
                String gender = rs.getString("gender");
                String profilePic = rs.getString("profile_pic");
                String coverPic = rs.getString("cover_pic");

                User user = new User(fname, lname, username, email, address, contact, address, dob, info, gender, profilePic, coverPic);
                profile.add(user);
            }

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

        return profile;
    }

    public boolean editProfile(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");

            PreparedStatement stmt1 = con.prepareStatement("UPDATE `user` SET `fname` = ?, `lname` = ?, `username` = ?, `email` = ?,`dob` = ?, `address` = ?, `gender` = ?,`contact` = ?, `info` = ? where `username`=(?)");

            stmt1.setString(1, user.getFname());
            stmt1.setString(2, user.getLname());
            stmt1.setString(3, user.getUname());
            stmt1.setString(4, user.getEmail());
            stmt1.setString(5, user.getDob());
            stmt1.setString(6, user.getAddress());
            stmt1.setString(7, user.getGender());
            stmt1.setLong(8, user.getContact());
            stmt1.setString(9, user.getInfo());
            stmt1.setString(10, user.getUname());

            int rs = 0;
            rs = stmt1.executeUpdate();

            if (rs == 1) {
                PreparedStatement stmt3 = con.prepareStatement("SELECT user_id from `user` WHERE username = ?");
                stmt3.setString(1, user.getUname());
                ResultSet rs3 = stmt3.executeQuery();
                if (rs3.next()) {
                    int id = rs3.getInt(1);

                    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO `history` (`user_id`, `username`, `activity`) VALUES (?,?,?)");
                    stmt2.setInt(1, id);
                    stmt2.setString(2, user.getUname());
                    stmt2.setString(3, "Profile was updated");

                    int rs2 = stmt2.executeUpdate();
                    if (rs2 == 1) {
                        System.out.println("Sucess");
                    } else {
                        System.out.println("Fail");
                    }

                    return true;

                }
            }
            System.out.println("Failed");
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        return false;

    }

    public void changeProfilePic(String uname, String path) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE `user` SET `profile_pic` = ? WHERE `username` = ?");
            ps.setString(1, path);
            ps.setString(2, uname);
            int executeUpdate = ps.executeUpdate();
            
            if (executeUpdate == 1) {
                PreparedStatement stmt3 = con.prepareStatement("SELECT user_id from `user` WHERE username = ?");
                stmt3.setString(1, uname);
                ResultSet rs3 = stmt3.executeQuery();
                if (rs3.next()) {
                    int id = rs3.getInt(1);

                    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO `history` (`user_id`, `username`, `activity`) VALUES (?,?,?)");
                    stmt2.setInt(1, id);
                    stmt2.setString(2, uname);
                    stmt2.setString(3, "Profile Picture Changed");

                    int rs2 = stmt2.executeUpdate();
                    

                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

    }
    
    public void changeCoverPic(String uname, String path) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Reference to connection interface 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE `user` SET `cover_pic` = ? WHERE `username` = ?");
            ps.setString(1, path);
            ps.setString(2, uname);
            int executeUpdate = ps.executeUpdate();
            
            if (executeUpdate == 1) {
                PreparedStatement stmt3 = con.prepareStatement("SELECT user_id from `user` WHERE username = ?");
                stmt3.setString(1, uname);
                ResultSet rs3 = stmt3.executeQuery();
                if (rs3.next()) {
                    int id = rs3.getInt(1);

                    PreparedStatement stmt2 = con.prepareStatement("INSERT INTO `history` (`user_id`, `username`, `activity`) VALUES (?,?,?)");
                    stmt2.setInt(1, id);
                    stmt2.setString(2, uname);
                    stmt2.setString(3, "Cover Picture Changed");

                    int rs2 = stmt2.executeUpdate();
                    

                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }

    }

}
