package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.Product;
import com.ecomm.dao.ProductDAO;



public class ProductDaoTest {
	static ProductDAO productDAO;
	@BeforeClass
	public static void intialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("ProductDAO");
	}
	@Ignore
	@Test
	public void addproducttest()
	{
		Product product=new Product();
		product.setProductName("SAMSUNG");
		product.setProductDesc("The mobile with 4G specification");
		product.setStock(20);
		product.setPrice(12000);
		product.setCategoryId(1);
		product.setSupplierId(6);
		assertTrue("problem in adding the product",productDAO.addproduct(product));
		
		
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(6);
		assertTrue("problem is deleting the product ",productDAO.deleteproduct(product));
		
	}
	@Ignore
	@Test
	public void UpdateProductTest()
	{
		Product product=productDAO.getProduct(7);
		product.setPrice(11000);
		product.setStock(15);
		assertTrue("problem in updating the product ",productDAO.updateproduct(product));
	}
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.ListProduct();
		assertTrue("Problem in retriving the product ",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
			System.out.println(product.getStock());
			System.out.println(product.getStock());
			System.out.println(product.getPrice());
		}
			
	}

}