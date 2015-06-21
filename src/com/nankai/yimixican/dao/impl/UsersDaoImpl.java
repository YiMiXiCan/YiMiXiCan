package com.nankai.yimixican.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nankai.yimixican.po.Users;
import com.nankai.yimixican.db.TransactionManager;
import com.nankai.yimixican.db.ConnectionManager;
import com.nankai.yimixican.db.DBUtils;
import com.nankai.yimixican.dao.IUsersDao;

public class UsersDaoImpl implements IUsersDao {
	
	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public UsersDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
    }
	@Override
	public int insert(Users user) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	   // String uid=user.getUid();
	    String username=user.getUsername();
	    String password=user.getPassword();
	    String repassword=user.getRepassword();
	    int gender=user.getGender();
	    int age=user.getAge();
	    String remind=user.getRemind();
	    float height=user.getHeight();
	    float weight=user.getWeight();
	    String remindtime=user.getRemindtime();
	    String declaration=user.getDeclaration();
	    String regtime=user.getRegtime();
	    String strSQL="insert into Users values(null,?,?,?,?,?,?,?,?,?,?,?)";
	    Object[] params=new Object[]{username,regtime,gender,age,remind,password,height,weight,declaration,remindtime,repassword};
	    
	    int affectedRows=this.dbUtils.execOthers(conn, strSQL, params);
	    
	    if(affectedRows>0)
	    {
	    	TransactionManager.commit(); 
	    	
	    }
	    else
	    {
	    	TransactionManager.rollback();
	    	
	    }
	   return affectedRows;
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
		    
		 
		    
			List<Users> lstUsers = new ArrayList<Users>();
			String strSQL="select * from Users order by uid";
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			
			try {
				while(resultSet.next())
				{
					Users user=new Users();
					user.setUid(resultSet.getInt(1));
					user.setUsername(resultSet.getString(2));
					user.setRemind(resultSet.getString(3));
					user.setGender(resultSet.getInt(4));
					user.setAge(resultSet.getInt(5));
					user.setRemind(resultSet.getString(6));
					user.setPassword(resultSet.getString(7));
					user.setHeight(resultSet.getFloat(8));
					user.setWeight(resultSet.getFloat(9));
					user.setDeclaration(resultSet.getString(10));
					user.setRemindtime(resultSet.getString(11));
					user.setRepassword(resultSet.getString(12));
					
					lstUsers.add(user);
					
				}
				return lstUsers;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				}
			
			finally{
				this.connectionManager.closeConnection(conn);
			}
			
	}

	@Override
	public int deleteById(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users selectByName(String username) {
		Connection conn=connectionManager.openConnection();
		String strSQL = "select * from users where username=?";
		Object[] params = new Object[] { username};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Users user=new Users();
				user.setUid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setRemind(resultSet.getString(3));
				user.setGender(resultSet.getInt(4));
				user.setAge(resultSet.getInt(5));
				user.setRemind(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setHeight(resultSet.getFloat(8));
				user.setWeight(resultSet.getFloat(9));
				user.setDeclaration(resultSet.getString(10));
				user.setRemindtime(resultSet.getString(11));
				user.setRepassword(resultSet.getString(12));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}


	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users selectByObject(int uid, String password) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from users where uid=? and password=?";
		Object[] params = new Object[]{uid, password};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
				Users user=new Users();
				user.setUid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setRemind(resultSet.getString(3));
				user.setGender(resultSet.getInt(4));
				user.setAge(resultSet.getInt(5));
				user.setRemind(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setHeight(resultSet.getFloat(8));
				user.setWeight(resultSet.getFloat(9));
				user.setDeclaration(resultSet.getString(10));
				user.setRemindtime(resultSet.getString(11));
				user.setRepassword(resultSet.getString(12));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}	
		return null;
	}

	@Override
	public Users selectById(int uid) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from users where uid=?";
		Object[] params = new Object[] { uid};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Users user=new Users();
				user.setUid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setRemind(resultSet.getString(3));
				user.setGender(resultSet.getInt(4));
				user.setAge(resultSet.getInt(5));
				user.setRemind(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setHeight(resultSet.getFloat(8));
				user.setWeight(resultSet.getFloat(9));
				user.setDeclaration(resultSet.getString(10));
				user.setRemindtime(resultSet.getString(11));
				user.setRepassword(resultSet.getString(12));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public boolean isHave(String account) {
		// TODO Auto-generated method stub
		Users user=new Users();
		user=selectByName(account);
		if(user==null){
		return false;}
		else{
			return true;}
	}

}
