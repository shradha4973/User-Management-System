/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.ForgotPasswordDao;
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
 * @author sasmi
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {
    
    ForgotPasswordDao dao = new ForgotPasswordDao();
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
      
        try {
            String email = req.getParameter("email");
            String userName = dao.getUserName(email);
            
//            System.out.println("Debugging name=" + userName);
            
            
            if(dao.check(email)){
                HttpSession session = req.getSession();
                session.setAttribute("username",userName);
                res.sendRedirect("changepassword.jsp");
            }
            else {
                
                res.sendRedirect("forgotpassword.jsp");
            } } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    

}
