package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.UserDetail;
import com.ecomm.dao.UserDAO;

public class UserDAOTest {

	static UserDAO userdao;
	public static void intialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userdao=(UserDAO)context.getBean("UserDao");
		
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("Chandru");
		user.setPassword("12345");
		user.setCustomerName("Siva");
		user.setEnable("true");
		user.setAddress("Chennai");
		user.setRole("Role-User");
		assertTrue("problem in adding the user",userdao.registerUser(user));
		
		
	}
	@Test
	public void UpdateUserTest()
	{
		UserDetail user=userdao.getuser("Madhu");
		user.setPassword("123");
		assertTrue("problem in updating the user ",userdao.updateuser(user));
	}
	
	

}
