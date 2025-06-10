package com.pojoPoji;

import java.sql.SQLException; 
import java.util.Iterator;

public interface CategoryDao {
	
	public Iterator<Category> getAllCategories() throws SQLException;
	
	public void addCategory(Category category) throws SQLException ;

}
