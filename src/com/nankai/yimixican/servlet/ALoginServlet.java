package com.nankai.yimixican.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixican.biz.ILoginBiz;
import com.nankai.yimixican.biz.impl.LoginBizImpl;
import com.nankai.yimixican.po.Users;

/**
 * Servlet implementation class ALoginServlet
 */
public class ALoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ALoginServlet() {
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
		//--------------------接受数据JSon-----------------
				// 获取终端传入的JSon数据
				String user_data = request.getParameter("user_data");
				System.out.println(user_data);
				// 反序列化形成一个Users对象
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				Users user = gson.fromJson(user_data, Users.class);
				
				
				// -------------------处理数据-----------------------
				ILoginBiz loginBiz = new LoginBizImpl();
				Users loginUser = loginBiz.isLogin(user.getUid(), user.getPassword());
				/*@SuppressWarnings("unchecked")
				List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
				if(usersOnLineList == null){
					usersOnLineList = new ArrayList<String>();
				}
				// 判断当前登录用户是否存在于该在线列表中
				boolean singleLoginFlag;
				if(usersOnLineList.contains(user.getUser_id())){
					singleLoginFlag = true;
				}else{
					singleLoginFlag = false;			
				}
				
				if(!singleLoginFlag){
					// 调用Biz层实现数据库验证
					ILoginBiz loginBiz = new LoginBizImpl();
					Userinfo loginUser = loginBiz.isLogin(user.getUser_id(), user.getUser_pwd());
					if(loginUser!=null)
					{
						HttpSession session = request.getSession(); // 获取session对象
						// 将登录的用户添加到在线列表中
						usersOnLineList.add(loginUser.getUser_id());
						// 刷新在线用户列表
						this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);
						session.setAttribute("user", loginUser);*/
						response.setContentType("text/html; charset=UTF-8");
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						String gson_data = gson.toJson(loginUser);
						System.out.println(gson_data);
						out.println(gson_data);
						
						out.flush();
						out.close();
						
					
				
				
				
				// -------------------响应客户端 JSon----------------
				
				
				
				
			}
			

		}
