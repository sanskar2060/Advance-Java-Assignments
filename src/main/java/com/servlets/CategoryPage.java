package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import com.pojoPoji.Category;

import com.pojoPoji.CategoryDaoImpl;

/**
 * Servlet implementation class CategoryPage
 */
@WebServlet("/category")
public class CategoryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter out = response.getWriter();
		CategoryDaoImpl categories = new CategoryDaoImpl();
		
		
		
		out.print("<html>"
				+ "    <head>"
				+ "        Categories"
				+ "    </head>"
				+ "    <body>"
				+"Hello "+username
				+ "        <table border = '1'>"
				+ "            <tr> "
				+ "                <th>id</th>"
				+ "                <th>Category name</th>"
				+ "                <th>Description</th>"
				+ "                <th>Image url</th>"
				+ "            </tr>");
		
		try {
			Iterator<Category> iterator = categories.getAllCategories() ;
			while(iterator.hasNext()) {
				Category category = iterator.next();
				out.print("<tr>"
						+ "<td> <a href='/sastaAmazonVersion2/products?cid="+category.getId()+"'>" +category.getId()+ "</a> </td>" 
						+ "<td>"+category.getCategoryNAme()+"</td>"
						+ "<td>"+category.getDescription()+"</td>"
						+ "<td>"+category.getImageUrl()+"</td>"
						
						+ "</tr>");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.print("</table>"
				+ "</body>"
				+ "</html>");
				
				
		
		 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
