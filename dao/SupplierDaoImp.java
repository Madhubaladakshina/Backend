package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.Model.Supplier;

@Repository("supplierdao")
@Transactional
public class SupplierDaoImp implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(Supplier supplier) {
		// TODO Auto-generated method stub
		 try
		  {
			  sessionFactory.getCurrentSession().save(supplier);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	}

	@Override
	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		  {
			  sessionFactory.getCurrentSession().delete(supplier);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
		
	}

	@Override
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		  {
			  sessionFactory.getCurrentSession().update(supplier);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	}

	@Override
	public List<Supplier> listsupplier() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
  		Query query=session.createQuery("from Supplier");
  		List<Supplier> supplier=query.list();
  		session.close();
  		return supplier;
	}

	@Override
	public Supplier getSupplier(int SupplierId) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,SupplierId );
		session.close();
		return supplier;
	}
	
}
