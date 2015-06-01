package com.nankai.yimixican.dao;
import java.util.List;

/**
 * 文件名：IHabitDao.java
 * 功能说明：dao层操作habits数据库的接口
 * 作者：谭米玲
 * 时间：2015-06-01 21:00
 * */
import com.nankai.yimixican.po.Habit;

public interface IHabitDao {
	public abstract List<Habit> showByClassID(int classID);//按classID罗列习惯
	public abstract int insert(Habit habit);//添加新习惯
}
