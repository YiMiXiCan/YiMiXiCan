package com.nankai.yimixican.biz;

import com.nankai.yimixican.po.Users;

public interface IUsersBiz {

	public abstract boolean add(final Users user);
	public abstract boolean modify(final Users user);
	public abstract Users findById(final int uid);
}
