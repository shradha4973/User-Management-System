<%-- 
    Document   : aboutus.jsp
    Created on : May 2, 2020, 12:57:15 PM
    Author     : sonam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head> 
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>About Us</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

    </head>

    <body id="sb-nav-fixed">
        <!-- Navbar-->
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="aboutus.jsp">User Management</a>

            <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">
                            <i class="fas fa-sign-in-alt"></i>
                            Login
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="register.jsp">
                            <i class="fas fa-user-plus"></i>
                            Sign-up
                        </a>
                    </li>

                </ul>


            </div> 
        </nav>

        <!--Header-->
        <header class="bg-primary text-white" style="padding: 5%;">
            <div class="container text-center" >
                <h1>Welcome to User Management System!</h1>
                <p class="lead">A complete solution for hassle-free User Management</p>
            </div>
        </header>
        <div class="cover">

            <image src="img/aboutus.jpg" style="width: 100%; object-fit: cover;"/>
            
        </div>
        <div class="container" style="padding: 5%;"> 
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <h2>About User Management System</h2>
                    <p class="lead">User Management System has been designed to manage different types of users. There are mainly three types of users in this system i.e. Admin, Client and Guest. They have the following features:</p>
                    <ul>
                        <li>Guests can only access the about us page and can register to be a client.</li>
                        <li>Clients can login to the system, view their profile, edit the profile and also view their history log.</li>
                        <li>Admin can login, view and edit profile and view both admin and clients history log. </li>
                        <li>Admin can also add new users, edit existing users and delete/block existing users.</li>
                        <li>Each and every users will have access to their dashboard.</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="py-5 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>Contact Us</h2>
                        <p class="lead">For technical difficulties, email us at: &nbsp&nbsp </p><i class="fas fa-envelope"></i> support@usermanagement.com <br><br>

                        <p class="lead">Keep In Touch</p>
                        <ul class="list-inline social-buttons">
                            <li class="list-inline-item">
                                <a href="https://www.instagram.com" target="_blank">
                                    <i class="fab fa-instagram" style="font-size: 50px;"></i>
                                </a>
                            </li>&nbsp&nbsp
                            <li class="list-inline-item">
                                <a href="https://www.facebook.com" target="_blank">
                                    <i class="fab fa-facebook-f" style="font-size: 50px;"></i>
                                </a>
                            </li>&nbsp&nbsp
                            <li class="list-inline-item">
                                <a href="https://www.twitter.com" target="_blank">
                                    <i class="fab fa-twitter" style="font-size: 50px;"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!--Foooter-->
        <footer class="py-4 bg-dark mt-auto">
            <div class="container-fluid">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; User Management System by Chasers 2020</div>

                </div>
            </div>
        </footer>
    </body>

</html>

