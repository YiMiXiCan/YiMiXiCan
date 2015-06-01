package com.nankai.yimixican.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




import com.nankai.yimixican.biz.IUsersBiz;
import com.nankai.yimixican.biz.impl.UsersBizImpl;
import com.nankai.yimixican.po.Users;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
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
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/file");
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的位置是："
				+ fileUploadPath);
		// 1-2：设置服务器临时缓冲区的位置（临时缓冲的文件夹）
		File fileUploadTempPath = new File(this.getServletContext()
				.getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// 创建一个全新的
			fileUploadTempPath.mkdir();
		}
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的临时位置是："
				+ fileUploadTempPath.getPath());

		// 步骤2：判断表单是否符合上传要求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 步骤3：设置文件上传缓冲区对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:缓冲区对象与磁盘物理位置的绑定
			factory.setRepository(fileUploadTempPath);
			// 3-2：设置缓冲区对象的大小（4*1024 字节）
			factory.setSizeThreshold(4 * 1024);
			System.out
					.println("[SingleFileUploadServlet] 初始化服务器接受客户端上传文件的临时位置完毕！");

			// 步骤4：解析客户端表单待上传的数据
			// 创建一个ServletFileUpload对象完成对二进制表单数据的解析，并实现服务器上传功能
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				// ★★特别注意★★ 在循环遍历表单数据之前创建实体类对象
				Users user = new Users();
				
				String password1="";
				
				
				

				// 将解析到的二进制文件封装到FileItem的对象中
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					//判断当前解析的请求数据是否为普通表单数据
					if (fileItem.isFormField()) {
						// 获取客户端表单输入元素的name属性的值
						String name = fileItem.getFieldName().trim();
						// 判断数据为哪个字段数据
						if ("username".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUsername(value);
							System.out.println("注册账号：> " + value);
						}
						if ("user_pwd".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setPassword(value);
							System.out.println("注册密码：> " + value);
						}
						if ("password1".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							password1=value;
							System.out.println("测试-用户昵称：> " + value);
						}
					}else {
					}
				}
						
				// 调用Biz层的方法完成注册功能
				IUsersBiz usersBiz=new UsersBizImpl();
				
				boolean flag1 =  usersBiz.add(user);System.out.println(flag1);
				
				boolean flag2 = false;
				if(user.getPassword().equals(password1))
					flag2=true;
				System.out.println(flag2);
				boolean flag=flag1&&flag2;
				// 根据返回值结果进行页面跳转
				if (flag) {
					// 跳转至登录页面
					request.setAttribute("username", user.getUsername());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				} else {
					System.out.println("注册失败！！！！！");
					}
				
					
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("客户端表单不符合上传要求！");
		}
	}

	// 自定义方法完成上传文件名称的自动生成
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
		
	}
		
	
		
	}



