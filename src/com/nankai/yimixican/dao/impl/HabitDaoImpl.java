package com.nankai.yimixican.dao.impl;
/**
 * 文件名：HabitDaoImpl.java
 * 功能说明：对dao层IHabitDao接口的实现
 * 作者：谭米玲
 * 时间：2015-06-01 21:00
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.yimixican.dao.IHabitDao;
import com.nankai.yimixican.db.ConnectionManager;
import com.nankai.yimixican.db.DBUtils;
import com.nankai.yimixican.db.TransactionManager;
import com.nankai.yimixican.po.Habit;

//按classID罗列习惯
public class HabitDaoImpl implements IHabitDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public HabitDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public List<Habit> showByClassID(int classID) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		String strSQL="select * from habits where class=?";
		Object[] params=new Object[]{classID};
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		List<Habit>list=new ArrayList<Habit>();
		try {
			while(resultSet.next()){	
				Habit habit=new Habit();
				habit.setHibitID(resultSet.getInt(1));
				habit.setClassID(resultSet.getInt(2));
				habit.setName(resultSet.getString(3));
				habit.setImgurl(resultSet.getString(5));
			list.add(habit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		this.connectionManager.closeConnection(conn);
		return list;
	}
	
	//添加新习惯
	@Override
	public int insert(Habit habit) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		int classID=habit.getClassID();
		String name=habit.getName();
			String strSQL = "insert into habits values(null,?,?,1)";
			Object[] params = new Object[]{classID,name};		
			int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
			if(affectedRows > 0){
				TransactionManager.commit();
			}else{
				TransactionManager.rollback();
			}
			this.connectionManager.closeConnection(conn);
			return affectedRows;
	}
	
/*测试
public static void main(String[] args) {
//	HabitDaoImpl daoImpl=new HabitDaoImpl();
//	ArrayList<Habit> list=(ArrayList<Habit>) daoImpl.showByClassID(2);
//	for (Habit habit : list) {
//		System.out.println(habit.getName());
//	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	Date d = new Date();
//	String date = sdf.format(d);
//	System.out.println(date);
	Calendar c = Calendar.getInstance();
	long t = c.getTimeInMillis();
	long l = t - 24 * 3600 * 1000;
	Date d = new Date(l);
	String s = sdf.format(d);
	System.out.println(s);
}*/
}

