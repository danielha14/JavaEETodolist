
<%
 
	String userId =   (String) session.getAttribute("userId");
	session.setAttribute("userId", userId);
%>
</div>
<form action="addItem">
	title : <input type="text" name="title"> description : <input
		type="text" name="description">
	<button class="btn btn-large btn-primary" type="submit">AddNewItem</button>
	</div>
</form>