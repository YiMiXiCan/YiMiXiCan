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
	private String remind;
	private String password;
	private float height;
	private float weight;
	private String remindtime;
	private String repassword;
	private String declaration;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int uid, String username, String regtime, int gender, int age,
			int rank, String remind, String password, float height,
			float weight, String remindtime, String repassword,
			String declaration) {
		super();
		this.uid = uid;
		this.username = username;
		this.regtime = regtime;
		this.gender = gender;
		this.age = age;
		this.rank = rank;
		this.remind = remind;
		this.password = password;
		this.height = height;
		this.weight = weight;
		this.remindtime = remindtime;
		this.repassword = repassword;
		this.declaration = declaration;
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
	public String getRemind() {
		return remind;
	}
	public void setRemind(String remind) {
		this.remind = remind;
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
	public String getRemindtime() {
		return remindtime;
	}
	public void setRemindtime(String remindtime) {
		this.remindtime = remindtime;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getDeclaration() {
		return declaration;
	}
	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", regtime="
				+ regtime + ", gender=" + gender + ", age=" + age + ", rank="
				+ rank + ", remind=" + remind + ", password=" + password
				+ ", height=" + height + ", weight=" + weight + ", remindtime="
				+ remindtime + ", repassword=" + repassword + ", declaration="
				+ declaration + "]";
	}
	

}
