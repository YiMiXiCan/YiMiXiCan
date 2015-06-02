package com.nankai.yimixican.biz;
/**
 * 文件名：IDailyCardBiz.java
 * 功能说明：biz层调用dao层IDailyCardDao方法实现对daily_card（每日打卡）数据库处理操作，包括：添加、删除、按用户和时间查询、计数
 * 作者：谭米玲
 * 时间：2015-06-02 15:30
 * */
import java.util.List;

import com.nankai.yimixican.po.DailyCard;

public interface IDailyCardBiz {
	public abstract boolean insert(DailyCard dailyCard);
	public abstract boolean delete(int dailyID);
	public abstract List<String> select(int userID);
	public abstract int countByUserId(int userID);

}
