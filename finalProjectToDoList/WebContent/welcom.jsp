<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>welcome</title>
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
        <h1>
            ToDo List
            <span class="glyphicon glyphicon-leaf"></span>
        </h1>
    <%
    String str="Guest";
    Cookie[] cookies = request.getCookies(	);
	if(cookies!=null){
		for (Cookie cooki : cookies) {
			if(cooki.getName().equals("userName")){
				str = cooki.getValue();
				break;
			}
		}
	}
    
	String userName = (String)request.getAttribute("name");	
	out.println("<p> Welcome "+"<span  style='color:blue'>"+str+"</span > </p>");		
	%>
    </div><!--jumbotron-->
        <div class="page-header">
            <div class="row">
                <div class="col-md-2">
                    <a href="#" class="btn btn-primary" role="button">
                        <span class="glyphicon glyphicon-home"></span>
                        Home
                    </a>
                </div>

                <div class="col-md-2">
                    <a href="useritems" class="btn btn-success" role="button">
                        <span class="glyphicon glyphicon-th-list"></span>
                        TodoList
                    </a>
                </div>

                <div class="col-md-2">
                <form action="controller/servies" method="post">
                    <a href="#" class="btn btn-info" type="submit" role="button">
                        <span class="glyphicon glyphicon-search"></span>
                        About
                    </a>
                 </form>
                </div>

                <div class="col-md-2">
                    <a href="#" class="btn btn-warning" role="button">
                        <span class="glyphicon glyphicon-envelope"></span>
                        Helep
                    </a>
                </div>
            </div><!--header row-->
        </div><!--header-->

    <h1>
        <span class="glyphicon glyphicon-leaf"></span>
        Hello ! welcome to youer TodoList App!
    </h1><!--welcome titel-->

    <div class="row">
        <div class="col-md-6">
            <h3>
                <span class="glyphicon glyphicon-leaf"></span>
                 TodoList App!
            </h3><!--welcome titel-->
            <p>
                HTML also defines special elements for defining text with a special meaning.
                HTML uses elements like and  for formatting output, like bold or italic text.
            </p>
        </div><!--left paragrph-->

        <div class="col-md-6">
            <h3>
                <span class="glyphicon glyphicon-leaf"></span>
                Title go here
            </h3><!--welcome titel-->
            <p>
                we can add content here.....
            </p>
        </div><!--right paragrph-->
    </div><!-- paragrph-->

</div><!--container-->

</body>
</html>