package com.nankai.yimixican.biz.impl;


import com.nankai.yimixican.biz.IUsersBiz;
import com.nankai.yimixican.dao.IUsersDao;
import com.nankai.yimixican.dao.impl.UsersDaoImpl;
import com.nankai.yimixican.po.Users;

public class UsersBizImpl implements IUsersBiz {

private IUsersDao iUsersDao;
	
	
	public UsersBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iUsersDao=new UsersDaoImpl();
	}
	
	@Override
	public boolean add(Users user) {
		// TODO Auto-generated method stub
		if(this.iUsersDao.selectByName(user.getUsername())==null){
			if(user.getUsername()!=null&&user.getPassword()!=null&&user.getRepassword()!=null)
			{
			
			   return this.iUsersDao.insert(user)>0?true:false;
			}
			else{
				return false;
			}
			
		}	
		else
		{
			return false;
		}
	}

	@Override
	public boolean modify(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users findById(int uid) {
		// TODO Auto-generated method stub
		return iUsersDao.selectById(uid);
	}

	@Override
	public boolean isHave(String account) {
		// TODO Auto-generated method stub
		return iUsersDao.isHave(account);
	}

	@Override
	public Users selectByName(String username) {
		// TODO Auto-generated method stub
		return iUsersDao.selectByName(username);
	}

}
