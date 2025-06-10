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
import java.util.*;
import java.util.Properties;

 



public class ProductDaoImpl implements ProductDao {
	
	Connection dbConnection  ;
	
	PreparedStatement psListAll ;
	public ProductDaoImpl() throws FileNotFoundException, IOException, SQLException {
		
		Properties props = new Properties();
		
		props.load(new FileInputStream("C:\\Users\\dac\\Desktop\\batch2\\Advance Java Batch2\\Assignment\\sastaAmazonVersion2\\application.properties"));
		System.out.println(props.getProperty("dbUrl"));
		dbConnection = DriverManager.getConnection(props.getProperty("dbUrl"), props.getProperty("dbUser"),props.getProperty("dbPassword"));
		
		psListAll = dbConnection.prepareStatement("Select * from Products where cid = ? ");
		
	}
	
	
	

	@Override
	public Iterator<Product> listAllProduct(int cid) throws SQLException {
		
		psListAll.setInt(1, cid);
		ResultSet rs = psListAll.executeQuery()	;
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			
		list.add(new Product(rs.getInt("id") , rs.getString("productname"),rs.getString("productDescription"),rs.getInt("cid") , rs.getDouble("price"))) ;
		
		
		}
		
		
		return  list.iterator() ;
	}

}
