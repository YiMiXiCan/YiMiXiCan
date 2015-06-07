package com.nankai.yimixican.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixican.biz.ITipsBiz;
import com.nankai.yimixican.biz.impl.TipsBizImpl;
import com.nankai.yimixican.po.Tips;

/**
 * Servlet implementation class FindTipById
 */
public class FindTipById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindTipById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据

String user_data = request.getParameter("user_data");
	System.out.print(user_data);
		// 反序列化形成一个Users对象
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
	Tips tip = gson.fromJson(user_data, Tips.class);
       int tid=tip.getImage();
		// -------------------处理数据-----------------------
		ITipsBiz tipsBiz = new TipsBizImpl();
		Tips tip1 = tipsBiz.findById(tid);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
    	 String gson_data = gson.toJson(tip1);
	System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}
