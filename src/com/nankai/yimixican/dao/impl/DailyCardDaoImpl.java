package com.nankai.yimixican.dao.impl;
/**
 * 文件名：DailyCardDaoImpl.java
 * 功能说明：实现dao层的IDailyCardDao接口，包括：添加、删除、按用户和时间查询、计数
 * 作者：谭米玲
 * 时间：2015-06-02 14:30
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nankai.yimixican.dao.IDailyCardDao;
import com.nankai.yimixican.db.ConnectionManager;
import com.nankai.yimixican.db.DBUtils;
import com.nankai.yimixican.db.TransactionManager;
import com.nankai.yimixican.po.DailyCard;

public class DailyCardDaoImpl implements IDailyCardDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	public DailyCardDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}
	@Override
	
	public int insert(DailyCard dailyCard) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		int habitID=dailyCard.getHabitID();
		int userID=dailyCard.getUserID();
		String finishtime=dailyCard.getFinishTime();
			String strSQL = "insert into daily_card values(null,?,?,?)";
			Object[] params = new Object[]{userID,habitID,finishtime};		
			int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
			if(affectedRows > 0){
				TransactionManager.commit();
			}else{
				TransactionManager.rollback();
			}
			this.connectionManager.closeConnection(conn);
			return affectedRows;
	}

	@Override
	public int delete(int dailyID) {
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
			String strSQL = "delete from daily_card where dailyid=?";
			Object[] params = new Object[]{dailyID};		
			int affectedRows = this.dbUtils.execOthers(conn, strSQL, params);
			if(affectedRows > 0){
				TransactionManager.commit();
			}else{
				TransactionManager.rollback();
			}
			this.connectionManager.closeConnection(conn);
			return affectedRows;
	}

	@Override
	public List<String> select(int userID) {//罗列某用户当日完成习惯情况用于打卡分享
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowtime = new Date();
		String nowtime1 = sdf.format(nowtime);
		
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date lasttime = new Date();
		String lasttime1 = sdf1.format(lasttime);
		String strSQL="select habits.name from daily_card,habits where daily_card.habitid=habits.habitid and daily_card.finishtime between ? and ?";
		Object[] params=new Object[]{lasttime1,nowtime1};
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		List<String>list=new ArrayList<String>();
		try {
			while(resultSet.next()){	
			list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		this.connectionManager.closeConnection(conn);
		return list;
	}

	@Override
	public int countByUserId(int userID) {//通过习惯完成总数来计算用户得分
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		String strSQL="select count(dailyid) from daily_card where uid=? ";
		Object[] params=new Object[]{userID};
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);	
		int c=0;
		try {
			if(resultSet.next()){
				c=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
/*
 //测试
	public static void main(String[] args) {
		DailyCardDaoImpl cardDaoImpl=new DailyCardDaoImpl();
		DailyCard dailyCard=new DailyCard();
		dailyCard.setFinishTime("2015-06-02 20:00:11");
		dailyCard.setHabitID(2);
		dailyCard.setUserID(1);
		//cardDaoImpl.insert(dailyCard);
		//cardDaoImpl.delete(2);
//		ArrayList<String> list=(ArrayList<String>)cardDaoImpl.select(1);
//		for (String string : list) {
//			System.out.println(string);
//		}
//		System.out.println(cardDaoImpl.countByUserId(1));
	}
	*/
}
