package com.nankai.yimixican.biz.impl;
/**
 * 文件名：DailyCardBizImpl.java
 * 功能说明：实现biz层的IDailyCardBiz接口，包括：添加、删除、按用户和时间查询、计数
 * 作者：谭米玲
 * 时间：2015-06-02 15:30
 * */
import java.util.List;

import com.nankai.yimixican.biz.IDailyCardBiz;
import com.nankai.yimixican.dao.IDailyCardDao;
import com.nankai.yimixican.dao.impl.DailyCardDaoImpl;
import com.nankai.yimixican.po.DailyCard;

public class DailyCardBizImpl implements IDailyCardBiz {
	private IDailyCardDao dailyCardDao;

	public DailyCardBizImpl() {
		super();
		dailyCardDao=new DailyCardDaoImpl();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(DailyCard dailyCard) {
		// TODO Auto-generated method stub
		return dailyCardDao.insert(dailyCard)>0?true:false;
	}
	@Override
	public boolean delete(int dailyID) {
		// TODO Auto-generated method stub
		return dailyCardDao.delete(dailyID)>0?true:false;
	}

	@Override
	public List<String> select(int userID) {
		// TODO Auto-generated method stub
		return dailyCardDao.select(userID);
	}

	@Override
	public int countByUserId(int userID) {
		// TODO Auto-generated method stub
		return dailyCardDao.countByUserId(userID);
	}

}
