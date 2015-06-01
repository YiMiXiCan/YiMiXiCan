package com.nankai.yimixican.biz;
/**
 * 文件名：IHabitBiz.java
 * 功能说明：biz层操作habits数据库的接口
 * 作者：谭米玲
 * 时间：2015-06-01 23:00
 * */
import java.util.List;

import com.nankai.yimixican.po.Habit;

public interface IHabitBiz {
	public abstract List<Habit> showHabitsByClassID(int classID);//按classID罗列习惯
	public abstract boolean insertHabit(Habit habit);//添加新习惯
}
