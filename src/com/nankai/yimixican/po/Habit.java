package com.nankai.yimixican.po;

/**
 * 文件名：Habit.java
 * 功能说明：小习惯类
 * 作者：谭米玲
 * 时间：2015-06-01 20:33
 * */
public class Habit {
	private int hibitID;//习惯ID
	private int classID;//类ID，1:饮食  2:生活  3:运动
	private String name;//习惯名称
	public Habit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Habit(int hibitID, int classID, String name) {
		super();
		this.hibitID = hibitID;
		this.classID = classID;
		this.name = name;
	}
	/**
	 * @return the hibitID
	 */
	public int getHibitID() {
		return hibitID;
	}
	/**
	 * @param hibitID the hibitID to set
	 */
	public void setHibitID(int hibitID) {
		this.hibitID = hibitID;
	}
	/**
	 * @return the classID
	 */
	public int getClassID() {
		return classID;
	}
	/**
	 * @param classID the classID to set
	 */
	public void setClassID(int classID) {
		this.classID = classID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Habit [hibitID=" + hibitID + ", classID=" + classID + ", name="
				+ name + "]";
	}
	
}
