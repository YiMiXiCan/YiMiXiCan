package com.nankai.yimixican.dao.impl;
/**
 * 文件名：UserCardDaoImpl.java 
 * 功能说明：对IUserCardDao接口的实现，进行具体的用户习惯管理，包括：添加习惯、删除习惯、罗列出用户习惯
 * 作者：谭米玲
 * 时间：2015-06-02 22:05
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nankai.yimixican.dao.IUserCardDao;
import com.nankai.yimixican.db.ConnectionManager;
import com.nankai.yimixican.db.DBUtils;
import com.nankai.yimixican.db.TransactionManager;
import com.nankai.yimixican.po.Habit;
import com.nankai.yimixican.po.UserCard;

public class UserCardDaoImpl implements IUserCardDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private DBUtils dbUtils;
	
	public UserCardDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager = new ConnectionManager();
		this.dbUtils = new DBUtils();
	}

	@Override
	public int insert(UserCard userCard) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		int habitID=userCard.getHabitID();
		int userID=userCard.getUserID();
		String strSQL = "insert into user_card values(?,?)";
		Object[] params = new Object[]{habitID,userID};		
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
	public int delete(UserCard userCard) {
		// TODO Auto-generated method stub
		this.conn = this.connectionManager.openConnection();
		TransactionManager.conn = this.conn;
		TransactionManager.beginTransaction();
		
		int habitID=userCard.getHabitID();
		int userID=userCard.getUserID();
		String strSQL = "delete from user_card where habitid=? and uid=?";
		Object[] params = new Object[]{habitID,userID};		
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
	public List<UserCard> selectHabitByUserID(int userID) {
		// TODO Auto-generated method stub
		this.conn=this.connectionManager.openConnection();
		String strSQL="select user_card.habitid,user_card.uid,habits.name from user_card,habits where user_card.habitid=habits.habitid and user_card.uid=?";
		Object[] params=new Object[]{userID};
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		List<UserCard>list=new ArrayList<UserCard>();
		try {
			while(resultSet.next()){	
				UserCard userCard=new UserCard();
				userCard.setHabitID(resultSet.getInt(1));
				userCard.setUserID(resultSet.getInt(2));
				userCard.setHabitName(resultSet.getString(3));
				list.add(userCard);
				}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				}
		this.connectionManager.closeConnection(conn);
		return list;
	}
	//*测试
	public static void main(String[] args) {
//		UserCardDaoImpl cardDaoImpl=new UserCardDaoImpl();
//		UserCard card=new UserCard();
//		card.setHabitID(2);
//		card.setUserID(1);
//		//cardDaoImpl.insert(card);
//		//cardDaoImpl.delete(2);
//		ArrayList<UserCard>list=(ArrayList<UserCard>) cardDaoImpl.selectHabitByUserID(1);
//		for(UserCard userCard : list) {
//			System.out.println("名字"+userCard.getHabitName());
//		}
		System.out.println(System.currentTimeMillis());
	}
//*/
}
