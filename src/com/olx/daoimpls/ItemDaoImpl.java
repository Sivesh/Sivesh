package com.olx.daoimpls;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.olx.daointerfaces.ItemDao;
import com.olx.models.Item;
import com.olx.models.Subcategory;
import com.olx.models.User;
import com.olx.utilities.ConnectionFactory;

public class ItemDaoImpl implements ItemDao{

	@Override
	public List<Item> getAvailableItems() {
		Connection conn=null;
		//PreparedStatement ps=null;
		List<Item>itemsList=new ArrayList<Item>();
		try{
			conn=ConnectionFactory.getConnection();
			String sql="select * from item where sold=0";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String description=rs.getString("description");
				float minPrice=rs.getFloat("min_price");
				float maxPrice=rs.getFloat("max_price");
				int sold=rs.getInt("sold");
				User user=new User();
				user.setUser_id(rs.getInt("posted_by"));
				Subcategory sub=new Subcategory();
				sub.setId(rs.getInt("subcategory_id"));
				
				Item item=new Item();
				item.setId(id);
				item.setName(name);
				item.setDescription(description);
				item.setMinPrice(minPrice);
				item.setMaxPrice(maxPrice);
				item.setSold(sold);
				item.setPostedBy(user);
				item.setSubcategory(sub);
				
				item.setItemImages(getItemImages(id));
				
				itemsList.add(item);
				//ps.close();
				//conn.close();
				//rs.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return itemsList;
	}
	
	public static List<String> getItemImages(int itemId){
		List<String>imageList=new ArrayList<String>();
		Connection conn=null;
		PreparedStatement ps=null;
		
		try{
			conn=ConnectionFactory.getConnection();
			String sql="select image from item_image where item_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				String imagepath=rs.getString("image");
				imageList.add(imagepath);
			}
		}catch(SQLException e){
			
		}
		
		return imageList;
			
		
		
	}

	@Override
	public List<Item> getItemsForSubCategory(int subcategoryId) {
List<Item> subcategoryItems = new ArrayList<Item>();
        
 		try{
		Connection conn = ConnectionFactory.getConnection();
		String sql =  "select * from item where subcategory_id=? and sold=0";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, subcategoryId);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
		
			Item item = new Item();
			User user = new User();
			Subcategory subcategory = new Subcategory();
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			float minprice = rs.getFloat("min_price");
			float maxprice = rs.getFloat("max_price");
			user.setUser_id(rs.getInt("posted_by"));;
			subcategory.setId(rs.getInt("subcategory_id"));
			int sold = rs.getInt("sold");
			
			
			
			
			item.setId(id);
			item.setDescription(description);
			item.setMaxPrice(maxprice);
			item.setMinPrice(minprice);
			item.setSold(sold);
			item.setName(name);
			item.setSubcategory(subcategory);
			item.setPostedBy(user);
			
			item.setItemImages(getItemImages(id));;
			
			subcategoryItems.add(item);
			
		}
		
		
		}	
          catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return subcategoryItems;
	}

	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Item item=null;
		try{
			conn = ConnectionFactory.getConnection();
			String sql =  "select * from item where sold=0 and id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user=new User();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float minprice = rs.getFloat("min_price");
				float maxprice = rs.getFloat("max_price");
				user.setUser_id(rs.getInt("posted_by"));
				
				item=new Item();
				
				item.setId(id);
				item.setName(name);
				item.setDescription(description);
				item.setMaxPrice(maxprice);
				item.setMinPrice(minprice);
				item.setPostedBy(user);
				
				item.setItemImages(getItemImages(id));;
				
			}
			ps.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println(item.getName());
			return item;
		
	}

	
	
	
	
	}

	
