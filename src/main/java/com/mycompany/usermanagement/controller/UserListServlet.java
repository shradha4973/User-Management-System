/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.model.User;
import com.mycompany.usermanagement.dao.UserListDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yawan
 */
public class UserListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserListDao userDao;

    @Override
    public void init() {
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        userDao = new UserListDao();
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action[] = request.getRequestURI().split("/");
        try {
            switch (action.length) {
                case 3:
                    listUser(request, response);
                    break;
                case 4:
                    switch (action[3]) {
                        case "new":
                            showNewForm(request, response);
                            break;
                        case "insert":
                            insertUser(request, response);
                            break;
                        case "delete":
                            deleteUser(request, response);
                            break;
                        case "edit":
                            showEditForm(request, response);
                            break;
                        case "update":
                            updateUser(request, response);
                            break;
                        case "block":
                            blockUser(request, response);
                            break;
                        case "unblock":
                            unblock(request, response);
                            break;
                       
                    }
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> listUser = userDao.listAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUserForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUserForm.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        long contact = Long.parseLong(request.getParameter("contact"));
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        int userType = Integer.parseInt(request.getParameter("userType"));
        
        User newUser = new User(fname, lname, uname, pass, email, contact, dob, address, gender, userType);
        userDao.insertUser(newUser);
        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int User_id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String pword = request.getParameter("pass");
        String email = request.getParameter("email");
        long contact = Long.parseLong(request.getParameter("contact"));
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        int userType=Integer.parseInt(request.getParameter("userType"));
        System.out.println(User_id);

        User user = new User(fname, lname, uname, pword, email, contact, dob, address, gender, userType);
        System.out.println(userDao.updateUser(user));
        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int User_id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("username");
        User user = new User(User_id);
        userDao.deleteUser(user, uname);
        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }
    
    
    private void blockUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int User_id = Integer.parseInt(request.getParameter("id"));
        User user = new User(User_id);
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("username");
        userDao.blockUser(user, uname);
        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }
    public void unblock(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int User_id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("username");
        User user = new User(User_id);
        boolean result = userDao.unblock(user, uname);
        if(result){
            response.sendRedirect(request.getContextPath()+"/UserListServlet");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/BlockedUserServlet");
        }
        
    }
    

}
