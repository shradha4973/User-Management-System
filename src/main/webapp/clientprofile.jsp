<%-- 
    Document   : clientprofile
    Created on : May 22, 2020, 2:32:32 AM
    Author     : sonam
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.usermanagement.model.User"%>
<%@page import="com.mycompany.usermanagement.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Profile</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <style>
            .card-wrapper{
                display:flex;
                align-items: center;
                align-content: center;
                flex-direction: column;
            }

            .cardd{
                background-color: #ebeef8;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                margin: 2rem 0;
                box-shadow: .5rem, .5rem 3rem rgba(0,0,0,0.2);


            }

            .cardd .card-img{
                width: 100%;
                object-fit: cover;
            }

            .cardd .profile-img{
                height: 15rem;
                width: 15rem;
                border-radius: 50%;
                margin-left: auto;
                margin-right: auto;
                object-fit: cover;
                border-radius: 50%;
                margin-top: -10rem;
                z-index: 999;
                border:0.5rem solid #ebeef8;
            }

            .middle {
                transition: .5s ease;
                opacity: 0;
                position: absolute;
                margin-top: 5rem;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                text-align: center;
            }
            .covermiddle {
                transition: .5s ease;
                opacity: 0;

                margin-left: 32rem;
                margin-top: -2rem;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                text-align: center;
            }


            .profile:hover .middle {
                opacity: 1;
            }

            .cover:hover .covermiddle {
                opacity: 1;
            }

        </style>
    </head>
    <body>
        <%

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP  1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0"); //Proxies
            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <% ArrayList<User> profile
                                    = (ArrayList<User>) request.getAttribute("profile");

                            for (User p : profile) {%> 
        


        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="ClientDashboardServlet">User Management</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>

            <!-- Navbar-->
            <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <ul class="navbar-nav ml-auto ml-md-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                            <form action="logout">
                                <input class="dropdown-item" type="submit" name="logout" value="Logout">
                            </form>
                        </div>
                    </li>
                </ul>
            </div> 
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <a class="nav-link" href="ClientDashboardServlet">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <a class="nav-link" href="getprofile">
                                <div class="sb-nav-link-icon"><i class="fas fa-id-card"></i></div>
                                Profile
                            </a>
                            <a class="nav-link" href="getclienthistory">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                History
                            </a>


                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <% out.println(session.getAttribute("username")); %>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Profile</h1>

                        
                        <div class="card-wrapper">
                            <div class="cardd">
                                <div class="cover">

                                    <image src="img/<%out.println(p.getCover_pic());%>" height="400px" width="100%" class="card-img"/>
                                    <div class="covermiddle">
                                        <a class="btn btn-link" href="uploadClientCoverPic.jsp" target="_blank">Change Picture</a>
                                    </div>
                                </div>

                                <a class="btn btn-primary" href="editprofile" style=" margin-left: 80%; margin-top: 2% ">Edit Profile</a>
                                <div class="profile">
                                    
                                    <image src="img/<%out.println(p.getProfile_pic());%>"  class="profile-img" />
                                    <div class="middle">
                                        <a class="btn btn-link" href="uploadClientProfilePic.jsp" target="_blank">Change Picture</a>
                                    </div>
                                </div>



                                <b style="margin-left: auto; margin-right: auto"><% out.println(p.getFname() + " " + p.getLname()); %></b> <br>
                                <b style="margin-left: auto; margin-right: auto"><% out.println("@" + p.getUname()); %></b> <br>
                                <br>

                                <div class="info" style="margin-right: 45%">
                                    <h3>Info:</h3>
                                    <% out.println(p.getInfo()); %>
                                </div>    
                                <div class="details" style="margin-left:  45%; padding-bottom: 5rem; margin-top: -5rem;">
                                    <b>Address: </b><% out.println(p.getAddress()); %><br>
                                    <b>Contact: </b> <% out.println(p.getContact()); %><br>
                                    <b>Email: &nbsp;&nbsp;&nbsp;</b> <% out.println(p.getEmail()); %><br>
                                    <b>DOB: </b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<% out.println(p.getDob()); %><br>
                                </div>

                                <% }%>
                            </div>
                        </div>
                    </div>
                </main>

                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; User Management System by Chasers 2020</div>

                        </div>
                    </div>
                </footer>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>

    </body>
</html>


