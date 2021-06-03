<%-- 
    Document   : clientDashboard
    Created on : May 22, 2020, 1:05:50 AM
    Author     : sonam
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <% 
            
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP  1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires","0"); //Proxies
            if(session.getAttribute("username")== null){
                response.sendRedirect("login.jsp");
            }
        %>
        
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
                    <h1 class="mt-4">Dashboard</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-primary text-white mb-4">


                                <div class="card-body">Total Users <% out.println(request.getAttribute("totalUser")); %></div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"a href="getdetails"></a>

                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-warning text-white mb-4">

                                <div class="card-body">Total Admin <% out.println(request.getAttribute("totalAdmin")); %></div>

                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"a href="getdetails"></a>

                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-success text-white mb-4">
                                <div class="card-body">Total Clients <% out.println(request.getAttribute("totalClient"));%></div>

                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"a href="getdetails"></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6">
                            <div class="card bg-danger text-white mb-4">
                                <div class="card-body">Total Blocked <% out.println(request.getAttribute("totalBlocked")); %></div>
                                <div class="card-footer d-flex align-items-center justify-content-between">
                                    <a class="small text-white stretched-link"a href="getdetails"></a>


                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Piechart-Start-->
                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

                    <script type="text/javascript">

                        google.charts.load('current', {'packages': ['corechart']});
                        google.charts.setOnLoadCallback(drawChart);

                        function drawChart() {

                            var data = google.visualization.arrayToDataTable([
                                ['User Type', 'Percent'],
                                ['Admin', <% out.println(request.getAttribute("totalAdmin")); %>],
                                ['Client', <% out.println(request.getAttribute("totalClient"));%>]

                            ]);

                            var options = {
                                title: 'Total Users'
                            };

                            var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                            chart.draw(data, options);
                        }
                    </script>
                    <div id="piechart" style="width: 900px; height: 500px; margin-left: auto; margin-right: auto; "></div>
                    <!-- Piechart-End-->

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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>
