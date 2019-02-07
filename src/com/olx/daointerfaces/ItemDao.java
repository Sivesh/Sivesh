package com.olx.daointerfaces;

import java.util.List;

import com.olx.models.Item;

public interface ItemDao {
	 List<Item> getAvailableItems();
	 public List<Item> getItemsForSubCategory(int subcategoryId);
	  
	Item getItem(int itemId);
}
