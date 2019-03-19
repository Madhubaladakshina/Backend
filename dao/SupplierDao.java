package com.ecomm.dao;

import java.util.List;

import com.ecomm.Model.Supplier;

public interface SupplierDao {
	public boolean add(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean update(Supplier supplier);
	
	public List<Supplier> listsupplier();
	Supplier getSupplier(int SupplierId);


}
