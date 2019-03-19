package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.Model.Supplier;
import com.ecomm.dao.SupplierDao;

public class SupplierDaotest {

	 static SupplierDao supplierdao;

	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("org.pro");
	context.refresh();

	supplierdao=(SupplierDao)context.getBean("supplierdao");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
	Supplier supplier=new Supplier();
	supplier.setSupplierName("shakshi");
	supplier.setSupplierAddress("chennai");

	 assertTrue("problem in adding the supplier",supplierdao.add(supplier));
	}

	@Test
	public void UpdateSupplierTest()
	{
		Supplier supplier=supplierdao.getSupplier(40);
		supplier.setSupplierName("Cabriella");
		supplier.setSupplierAddress("simla");

		 assertTrue("problem in adding the category",supplierdao.update(supplier));

	}
	@Ignore
	@Test
	public void DeleteCategoryTest()
	{

		Supplier supplier=supplierdao.getSupplier(37);
		supplier.setSupplierName("Cabriella");
		supplier.setSupplierAddress("simla");

		 assertTrue("problem in adding the category",supplierdao.delete(supplier));

	}

		
	public void listCategoriesTest()
	{
		List<Supplier> listsupplier=supplierdao.listsupplier();
		assertTrue("problem in adding the category",listsupplier.size()>0);
		for(Supplier supplier:listsupplier)
		{
			System.out.println(listsupplier);
		}
		
	}
	
}
