package com.nankai.yimixican.biz;

import com.nankai.yimixican.po.Users;

public interface ILoginBiz {
	public abstract Users isLogin(final String uid, final String password);
}
