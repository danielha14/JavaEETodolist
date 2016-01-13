package com.project.todolist.servies;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.List;
import com.project.todolist.model.HibernateToDoListDAO;
import com.project.todolist.model.ToDoItem;
import com.project.todolist.model.TodoListPlatformException;

import javax.ws.rs.Path;

@Path("/helloworld")
public class HelloWorld {

	
		@GET
		@Produces("text/plain")
		public String getClichedMessage(HibernateToDoListDAO model) {
//			 try {
//				List<ToDoItem> items = (List<ToDoItem>)model.getItems();
//				int i = 0;
//				for(ToDoItem item : items) {
//				    String result= "<tr>"+ 
//				    "<td>"+i+++"</td>"+
//					"<td>"+item.getTitle()+"</td>"+
//					"<td>"+item.getDescription()+"</td>"+
//					"</tr>";	
//					}
//			} catch (TodoListPlatformException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return "Hello World";
	}
}