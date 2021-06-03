<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
                  crossorigin="anonymous">
        </head>
<body>
    <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${user == null}">
                                  <div class="card-header"><h3 class="text-center font-weight-light my-4">Add New User</h3></div>
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.user_id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Full Name</label> <input type="text" value="<c:out value='${user.fname}' />" class="form-control" name="fname" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Username</label> <input type="text" value="<c:out value='${user.uname}' />" class="form-control" name="uname">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="text" value="<c:out value='${user.pass}' />" class="form-control" name="pass">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>User Email</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Contact</label> <input type="text" value="<c:out value='${user.contact}' />" class="form-control" name="contact">
                        </fieldset>

                        <fieldset class="form-group">
                             <label class="small mb-1" for="inputDOB">DOB</label><input class="form-control py-4" id="inputDOB" type="date" value="<c:out value='${user.dob}' />" name="dob" />
                        </fieldset>
                         <fieldset class="form-group">
                            <label>User Address</label> <input type="text" value="<c:out value='${user.address}' />" class="form-control" name="address" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>User Gender</label> 
                        </fieldset>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputDOB">Gender</label>
                                                <select class="form-control" id="inputGender" value="<c:out value='${user.gender}' />" name="gender"/>
                                                    <option value="male">Male</option>
                                                    <option value="female">Female</option>
                                                    <option value="others">Others</option>
                                                </select>
                                            </div>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
                     
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
  
        </body>
        </html>
        
