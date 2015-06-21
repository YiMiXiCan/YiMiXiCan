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
 * Servlet implementation class UserInformationServlet
 * 用于显示用户信息
 */
public class UserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformationServlet() {
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
		int userID = Integer.parseInt(request.getParameter("user_id"));		
		// 反序列化形成一个Organizer对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
	//	Candidate candidate= gson.fromJson(user, Candidate.class);		
		// -------------------处理数据-----------------------
		IUsersBiz biz=new UsersBizImpl();
		Users user=new Users();
		user=biz.findById(userID);
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String gson_data = gson.toJson(user);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();		
	}
}
