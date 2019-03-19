package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.Model.Product;
@Repository("productDao")
@Transactional

public class ProductDAOImp implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addproduct(Product product) {
		// TODO Auto-generated method stub
		 try
		  {
			  sessionFactory.getCurrentSession().save(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	
	} 

	@Override
	public boolean deleteproduct(Product product) {
		// TODO Auto-generated method stub

		  try
		  {
			  sessionFactory.getCurrentSession().delete(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	
	}

	@Override
	public boolean updateproduct(Product product) {
		// TODO Auto-generated method stub
		try
		  {
			  sessionFactory.getCurrentSession().update(product);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	
	}

	@Override
	public List<Product> ListProduct() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
	
	}

	@Override
	public List<Product> listProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:categoryId");
		query.setParameter("categoryId",categoryId);
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
	
	}

}
