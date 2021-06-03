/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.ClientDashboardDao;
import java.io.IOException;
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
@WebServlet(name = "ClientDashboardServlet", urlPatterns = {"/ClientDashboardServlet"})
public class ClientDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClientDashboardDao obj = new ClientDashboardDao();
        int totalUser = obj.DisplayTables();
        request.setAttribute("totalUser",totalUser);
        int totalAdmin = obj.DisplayAdmins();
        
        int totalClient = obj.DisplayClients();
        
        int totalBlocked = obj.DisplayBlockeds();
        
        
        request.setAttribute("totalBlocked",totalBlocked);
        request.setAttribute("totalAdmin",totalAdmin);
        request.setAttribute("totalClient",totalClient);
        request.setAttribute("totalUser",totalUser);
        
        RequestDispatcher rd = request.getRequestDispatcher("clientDashboard.jsp");
        rd.forward(request, response);
        
    }

}
