package com.project.todolist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.project.todolist.model.HibernateToDoListDAO;
import com.project.todolist.model.IToDoListDAO;
import com.project.todolist.model.ToDoItem;
import com.project.todolist.model.TodoListPlatformException;
import com.project.todolist.model.User;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

/**
 * Servlet implementation class ToDoListPlatformConroller 1
 */
@WebServlet("/controller/*")
public class ToDoListPlatformConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoListPlatformConroller() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter writer = response.getWriter();
		StringBuffer sb = request.getRequestURL();
		String url = sb.toString();
		RequestDispatcher dispatcher = null;
		if (url.endsWith("home"))
		{
			dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		} 
		else
			if (url.endsWith("login"))
			{
				dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
			else
				if (url.endsWith("toregister"))
				{
					dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
					dispatcher.forward(request, response);
				}
				else

					if (url.endsWith("addItem")) {
						HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
						List listOfUserItems = null;
						String title = request.getParameter("title");
						String description = request.getParameter("description");
						int userId = (int) request.getSession().getAttribute("userId");
						ToDoItem item = new ToDoItem(8, title, description, userId);

						try {
							model.addItem(item);
							listOfUserItems = model.getUserItems(userId);
							request.getSession().setAttribute("listOfUserItems", listOfUserItems);
							request.getSession().setAttribute("userId", userId);
							dispatcher = getServletContext().getRequestDispatcher("/userItems.jsp");
							dispatcher.forward(request, response);
						}
						catch (TodoListPlatformException e) 
						{
							dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
							dispatcher.forward(request, response);
						}

					} 
					else
						if (url.endsWith("signin")) {
							HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
							String userEmail = request.getParameter("email");
							String userPassword = request.getParameter("password");

							try {
								boolean result = model.authenticateUser(userEmail, userPassword);
								if (result) {
									User user = model.getUserByEmail(userEmail);
									Cookie cookie = new Cookie("userName", user.getUserName());
									cookie.setMaxAge(1000);
									response.addCookie(cookie);		
									request.getSession().setAttribute("email", userEmail);
									dispatcher = getServletContext().getRequestDispatcher("/welcom.jsp");
									dispatcher.forward(request, response);
								} 
								else 
								{

									response.sendRedirect("home.jsp");
									response.getWriter().println("your password or id not right");
								}
							}
							catch (TodoListPlatformException e) 
							{
								dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
								dispatcher.forward(request, response);
							}
						}
						else
							if(url.endsWith("useritems"))
							{
						    HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
							String userEmail = (String)request.getSession().getAttribute("email");
							List listOfUserItems = null;
							
							try {
									User user = model.getUserByEmail(userEmail);	
									listOfUserItems = model.getUserItems(user.getId());
									request.getSession().setAttribute("listOfUserItems", listOfUserItems);
									request.getSession().setAttribute("user", user);
									dispatcher = getServletContext().getRequestDispatcher("/userItems.jsp");
									dispatcher.forward(request, response);
							}
							catch (TodoListPlatformException e) 
							{
								dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
								dispatcher.forward(request, response);
							}
							}
							else
							if (url.endsWith("UpdateItem"))
							{
								HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
								List listOfUserItems = null;
								String title = request.getParameter("title");
								String description = request.getParameter("description");
								int userId = (int) request.getSession().getAttribute("userId");	
								int itemid = Integer.parseInt((String)request.getSession().getAttribute("itemId"));
								ToDoItem newItem = new ToDoItem(itemid, title, description, userId);
								try 
								{
									model.updateItem(newItem);
									listOfUserItems = model.getUserItems(userId);
									request.getSession().setAttribute("listOfUserItems", listOfUserItems);
									request.getSession().setAttribute("userId", userId);
									dispatcher = getServletContext().getRequestDispatcher("/userItems.jsp");
									dispatcher.forward(request, response);

								}
								catch (TodoListPlatformException e) 
								{
									dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
									dispatcher.forward(request, response);			}


							}
							else 
								if (url.endsWith("delete")) 
								{
									HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
									List listOfUserItems = null;
									int userId = (int) request.getSession().getAttribute("userId");
									int itemId = Integer.parseInt((String)request.getParameter("itemToDelete"));

									try 
									{
										ToDoItem item = model.getItemById(itemId);
										model.deleteItem(item);
										listOfUserItems = model.getUserItems(userId);
										request.getSession().setAttribute("listOfUserItems", listOfUserItems);
										request.getSession().setAttribute("userId", userId);
										dispatcher = getServletContext().getRequestDispatcher("/userItems.jsp");
										dispatcher.forward(request, response);
									}
									catch (TodoListPlatformException e) {

										dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
										dispatcher.forward(request, response);
									}

								}
								else
									if (url.endsWith("register"))
									{
										HibernateToDoListDAO model = HibernateToDoListDAO.getInstance();
										String userName = request.getParameter("userName");
										String userId = request.getParameter("id");
										String userEmail = request.getParameter("email");
										String userPassword = request.getParameter("password");
										User user = new User(Integer.parseInt(userId),userName,userEmail,userPassword);
										

										try 
										{
											model.addUser(user);
											dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
											dispatcher.forward(request, response);

										}
										catch (TodoListPlatformException e) {
											dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
											dispatcher.forward(request, response);
										}
									}
									else
										if (url.endsWith("Item"))
										{
											dispatcher = getServletContext().getRequestDispatcher("/AddNewItem.jsp");
											dispatcher.forward(request, response);

										}
										else 
											if (url.endsWith("toUpdate"))
											{
												dispatcher = getServletContext().getRequestDispatcher("/EditItem.jsp");
												dispatcher.forward(request, response);

											}
											else
											{
												dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
												dispatcher.forward(request, response);
											}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
