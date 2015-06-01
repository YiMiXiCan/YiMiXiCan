package com.nankai.yimixican.biz.impl;
/**
 * 文件名：HabitBizImpl.java
 * 功能说明：调用dao层的IHabitDao中的函数，对biz层IHabitBiz接口的实现
 * 作者：谭米玲
 * 时间：2015-06-01 21:30
 * */
import java.util.List;

import com.nankai.yimixican.biz.IHabitBiz;
import com.nankai.yimixican.dao.IHabitDao;
import com.nankai.yimixican.dao.impl.HabitDaoImpl;
import com.nankai.yimixican.po.Habit;

public class HabitBizImpl implements IHabitBiz {
	private IHabitDao habitDao;

	public HabitBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		habitDao=new HabitDaoImpl();
	}

	@Override
	public List<Habit> showHabitsByClassID(int classID) {
		// TODO Auto-generated method stub
		return habitDao.showByClassID(classID);
	}

	@Override
	public boolean insertHabit(Habit habit) {
		// TODO Auto-generated method stub
		return habitDao.insert(habit)>0?true:false;
	}

}
