/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.AdminReportDao;
import com.mycompany.usermanagement.model.AdminReport;
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


/**
 *
 * @author sasmi
 */
@WebServlet(name = "AdminReportServlet", urlPatterns = {"/AdminReportServlet"})
public class AdminReportServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        AdminReportDao obj = new AdminReportDao();

        ArrayList<AdminReport> al=null;
     try {
         al = obj.getCreatedUser();
         
     } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(AdminReportServlet.class.getName()).log(Level.SEVERE, null, ex);
     }

        request.setAttribute("AdminReport", al);
        RequestDispatcher rd
                = request.getRequestDispatcher("adminreport.jsp");
        rd.forward(request, response);
        
        

    }

}
