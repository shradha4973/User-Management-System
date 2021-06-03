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
@WebServlet(name = "getprofile", urlPatterns = {"/getprofile"})
public class ProfileServlet extends HttpServlet {

    User user = new User();
    LoginDao dao = new LoginDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProfileDao obj = new ProfileDao();
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("username");
        ArrayList<User> profile = obj.getProfile(uname);
        request.setAttribute("profile", profile);

        RequestDispatcher rd = null;
        try {
            if (dao.checkAdmin(uname)) {
                rd = request.getRequestDispatcher("profile.jsp");
            } else {
                rd = request.getRequestDispatcher("clientprofile.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        rd.forward(request, response);

    }

}
