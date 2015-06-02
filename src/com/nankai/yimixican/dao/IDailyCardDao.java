package com.nankai.yimixican.dao;

import java.util.List;

import com.nankai.yimixican.po.DailyCard;

/**
 * 文件名：IDailyCardDao.java
 * 功能说明：dao层实现对daily_card（每日打卡）数据库处理操作，包括：添加、删除、按用户和时间查询、计数
 * 作者：谭米玲
 * 时间：2015-06-02 14:30
 * */
public interface IDailyCardDao {
	public abstract int insert(DailyCard dailyCard);
	public abstract int delete(int dailyID);
	public abstract List<String> select(int userID);
	public abstract int countByUserId(int userID);
}
