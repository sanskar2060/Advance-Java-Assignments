package com.pojoPoji;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class CartDaoImpl implements CartInterface {
	
	ArrayList<Product> cart ;
	
	Connection dbConnection ;
	PreparedStatement pstInsert ;
	PreparedStatement getCart ;
	public CartDaoImpl() throws FileNotFoundException, IOException, SQLException{
		super();
		Properties props = new Properties();
		
		props.load(new FileInputStream("C:\\Users\\dac\\Desktop\\batch2\\Advance Java Batch2\\Assignment\\sastaAmazonVersion2\\application.properties"));
		
		this.dbConnection = DriverManager.getConnection(props.getProperty("dbUrl"),props.getProperty("dbUser"),props.getProperty("dbPassword"));
		this.pstInsert = this.dbConnection.prepareStatement("insert into cart values(? , ? , ? , ?)") ;
		this.getCart = this.dbConnection.prepareStatement("select * from cart where uid = ?");
	}
	@Override
	public void addProduct(Product p, String username) throws SQLException {
		
		pstInsert.setInt(1, p.getId());
		pstInsert.setString(2, username);
		pstInsert.setString(3, p.getProductName());
		pstInsert.setDouble(4, p.getPrice());
		pstInsert.executeUpdate();
		
	}
	@Override
	public Iterator<Product> showCart(String username) throws SQLException {
		
		  getCart.setString(1, username);
		  ResultSet rs = getCart.executeQuery();
		  
		  while(rs.next()) {
			  
			  List<Cart> cart = new ArrayList<>();
			  
			  cart.add(new Cart(rs.getInt( "id"), rs.getString("username"), rs.getInt("uid"), rs.getString("productName") , rs.getDouble("price")));
			  
		  }
		  
		  
		return cart.iterator();
	}
	
	

}
