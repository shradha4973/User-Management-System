/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.LoginDao;
import com.mycompany.usermanagement.dao.ProfileDao;
import com.mycompany.usermanagement.model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonam
 */
@WebServlet(name = "editprofile", urlPatterns = {"/editprofile"})
public class EditProfileServelet extends HttpServlet {

    ProfileDao obj = new ProfileDao();
    LoginDao dao = new LoginDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String uname = (String) session.getAttribute("username");

        ArrayList<User> profile = obj.getProfile(uname);

        request.setAttribute("profile", profile);
        RequestDispatcher rd = null;
        try {
            if (dao.checkAdmin(uname)) {

                rd = request.getRequestDispatcher("editprofile.jsp");
            } else {
                rd = request.getRequestDispatcher("editClientProfile.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditProfileServelet.class.getName()).log(Level.SEVERE, null, ex);
        }

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        long contact = Long.parseLong(request.getParameter("contact"));
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String info = request.getParameter("info");
        java.util.Date date = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd");

        String dob = sdf.format(date);

        User user = new User();

        user.setFname(fname);
        user.setLname(lname);
        user.setUname(uname);
        user.setEmail(email);
        user.setContact(contact);
        user.setAddress(address);
        user.setDob(dob);
        user.setGender(gender);
        user.setInfo(info);

        boolean result = obj.editProfile(user);
        if (result) {
            response.sendRedirect("getprofile");

        } else {
            String errorMessage = "Update Unsucessful";
            HttpSession regSession = request.getSession();
            regSession.setAttribute("RegError", errorMessage);
            try {
                if (dao.checkAdmin(uname)) {

                    response.sendRedirect("editprofile.jsp");
                } else {
                    response.sendRedirect("editClientProfile.jsp");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(EditProfileServelet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
