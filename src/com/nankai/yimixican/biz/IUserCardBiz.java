package com.nankai.yimixican.biz;

import java.util.List;

import com.nankai.yimixican.po.UserCard;

public interface IUserCardBiz {
	public abstract boolean insert(UserCard userCard);//添加用户习惯
	public abstract boolean delete(UserCard userCard);//删除用户习惯
	public abstract List<UserCard>selectHabitByUserID(int userID);//罗列用户习惯
}
