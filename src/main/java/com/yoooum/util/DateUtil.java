package com.yoooum.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName DateUtil
 * @Description 日期处理类
 * @Author kiss
 * @Date 2020/5/28 17:51
 * @Version 1.0
 */
public class DateUtil
{

    /**
     * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
     * @param time
     * @return
     */
    public static long StringToTimestamp(String time){
        //如果时间是"2020-11-11T14:24:00" 转为 "2020-11-11 14:24:00"
        if(time.length()==16){
            time = time.indexOf('T')!=-1? time.replace('T', ' ')+":00":time+":00";
        }else{
            time = time.indexOf('T')!=-1? time.replace('T', ' '):time;
        }
        System.out.println(time);
        long times = 0L;
        try {
             times = ((Timestamp.valueOf(time).getTime()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(times==0){
            System.out.println("String转10位时间戳失败");
        }
        return times;

    }

    public static void main(String[] args)
    {
        String strTime = "2020-11-11T14:24";
        String strTime2 = "2020-11-11T14:24:00";
        System.out.println(strTime.length());
        System.out.println(StringToTimestamp(strTime));
        System.out.println(StringToTimestamp(strTime2));
    }

    /**
     * 获取两个日期字符串之间的日期集合
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenDateByString(String startTime, String endTime)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try
        {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime())
            {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
     *
     * @param time
     * @return
     */
    public static Integer strToStamp(String time) {
        int times = 0;
        try {
            times = (int) ((Timestamp.valueOf(time).getTime()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (times == 0) {
            System.out.println("=====String转10位时间戳失败=====");
        }

        return times;
    }

    /**
     * @Description:  获取指定日期的前几天(-)或后几天 例：2019-12-01 2 --> 20191203
     * @Date 2020/6/4 13:43
     * @param checkDate
     * @param day
     * @param type
     * @return
    **/
    public static String getDateAfter(String checkDate, int day, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String resDate = "";
        try {
            Date utilDate = sdf.parse(checkDate);
            Calendar now = Calendar.getInstance();
            now.setTime(utilDate);
            now.set(Calendar.DATE, now.get(Calendar.DATE) + day);// +后 -前
            // 日期转字符串
            SimpleDateFormat formatter = new SimpleDateFormat(type);
            resDate = formatter.format(now.getTime());
        } catch (Exception e) {
            resDate = checkDate;
            System.out.println("获取指定日期异常:" + e.getMessage());
        }

        return resDate;
    }

    /**
     * 获取两个日期字符串之间的日期集合
     *
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenDate(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 声明保存日期集合
        List<String> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            // 用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                // 把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取指定日期的前(后)num 天的日期
     *
     * @param date
     * @param num
     * @return
     */
    public static String getDateByNum(String date, Integer num) {
        Calendar c = new GregorianCalendar();
        String[] inputs = date.split("-");
        int year = Integer.parseInt(inputs[0]);
        int month = Integer.parseInt(inputs[1]);
        int day = Integer.parseInt(inputs[2]);

        c.set(year, month - 1, day);
        c.add(Calendar.DAY_OF_YEAR, num);
        Date today = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        System.out.println(result);

        return result;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static String getNowDate()
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
