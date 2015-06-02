package com.nankai.yimixican.dao;
/**
 * 文件名：IUserCardDao.java 
 * 功能说明：dao层对用户习惯管理，包括：添加习惯、删除习惯、罗列出用户习惯
 * 作者：谭米玲
 * 时间：2015-06-02 22:05
 * */
import java.util.List;

import com.nankai.yimixican.po.UserCard;

public interface IUserCardDao {
	public abstract int insert(UserCard userCard);//添加用户习惯
	public abstract int delete(UserCard userCard);//删除用户习惯
	public abstract List<UserCard>selectHabitByUserID(int userID);//罗列用户习惯
}
