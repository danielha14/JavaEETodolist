package com.project.todolist.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * The Class HibernateToDoListDAO.
 */
public class HibernateToDoListDAO implements IToDoListDAO, IToDoListUser {

	/** The factory. */
	private SessionFactory factory = null;

	/** The instance. */
	private static HibernateToDoListDAO instance = null;

	/**
	 * Constructor HibernateToDoListDAO.
	 */
	private HibernateToDoListDAO() {

		factory = new AnnotationConfiguration().configure().buildSessionFactory();

	}

	/**
	 * Gets the single instance of HibernateToDoListDAO.
	 *
	 * @return single instance of HibernateToDoListDAO
	 */
	public static HibernateToDoListDAO getInstance() {
		if (instance == null) {
			instance = new HibernateToDoListDAO();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abelski.samples.hibernate.IToDoListUser#addUser(com.abelski.samples.
	 * hibernate.User)
	 */
	@Override
	public void addUser(User user) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {

			session.beginTransaction();
			// if(!(session.get(user.getClass(),user.getEmail()) != null))
			// {
			session.save(user);
			session.getTransaction().commit();

			// }
			// else
			// .out.println("user "+user.getUserName() +" is exists");

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with addUser method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with addItem method");
				}

			}
		}
	}

	@Override
	public User getUserByEmail(String email) throws TodoListPlatformException {
		Session session = factory.openSession();
		User user = null;
		try {
			user = (User) session.get(User.class, 1);
			session.beginTransaction();
			if ((user != null)) {

				session.getTransaction().commit();
				// user =(User) session.get(User.class, email);
			}
			// else
			// System.out.println("user "+user.getUserName() +" is exists");

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with getUserById method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with getUserById  method");
				}

			}
		}
		return user;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abelski.samples.hibernate.IToDoListUser#deleteUser(com.abelski.
	 * samples.hibernate.User)
	 */
	@Override
	public boolean deleteUser(User user) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with deteteUser method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with deleteUser method");
				}

			}
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abelski.samples.hibernate.IToDoListUser#updateUser(com.abelski.
	 * samples.hibernate.User)
	 */
	@Override
	public void updateUser(User userToUpdate) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {

			session.beginTransaction();
			session.update(userToUpdate);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with updateUser method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with updateUser method");
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abelski.samples.hibernate.IToDoListDAO#addItem(com.abelski.samples.
	 * hibernate.ToDoItem)
	 */
	@Override
	public void addItem(ToDoItem itemFromUserToAdd) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {

			session.beginTransaction();
			session.save(itemFromUserToAdd);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with addItem method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with addItem method");
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abelski.samples.hibernate.IToDoListDAO#deleteItem(com.abelski.samples
	 * .hibernate.ToDoItem)
	 */
	@Override
	public boolean deleteItem(ToDoItem itemFromUserToDelete) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.delete(itemFromUserToDelete);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with deleteItem method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with deleteItem method");
				}

			}
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.abelski.samples.hibernate.IToDoListDAO#updateItem(com.abelski.samples
	 * .hibernate.ToDoItem)
	 */
	public void updateItem(ToDoItem itemFromUserToUpdate) throws TodoListPlatformException {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			session.update(itemFromUserToUpdate);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with updateItem method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with updateItem method");
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.abelski.samples.hibernate.IToDoListDAO#getItems()
	 */
	@SuppressWarnings("finally")
	@Override
	public List getItems() throws TodoListPlatformException {
		Session session = factory.openSession();
		List items = null;
		try {
			session.beginTransaction();
			items = session.createQuery("from ToDoItem").list();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with getItems method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with getItems method");
				}

			}
			return items;
		}

	}

	@Override
	public List<ToDoItem> getUserItems(int id) throws TodoListPlatformException {
		Session session = factory.openSession();
		List items = null;
		try {
			session.beginTransaction();
			items = session.createQuery("from ToDoItem where USERID=" + id).list();

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with getItems method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with getItems method");
				}

			}
			return items;
		}
	}

	public boolean authenticateUser(String userEmail, String password) throws TodoListPlatformException {
		User user = getUserByEmail(userEmail);
		if (user != null && user.getEmail().equals(userEmail) && user.getPassword().equals(password)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public ToDoItem getItemById(int itemId) throws TodoListPlatformException {
		Session session = factory.openSession();
		ToDoItem item = null;
		try {

			session.beginTransaction();
			if ((session.get(ToDoItem.class, itemId) != null)) {

				session.getTransaction().commit();
				item = (ToDoItem) session.get(ToDoItem.class, itemId);
			}
			// else
			// System.out.println("user "+user.getUserName() +" is exists");

		} catch (HibernateException e) {
			if (session.getTransaction() != null) {

				session.getTransaction().rollback();
				throw new TodoListPlatformException("error with getUserById method");
			}

		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
					throw new TodoListPlatformException("error with getUserById  method");
				}

			}
		}
		return item;

	}

}
