package com.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection dbConnection;
	private PreparedStatement psAuthenticate;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String userName = request.getParameter("username");
		 
		 String password = request.getParameter("password");

		 try {
			psAuthenticate.setString(1,userName);
			psAuthenticate.setString(2, password);
			
			ResultSet rs = psAuthenticate.executeQuery()	;
			
			if(rs.next()) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("username", userName);
				
				session.setAttribute("username", userName);
				
				response.sendRedirect("/sastaAmazonVersion2/category");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		ServletContext application = getServletContext();

		String url = application.getInitParameter("dbUrl");

		String userName = application.getInitParameter("dbUser");

		String password = application.getInitParameter("dbPassword");

		String driverClassLoader = application.getInitParameter("driverClass");

		try {
			Class.forName(driverClassLoader);

			try {
				dbConnection = DriverManager.getConnection(url, userName, password);
				psAuthenticate = dbConnection
						.prepareStatement("select * from users where username = ? and password = ? ");
				
				application.setAttribute("dbGlobalConnection", dbConnection);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	

}
