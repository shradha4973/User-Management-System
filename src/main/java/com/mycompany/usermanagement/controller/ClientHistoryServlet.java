/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.HistoryDao;
import com.mycompany.usermanagement.model.History;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "getclienthistory", urlPatterns = {"/getclienthistory"})
public class ClientHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HistoryDao obj = new HistoryDao();
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("username");
        ArrayList<History> al = obj.getClientHistory(uname);

        request.setAttribute("history", al);
        RequestDispatcher rd
                = request.getRequestDispatcher("clientHistory.jsp");
        rd.forward(request, response);
        

    }

}
