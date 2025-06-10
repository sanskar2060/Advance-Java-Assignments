package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import com.pojoPoji.Product;
import com.pojoPoji.ProductDaoImpl;

/**
 * Servlet implementation class Products
 */
@WebServlet("/products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductDaoImpl products = new ProductDaoImpl();
			PrintWriter out = response.getWriter();
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			 Iterator<Product> productsList =  products.listAllProduct(cid);
			 out.print("<html>"
						+ "    <head>"
						+ "        Products"
						+ "    </head>"
						+ "    <body>"
						+ "        <table border='1'>"
						+ "            <tr> "
						+ "                <th>id</th>"
						+ "                <th>Product name</th>"
						+ "                <th>Description</th>"
						+ "                <th>cid</th>"
						+ "					<th> price </th>"
						+ "					<th>Add to cart </th>"
						+ "            </tr>");
			 while(productsList.hasNext()) {
				 Product temp = productsList.next();
				 out.print("<tr>"
							+ "<td>"+ temp.getId() +"</td>"
							+ "<td>"+temp.getProductName()+"</td>"
							+ "<td>"+temp.getDescription()+"</td>"
							+ "<td>"+temp.getCid()+"</td>"
									+ "<td>" +temp.getPrice()+ "</td>"
							+ "<td><a href='/sastaAmazonVersion2/cart'>Add to cart </a></td>"
							+ "</tr>");
			 }
			 
			 out.print("</table>"
						+ "</body>"
						+ "</html>");
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
