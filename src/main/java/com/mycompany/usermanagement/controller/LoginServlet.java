/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    LoginDao dao = new LoginDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uname = request.getParameter("uname");
        String pword = request.getParameter("pword");

        try {
            if (dao.checkBlocked(uname)) {
                String errorMessage = "You are blocked, you cannot login!";
                HttpSession regSession = request.getSession();
                regSession.setAttribute("blockedErr", errorMessage);
                response.sendRedirect("login.jsp");
            } else {
                if (dao.check(uname, pword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", uname);
                    try {
                        if (dao.checkAdmin(uname)) {
                            response.sendRedirect("getdetails");
                        } else {
                            response.sendRedirect("ClientDashboardServlet");
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    String errorMessage = "Your username or password doesnot match, Please try again.";
                    HttpSession session = request.getSession();
                    session.setAttribute("loginErr", errorMessage);
                    response.sendRedirect("login.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
