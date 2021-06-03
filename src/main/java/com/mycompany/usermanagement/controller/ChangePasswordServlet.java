/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.ChangePasswordDao;
import com.mycompany.usermanagement.model.User;
import java.io.IOException;
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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

    ChangePasswordDao dao = new ChangePasswordDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        
//        String cpword = req.getParameter("cpword");
        HttpSession userSession = req.getSession(false);
        String uname = (String)userSession.getAttribute("username");
        
//        System.out.println("Debugging session=" + uname);
                
//        String uname = req.getParameter("uname");
        String npword = req.getParameter("npword");
        String pwordconf = req.getParameter("pwordconf");
        
        System.out.println("npword="+ npword);
        System.out.println("pwordconf=" + pwordconf);
        
        if (npword.equals(pwordconf)){
            
            User user = new User();

       
//        user.setPword(cpword);
            user.setUname(uname);
            user.setPword(npword);
            ChangePasswordDao obj = new ChangePasswordDao();
       
            boolean result = obj.insert(user);
     
            if (result) {
                HttpSession session = req.getSession();
    //            session.setAttribute("password", pword);
                res.sendRedirect("login.jsp");
            } else {
                String errorMessage = "Changing password was unsuccessful";
                HttpSession regSession = req.getSession();
                regSession.setAttribute("PassError", errorMessage);
                res.sendRedirect("forgotpassword.jsp");

            }


        }
        else{
            String errorMessage = "Password you entered in both field does not match each other";
            HttpSession regSession = req.getSession();
            regSession.setAttribute("PassError", errorMessage);
            res.sendRedirect("forgotpassword.jsp");
            System.out.println(errorMessage);
        }
//       

        

    }

}
