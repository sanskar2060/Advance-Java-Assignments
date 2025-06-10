package com.pojoPoji;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class CategoryDaoImpl implements CategoryDao{
	
	PreparedStatement pst = null;
	Connection cn = null;
	PreparedStatement addCategory = null;
	
	public CategoryDaoImpl() {
		try {
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/advancejava", "root", "123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst = cn.prepareStatement("select * from categories");
			addCategory = cn.prepareStatement("insert into categories values(? , ? , ? , ?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Iterator<Category> getAllCategories() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = pst.executeQuery();
		ArrayList<Category> categories = new ArrayList<>();
		while(rs.next()) {
			categories.add(
					new Category(rs.getInt("id"),rs.getString("categoryname"), rs.getString("description"),rs.getString("imageUrl")));			
		}
		return categories.iterator();
	}
	@Override
	public void addCategory(Category category) throws SQLException {
		
		addCategory.setInt(1, category.getId());
		addCategory.setString(2, category.getCategoryNAme());
		addCategory.setString(3, category.getDescription());
		addCategory.setString(4, category.getImageUrl());
		
		addCategory.executeUpdate();
		
	}

}