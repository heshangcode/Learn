package com.hs.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 扩展DateUtils的基础上扩展属于自己的工具类
 *造轮子
 * @author 刘文铭
 * @see com.shxt.commons.helper.DateHelper
 * @since 1.0
 */

public final class DateHelper extends DateUtils {
	private final static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
			"yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	private final static String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:dd";
	private final static String DEFAULT_DATE = "yyyy-MM-dd";
	private final static String DEFAULT_TIME = "HH:mm:dd";
	private final static String DEFAULT_YEAR = "yyyy";
	private final static String DEFAULT_MONTH = "MM";
	private final static String DEFAULT_DAY = "dd";
	private final static String DEFAULT_E = "E";

	private static Date nowDate = new Date();

	private static Calendar calendar = Calendar.getInstance();

	/**
	 * java.util.Date转换格式（yyyy-MM-dd）
	 *
	 * @return String
	 */
	public static String getCurrentDate() {
		return DateHelper.getDefDateTime(DEFAULT_DATE);
	}

	/**
	 * java.util.Date转换格式（HH:mm:ss）
	 *
	 * @return String
	 */
	public static String getCurrentTime() {
		return DateHelper.getDefDateTime(DEFAULT_TIME);
	}

	/**
	 * java.util.Date转换格式（yyyy-MM-dd HH:mm:ss）
	 *
	 * @return String
	 */
	public static String getCurrentDateTime() {
		return DateHelper.getDefDateTime(DEFAULT_DATE_TIME);
	}

	/**
	 * 获取自定义格式的当前日期
	 * <p>
	 * 获取特定格式的日期
	 * </p>
	 *
	 * @param pattern 默认格式（yyyy-MM-dd） 可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @return String
	 */
	public static String getDefDateTime(String pattern) {
		return DateFormatUtils.format(nowDate, pattern);
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 *
	 * @return String
	 */
	public static String getYear() {
		return DateHelper.getDefDateTime(DEFAULT_YEAR);
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 *
	 * @return String
	 */
	public static String getMonth() {
		return DateHelper.getDefDateTime(DEFAULT_MONTH);
	}

	/**
	 * 得到当天字符串 格式（dd）
	 *
	 * @return String
	 */
	public static String getDay() {
		return DateHelper.getDefDateTime(DEFAULT_DAY);
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 *
	 * @return String
	 */
	public static String getWeek() {
		return DateHelper.getDefDateTime(DEFAULT_E);
	}

	/**
	 * 获取日期字符串,java.util.Date转化为字符串
	 * <p>
	 * 使用格式化数据,
	 * </p>
	 *
	 * @param date
	 * @param pattern 默认格式（yyyy-MM-dd） 可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @return String
	 */
	public static String formatDate(Date date, String... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString().trim());
		} else {
			formatDate = DateFormatUtils.format(date, DEFAULT_DATE);
		}
		return formatDate;
	}

	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object date_str) {
		try {
			if (date_str == null || String.valueOf(date_str).trim().length() == 0) {
				return null;
			}
			return DateUtils.parseDate(String.valueOf(date_str).trim(), parsePatterns);
		} catch (ParseException pe) {
			System.out.println("DateHelper-->parseDate方法格式化错误");
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 *
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 *
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 *
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 *
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = timeMillis / (60 * 60 * 1000) - day * 24;
		long min = timeMillis / (60 * 1000) - day * 24 * 60 - hour * 60;
		long s = timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
		long sss = timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000;
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取当前日期,一周前的日期字符串
	 *
	 * @return String
	 */
	public static String getLastWeek() {
		long rightnow = calendar.getTimeInMillis();
		long aweekbefore = 6 * 24 * 60 * 60 * 1000;
		return DateFormatUtils.format(rightnow - aweekbefore, DEFAULT_DATE);
	}

	/**
	 * 获取格式化当前月第一天的表达式
	 *
	 * @return String
	 */
	public static String getFirstDayInMonth() {
		calendar.set(DateHelper.getYearNUM(), DateHelper.getMonthNUM() - 1, 1);// 设为当前月的1号 ，月从0开始
		return DateFormatUtils.format(calendar.getTime(), DEFAULT_DATE);
	}

	/**
	 * 获取格式化给定月(参数：逻辑月)第一天的表达式，重载方法
	 *
	 * @param month
	 * @return String
	 */
	public static String getFirstDayInMonth(int month) {
		calendar.set(DateHelper.getYearNUM(), month - 1, 1);// 设为当前月的1号 ，月从0开始
		return DateFormatUtils.format(calendar.getTime(), DEFAULT_DATE);
	}

	/**
	 * 获取格式化给定月(参数：逻辑月)最后一天的表达式
	 *
	 * @param month
	 * @return String
	 */
	public static String getLastDayInMonth(int month) {
		calendar.set(DateHelper.getYearNUM(), month, 1); // 设成下个月的一号，往前减一天的时间
		return DateFormatUtils.format(calendar.getTimeInMillis() - 24 * 60 * 60 * 1000, DEFAULT_DATE);
	}

	/**
	 * 获取格式化当前季度第一天的表达式
	 *
	 * @return String
	 */
	public static String getFirstDayInQuart() {
		int month = DateHelper.getMonthNUM();
		if (month >= 1 && month <= 3) {
			month = 1;
		}
		if (month >= 4 && month <= 6) {
			month = 4;
		}
		if (month >= 7 && month <= 9) {
			month = 7;
		}
		if (month >= 10 && month <= 12) {
			month = 10;
		}
		calendar.set(DateHelper.getYearNUM(), month - 1, 1); // 当年当季一号，月从0开始
		return DateFormatUtils.format(calendar.getTime(), DEFAULT_DATE);
	}

	/**
	 * @return String 获取格式化一年第一天的表达式
	 */
	public static String getFirstDayInYear() { /** 获取格式化一年第一天的表达式 **/
		calendar.set(calendar.get(Calendar.YEAR), 0, 1); // 当年第一个月一号，月从0开始
		return DateFormatUtils.format(calendar.getTime(), DEFAULT_DATE);
	}

	/**
	 * @return int 获得当前年份
	 */
	public static int getYearNUM() { /** 获得当前年份 */
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * @return int 获得当前月份
	 */
	public static int getMonthNUM() { /*** 获得当前月份 **/
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * @return int 获得当前周数
	 */
	public static int getWeekNUM() { /*** 获得当前周数 **/
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * @return int 取到一天中的小时数
	 */
	public static int getHoursofDay() {
		return Calendar.HOUR_OF_DAY;
	}

	/**
	 * 获取最近ndays天(含今天)的日期，返回日期表达式数组
	 *
	 * @param ndays
	 * @return String[]
	 */
	public static String[] getDaysBackward(int ndays) {
		String[] daysBackward = new String[ndays];
		Calendar lastDate;
		for (int i = 0; i < ndays; i++) {
			lastDate = Calendar.getInstance();
			lastDate.add(Calendar.DATE, -1 * i); // 减去一天，变为上月最后一天
			daysBackward[ndays - 1 - i] = DateFormatUtils.format(lastDate.getTimeInMillis(), DEFAULT_DATE);
		}
		return daysBackward;
	}

}
