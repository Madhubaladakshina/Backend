package com.ecomm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.Model.UserDetail;
@Repository
@Transactional

public class UserDAOImp implements UserDAO {

	@Autowired 
	SessionFactory sessionfactory ;
	@Override
	public boolean registerUser(UserDetail userdetail) {
		// TODO Auto-generated method stub
		try
		{
			sessionfactory.getCurrentSession().save(userdetail);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateuser(UserDetail userdetail) {
		// TODO Auto-generated method stub

		  try
		  {
			  sessionfactory.getCurrentSession().update(userdetail);
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;  
		  }
	}



	@Override
	public UserDetail getuser(String username) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		UserDetail user=session.get(UserDetail.class, username);
		session.close();
		return user;
	}
	

}
