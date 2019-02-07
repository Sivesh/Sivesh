package com.olx.daoimpls;
import com.olx.daointerfaces.UserDAo;
import com.olx.models.User;
import com.olx.utilities.ConnectionFactory;

import java.sql.*;
public class UserDAoImpl implements UserDAo{
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		int result=0;
		try{
		Connection conn=ConnectionFactory.getConnection();
		String sql="Insert into user(id,name,phone_number,email,password,deleted) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user.getUser_id());
		ps.setString(2, user.getName());
		ps.setLong(3, user.getPhone_number());
		ps.setString(4, user.getEmail());
		
		ps.setString(5, user.getPassword());
		ps.setInt(6, 0);
		result =ps.executeUpdate();
		
		ps.close();
		conn.close();
		}catch(Exception e){
			 e.printStackTrace();
		}
		return result;
		
	}

	ResultSet rs =null;
	  User user=null;
	 
	public User getUser(String email) {
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
		
			String sql = "Select * from user where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()){
		    	
	           int id=rs.getInt("id");
		    	String name=  rs.getString("name");
		    	long phone_number =  rs.getLong("phone_number");
		     	String emailId = rs.getString("email");
		     	String password= rs.getString("password");
		     	
		     	user = new User();
		     	user.setUser_id(id);
		     	user.setName(name);
		     	user.setPhone_number(phone_number);
		     	user.setEmail(emailId);
		     	user.setPassword(password);
		     	
		     	
		     	
		  
		    }
		        rs.close();
			    ps.close();
			    conn.close();
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//System.out.println(user.getName());
			return user;
		}

	

}
