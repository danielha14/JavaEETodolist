<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
	import="java.util.*,com.project.todolist.model.*"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="bootstrap/js/appjs.js‬"></script>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		session.setAttribute("userId", user.getId());
	%>

	<div class="container">
		<div class="jumbotron">
			<h1>
				<%
					out.println(user.getUserName());
				%>
				List of tasks
			</h1>

		</div>

		<div class="row">
			<div class="col-sm-4">
				<h3>ToDoItem Title</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>

			</div>
			<div class="col-sm-4">
				<h3>Description</h3>
				<p>Lorem ipsum dolor sit amet...</p>

			</div>
			<form action="Item">
				<button class="btn btn-large btn-primary" type="submit">AddNewItem</button>


			</form>

		</div>
	</div>
	<!-- /row 1 -->

	<div class="panel-group" id="accordion">
		<%
			List<ToDoItem> items = (ArrayList<ToDoItem>) session.getAttribute("listOfUserItems");
			int i = 1;
			for (ToDoItem item : items) {
		%>
		<div class="panel panel-default template">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse<%out.print(i);%>"> <%
							out.println(item.getTitle());
						%>
					</a>
				</h4>
			</div>
			<%
				out.println("<div id=" + '"' + "collapse" + i + '"' + "class=" + '"' + "panel-collapse collapse" + '"'
							+ " >");
					out.println("<div class=" + '"' + "panel-body" + '"' + ">Title : " + item.getTitle().toString() + "</div>");
					out.println("<div class=" + '"' + "panel-body" + '"' + ">Description :"
							+ item.getDescription().toString() + "</div>");
					out.println("<div class=" + '"' + "panel-footer" + '"' + ">");
					i++;
			%>
			<form action="delete" method="post">
				<input type="hidden" name="itemToDelete"
					value="<%out.print(item.getId());%>">
				<button class="btn btn-danger" type="submit">delete</button>
			</form>

			<form action="toUpdate">
				<button class="btn btn-large btn-primary" type="submit">Update</button>
				<input type="hidden" name="submit_id"
					value='<%out.print(item.getId());%>' />
			</form>

		</div>
	</div>

	<%
		}
	%>


</body>
</html>
