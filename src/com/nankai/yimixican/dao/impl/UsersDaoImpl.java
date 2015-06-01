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
	    
	    int uid=user.getUid();
	    String username=user.getUsername();
	    String password=user.getPassword();
	    int gender=user.getGender();
	    int age=user.getAge();
	    String remark=user.getRemark();
	    float height=user.getHeight();
	    float weight=user.getWeight();
	    String head_photo=user.getHead_photo();
	    String regtime=user.getRegtime();
	    
	    String strSQL="insert into Users values(null,?,?,?,?,?,?,?,?,?)";
	    
	    Object[] params=new Object[]{uid,username,password,gender,age,remark,height,weight,head_photo,regtime};
	    
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
					user.setPassword(resultSet.getString(3));
					user.setGender(resultSet.getInt(4));
					user.setAge(resultSet.getInt(5));
					user.setRank(resultSet.getInt(6));
					user.setRemark(resultSet.getString(7));
					user.setHeight(resultSet.getFloat(8));
					user.setWeight(resultSet.getFloat(9));
					user.setHead_photo(resultSet.getString(10));
					user.setRegtime(resultSet.getString(11));
					
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users selectByObject(String username, String password) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from users where username=? and password=?";
		Object[] params = new Object[]{username, password};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
				Users user=new Users();
				user.setUid(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setGender(resultSet.getInt(4));
				user.setAge(resultSet.getInt(5));
				user.setRank(resultSet.getInt(6));
				user.setRemark(resultSet.getString(7));
				user.setHeight(resultSet.getFloat(8));
				user.setWeight(resultSet.getFloat(9));
				user.setHead_photo(resultSet.getString(10));
				user.setRegtime(resultSet.getString(11));
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
				user.setPassword(resultSet.getString(3));
				user.setGender(resultSet.getInt(4));
				user.setAge(resultSet.getInt(5));
				user.setRank(resultSet.getInt(6));
				user.setRemark(resultSet.getString(7));
				user.setHeight(resultSet.getFloat(8));
				user.setWeight(resultSet.getFloat(9));
				user.setHead_photo(resultSet.getString(10));
				user.setRegtime(resultSet.getString(11));
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

}
