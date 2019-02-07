package com.olx.daointerfaces;

import java.util.List;
import com.olx.models.*;

public interface SubCategoryDao {
	List<Subcategory> getSubCategories(int categoryId);
}
