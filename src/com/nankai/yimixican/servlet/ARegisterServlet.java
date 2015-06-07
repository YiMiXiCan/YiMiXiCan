package com.nankai.yimixican.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixican.biz.IUsersBiz;
import com.nankai.yimixican.biz.impl.UsersBizImpl;
import com.nankai.yimixican.po.Users;

/**
 * Servlet implementation class ARegisterServlet
 */
public class ARegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ARegisterServlet() {
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
		
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String user_data = request.getParameter("user_data");
		System.out.println(user_data);
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Users user = gson.fromJson(user_data, Users.class);
		
		//Users users = new Users();
		//.setUser_name("bbbb");
		//users.setUserpassword("111");-----------测试
		// -------------------处理数据-----------------------
		IUsersBiz usersBiz=new UsersBizImpl();
		boolean flag= usersBiz.add(user);
		
			
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	//	System.out.println("yes");
}
}
