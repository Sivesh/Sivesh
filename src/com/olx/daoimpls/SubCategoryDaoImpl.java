package com.olx.daoimpls;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.olx.daointerfaces.SubCategoryDao;
import com.olx.models.Item;
import com.olx.models.Subcategory;
import com.olx.utilities.ConnectionFactory;

public class SubCategoryDaoImpl implements SubCategoryDao{

	@Override
	public List<Subcategory> getSubCategories(int categoryId) {
List<Subcategory> subcategoryList = new ArrayList<Subcategory>();
		
		try{
			Connection conn = ConnectionFactory.getConnection();
			
			String sql =  "select * from subcategory where category_id=? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Subcategory subcategory = new Subcategory();
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String iconpath = rs.getString("icon_path");
				int deleted = rs.getInt("deleted");
				List<Item> itemList = new ItemDaoImpl().getItemsForSubCategory(id);
				
			    subcategory.setId(id);
				subcategory.setName(name);
				subcategory.setImagepath(iconpath);
				subcategory.setDeleted(deleted);
				subcategory.setItemsList(itemList);
				
				
				subcategoryList.add(subcategory);
				
			

				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return subcategoryList;
	}

}
