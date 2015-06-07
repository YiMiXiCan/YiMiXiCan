package com.nankai.yimixican.po;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Tips implements Serializable {
private int tid;
private int type;
private String title;
private String txt;
private int image;
public Tips() {
	super();
	// TODO Auto-generated constructor stub
}
public Tips(int tid, int type, String title, String txt,int image) {
	super();
	this.tid = tid;
	this.type = type;
	this.title = title;
	this.txt = txt;
	this.image=image;
}

public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTxt() {
	return txt;
}
public void setTxt(String txt) {
	this.txt = txt;
}
public int getImage() {
	return image;
}
public void setImage(int image) {
	this.image = image;
}
@Override
public String toString() {
	return "Tips [tid=" + tid + ", type=" + type + ", title=" + title
			+ ", txt=" + txt + ",image="+image+"]";
}

}
