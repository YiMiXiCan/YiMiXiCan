package com.nankai.yimixican.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixican.biz.IUserCardBiz;
import com.nankai.yimixican.biz.impl.UserCardBizImpl;
import com.nankai.yimixican.po.UserCard;

/**
 * Servlet implementation class InsertHabitServlet
 */
public class InsertHabitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHabitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");			
		String card_data = request.getParameter("card_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		UserCard card = gson.fromJson(card_data, UserCard.class);		
		
		// -------------------处理数据-----------------------
		IUserCardBiz biz=new UserCardBizImpl();
		boolean flag=biz.insert(card);
			
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag);		
		System.out.println(gson_data);
		out.println(gson_data);	
		out.flush();
		out.close();		
		
	}

}
