package com.olx.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.olx.models.Bid;
import com.olx.models.Category;
import com.olx.models.Item;
import com.olx.models.User;
import com.olx.services.OlxService;

/**
 * Servlet implementation class OlxController
 */
@WebServlet("/OlxController")
public class OlxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OlxController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public static void processHomePage(HttpServletRequest request, HttpServletResponse response){
		List<Item> itemsList = new OlxService().getAllItems();
		System.out.println("contr" +itemsList.size());
		request.setAttribute("itemsList", itemsList);
		
		List<Category> categoriesList=new OlxService().getAvailableCategories();
		request.setAttribute("categoriesList", categoriesList);
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action == null){
			List<Item> itemsList = new OlxService().getAllItems();
			System.out.println("contr" +itemsList.size());
			request.setAttribute("itemsList", itemsList);
			
			List<Category> categoriesList=new OlxService().getAvailableCategories();
			request.setAttribute("categoriesList", categoriesList);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(action.equalsIgnoreCase("Sign Up")){
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone_number = request.getParameter("phone_number");
			
			User user= new User();
			
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
		    user.setPhone_number(Long.parseLong(phone_number));
			
			int count = new OlxService().registerUser(user);
			
			if(count==1){
				HttpSession session=request.getSession();
				session.setAttribute("user",user);
				processHomePage(request,response);
				request.getRequestDispatcher("/userhome.jsp").forward(request, response);
			}
			else{
				out.print("user registration was unsuccessfull.please try again");
				processHomePage(request,response);
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			//out.println("one Record inserted");
		}
		
		if(action.equalsIgnoreCase("Sign In")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			User user = new OlxService().authenticateUser(email, password);
			
			if(user == null)
			{
				out.println("<h2><b>Invalid Username or Password</b></h2>");
				processHomePage(request,response);
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				processHomePage(request,response);
				request.getRequestDispatcher("/userhome.jsp").forward(request, response);
			}
		}

		if(action.equalsIgnoreCase("product")){
			
			String itemid = request.getParameter("item_id");
			
			request.setAttribute("itemid", itemid);
			System.out.println(Integer.parseInt(itemid));
			
			Item item = new OlxService().getItem(Integer.parseInt(itemid));
			request.setAttribute("item", item);
			
			request.getRequestDispatcher("/product.jsp").forward(request, response);
			
			
		}
		
		if(action.equalsIgnoreCase("bid")){
			
			String itemId=request.getParameter("itemId");
			String userId=request.getParameter("userId");
			String bidAmount=request.getParameter("bidAmount");
			
			Item item=new Item();
			item.setId(Integer.parseInt(itemId));
			
			User bidder=new User();
			bidder.setUser_id(Integer.parseInt(userId));
			
			Bid bid=new Bid();
			bid.setItem(item);
			bid.setBidder(bidder);
			bid.setAmount(Float.parseFloat(bidAmount));
			bid.setStatus(0);

			
			int result=new OlxService().enterBid(bid);
			
			if(result==1){
				request.setAttribute("result", result);
				//System.out.println("Bidding completed successfully");
				request.getRequestDispatcher("/bidsuccess.jsp").forward(request, response);
			}
			else{
				out.println("<h3>Bid not accepted</h3>");
				request.getRequestDispatcher("/product.jsp").include(request, response);
			}
		}
		
	}
}
