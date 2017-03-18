package com.android.framewok.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lizhixian on 2017/3/18.
 */

public class DateTools extends SimpleDateFormat{

    private static final long serialVersionUID = -2987750868895651661L;

    /**
     * 时间格式为yyyy/MM/dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式为yyyyMMddHHmmssSSS
     */
    public static final String YYYYMMDDHHMMSSS="yyyyMMddHHmmssSSS";

    public static final String YYMMDDHHMMSSS="yyMMddHHmmssSSS";
    /**
     * 时间格式为yyyy-MM-dd HH:mm:ss.sss
     */
    public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 时间格式为yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * 时间格式为yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 时间格式为ddHHmmss
     */
    public static final String DDHHMMSS = "ddHHmmss";

    /**
     * 时间格式为yyyy-MM-dd HH:mm
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * 时间格式为yyyy-MM-dd HH
     */
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    /**
     * 年份格式为yyyy
     */
    public static final String YYYY = "yyyy";
    /**
     * 年份格式为yyyy
     */
    public static final String MM_DD = "MM-dd";
    /**
     * 年份格式为yyyy
     */
    public static final String MY_DR = "MM月-dd日";

    /**
     * DATETOOL
     */
    private static DateTools dateTools = null;

    /**
     * 日历类
     */
    private final static Calendar calendar = Calendar.getInstance();

    /**
     * <默认私有构造函数>
     */
    private DateTools(){
        super(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * <默认构造函数>
     * @param mode 模态
     */
    private DateTools(String mode){
        super(mode);
    }

    /**
     * 此类构造的日期工具类不可以格式化日期
     * @return DateTools
     */
    public static DateTools getDateTools(){
        if (null == dateTools){
            dateTools = new DateTools();
        }
        return dateTools;
    }

    /**
     * 此类构造的日期工具类可以格式化日期
     * @param mode mode模式 以哪种时间模式去创建或转换
     * @return DateTools
     */
    public static DateTools getDateTools(String mode){
        if (null == dateTools){
            dateTools = new DateTools(mode);
        }
        return dateTools;
    }

    /**
     * 得到会传入日期的月份
     * @param date 日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getMonth(Date date) throws ParseException{
        setCalendar(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到会传入日期的年份
     * @param date 日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getYear(Date date) throws ParseException{
        setCalendar(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到会传入日期的是日期所在月的哪一天
     * @param date 日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getDate(Date date) throws ParseException	{
        setCalendar(date);
        return calendar.get(Calendar.DATE) + 1;
    }

    /**
     * 得到会传入日期的分钟
     * @param date 日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getMinute(Date date) throws ParseException{
        setCalendar(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 得到会传入日期的小时
     * @param date 日期
     * @param isStandard 是否是24小时制的,true:是
     * @return int
     * @throws ParseException ParseException
     */
    public static int getHour(Date date, boolean isStandard) throws ParseException	{
        setCalendar(date);
        if (isStandard){
            return calendar.get(Calendar.HOUR_OF_DAY);
        }else{
            return calendar.get(Calendar.HOUR);
        }
    }

    /**
     * 得到传入日期的小时
     * @param date 日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getSecond(Date date) throws ParseException{
        setCalendar(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 得到传入日期的月份
     * @param strDate 字符串日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getMonth(String strDate) throws ParseException{
        setCalendar(strDate);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到传入日期的年份
     * @param strDate 字符串日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getYear(String strDate) throws ParseException{
        setCalendar(strDate);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到传入日期的是日期所在月的哪一天
     * @param strDate 字符串日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getDate(String strDate) throws ParseException{
        setCalendar(strDate);
        return calendar.get(Calendar.DATE) + 1;
    }

    /**
     * 得到传入日期的分钟
     * @param strDate 字符串日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getMinute(String strDate) throws ParseException{
        setCalendar(strDate);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 得到传入日期的小时
     * @param strDate 字符串日期
     * @param isStandard 是否是24小时制的,true:是
     * @return int
     * @throws ParseException ParseException
     */
    public int getHour(String strDate, boolean isStandard) throws ParseException{
        setCalendar(strDate);
        if (isStandard){
            return calendar.get(Calendar.HOUR_OF_DAY);
        }else{
            return calendar.get(Calendar.HOUR);
        }
    }

    /**
     * 得到传入日期的小时
     * @param strDate 字符串日期
     * @return int
     * @throws ParseException ParseException
     */
    public int getSecond(String strDate) throws ParseException {
        setCalendar(strDate);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 在原有的时间小时上加上或减去多少
     * @param date 原有时间
     * @param levevHour 要加减的小时数
     * @param isStandard 是还是24小时制
     * @return Date
     */
    public Date operationHour(Date date, int levevHour, boolean isStandard){
        setCalendar(date);
        if (isStandard){
            calendar.add(Calendar.HOUR_OF_DAY, levevHour);
        }else{
            calendar.add(Calendar.HOUR, levevHour);
        }
        return calendar.getTime();
    }

    /**
     * 在原有的时间分钟上加上或减去多少
     * @param date 原有时间
     * @param levevMinute 要加减的分钟数
     * @return Date
     */
    public Date operationMinute(Date date, int levevMinute){
        setCalendar(date);
        calendar.add(Calendar.MINUTE, levevMinute);
        return calendar.getTime();
    }

    /**
     * 在原有的时间年份上加上或减去多少
     * @param date 原有时间
     * @param levevYear 要加减的年份数
     * @return Date
     */
    public Date operationYear(Date date, int levevYear) {
        setCalendar(date);
        calendar.add(Calendar.YEAR, levevYear);
        return calendar.getTime();
    }

    /**
     * 在原有的时间月份上加上或减去多少
     * @param date 原有时间
     * @param levevMonth 要加减的月份数
     * @return Date
     */
    public Date operationMonth(Date date, int levevMonth) {
        setCalendar(date);
        calendar.add(Calendar.MONTH, levevMonth);
        return calendar.getTime();
    }

    /**
     * 在原有的时间月份上加上或减去多少
     * @param date 原有时间
     * @param levevDate 要加减的月份数
     * @return Date
     */
    public static Date operationDate(Date date, int levevDate) {
        setCalendar(date);
        calendar.add(Calendar.DATE, levevDate);
        return calendar.getTime();
    }

    /**
     * 在原有的时间秒上加上或减去多少
     * @param date 原有时间
     * @param levevSecond 要加减的秒数
     * @return Date
     */
    public Date operationSecond(Date date, int levevSecond) {
        setCalendar(date);
        calendar.add(Calendar.SECOND, levevSecond);
        return calendar.getTime();
    }

    /**
     * 在原有的时间小时上加上或减去多少(字符串时间)
     * @param strDate 原有时间
     * @param levevHour 要加减的小时数
     * @param isStandard 是还是24小时制
     * @return String
     * @throws ParseException ParseException
     */
    public String operationHour(String strDate, int levevHour, boolean isStandard) throws ParseException {
        setCalendar(strDate);
        if (isStandard){
            calendar.add(Calendar.HOUR_OF_DAY, levevHour);
        } else {
            calendar.add(Calendar.HOUR, levevHour);
        }
        return format(calendar.getTime());
    }

    /**
     * 在原有的时间分钟上加上或减去多少
     * @param strDate 原有时间
     * @param levevMinute 要加减的分钟数
     * @return String
     * @throws ParseException ParseException
     */
    public String operationMinute(String strDate, int levevMinute) throws ParseException {
        setCalendar(strDate);
        calendar.add(Calendar.MINUTE, levevMinute);
        return format(calendar.getTime());
    }

    /**
     * 在原有的时间年份上加上或减去多少
     * @param strDate 原有时间
     * @param levevYear 要加减的年份数
     * @return String
     * @throws ParseException ParseException
     */
    public String operationYear(String strDate, int levevYear) throws ParseException{
        setCalendar(strDate);
        calendar.add(Calendar.YEAR, levevYear);
        return format(calendar.getTime());
    }

    /**
     * 在原有的时间月份上加上或减去多少
     * @param strDate 原有时间
     * @param levevMonth 要加减的月份数
     * @return Date
     * @throws ParseException ParseException
     */
    public String operationMonth(String strDate, int levevMonth) throws ParseException{
        setCalendar(strDate);
        calendar.add(Calendar.MONTH, levevMonth);
        return format(calendar.getTime());
    }

    /**
     * 在原有的时间月份上加上或减去多少
     * @param strDate 原有时间
     * @param levevDate 要加减的月份数
     * @return Date
     * @throws ParseException ParseException
     */
    public String operationDate(String strDate, int levevDate)throws ParseException	{
        setCalendar(strDate);
        calendar.add(Calendar.DATE, levevDate);
        return format(calendar.getTime());
    }

    /**
     * 在原有的时间秒上加上或减去多少
     * @param strDate 原有时间
     * @param levevSecond 要加减的秒数
     * @return Date
     * @throws ParseException ParseException
     */
    public String operationSecond(String strDate, int levevSecond) throws ParseException{
        setCalendar(strDate);
        calendar.add(Calendar.SECOND, levevSecond);
        return format(calendar.getTime());
    }

    /**
     * 返回两个时间段之间的间隔(天)
     * @param srcDate 时间点1
     * @param destDate 时间点2
     * @return int
     * @throws ParseException ParseException
     */
    public int getDaysOperationDate(Date srcDate, Date destDate) throws ParseException{
        return (int)StrictMath.abs((srcDate.getTime() - destDate.getTime()) / 30);
    }

    /**
     * 返回两个时间段之间的间隔(天)
     * @param strSrcDate 时间点1
     * @param strDestDate 时间点2
     * @return int
     * @throws ParseException ParseException
     */
    public int getDaysOperationDate(String strSrcDate, String strDestDate) throws ParseException{
        return (int)StrictMath.abs((parse(strSrcDate).getTime() - parse(strDestDate).getTime()) / 30);
    }

    /**
     * 判断用户输入的时间是否介于两个时间段内
     * @param afterDate 结束时间
     * @param beforeDate 起始时间
     * @param currentDate 用户输入的时间
     * @return boolean true:是介于两个时间段之间
     */
    public boolean compareDate(Date afterDate, Date beforeDate, Date currentDate){
        if (currentDate.after(beforeDate) && currentDate.before(afterDate)){
            return true;
        }
        return false;
    }

    /**
     * 判断用户输入的时间是否介于两个时间段内(字符串时间)
     * @param strAfterDate 结束时间
     * @param strBeforeDate 起始时间
     * @param strCurrentDate 用户输入的时间
     * @return boolean true:是介于两个时间段之间
     * @throws ParseException ParseException
     */
    public boolean compareDate(String strAfterDate, String strBeforeDate, String strCurrentDate) throws ParseException {
        Date currentDate = parse(strCurrentDate);
        if (currentDate.after(parse(strBeforeDate))
                && currentDate.before(parse(strAfterDate))){
            return true;
        }
        return false;
    }

    /**
     * 返回系统的当前时间,以字符串形式
     * @return String
     */
    public String getSystemStrDate(){
        return format(new Date());
    }

    /**
     * 设置日历的时间
     */
    private static void setCalendar(Date date) {
        calendar.setTime(date);
    }

    /**
     * 设置日历的时间
     */
    private void setCalendar(String strDate) throws ParseException{
        calendar.setTime(parse(strDate));
    }

    /**
     * 判断当前时间是否介于开始时间和结束时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return boolean
     * @throws ParseException ParseException
     */
    public boolean compareDate(String startTime, String endTime) throws ParseException {
        Date currentDate = new Date();
        String strCurrentTime = format(currentDate);
        String time = strCurrentTime.substring(0, strCurrentTime.indexOf(" ") + 1);
        Date startDate = parse(time + startTime);
        Date endDate = parse(time + endTime);
        if (currentDate.before(startDate)){
            if (currentDate.before(endDate)){
                return true;
            }
        }else if (endDate.before(startDate)){
            if (currentDate.after(startDate)){
                return true;
            }
        }else {
            if (currentDate.after(startDate) && currentDate.before(endDate)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取当前时间， 年月日时分秒毫秒
     * @return
     */
    public static String nowTime(){
        String time = (new SimpleDateFormat(YYYYMMDDHHMMSSS)).format(new Date()).toString();
        return time;
    }

    public static String nowTimeT(){
        String time = (new SimpleDateFormat(YYMMDDHHMMSSS)).format(new Date()).toString();
        return time;
    }

    public static String datetime(){
        String time = (new SimpleDateFormat(YYYYMMDDHHMMSS)).format(new Date()).toString();
        return time;
    }

    public static Date now(){
        return new Date();
    }

    /**
     * 获取当前时间，  年月日时分秒
     * @return
     */
    public static String createTime(){
        String time=(new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS)).format(new Date()).toString();
        return time;
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String createDate(){
        String time=(new SimpleDateFormat(YYYY_MM_DD)).format(new Date()).toString();
        return time;
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String yearMonth(){
        String time=(new SimpleDateFormat(YYYY_MM)).format(new Date()).toString();
        return time;
    }

    /**
     * 获取当前年份
     * @return
     */
    public static String nowYear(){
        String time = (new SimpleDateFormat(YYYY)).format(new Date()).toString();
        return time;
    }

    /**
     * 比较两个时间那个早那个晚
     * @param nowTime  给定的第一个时间
     * @param date2           给定的第二个时间
     * @return  1：表示第一个时间(12:00)已经过了第二个时间(11:00)
     */
    public static int compareTime(String nowTime,String date2) {
        int flag=0;
        DateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date dt1 = df.parse(nowTime);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                flag= 1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取本月第一天
     */
    public static String getFirtDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;
    }

    /**
     * 两个时间之间相差距离多少天
     * @param str1 时间参数 1：
     * @param str2 时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceDays(String str1, String str2) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTimes(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }

    /**
     *
     * @Title: getDistanceHour
     * @Description: TODO(获取连个时间字符相差的天)
     * @param  str1
     * @param  str2
     * @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getDistanceDay(String str1, String str2) {
        long[] times =getDistanceTimes(str1, str2);
        String day = Long.toString(times[0]) ;
        return day;
    }

    /**
     * @Title: getDistanceHour
     * @Description: TODO(获取连个时间字符相差的小时)
     * @param str1
     * @param str2
     * @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getDistanceHour(String str1, String str2) {
        long[] times =getDistanceTimes(str1, str2);
        String hour = Long.toString(times[1]) ;
        return hour;
    }

    /**
     * @Title: getDistanceHour
     * @Description: TODO(获取连个时间字符相差的分钟)
     * @param  str1
     * @param  str2
     * @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getDistanceMinute(String str1, String str2) {
        long[] times =getDistanceTimes(str1, str2);
        String minute = Long.toString(times[2]) ;
        return minute;
    }

    /**
     * @Title: getDistanceHour
     * @Description: TODO(获取连个时间字符相差的分钟)
     * @param  str1
     * @param  str2
     * @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getDistanceSecond(String str1, String str2) {
        long[] times =getDistanceTimes(str1, str2);
        String second = Long.toString(times[3]) ;
        return second;
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static String getDistanceTime(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day + "天" + hour + "小时" + min + "分" + sec + "秒";
    }

    /**
     * 获取本月最后一天
     */
    public static String getLastDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        return last;
    }

    /**
     * Date转string
     * @return
     */
    public static String dateYMDToStr(Date date) {
        String time = (new SimpleDateFormat("yyyy-MM-dd")).format(date).toString();
        return time;
    }

    /**
     * Date转string
     * @return
     */
    public static String DateYMDHMToStr(Date date) {
        String time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date).toString();
        return time;
    }
    public static String getMonthDate(Date d){
        String time = (new SimpleDateFormat("MM-dd")).format(d).toString();
        return time;
    }

    //返回分钟
    public static long dataminus(Date d2) {
        long days = 0;
        try {
            Date d1 = new Date();
            long diff = d1.getTime() - d2.getTime();
            days = diff / (1000 * 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }

    /*
    * 将时间戳转换为时间
    */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        res = simpleDateFormat.format(new Date(Long.parseLong(s+"000")));
        return res;
    }

    /*
    * 将时间转换为时间戳
    */
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 根据日期获取小时
     */
    public static String strToHour(String str){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date date = null;
        try {
            date = sdf.parse(str);
            int strtime = getHour(date, true);
            return String.valueOf(strtime);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据日期获取天
     */
    public static String strToDate(String str){
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
        String strday = null;
        try {
            Date date = sdf.parse(str); // 获取Date
            //Calendar cal = Calendar.getInstance();
            calendar.setTime(date); // 转为新Calendar
            int day = calendar.get(calendar.DAY_OF_MONTH); // 日
            strday = String.valueOf(day);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strday;
    }

    /*
     * 根据日期获取月份
     */
    public static String strToMonth(String str){
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
        String strmonth = null;
        try {
            Date date = sdf.parse(str); // 获取Date
            //Calendar cal = Calendar.getInstance();
            calendar.setTime(date); // 转为新Calendar
            int year = calendar.get(calendar.MONTH)+1;
            strmonth = String.valueOf(year);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strmonth;
    }

    /**
     * 将分钟转成  时 ：分
     * @param time
     * @return
     */
    public static String TimeToDate(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time % 60 ;
            hour = time /60 ;
            timeStr = unitFormat(hour) + ":" + unitFormat(minute) ;
        }
        return timeStr;
    }

    /**
     * 将0-9的时间数前面加0输出
     * eg:9点 转换成 09:00
     * @param i
     * @return
     */
    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
