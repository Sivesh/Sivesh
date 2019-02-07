package com.olx.daoimpls;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

import com.olx.daointerfaces.CategoryDao;
import com.olx.models.Category;
import com.olx.models.Subcategory;
import com.olx.utilities.ConnectionFactory;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> getAvailableCategories() {
List<Category> categoryList = new ArrayList<Category>();
		
		try{
			Connection conn = ConnectionFactory.getConnection();
			String sql =  "select * from category where deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Category category = new Category();
				int id =rs.getInt("id");
				String name = rs.getString("name");
				String iconpath = rs.getString("icon_path");
				int deletd = rs.getInt("deleted");
				
				 
				List<Subcategory> subcategorylist = new SubCategoryDaoImpl().getSubCategories(id);
				
				category.setName(name);
				category.setImagepath(iconpath);
				category.setDeleted(deletd);
				category.setSubcategoryList(subcategorylist);
				
				categoryList.add(category);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return categoryList;
		
	}

}
