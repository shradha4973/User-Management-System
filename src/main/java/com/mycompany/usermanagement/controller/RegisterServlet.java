
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.RegisterDao;
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
 * @author sonam
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    RegisterDao dao = new RegisterDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String strcontact = request.getParameter("contact");
        long contact = Long.parseLong(strcontact);
        String address = request.getParameter("address");
        String pword = request.getParameter("pword");
        String pwordconf = request.getParameter("pwordconf");
        java.util.Date date = new java.util.Date();

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd");

        String dob = sdf.format(date);
        String gender = request.getParameter("gender");
        HttpSession regSession = request.getSession();
        
        User user = new User();

        user.setFname(fname);
        user.setLname(lname);
        user.setUname(uname);
        user.setEmail(email);
        user.setContact(contact);
        user.setAddress(address);
        user.setPword(pword);
        user.setPwordconf(pwordconf);
        user.setDob(dob);
        user.setGender(gender);
        System.out.println(user.getAddress());

        boolean responseult = dao.insert(user);
        if (responseult) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("ClientDashboardServlet");
        } 
        else {
            String errorMessage = "Check your credentials and try again";
            regSession.setAttribute("RegErr", errorMessage);
            response.sendRedirect("register.jsp");

        }
    }
}
