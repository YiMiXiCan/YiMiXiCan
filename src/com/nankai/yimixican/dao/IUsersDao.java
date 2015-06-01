package com.nankai.yimixican.dao;

import java.util.List;

import com.nankai.yimixican.po.Users;


public interface IUsersDao {
	public abstract int insert(final Users user);      //添加用户
	public abstract List<Users> selectAll();       //查找详细信息
	public abstract int deleteById(final int uid);  //删除用户
	public abstract Users selectByName(final String username); //通过姓名查找
	public abstract int update(final Users user);// 更新
	public abstract Users selectByObject(final String username,final String password);//登陆验证
	public abstract Users selectById(final int uid);//通过id查询

}
