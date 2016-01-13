<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="appjs.js"></script>
</head>

<body>

    <div class="container">
        <div class="jumbotron">
            <h1 align="center">Sign Up</h1>
        </div>

<!--  
<jsp:useBean id="user" scope="session" class="com.project.todolist.model.User"/>
<jsp:setProperty name="user" property="id" param="id"/>
<jsp:setProperty name="user" property="userName" param="userName"/>
<jsp:setProperty name="user" property="email" param="email"/>
<jsp:setProperty name="user" property="password" param="password"/>
<%//session.("user",user); %>
 -->
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form role="form" action="register" method="post" class="form-horizontal sign-up-form">
                    <h3>Please SignUp...</h3>
                    <div class="form-group col-sm-10">
                        <label for="first-name" class="sr-only">First Name</label>
                        <input type="text" id="first-name" class="form-control" name="userName" placeholder="First Name" required autofocus>
                    </div>
                    <div class="form-group col-sm-10">
                        <label for="last-name" class="sr-only">id</label>
                        <input type="number" id="last-name" class="form-control" placeholder="id" name = "id" required autofocus>
                    </div>
                    <div class="form-group col-sm-10">
                        <label for="email" class="sr-only">Email address</label>
                        <input type="email" id="email" class="form-control" name="email" placeholder="Email address" required autofocus>
                    </div>
                    <div class="form-group col-sm-10">
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" id="password" class="form-control" name="password" placeholder="Password"  required>
                    </div>
                    <div class="form-group col-sm-10">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
                    </div>
                </form>
            </div>
        </div>

    </div><!-- /container -->

</body>
</html>
