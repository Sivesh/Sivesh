package com.olx.daointerfaces;

import java.util.List;

import com.olx.models.Category;

public interface CategoryDao {
	List<Category> getAvailableCategories();
}
