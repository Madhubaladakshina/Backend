package com.ecomm.dao;

import java.util.List;

import com.ecomm.Model.Category;



public interface CategoryDAO {
public boolean addcategory(Category category);
public boolean deletecategory(Category category);
public boolean Updatecategory(Category category);
public List<Category>listcategories();
public Category getcategory(int category);

}
