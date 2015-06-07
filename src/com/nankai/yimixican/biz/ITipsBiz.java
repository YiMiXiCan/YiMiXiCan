package com.nankai.yimixican.biz;

import java.util.List;

import com.nankai.yimixican.po.Tips;

public interface ITipsBiz {
	public abstract List<Tips> findAll(final int a);
	public abstract Tips findById(final int tid);
	public abstract Tips findByTitle(final String title);
}
