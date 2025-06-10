package com.pojoPoji;

import java.sql.SQLException;
import java.util.Iterator;

public interface CartInterface {

	public void addProduct(Product p, String username) throws SQLException ;
	public Iterator<Product> showCart(String username) throws SQLException;
}
