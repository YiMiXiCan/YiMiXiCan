package com.nankai.yimixican.dao;

import java.util.List;

import com.nankai.yimixican.po.Tips;


public interface ITipsDao {
	public abstract Tips selectByid(final int image);
	public abstract List<Tips> selectAll(final int a);
	public abstract Tips selectByTitle(final String title);
}
