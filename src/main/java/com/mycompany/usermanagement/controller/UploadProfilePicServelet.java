/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermanagement.controller;

import com.mycompany.usermanagement.dao.LoginDao;
import com.mycompany.usermanagement.dao.ProfileDao;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author sonam
 */
@WebServlet(name = "uploadImage", urlPatterns = {"/uploadImage"})
public class UploadProfilePicServelet extends HttpServlet {

    ProfileDao dao = new ProfileDao();
    LoginDao obj= new LoginDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

            List<FileItem> profilePic = sf.parseRequest(request);

            HttpSession session = request.getSession();
            String uname = (String) session.getAttribute("username");

            for (FileItem i : profilePic) {

                i.write(new File("C:/Users/sonam/Documents/NetBeansProjects/UserManagement/src/main/webapp/img/" + i.getName()));
                String path = i.getName();
                
                ProfileDao obj = new ProfileDao();
                obj.changeProfilePic(uname, path);
                System.out.println("Image Uploaded");
            }
            
            response.sendRedirect("getprofile");
            
            

        } catch (FileUploadException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UploadProfilePicServelet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UploadProfilePicServelet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
