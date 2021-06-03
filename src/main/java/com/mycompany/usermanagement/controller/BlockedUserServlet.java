/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.UserListDao;
import com.mycompany.usermanagement.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sonam
 */
@WebServlet(name = "BlockedUserServlet", urlPatterns = {"/BlockedUserServlet"})
public class BlockedUserServlet extends HttpServlet {
    UserListDao userDao = new UserListDao();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<User> listUser = userDao.listBlockUser();
            
            request.setAttribute("listBlockUser", listUser);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("listBlockUser.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BlockedUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
