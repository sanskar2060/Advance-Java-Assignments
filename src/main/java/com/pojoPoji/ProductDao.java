package com.pojoPoji;

import java.sql.SQLException;  
import java.util.Iterator;

 

public interface ProductDao {
	
	Iterator<Product> listAllProduct(int cid) throws SQLException  ;

}
