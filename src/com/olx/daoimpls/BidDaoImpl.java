package com.olx.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.olx.daointerfaces.BidDao;
import com.olx.models.Bid;
import com.olx.models.Item;
import com.olx.models.Subcategory;
import com.olx.models.User;
import com.olx.utilities.ConnectionFactory;

public class BidDaoImpl implements BidDao{

	@Override
	public int insertBid(Bid bid) {
		
			
		       int result = 0;
				
				try{
					Connection conn = ConnectionFactory.getConnection();
					
					String sql = "insert into bid(item_id,user_id,amount,status) values(?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					
				
					ps.setObject(1, bid.getItem().getId());
					ps.setObject(2, bid.getBidder().getUser_id());
					ps.setFloat(3, bid.getAmount());
					ps.setInt(4, bid.getStatus());
				
					
					result = ps.executeUpdate();
					
					ps.close();
					conn.close();
				}catch(Exception e){
					e.getMessage();
				}
				
				System.out.println(result);
				return result;
				
		
	}

}
