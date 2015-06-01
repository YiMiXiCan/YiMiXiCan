package com.nankai.yimixican.po;

import java.io.Serializable;

public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uid;
	private String username;
	private String regtime;
	private int gender;
	private int age;
	private int rank;
	private String remark;
	private String password;
	private float height;
	private float weight;
	private String head_photo;
	private String segtime;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int uid, String username, String regtime, int gender, int age,
			int rank, String remark, String password, float height,
			float weight, String head_photo, String segtime) {
		super();
		this.uid = uid;
		this.username = username;
		this.regtime = regtime;
		this.gender = gender;
		this.age = age;
		this.rank = rank;
		this.remark = remark;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.head_photo = head_photo;
		this.segtime = segtime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getHead_photo() {
		return head_photo;
	}
	public void setHead_photo(String head_photo) {
		this.head_photo = head_photo;
	}
	public String getSegtime() {
		return segtime;
	}
	public void setSegtime(String segtime) {
		this.segtime = segtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", regtime="
				+ regtime + ", gender=" + gender + ", age=" + age + ", rank="
				+ rank + ", remark=" + remark + ", password=" + password
				+ ", height=" + height + ", weight=" + weight + ", head_photo="
				+ head_photo + ", segtime=" + segtime + "]";
	}
	
	
	
}
