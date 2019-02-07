package com.olx.services;

import java.sql.*;
import java.util.List;

import com.olx.daoimpls.BidDaoImpl;
import com.olx.daoimpls.CategoryDaoImpl;
import com.olx.daoimpls.ItemDaoImpl;
import com.olx.daoimpls.UserDAoImpl;
import com.olx.daointerfaces.BidDao;
import com.olx.daointerfaces.CategoryDao;
import com.olx.daointerfaces.ItemDao;
import com.olx.daointerfaces.UserDAo;
import com.olx.models.Bid;
import com.olx.models.Category;
import com.olx.models.Item;
import com.olx.models.User;


public class OlxService {
	
	public  int registerUser(User user){
		UserDAo dao = new UserDAoImpl();
		int count= dao.insertUser(user);
		return count;
		
	}
	public User authenticateUser(String email, String password) {

		UserDAo dao = new UserDAoImpl();
		User user = dao.getUser(email);
		//System.out.println("2 " + user.getName());
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;

		}
	}
    public List<Item>getAllItems(){
		ItemDao dao=new ItemDaoImpl();
		List<Item> itemsList =dao.getAvailableItems();
		
    	return itemsList;
    	
    }
public static List<Category> getAvailableCategories(){
		
		CategoryDao dao = new CategoryDaoImpl();
		List<Category> categoryList = dao.getAvailableCategories();
		
		return categoryList;
		
}
public Item  getItem(int itemId){
	
		ItemDao dao=new ItemDaoImpl();
		 Item ItemId=dao.getItem(itemId);
		
		return ItemId;
	
}
public int enterBid(Bid bid) {
	BidDao dao=new BidDaoImpl();
	int BidId=dao.insertBid(bid);
	
	return BidId;
}

}
