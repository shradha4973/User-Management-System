<%-- 
    Document   : profile
    Created on : May 15, 2020, 4:37:29 PM
    Author     : sonam
--%>

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

        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="getdetails">User Management</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
<!--            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" value="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form>-->
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
                            <a class="nav-link" href="getdetails">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <a class="nav-link" href="getprofile">
                                <div class="sb-nav-link-icon"><i class="fas fa-id-card"></i></div>
                                Profile
                            </a>
                            <a class="nav-link" href="UserListServlet">
                                <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                                Users
                            </a>
                            <a class="nav-link" href="getadminhistory">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                History
                            </a>
                            <a class="nav-link" href="AdminReportServlet">
                                <div class="sb-nav-link-icon"><i class="fas fa-file-word"></i></div>
                                Report
                            </a>

                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <% out.println(session.getAttribute("username"));%>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Profile > Edit Profile</h1>

                        <div class="card mb-4" style="padding: 2rem;">
                            <form action="editprofile" method="post">
                                <% ArrayList<User> profile
                                            = (ArrayList<User>) request.getAttribute("profile");

                                    for (User p : profile) {%> 
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group"><label class="small mb-1" for="inputFirstName">First Name</label><input class="form-control py-4" id="inputFirstName" type="text" value="<% out.println(p.getFname()); %>" name="fname"/></div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group"><label class="small mb-1" for="inputLastName">Last Name</label><input class="form-control py-4" id="inputLastName" type="text" value="<% out.println(p.getLname()); %>" name="lname"/></div>
                                    </div>
                                </div>
                                <div class="form-group"><label class="small mb-1" for="inputUsername">Username</label><input class="form-control py-4" id="inputUsername" type="text"  value="<% out.println(p.getUname()); %>" name="uname"/></div>
                                <div class="form-group"><label class="small mb-1" for="inputEmailAddress">Email</label><input class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" value="<% out.println(p.getEmail()); %>" name="email" /></div>
                                <div class="form-group"><label class="small mb-1" for="inputContact">Contact</label><input class="form-control py-4" id="inputContact" type="text" value="<% out.println(p.getContact()); %>" name="contact"/></div>
                                <div class="form-group"><label class="small mb-1" for="inputAddress">Address</label><input class="form-control py-4" id="inputAddress" type="text" value="<% out.println(p.getAddress()); %>" name="address"/></div>
                                <div class="form-group"><label class="small mb-1" for="inputDOB">DOB</label><input class="form-control py-4" id="inputDOB" type="date" name="dob" value="<% out.println(p.getDob()); %>"/></div>
                                <div class="form-group">
                                    <label class="small mb-1" for="inputDOB">Gender</label>
                                    <select class="form-control" id="inputGender" name="gender"/>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    <option value="others">Others</option>
                                    </select>
                                </div>
                                <div class="form-group"><label class="small mb-1" for="inputInfo">Info</label><input class="form-control py-4" id="inputInfo" type="text" value="<% out.println(p.getInfo()); %>" name="info"/></div>
                                <div class="form-group mt-4 mb-0"><input type="submit" class="btn btn-primary btn-block" value="Update"></div>
                                    <% }%>
                            </form>
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

