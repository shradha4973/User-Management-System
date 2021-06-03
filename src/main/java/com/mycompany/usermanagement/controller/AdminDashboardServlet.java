/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.AdminDashboardDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author simdo
 */
@WebServlet(name = "getdetails", urlPatterns = {"/getdetails"})
public class AdminDashboardServlet extends HttpServlet {

    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDashboardDao obj = new AdminDashboardDao();
        int totalUser = obj.DisplayTable();
        request.setAttribute("totalUser",totalUser);
        int totalAdmin = obj.DisplayAdmin();
        
        int totalClient = obj.DisplayClient();
        
        int totalBlocked = obj.DisplayBlocked();
        
        
        request.setAttribute("totalBlocked",totalBlocked);
        request.setAttribute("totalAdmin",totalAdmin);
        request.setAttribute("totalClient",totalClient);
        request.setAttribute("totalUser",totalUser);
        
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
        
    }
   
   
}

