<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>sign up</title>
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
        <h1 align="center">Sign In</h1>
    </div>

    <div class="row">
        <div class="col-md-4">
            <strong>Aj Response</strong>:
			<div id="ajaxGetUserServletResponse"></div>
	    </div>
        <div class="col-md-4">

            <form role="form" action = "controller" method ="post" class="form-horizontal sign-in-form">
                <h3>Please Signin...</h3>

                <div class="form-group col-sm-10">
                    <label for="email" class="sr-only">Email address</label>
                    <input type="email" id="email" class="form-control" name="email" placeholder="Email address" required autofocus>
                </div>
                <div class="form-group col-sm-10">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" class="form-control" name="password" placeholder="Password"  required>
                </div>
                <div class="form-group col-sm-10">
                    <button id="signinid" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </div>
            </form>
            
         
        </div>
    </div>

</div><!-- /container -->

</body>
</html>
