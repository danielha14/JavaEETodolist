<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
	import="java.util.*,com.project.todolist.model.*"
	pageEncoding="windows-1255"%>
<%
	int userId = (int) session.getAttribute("userId");
	session.setAttribute("userId", userId);
	String item = request.getParameter("submit_id");
	session.setAttribute("itemId",item );
%>
</div>
<form action="UpdateItem" method="post">
	title : <input type="text" placeholder="enter new title" name="title"> description : 
	<input type="text" placeholder="enter new description" name="description">
	<button class="btn btn-large btn-primary" type="submit">Update</button>
	</div>
</form>