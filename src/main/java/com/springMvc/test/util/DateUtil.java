/**   
 * @Title: DateUtil.java 
 * @Package com.xd100.function.util 
 * @Description: 
 * @author xiaoyu Mo (liujun) 
 * @date 2014-3-7 上午10:28:48 
 */
package com.springMvc.test.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/** 
 * @ClassName: DateUtil 
 * @Description: 时间工具类
 * @author xiaoyu Mo (liujun) 
 * @date 2014-3-7 上午10:28:48  
 * 
 */
public class DateUtil {

	/**
	 * 私有构造函数，表示不可实例化
	 */
	private DateUtil() {
	}

	public static Timestamp  getFisrt(){
		Calendar   cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);
		
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");

		return new Timestamp(toDateTime(format.format(cal_1.getTime())+" 00:00:00").getTime());
	}

	public static Timestamp  getLast(){
		Calendar cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH, cal_1.getActualMaximum(Calendar.DAY_OF_MONTH));
		
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");

		return new Timestamp(toDateTime(format.format(cal_1.getTime())+" 23:59:59").getTime()+999);
	}


	public static String  getDateStr(Timestamp timestamp){
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(timestamp);
	}


	/**
	 * 返回一个当前的时间，并按格式转换为字符串 例：17:27:03
	 * 
	 * @return String
	 */
	public static String getTime() {
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dNow = gcNow.getTime();
		DateFormat timeDF = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return timeDF.format(dNow);
	}

	/**
	 * 返回一个当前日期，并按格式转换为字符串 例：2009-12-12
	 * 
	 * @return String
	 */
	public static String getDate() {
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dNow = gcNow.getTime();
		DateFormat dateDF = DateFormat. getDateInstance(
		        DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return dateDF.format(dNow);
	}

	/**
	 * 返回一个当前日期和时间，并按格式转换为字符串 例：2009-12-08 14:27:03
	 * 
	 * @return String
	 */
	public static String getDateTime() {
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dNow = gcNow.getTime();
		DateFormat datetimeDF = DateFormat.getDateTimeInstance(
		        DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return datetimeDF.format(dNow);
	}

	/**
	 * 返回当前年的年号
	 * 
	 * @return int
	 */
	public static int getYear() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.YEAR);
	}

	/**
	 * 返回本月月号：从 0 开始
	 * 
	 * @return int
	 */
	public static int getMonth() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.MONTH);
	}

	/**
	 * 返回今天是本月的第几天
	 * 
	 * @return int 从1开始
	 */
	public static int getToDayOfMonth() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * 返回一格式化的日期
	 * 
	 * @param date
	 *            java.util.Date
	 * @return String yyyy-mm-dd 格式
	 */
	public static String formatDate(Date date) {
	    SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	/**
	 * 返回一格式化的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(long date) {
		return formatDate(new Date(date));
	}

	/**
	 * 返回一格式化的时间
	 * 
	 * @param date
	 *            Date
	 * @return String hh:ss:mm 格式
	 */
	public static String formatTime(Date date) {
	    DateFormat timeDF = DateFormat.getTimeInstance(
	            DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return timeDF.format(date);
	}

	/**
	 * 返回一格式化的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTime(long date) {
		return formatTime(new Date(date));
	}

	/**
	 * 返回一格式化的日期时间
	 * 
	 * @param date
	 *            Date
	 * @return String yyyy-mm-dd hh:mm:ss 格式
	 */
	public static String formatDateTime(Date date) {
	    DateFormat datetimeDF = DateFormat.getDateTimeInstance(
	            DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return datetimeDF.format(date);
	}

	/**
	 * 返回一格式化的日期时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTime(long date) {
		return formatDateTime(new Date(date));
	}

	/**
	 * 将字串转成日期和时间，字串格式: yyyy-MM-dd HH:mm:ss
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */
	public static Date toDateTime(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return (Date) formatter.parse(string);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * 将字串转成日期和时间，字串格式: yyyy-MM-dd HH:mm:ss
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */
	public static Date toDateTimeTwo(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			return (Date) formatter.parse(string);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将字串转成日期，字串格式: yyyy-MM-dd
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */
	public static Date toDate(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (Date) formatter.parse(string);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 取值：某日期的年号
	 * 
	 * @param date
	 *            格式: yyyy-MM-dd
	 * @return
	 */
	public static int getYear(String date) {
		Date d = toDate(date);
		if (d == null)
			return 0;
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		calendar.setTime(d);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 取值：某日期的月号
	 * 
	 * @param date
	 *            格式: yyyy-MM-dd
	 * @return 从0开始
	 */
	public static int getMonth(String date) {
		Date d = toDate(date);
		if (d == null)
			return 0;
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		calendar.setTime(d);
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * 取值：某日期的日号
	 * 
	 * @param date
	 *            格式: yyyy-MM-dd
	 * @return 从1开始
	 */
	public static int getDayOfMonth(String date) {
		Date d = toDate(date);
		if (d == null)
			return 0;
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 计算两个日期的年数差
	 * 
	 * @param one
	 *            格式: yyyy-MM-dd
	 * @param two
	 *            格式: yyyy-MM-dd
	 * @return
	 */
	public static int compareYear(String one, String two) {
		return getYear(one) - getYear(two);
	}

	/**
	 * 计算岁数
	 * 
	 * @param date
	 *            格式: yyyy-MM-dd
	 * @return
	 */
	public static int compareYear(String date) {
		return getYear() - getYear(date);
	}
	
	/**
	 * 使用format格式化Date对象为字符串
	 * 
	 * @param date
	 *            date
	 * @return String
	 */ 
	public static String getDateString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	/**
	 * 使用format格式化Date对象为字符串
	 * 
	 * @param date
	 *            date
	 * @return String
	 */ 
	public static String getFullDateString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}  
	
	/**
	 * 使用format格式化Date对象为字符串,获取年份
	 * 
	 * @param date
	 *            date
	 * @return String
	 */
	public static String getYear(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}  
	
	/**
	 * 使用format格式化Date对象为字符串,获取中文表示的年月日
	 * 
	 * @param date
	 *            date
	 * @return String 2009年12月08日
	 */
	public static String getDateStrC(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		return format.format(date);
	}
  
	/**
	 * 使用format格式化Date对象为字符串,获取年份
	 * 
	 * @param date
	 *            date
	 * @return String 20091208
	 */
	public static String getDateStrCompact(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String str = format.format(date);
		return str;
	}   
	
	/**
	 * 使用format格式化Date对象为字符串,获取年月日和时间
	 * 
	 * @param date
	 *            date
	 * @return String 2009年12月8日 14时03分10秒
	 */
	public static String getDateTimeStrC(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return format.format(date);
	}
  
	/**
	 * 获取指定日期后下一个月的第一天
	 * 
	 *            .sql.Date date
	 * @return java.sql.Date
	 */
	public static java.sql.Date getNextMonthFirstDate(Date date)
			throws ParseException {
		Calendar scalendar = new GregorianCalendar();
		scalendar.setTime(date);
		scalendar.add(Calendar.MONTH, 1);
		scalendar.set(Calendar.DATE, 1);
		return new java.sql.Date(scalendar.getTime().getTime());
	}   

	/**
	 * 获取指定日期的前面几天
	 * 
	 *            .sql.Date date
	 * @param dayCount
	 *            表示前几天
	 * @return java.sql.Date
	 */
	public static java.sql.Date getFrontDateByDayCount(java.sql.Date date,
			int dayCount) throws ParseException {
		Calendar scalendar = new GregorianCalendar();
		scalendar.setTime(date);
		scalendar.add(Calendar.DATE, -dayCount);
		return new java.sql.Date(scalendar.getTime().getTime());
	}
 
	/**
	 * 取得指定年份和月份的第一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return Date
	 */
	public static Date getFirstDay(String year, String month)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(year + "-" + month + "-1");
	}  
	
	/**
	 * 取得指定年份和月份的第一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return Date
	 */
	public static Date getFirstDay(int year, int month) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(year + "-" + month + "-1");
	}   
	
	/**
	 * 取得指定年份和月份的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return Date
	 */
	public static Date getLastDay(String year, String month)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(year + "-" + month + "-1");

		Calendar scalendar = new GregorianCalendar();
		scalendar.setTime(date);
		scalendar.add(Calendar.MONTH, 1);
		scalendar.add(Calendar.DATE, -1);
		date = scalendar.getTime();
		return date;
	}   
	
	/**
	 * 取得指定年份和月份的最后一天
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return Date
	 */
	public static Date getLastDay(int year, int month) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(year + "-" + month + "-1");
		Calendar scalendar = new GregorianCalendar();
		scalendar.setTime(date);
		scalendar.add(Calendar.MONTH, 1);
		scalendar.add(Calendar.DATE, -1);
		date = scalendar.getTime();
		return date;
	}  
	
	/**
	 * 取得指定年份之间的相隔月数
	 * 
	 * @return Date
	 */
	public static long getDistinceMonth(String beforedate, String afterdate)
			throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		long monthCount = 0;
		try {
			Date before = d.parse(beforedate);
			Date after = d.parse(afterdate);
			monthCount = (Integer.parseInt(DateUtil.getYear(after)) - Integer
					.parseInt(DateUtil.getYear(before)))
					* 12
					+ DateUtil.getMonth(afterdate)
					- DateUtil.getMonth(beforedate);
		} catch (ParseException e) {
			System.out.println("Date parse error!");
		}
		return monthCount;
	}  
	
	/**
	 * 取得指定年份之间的相隔天数
	 * 
	 * @return Date
	 */
	public static long getDistinceDay(String beforedate, String afterdate)
			throws ParseException {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		long dayCount = 0;
		try {
			Date d1 = d.parse(beforedate);
			Date d2 = d.parse(afterdate);
			dayCount = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			System.out.println("Date parse error!");
		}
		return dayCount;
	}
	
	 /**
	 * 指定日期加减天数
	 * 
	 * @param date
	 * @param day 加一天就传入1  减一天就传入-1
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date getDaytoDay(Date date,int day){
			if(date==null)
				return date;
		 	Calendar calendar = new GregorianCalendar();
		 	calendar.setTime(date); 
		 	calendar.add(calendar.DATE,day);
		 	date=calendar.getTime();
		 	return date;
	}
	
	@SuppressWarnings("static-access")
	public static Date getMonthtoMonth(Date date,int day){
		if(date==null)
			return date;
	 	Calendar calendar = new GregorianCalendar();
	 	calendar.setTime(date); 
	 	calendar.add(calendar.MONTH,day);
	 	date=calendar.getTime();
	 	return date;
	}
	
	/**
	 * @Title: getTime
	 * @Description: 得到两个时间之间的时间具体列表
	 * @param: @param starttime
	 * @param: @param endtime
	 * @param: @return 
	 * @return: List<String> 返回类型
	 * @throws:
	 */
	public static List<String> getEveryDay(String startTime, String endTime) {
		List<String> dayList = new ArrayList<String>();
		dayList.add(formatDate(toDate(startTime)));
		long end = toDate(endTime).getTime();
		long sta = toDate(startTime).getTime();
		if(end<sta){
			return null;
		}else if(end==sta){
			return dayList;
		}else{
			dayList = getd(end, sta, dayList);
			dayList.add(formatDate(toDate(endTime)));
			return dayList;
		}
	}
	private  static List<String> getd(Long end ,Long sta,List<String> list ){
		if(sta+(24*60*60*1000)<end){
			list.add(formatDate(sta + (24 * 60 * 60 * 1000)));
			getd(end, sta+(24*60*60*1000), list);
		}
		return list;
	}

	private  static List<String> getdTwo(Long end ,Long sta,List<String> list ){
		if(sta+(24*60*60*1000)<end){
		    SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
			list.add(format.format(new Date(sta+(24*60*60*1000))));
			getd(end, sta+(24*60*60*1000), list);
		}
		return list;
	}

	public static List<String> getEveryDayTwo(String startTime, String endTime) {

		List<String> dayList = new ArrayList<String>();
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		dayList.add(format.format(toDate(startTime)));
		long end = toDate(endTime).getTime();
		long sta = toDate(startTime).getTime();
		if(end<sta){
			return null;
		}else if(end==sta){
			return dayList;
		}else{
			dayList = getdTwo(end, sta, dayList);
			dayList.add(format.format(toDate(endTime)));
			return dayList;
		}
	}
	
	/**
	 * @Title: stringToDate
	 * @Description: 字符串转换为date
	 * @param: @param str
	 * @param: @return 
	 * @return: Date yyyy-MM-dd 格式返回类型
	 */
	public static Date stringToDate(String str) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取当年的第一天
	 * @return
	 */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取当年的最后一天
	 * @return
	 */
	public static Date getCurrYearLast(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearLast(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 某月的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastday_Month(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date theDate = calendar.getTime();

		//上个月最后一天
		calendar.add(Calendar.MONTH, 1);    //加一个月
		calendar.set(Calendar.DATE, 1);        //设置为该月第一天
		calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
		String day_last = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
		day_last = endStr.toString();
		return day_last;
	}

	/**
	 * 当月第一天
	 * @return
	 */
	public static String getFirstDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
		return str.toString();

	}

	/**
	 * 当月最后一天
	 * @return
	 */
	public static String getLastDay() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();
		String s = df.format(theDate);
		StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
		return str.toString();

	}

	/**
	 * 当月最后一天
	 * @return
	 */
	public static Timestamp getLastTimestamp() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date theDate = calendar.getTime();
		String s = df.format(theDate);
		StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
		return new Timestamp(toDateTime(str.toString()).getTime()+999);

	}

	/**
	 * @Title: dateToString2
	 * @Description: date转换为string
	 * @param: @param date
	 * @return: String yyyy-MM-dd返回类型
	 */
	public static String dateToString(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	/**
	* @Title: getYesterday 获得昨天的时间
	* @Description: getYesterday
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	* @author ZengLiming
	 */
	public static String getYesterday(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(new Date().getTime()-(24*60*60*1000)));
	}
	
	public static Date getYesterdayDate(){
		return  new Date(new Date().getTime()-(24*60*60*1000));
	}
	
	public static Long getYesterdayLong(){
		String yesterday =  getYesterday()+" 00:00:00";
		return toDateTime(yesterday).getTime();
	}
	public static Long getYesterdayLongEnd(){
		String yesterday =  getYesterday()+" 23:59:59";
		return toDateTime(yesterday).getTime();
	}
	
	public static Long getNowDayLong(){
		String yesterday =  getNowDay()+" 00:00:00";
		return toDateTime(yesterday).getTime();
	}
	public static Long getNowDayEndLong(){
		String yesterday =  getNowDay()+" 23:59:59";
		return toDateTime(yesterday).getTime();
	}
	
	/**
	* @Title: getYesterday 获得今天的时间
	* @Description: getYesterday
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	* @author ZengLiming
	 */
	public static String getNowDay(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	public static String getQuartz(String string) {
		return new SimpleDateFormat("ss mm HH dd MM ? yyyy").format(toDateTime(string));
	}
	public static String getQuartz(Long date) {
		return new SimpleDateFormat("ss mm HH dd MM ? yyyy").format(new Date(date));
	}
	public static String getQuartz(Date date) {
		return new SimpleDateFormat("ss mm HH dd MM ? yyyy").format(date);
	}

	/** * 获取指定日期是星期几
	  * 参数为null时表示获取当前日期是星期几
	  * @param date
	  * @return
	*/
	public static String getWeekOfDate(Date date) {      
	    String[] weekOfDays = {"日", "一", "二", "三", "四", "五", "六"};        
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(date);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    
	}

	public  static  String formDateDays(Timestamp date){
	    long day = 24*60*60*1000;
		long nowTime = System.currentTimeMillis();
		long time = date.getTime();
		long nowTime2=nowTime%day==57600000?nowTime/day+1:nowTime/day;
		long time2=time%day==57600000?time/day+1:time/day;
		if(nowTime2==time2){
			return "1天";
		}else{
			return (nowTime2-time2+1)+"天";
		}
	}
	public  static  String formDateDays2(Timestamp date){
	    long day = 24*60*60*1000;
		long nowTime = System.currentTimeMillis();
		long time = date.getTime();
		long nowTime2=nowTime%day==57600000?nowTime/day+1:nowTime/day;
		long time2=time%day==57600000?time/day+1:time/day;
		if(nowTime2==time2){
			return "今天";
		}else{
			if((time2-nowTime2+1)<0){
				return (nowTime2-time2)+"天前";
			}
			return (time2-nowTime2)+"天后";
		}
	}
	public  static  String formDateByw(Object obj){
		Date date = null;
		if(obj instanceof String){
			date = toDateTime(obj.toString());
		}else if(obj instanceof Timestamp){
			date = (Timestamp)obj;
		}else if(obj instanceof Date){
			date = (Date)obj;
		}else if(obj instanceof Long){
			date = new Date((Long) obj);
		}
		Calendar calendar = Calendar.getInstance();
		int year = calendar.getWeeksInWeekYear();
		if(year!=date.getYear()+1900){
		    SimpleDateFormat yaerdata  = new SimpleDateFormat("yy年MM月dd日");
			return yaerdata.format(date);
		}else{
			Calendar cal1=Calendar.getInstance();
			cal1.add(Calendar.MONTH, -1);
			Calendar cal2=Calendar.getInstance();
			cal2.add(Calendar.MONTH, -2);
			Calendar cal3=Calendar.getInstance();
			cal3.add(Calendar.MONTH, -3);
			if(cal3.getTimeInMillis()>=date.getTime()){
			    SimpleDateFormat montydata  = new SimpleDateFormat("MM月dd日");
				return montydata.format(date);
			}else if(cal2.getTimeInMillis()>=date.getTime()){
				return "2个月前";
			}else if(cal1.getTimeInMillis()>=date.getTime()){
				return "1个月前";
			}else{
			    SimpleDateFormat hdate  = new SimpleDateFormat("HH点");
				long day = 24*60*60*1000;
				long nowTime = System.currentTimeMillis();
				long time = date.getTime();
				long nowTime2=nowTime%day==57600000?nowTime/day+1:nowTime/day;
				long time2=time%day==57600000?time/day+1:time/day;
				if(nowTime2==time2){
					return "今天"+hdate.format(date);
				}else if(nowTime2-1==time2){
					return "昨天"+hdate.format(date);
				}else if(nowTime2-2==time2){
					return "前天"+hdate.format(date);
				}else if(nowTime2-3==time2){
					return "3天前";
				}else if(nowTime2-4==time2){
					return "4天前";
				}else if(nowTime2-5==time2){
					return "5天前";
				}else if(nowTime2-6==time2){
					return "6天前";
				}else if((nowTime2-time2)>=7 && (nowTime2-time2) <15){
					return "1周前";
				}else if((nowTime2-time2)>=15 && (nowTime2-time2) <21){
					return "2周前";
				}else if((nowTime2-time2)>=21 && (nowTime2-time2) <28){
					return "3周前";
				}else if((nowTime2-time2)>=28){
					return "4周前";
				}
			}
		}
		return "";
	}
}
