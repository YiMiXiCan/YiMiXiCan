package com.nankai.yimixican.biz.impl;

import java.util.List;


import com.nankai.yimixican.biz.ITipsBiz;
import com.nankai.yimixican.dao.ITipsDao;
import com.nankai.yimixican.dao.impl.TipsDaoImpl;
import com.nankai.yimixican.po.Tips;

public class TipsBizImpl implements ITipsBiz {
	private ITipsDao tipsDao;
	  
	public TipsBizImpl() {
		// TODO Auto-generated constructor stub
	// TODO Auto-generated constructor stub
	this.tipsDao=new TipsDaoImpl();
}
	@Override
	public List<Tips> findAll( int a) {
		// TODO Auto-generated method stub
		return this.tipsDao.selectAll ( a);
	}

	@Override
	public Tips findById(int tid) {
		// TODO Auto-generated method stub
		return this.tipsDao.selectByid(tid);
	}

	@Override
	public Tips findByTitle( String title) {
		// TODO Auto-generated method stub
		return this.tipsDao.selectByTitle(title);
	}

}
