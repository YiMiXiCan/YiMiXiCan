package com.nankai.yimixican.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class FindAllTipsServlet
 */
public class FindAllTipsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllTipsServlet() {
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
/*		// 步骤1：调用Biz层的方法实现对Customers数据的检索
		ITipsBiz tipsBiz = new TipsBizImpl();
		String type = request.getParameter("type");
		int a=Integer.parseInt(type);
		// 步骤2：调用findAll方法完成数据的获取
		List<Tips> lstTips = tipsBiz.findAll(a);
		// 步骤3：将获取的数据添加到request级别对象中
		request.setAttribute("lstTips", lstTips);
		// 步骤4：使用请求转发模式完成界面的跳转（可以携带reuqest对象进行跳转）
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/ShowTips.jsp");
		dispatcher.forward(request, response);  */
		// TODO Auto-generated method stub
		//--------------------接受数据JSon-----------------
				// 获取终端传入的JSon数据
		
		String gson_data = request.getParameter("gson_data");
			System.out.print(gson_data);
				// 反序列化形成一个Users对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			int type = gson.fromJson(gson_data, Integer.class);

				// -------------------处理数据-----------------------
				ITipsBiz tipsBiz = new TipsBizImpl();
				List<Tips> lstTips = tipsBiz.findAll(type);
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
			
		    	 gson_data = gson.toJson(lstTips);
			System.out.println(gson_data);
		//		out.println(gson_data);
				
				out.flush();
				out.close();
	}

}
