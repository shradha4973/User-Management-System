<%-- 
    Document   : forgotpassword
    Created on : May 17, 2020, 12:25:43 PM
    Author     : sasmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Forgot Password</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Forgot Password</h3></div>
                                    <div class="card-body">

                                        <form action="ForgotPasswordServlet" method="post">

                                            <div class="form-group">
                                                <label class="small mb-1" for="inputUsername">Email</label>
                                                <input class="form-control py-4" id="inputUsername" type="email" placeholder="Enter email" name="email"/>
                                            </div>

                                            <!--                                                <input type="submit" value="NEXT">-->
                                            <!--                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"><a class="small" href="changepassword.html"></a>-->


                                            <input type="submit" class="btn btn-primary" value="Reset" >
                                            
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="changepassword.jsp"></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
