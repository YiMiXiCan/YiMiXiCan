package com.nankai.yimixican.biz.impl;


import com.nankai.yimixican.biz.ILoginBiz;
import com.nankai.yimixican.dao.IUsersDao;
import com.nankai.yimixican.dao.impl.UsersDaoImpl;
import com.nankai.yimixican.po.Users;

public class LoginBizImpl implements ILoginBiz {

	private IUsersDao usersDao;
	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	this.usersDao = new UsersDaoImpl();
}
	@Override
	public Users isLogin(String uid, String password) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByObject(uid, password);
	}

}
