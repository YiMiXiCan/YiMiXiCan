package com.nankai.yimixican.po;
/**
 * 文件名：DailyCard.java 
 * 功能说明：每日习惯打卡类
 * 作者：谭米玲
 * 时间：2015-06-02 15:25
 * */
public class DailyCard {
	private int dailyID;
	private int userID;
	private int habitID;
	private String finishTime;
	
	private String habitName;

	public DailyCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DailyCard(int dailyID, int userID, int habitID, String finishTime,
			String habitName) {
		super();
		this.dailyID = dailyID;
		this.userID = userID;
		this.habitID = habitID;
		this.finishTime = finishTime;
		this.habitName = habitName;
	}

	/**
	 * @return the dailyID
	 */
	public int getDailyID() {
		return dailyID;
	}

	/**
	 * @param dailyID the dailyID to set
	 */
	public void setDailyID(int dailyID) {
		this.dailyID = dailyID;
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
	 * @return the finishTime
	 */
	public String getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
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
		return "DailyCard [dailyID=" + dailyID + ", userID=" + userID
				+ ", habitID=" + habitID + ", finishTime=" + finishTime
				+ ", habitName=" + habitName + "]";
	}
	
	
}
