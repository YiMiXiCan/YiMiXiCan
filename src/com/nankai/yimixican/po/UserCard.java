package com.nankai.yimixican.po;
/**
 * 文件名：UserCard.java
 * 功能说明：用户选定的习惯
 * 作者：谭米玲
 * 时间：2015-06-02 22:00
 * */
public class UserCard { 
	private int userID;//用户ID
	private int habitID;//习惯ID
	private String habitName;//习惯名
	public UserCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCard(int userID, int habitID, String habitName) {
		super();
		this.userID = userID;
		this.habitID = habitID;
		this.habitName = habitName;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the habitID
	 */
	public int getHabitID() {
		return habitID;
	}
	/**
	 * @param habitID the habitID to set
	 */
	public void setHabitID(int habitID) {
		this.habitID = habitID;
	}
	/**
	 * @return the habitName
	 */
	public String getHabitName() {
		return habitName;
	}
	/**
	 * @param habitName the habitName to set
	 */
	public void setHabitName(String habitName) {
		this.habitName = habitName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCard [userID=" + userID + ", habitID=" + habitID
				+ ", habitName=" + habitName + "]";
	}
	
}
