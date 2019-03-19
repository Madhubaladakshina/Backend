package com.ecomm.dao;

import java.util.List;

import com.ecomm.Model.Product;

public interface ProductDAO {
	
	public boolean addproduct(Product product);
	public boolean deleteproduct(Product product);
	public boolean updateproduct(Product product);
	public Product getProduct(int productId);
	public List<Product>ListProduct();
	public List<Product>listProductByCategory(int categoryId); 
	
	

}
