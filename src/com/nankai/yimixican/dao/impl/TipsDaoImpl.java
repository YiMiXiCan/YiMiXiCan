package com.nankai.yimixican.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






import com.nankai.yimixican.dao.ITipsDao;
import com.nankai.yimixican.db.ConnectionManager;
import com.nankai.yimixican.db.DBUtils;
import com.nankai.yimixican.po.Tips;

public class TipsDaoImpl implements ITipsDao {
	 private ConnectionManager connectionmanager=new ConnectionManager();
	   private DBUtils dbutils=new DBUtils();
	   public TipsDaoImpl(){
	   super();
	   this.connectionmanager=new ConnectionManager();
	   this.dbutils=new DBUtils();
	   }

	@Override
	public List<Tips> selectAll(int a) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// 步骤1：创建一个空的集合准备存放查询的结果
				List<Tips> lstTips = new ArrayList<Tips>();
				// 步骤2：获取一个数据库的连接对象
				Connection conn = connectionmanager.openConnection();
				// 步骤3：创建查询语句的模板
				System.out.println(a);
				String strSQL = "select * from tips where type=? order by tid";
				//System.out.println(a);
				Object[] params=new Object[]{a};
				// 步骤4：使用dbutils方法实现查询操作
				ResultSet resultSet = this.dbutils.execQuery(conn, strSQL, params);
				// 步骤5：将resultSet结果集转换成List数据结构
				try {
					while(resultSet.next()){
						// 步骤5-1：创建一个Customers对象
						Tips tip = new Tips();
						tip.setTid(resultSet.getInt(1));
						tip.setType(resultSet.getInt(2));
						tip.setTxt(resultSet.getString(3));
						tip.setTitle(resultSet.getString(4));
					    tip.setImage(resultSet.getInt(5));
						
						// 步骤5-2：将封装好的对象添加到List集合中
						lstTips.add(tip);				
					}
					// 返回结果
					return lstTips;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} finally{
					// 步骤6：关闭数据库连接
					this.connectionmanager.closeConnection(conn);
				}
	}
	@Override
	public Tips selectByid(int image) {
		// TODO Auto-generated method stub
        Connection conn=connectionmanager.openConnection();
		
		String strSQL= "select * from tips where image=?";
		
		Object[] params=new Object[]{image};
		
		ResultSet resultSet=this.dbutils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()){
				
				Tips tip=new Tips();
				tip.setTid(resultSet.getInt(1));
				tip.setType(resultSet.getInt(2));
				tip.setTxt(resultSet.getString(3));
				tip.setTitle(resultSet.getString(4));
				 tip.setImage(resultSet.getInt(5));
				
				return tip;
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionmanager.closeConnection(conn);
		}
	
	}

	@Override
	public Tips selectByTitle(String title) {
		// TODO Auto-generated method stub
        Connection conn=connectionmanager.openConnection();
		
		String strSQL= "select * from tips where title=?";
		
		Object[] params=new Object[]{title};
		
		ResultSet resultSet=this.dbutils.execQuery(conn, strSQL, params);
		
		try {
			if(resultSet.next()){
				
				Tips tip=new Tips();
				tip.setTid(resultSet.getInt(1));
				tip.setType(resultSet.getInt(2));
				tip.setTxt(resultSet.getString(3));
				tip.setTitle(resultSet.getString(4));
				 tip.setImage(resultSet.getInt(5));
				
				return tip;
			}else{
				return null;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			this.connectionmanager.closeConnection(conn);
		}
	
	}

}
