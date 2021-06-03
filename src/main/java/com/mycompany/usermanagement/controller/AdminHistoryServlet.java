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

/**
 *
 * @author sonam
 */
@WebServlet(name = "getadminhistory", urlPatterns = {"/getadminhistory"})
public class AdminHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HistoryDao obj = new HistoryDao();

        ArrayList<History> al = obj.getHistory();

        request.setAttribute("history", al);
        RequestDispatcher rd
                = request.getRequestDispatcher("adminhistory.jsp");
        rd.forward(request, response);
        

    }

}
