package com.nankai.yimixican.biz.impl;

import java.util.List;

import com.nankai.yimixican.biz.IUserCardBiz;
import com.nankai.yimixican.dao.IUserCardDao;
import com.nankai.yimixican.dao.impl.UserCardDaoImpl;
import com.nankai.yimixican.po.UserCard;

public class UserCardBizImpl implements IUserCardBiz {
	private IUserCardDao userCardDao;

	public UserCardBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		userCardDao=new UserCardDaoImpl();
	}

	@Override
	public boolean insert(UserCard userCard) {
		// TODO Auto-generated method stub
		return userCardDao.insert(userCard)>0?true:false;
	}

	@Override
	public boolean delete(UserCard userCard) {
		// TODO Auto-generated method stub
		return userCardDao.delete(userCard)>0?true:false;
	}

	@Override
	public List<UserCard> selectHabitByUserID(int userID) {
		// TODO Auto-generated method stub
		return userCardDao.selectHabitByUserID(userID);
	}

}
