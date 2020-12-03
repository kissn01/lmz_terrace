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

    public static void main(String[] args)
    {
        System.out.println(getLastSevenDay(0,7));
    }
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
     * 获取最近N天日期
     * @param begDay  0为从今天开始
     * @param countDay  天数
     * @return
     */
    public static List<String> getLastSevenDay(Integer begDay,Integer countDay)
    {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i=begDay;i<countDay;i++){
            c=Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, - i);
            list.add(sdf.format(c.getTime()));
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

    public static Map<String,String> getDays(Integer time)
    {
        String begTime="123";
        String endTime="123";
        //根据参数判断返回值
        if(time==1)
        {
            begTime=getTime().get("formatDateBeg");
            endTime=getTime().get("formatDateEnd");
        }
        else if(time==2)
        {
            begTime=getTime().get("formatTopDateBeg");
            endTime=getTime().get("formatTopDateEnd");
        }else if(time==5)
        {
            begTime=getTime().get("formatTop4DateBeg");
            endTime=getTime().get("formatTop4DateEnd");
        }else if(time==7)
        {
            begTime=getTime().get("formatTop6DateBeg");
            endTime=getTime().get("formatDateEnd");
        }else if(time==-7)
        {
            begTime=getTime().get("formatTop7DateBeg");
            endTime=getTime().get("formatTopDateEnd");
        }else if(time==8)
        {
            begTime=getTime().get("formatTop7DateBeg");
            endTime=getTime().get("formatDateEnd");
        }
        else if(time==30)
        {
            begTime=getTime().get("formatTop29DateBeg");
            endTime=getTime().get("formatDateEnd");
        }
        else if(time==90)
        {
            begTime=getTime().get("formatTop89DateBeg");
            endTime=getTime().get("formatDateEnd");
        }


        //定义map 存入结果
        Map<String,String> map=new HashMap<String, String>();
        map.put("begTime", begTime);
        map.put("endTime", endTime);

        return map;
    }


    /**
     * 获取最近14天时间
     * @return
     */
    public static Map<String, String> getTime()
    {
        Date currentEndDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //当日 开始
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentEndDate);
        cal.add(Calendar.DATE,0);
        cal.set(Calendar.AM_PM, 0);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date nextDate = cal.getTime();
        String formatDateBeg = formatter.format(nextDate);

        //当日 结束
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(currentEndDate);
        calEnd.add(Calendar.DATE,0);
        calEnd.set(Calendar.AM_PM, 0);
        calEnd.set(Calendar.HOUR, 23);
        calEnd.set(Calendar.MINUTE,59);
        calEnd.set(Calendar.SECOND, 59);
        Date dateEnd = calEnd.getTime();
        String formatDateEnd = formatter.format(dateEnd);

        //明日 开始
        Calendar calNextBeg = Calendar.getInstance();
        calNextBeg.setTime(currentEndDate);
        calNextBeg.add(Calendar.DATE,1);
        calNextBeg.set(Calendar.AM_PM, 0);
        calNextBeg.set(Calendar.HOUR, 0);
        calNextBeg.set(Calendar.MINUTE, 0);
        calNextBeg.set(Calendar.SECOND, 0);
        Date nextDateBeg = calNextBeg.getTime();
        String formatNextDateBeg = formatter.format(nextDateBeg);

        //明日 结束
        Calendar calNextEnd = Calendar.getInstance();
        calNextEnd.setTime(currentEndDate);
        calNextEnd.add(Calendar.DATE,1);
        calNextEnd.set(Calendar.AM_PM, 0);
        calNextEnd.set(Calendar.HOUR, 23);
        calNextEnd.set(Calendar.MINUTE,59);
        calNextEnd.set(Calendar.SECOND, 59);
        Date nextDateEnd = calNextEnd.getTime();
        String formatNextDateEnd = formatter.format(nextDateEnd);

        //2天后 开始
        Calendar calNext2Beg = Calendar.getInstance();
        calNext2Beg.setTime(currentEndDate);
        calNext2Beg.add(Calendar.DATE,2);
        calNext2Beg.set(Calendar.AM_PM, 0);
        calNext2Beg.set(Calendar.HOUR, 0);
        calNext2Beg.set(Calendar.MINUTE, 0);
        calNext2Beg.set(Calendar.SECOND, 0);
        Date next2DateBeg = calNext2Beg.getTime();
        String formatNext2DateBeg = formatter.format(next2DateBeg);

        //2天后 结束
        Calendar calNext2End = Calendar.getInstance();
        calNext2End.setTime(currentEndDate);
        calNext2End.add(Calendar.DATE,2);
        calNext2End.set(Calendar.AM_PM, 0);
        calNext2End.set(Calendar.HOUR, 23);
        calNext2End.set(Calendar.MINUTE,59);
        calNext2End.set(Calendar.SECOND, 59);
        Date next2DateEnd = calNext2End.getTime();
        String formatNext2DateEnd = formatter.format(next2DateEnd);

        //3天后 开始
        Calendar calNext3Beg = Calendar.getInstance();
        calNext3Beg.setTime(currentEndDate);
        calNext3Beg.add(Calendar.DATE,3);
        calNext3Beg.set(Calendar.AM_PM, 0);
        calNext3Beg.set(Calendar.HOUR, 0);
        calNext3Beg.set(Calendar.MINUTE, 0);
        calNext3Beg.set(Calendar.SECOND, 0);
        Date next3DateBeg = calNext3Beg.getTime();
        String formatNext3DateBeg = formatter.format(next3DateBeg);

        //3天后 结束
        Calendar calNext3End = Calendar.getInstance();
        calNext3End.setTime(currentEndDate);
        calNext3End.add(Calendar.DATE,3);
        calNext3End.set(Calendar.AM_PM, 0);
        calNext3End.set(Calendar.HOUR, 23);
        calNext3End.set(Calendar.MINUTE,59);
        calNext3End.set(Calendar.SECOND, 59);
        Date next3DateEnd = calNext3End.getTime();
        String formatNext3DateEnd = formatter.format(next3DateEnd);

        //4天后 开始
        Calendar calNext4Beg = Calendar.getInstance();
        calNext4Beg.setTime(currentEndDate);
        calNext4Beg.add(Calendar.DATE,4);
        calNext4Beg.set(Calendar.AM_PM, 0);
        calNext4Beg.set(Calendar.HOUR, 0);
        calNext4Beg.set(Calendar.MINUTE, 0);
        calNext4Beg.set(Calendar.SECOND, 0);
        Date next4DateBeg = calNext4Beg.getTime();
        String formatNext4DateBeg = formatter.format(next4DateBeg);

        //4天后 结束
        Calendar calNext4End = Calendar.getInstance();
        calNext4End.setTime(currentEndDate);
        calNext4End.add(Calendar.DATE,4);
        calNext4End.set(Calendar.AM_PM, 0);
        calNext4End.set(Calendar.HOUR, 23);
        calNext4End.set(Calendar.MINUTE,59);
        calNext4End.set(Calendar.SECOND, 59);
        Date next4DateEnd = calNext4End.getTime();
        String formatNext4DateEnd = formatter.format(next4DateEnd);

        //5天后 开始
        Calendar calNext5Beg = Calendar.getInstance();
        calNext5Beg.setTime(currentEndDate);
        calNext5Beg.add(Calendar.DATE,5);
        calNext5Beg.set(Calendar.AM_PM, 0);
        calNext5Beg.set(Calendar.HOUR, 0);
        calNext5Beg.set(Calendar.MINUTE, 0);
        calNext5Beg.set(Calendar.SECOND, 0);
        Date next5DateBeg = calNext5Beg.getTime();
        String formatNext5DateBeg = formatter.format(next5DateBeg);

        //5天后 结束
        Calendar calNext5End = Calendar.getInstance();
        calNext5End.setTime(currentEndDate);
        calNext5End.add(Calendar.DATE,5);
        calNext5End.set(Calendar.AM_PM, 0);
        calNext5End.set(Calendar.HOUR, 23);
        calNext5End.set(Calendar.MINUTE,59);
        calNext5End.set(Calendar.SECOND, 59);
        Date next5DateEnd = calNext5End.getTime();
        String formatNext5DateEnd = formatter.format(next5DateEnd);

        //6天后 开始
        Calendar calNext6Beg = Calendar.getInstance();
        calNext6Beg.setTime(currentEndDate);
        calNext6Beg.add(Calendar.DATE,6);
        calNext6Beg.set(Calendar.AM_PM, 0);
        calNext6Beg.set(Calendar.HOUR, 0);
        calNext6Beg.set(Calendar.MINUTE, 0);
        calNext6Beg.set(Calendar.SECOND, 0);
        Date next6DateBeg = calNext6Beg.getTime();
        String formatNext6DateBeg = formatter.format(next6DateBeg);

        //3天后 结束
        Calendar calNext6End = Calendar.getInstance();
        calNext6End.setTime(currentEndDate);
        calNext6End.add(Calendar.DATE,6);
        calNext6End.set(Calendar.AM_PM, 0);
        calNext6End.set(Calendar.HOUR, 23);
        calNext6End.set(Calendar.MINUTE,59);
        calNext6End.set(Calendar.SECOND, 59);
        Date next6DateEnd = calNext6End.getTime();
        String formatNext6DateEnd = formatter.format(next6DateEnd);

        //7天后 开始
        Calendar calNext7Beg = Calendar.getInstance();
        calNext7Beg.setTime(currentEndDate);
        calNext7Beg.add(Calendar.DATE,7);
        calNext7Beg.set(Calendar.AM_PM, 0);
        calNext7Beg.set(Calendar.HOUR, 0);
        calNext7Beg.set(Calendar.MINUTE, 0);
        calNext7Beg.set(Calendar.SECOND, 0);
        Date next7DateBeg = calNext7Beg.getTime();
        String formatNext7DateBeg = formatter.format(next7DateBeg);

        //7天后 结束
        Calendar calNext7End = Calendar.getInstance();
        calNext7End.setTime(currentEndDate);
        calNext7End.add(Calendar.DATE,7);
        calNext7End.set(Calendar.AM_PM, 0);
        calNext7End.set(Calendar.HOUR, 23);
        calNext7End.set(Calendar.MINUTE,59);
        calNext7End.set(Calendar.SECOND, 59);
        Date next7DateEnd = calNext7End.getTime();
        String formatNext7DateEnd = formatter.format(next7DateEnd);



        //昨天 开始
        Calendar calTopBeg = Calendar.getInstance();
        calTopBeg.setTime(currentEndDate);
        calTopBeg.add(Calendar.DATE,-1);
        calTopBeg.set(Calendar.AM_PM, 0);
        calTopBeg.set(Calendar.HOUR, 0);
        calTopBeg.set(Calendar.MINUTE, 0);
        calTopBeg.set(Calendar.SECOND, 0);
        Date topDateBeg = calTopBeg.getTime();
        String formatTopDateBeg = formatter.format(topDateBeg);

        //昨日 结束
        Calendar calTopEnd = Calendar.getInstance();
        calTopEnd.setTime(currentEndDate);
        calTopEnd.add(Calendar.DATE,-1);
        calTopEnd.set(Calendar.AM_PM, 0);
        calTopEnd.set(Calendar.HOUR, 23);
        calTopEnd.set(Calendar.MINUTE, 59);
        calTopEnd.set(Calendar.SECOND, 59);
        Date topDateEnd = calTopEnd.getTime();
        String formatTopDateEnd = formatter.format(topDateEnd);

        //前3开始
        Calendar calTop2Beg = Calendar.getInstance();
        calTop2Beg.setTime(currentEndDate);
        calTop2Beg.add(Calendar.DATE,-2);
        calTop2Beg.set(Calendar.AM_PM, 0);
        calTop2Beg.set(Calendar.HOUR, 0);
        calTop2Beg.set(Calendar.MINUTE, 0);
        calTop2Beg.set(Calendar.SECOND, 0);
        Date top2DateBeg = calTop2Beg.getTime();
        String formatTop2DateBeg = formatter.format(top2DateBeg);

        //前3结束
        Calendar calTop2End = Calendar.getInstance();
        calTop2End.setTime(currentEndDate);
        calTop2End.add(Calendar.DATE,-2);
        calTop2End.set(Calendar.AM_PM, 0);
        calTop2End.set(Calendar.HOUR, 23);
        calTop2End.set(Calendar.MINUTE, 59);
        calTop2End.set(Calendar.SECOND, 59);
        Date top2DateEnd = calTop2End.getTime();
        String formatTop2DateEnd = formatter.format(top2DateEnd);

        //前4 开始
        Calendar calTop3Beg = Calendar.getInstance();
        calTop3Beg.setTime(currentEndDate);
        calTop3Beg.add(Calendar.DATE,-3);
        calTop3Beg.set(Calendar.AM_PM, 0);
        calTop3Beg.set(Calendar.HOUR, 0);
        calTop3Beg.set(Calendar.MINUTE, 0);
        calTop3Beg.set(Calendar.SECOND, 0);
        Date top3DateBeg = calTop3Beg.getTime();
        String formatTop3DateBeg = formatter.format(top3DateBeg);

        //前4结束
        Calendar calTop3End = Calendar.getInstance();
        calTop3End.setTime(currentEndDate);
        calTop3End.add(Calendar.DATE,-3);
        calTop3End.set(Calendar.AM_PM, 0);
        calTop3End.set(Calendar.HOUR, 23);
        calTop3End.set(Calendar.MINUTE, 59);
        calTop3End.set(Calendar.SECOND, 59);
        Date top3DateEnd = calTop3End.getTime();
        String formatTop3DateEnd = formatter.format(top3DateEnd);

        //前5 开始
        Calendar calTop4Beg = Calendar.getInstance();
        calTop4Beg.setTime(currentEndDate);
        calTop4Beg.add(Calendar.DATE,-4);
        calTop4Beg.set(Calendar.AM_PM, 0);
        calTop4Beg.set(Calendar.HOUR, 0);
        calTop4Beg.set(Calendar.MINUTE, 0);
        calTop4Beg.set(Calendar.SECOND, 0);
        Date top4DateBeg = calTop4Beg.getTime();
        String formatTop4DateBeg = formatter.format(top4DateBeg);

        //前5 结束
        Calendar calTop4End = Calendar.getInstance();
        calTop4End.setTime(currentEndDate);
        calTop4End.add(Calendar.DATE,-4);
        calTop4End.set(Calendar.AM_PM, 0);
        calTop4End.set(Calendar.HOUR, 23);
        calTop4End.set(Calendar.MINUTE, 59);
        calTop4End.set(Calendar.SECOND, 59);
        Date top4DateEnd = calTop4End.getTime();
        String formatTop4DateEnd = formatter.format(top4DateEnd);


        //前6 开始
        Calendar calTop5Beg = Calendar.getInstance();
        calTop5Beg.setTime(currentEndDate);
        calTop5Beg.add(Calendar.DATE,-5);
        calTop5Beg.set(Calendar.AM_PM, 0);
        calTop5Beg.set(Calendar.HOUR, 0);
        calTop5Beg.set(Calendar.MINUTE, 0);
        calTop5Beg.set(Calendar.SECOND, 0);
        Date top5DateBeg = calTop5Beg.getTime();
        String formatTop5DateBeg = formatter.format(top5DateBeg);

        //前6 结束
        Calendar calTop5End = Calendar.getInstance();
        calTop5End.setTime(currentEndDate);
        calTop5End.add(Calendar.DATE,-5);
        calTop5End.set(Calendar.AM_PM, 0);
        calTop5End.set(Calendar.HOUR, 23);
        calTop5End.set(Calendar.MINUTE, 59);
        calTop5End.set(Calendar.SECOND, 59);
        Date top5DateEnd = calTop5End.getTime();
        String formatTop5DateEnd = formatter.format(top5DateEnd);

        //前7 开始
        Calendar calTop6Beg = Calendar.getInstance();
        calTop6Beg.setTime(currentEndDate);
        calTop6Beg.add(Calendar.DATE,-6);
        calTop6Beg.set(Calendar.AM_PM, 0);
        calTop6Beg.set(Calendar.HOUR, 0);
        calTop6Beg.set(Calendar.MINUTE, 0);
        calTop6Beg.set(Calendar.SECOND, 0);
        Date top6DateBeg = calTop6Beg.getTime();
        String formatTop6DateBeg = formatter.format(top6DateBeg);

        //前7 结束
        Calendar calTop6End = Calendar.getInstance();
        calTop6End.setTime(currentEndDate);
        calTop6End.add(Calendar.DATE,-6);
        calTop6End.set(Calendar.AM_PM, 0);
        calTop6End.set(Calendar.HOUR, 23);
        calTop6End.set(Calendar.MINUTE, 59);
        calTop6End.set(Calendar.SECOND, 59);
        Date top6DateEnd = calTop6End.getTime();
        String formatTop6DateEnd = formatter.format(top6DateEnd);

        //前8 开始
        Calendar calTop7Beg = Calendar.getInstance();
        calTop7Beg.setTime(currentEndDate);
        calTop7Beg.add(Calendar.DATE,-7);
        calTop7Beg.set(Calendar.AM_PM, 0);
        calTop7Beg.set(Calendar.HOUR, 0);
        calTop7Beg.set(Calendar.MINUTE, 0);
        calTop7Beg.set(Calendar.SECOND, 0);
        Date top7DateBeg = calTop7Beg.getTime();
        String formatTop7DateBeg = formatter.format(top7DateBeg);

        //前8 结束
        Calendar calTop7End = Calendar.getInstance();
        calTop7End.setTime(currentEndDate);
        calTop7End.add(Calendar.DATE,-7);
        calTop7End.set(Calendar.AM_PM, 0);
        calTop7End.set(Calendar.HOUR, 23);
        calTop7End.set(Calendar.MINUTE, 59);
        calTop7End.set(Calendar.SECOND, 59);
        Date top7DateEnd = calTop7End.getTime();
        String formatTop7DateEnd = formatter.format(top7DateEnd);

        //前9 开始
        Calendar calTop8Beg = Calendar.getInstance();
        calTop8Beg.setTime(currentEndDate);
        calTop8Beg.add(Calendar.DATE,-8);
        calTop8Beg.set(Calendar.AM_PM, 0);
        calTop8Beg.set(Calendar.HOUR, 0);
        calTop8Beg.set(Calendar.MINUTE, 0);
        calTop8Beg.set(Calendar.SECOND, 0);
        Date top8DateBeg = calTop8Beg.getTime();
        String formatTop8DateBeg = formatter.format(top8DateBeg);

        //前9 结束
        Calendar calTop8End = Calendar.getInstance();
        calTop8End.setTime(currentEndDate);
        calTop8End.add(Calendar.DATE,-8);
        calTop8End.set(Calendar.AM_PM, 0);
        calTop8End.set(Calendar.HOUR, 23);
        calTop8End.set(Calendar.MINUTE, 59);
        calTop8End.set(Calendar.SECOND, 59);
        Date top8DateEnd = calTop8End.getTime();
        String formatTop8DateEnd = formatter.format(top8DateEnd);

        //前10开始
        Calendar calTop9Beg = Calendar.getInstance();
        calTop9Beg.setTime(currentEndDate);
        calTop9Beg.add(Calendar.DATE,-9);
        calTop9Beg.set(Calendar.AM_PM, 0);
        calTop9Beg.set(Calendar.HOUR, 0);
        calTop9Beg.set(Calendar.MINUTE, 0);
        calTop9Beg.set(Calendar.SECOND, 0);
        Date top9DateBeg = calTop9Beg.getTime();
        String formatTop9DateBeg = formatter.format(top9DateBeg);

        //前10结束
        Calendar calTop9End = Calendar.getInstance();
        calTop9End.setTime(currentEndDate);
        calTop9End.add(Calendar.DATE,-9);
        calTop9End.set(Calendar.AM_PM, 0);
        calTop9End.set(Calendar.HOUR, 23);
        calTop9End.set(Calendar.MINUTE, 59);
        calTop9End.set(Calendar.SECOND, 59);
        Date top9DateEnd = calTop9End.getTime();
        String formatTop9DateEnd = formatter.format(top9DateEnd);

        //前11开始
        Calendar calTop10Beg = Calendar.getInstance();
        calTop10Beg.setTime(currentEndDate);
        calTop10Beg.add(Calendar.DATE,-10);
        calTop10Beg.set(Calendar.AM_PM, 0);
        calTop10Beg.set(Calendar.HOUR, 0);
        calTop10Beg.set(Calendar.MINUTE, 0);
        calTop10Beg.set(Calendar.SECOND, 0);
        Date top10DateBeg = calTop10Beg.getTime();
        String formatTop10DateBeg = formatter.format(top10DateBeg);

        //前11结束
        Calendar calTop10End = Calendar.getInstance();
        calTop10End.setTime(currentEndDate);
        calTop10End.add(Calendar.DATE,-10);
        calTop10End.set(Calendar.AM_PM, 0);
        calTop10End.set(Calendar.HOUR, 23);
        calTop10End.set(Calendar.MINUTE, 59);
        calTop10End.set(Calendar.SECOND, 59);
        Date top10DateEnd = calTop6End.getTime();
        String formatTop10DateEnd = formatter.format(top10DateEnd);

        //前12 开始
        Calendar calTop11Beg = Calendar.getInstance();
        calTop11Beg.setTime(currentEndDate);
        calTop11Beg.add(Calendar.DATE,-11);
        calTop11Beg.set(Calendar.AM_PM, 0);
        calTop11Beg.set(Calendar.HOUR, 0);
        calTop11Beg.set(Calendar.MINUTE, 0);
        calTop11Beg.set(Calendar.SECOND, 0);
        Date top11DateBeg = calTop11Beg.getTime();
        String formatTop11DateBeg = formatter.format(top11DateBeg);

        //前12 结束
        Calendar calTop11End = Calendar.getInstance();
        calTop11End.setTime(currentEndDate);
        calTop11End.add(Calendar.DATE,-11);
        calTop11End.set(Calendar.AM_PM, 0);
        calTop11End.set(Calendar.HOUR, 23);
        calTop11End.set(Calendar.MINUTE, 59);
        calTop11End.set(Calendar.SECOND, 59);
        Date top11DateEnd = calTop11End.getTime();
        String formatTop11DateEnd = formatter.format(top11DateEnd);

        //前13开始
        Calendar calTop12Beg = Calendar.getInstance();
        calTop12Beg.setTime(currentEndDate);
        calTop12Beg.add(Calendar.DATE,-12);
        calTop12Beg.set(Calendar.AM_PM, 0);
        calTop12Beg.set(Calendar.HOUR, 0);
        calTop12Beg.set(Calendar.MINUTE, 0);
        calTop12Beg.set(Calendar.SECOND, 0);
        Date top12DateBeg = calTop12Beg.getTime();
        String formatTop12DateBeg = formatter.format(top12DateBeg);

        //前13 结束
        Calendar calTop12End = Calendar.getInstance();
        calTop12End.setTime(currentEndDate);
        calTop12End.add(Calendar.DATE,-12);
        calTop12End.set(Calendar.AM_PM, 0);
        calTop12End.set(Calendar.HOUR, 23);
        calTop12End.set(Calendar.MINUTE, 59);
        calTop12End.set(Calendar.SECOND, 59);
        Date top12DateEnd = calTop12End.getTime();
        String formatTop12DateEnd = formatter.format(top12DateEnd);

        //前14开始
        Calendar calTop13Beg = Calendar.getInstance();
        calTop13Beg.setTime(currentEndDate);
        calTop13Beg.add(Calendar.DATE,-13);
        calTop13Beg.set(Calendar.AM_PM, 0);
        calTop13Beg.set(Calendar.HOUR, 0);
        calTop13Beg.set(Calendar.MINUTE, 0);
        calTop13Beg.set(Calendar.SECOND, 0);
        Date top13DateBeg = calTop13Beg.getTime();
        String formatTop13DateBeg = formatter.format(top13DateBeg);

        //前14 结束
        Calendar calTop13End = Calendar.getInstance();
        calTop13End.setTime(currentEndDate);
        calTop13End.add(Calendar.DATE,-13);
        calTop13End.set(Calendar.AM_PM, 0);
        calTop13End.set(Calendar.HOUR, 23);
        calTop13End.set(Calendar.MINUTE, 59);
        calTop13End.set(Calendar.SECOND, 59);
        Date top13DateEnd = calTop13End.getTime();
        String formatTop13DateEnd = formatter.format(top13DateEnd);

        //前30 开始
        Calendar calTop29Beg = Calendar.getInstance();
        calTop29Beg.setTime(currentEndDate);
        calTop29Beg.add(Calendar.DATE,-29);
        calTop29Beg.set(Calendar.AM_PM, 0);
        calTop29Beg.set(Calendar.HOUR, 0);
        calTop29Beg.set(Calendar.MINUTE, 0);
        calTop29Beg.set(Calendar.SECOND, 0);
        Date top29DateBeg = calTop29Beg.getTime();
        String formatTop29DateBeg = formatter.format(top29DateBeg);

        //前30 结束
        Calendar calTop29End = Calendar.getInstance();
        calTop29End.setTime(currentEndDate);
        calTop29End.add(Calendar.DATE,-29);
        calTop29End.set(Calendar.AM_PM, 0);
        calTop29End.set(Calendar.HOUR, 23);
        calTop29End.set(Calendar.MINUTE, 59);
        calTop29End.set(Calendar.SECOND, 59);
        Date top29DateEnd = calTop29End.getTime();
        String formatTop29DateEnd = formatter.format(top29DateEnd);
        //前31 开始
        Calendar calTop30Beg = Calendar.getInstance();
        calTop30Beg.setTime(currentEndDate);
        calTop30Beg.add(Calendar.DATE,-30);
        calTop30Beg.set(Calendar.AM_PM, 0);
        calTop30Beg.set(Calendar.HOUR, 0);
        calTop30Beg.set(Calendar.MINUTE, 0);
        calTop30Beg.set(Calendar.SECOND, 0);
        Date top30DateBeg = calTop30Beg.getTime();
        String formatTop30DateBeg = formatter.format(top30DateBeg);

        //前31结束
        Calendar calTop30End = Calendar.getInstance();
        calTop30End.setTime(currentEndDate);
        calTop30End.add(Calendar.DATE,-30);
        calTop30End.set(Calendar.AM_PM, 0);
        calTop30End.set(Calendar.HOUR, 23);
        calTop30End.set(Calendar.MINUTE, 59);
        calTop30End.set(Calendar.SECOND, 59);
        Date top30DateEnd = calTop30End.getTime();
        String formatTop30DateEnd = formatter.format(top30DateEnd);
        //前32 开始
        Calendar calTop31Beg = Calendar.getInstance();
        calTop31Beg.setTime(currentEndDate);
        calTop31Beg.add(Calendar.DATE,-31);
        calTop31Beg.set(Calendar.AM_PM, 0);
        calTop31Beg.set(Calendar.HOUR, 0);
        calTop31Beg.set(Calendar.MINUTE, 0);
        calTop31Beg.set(Calendar.SECOND, 0);
        Date top31DateBeg = calTop31Beg.getTime();
        String formatTop31DateBeg = formatter.format(top31DateBeg);

        //前32 结束
        Calendar calTop31End = Calendar.getInstance();
        calTop31End.setTime(currentEndDate);
        calTop31End.add(Calendar.DATE,-31);
        calTop31End.set(Calendar.AM_PM, 0);
        calTop31End.set(Calendar.HOUR, 23);
        calTop31End.set(Calendar.MINUTE, 59);
        calTop31End.set(Calendar.SECOND, 59);
        Date top31DateEnd = calTop31End.getTime();
        String formatTop31DateEnd = formatter.format(top31DateEnd);
        //前33 开始
        Calendar calTop32Beg = Calendar.getInstance();
        calTop32Beg.setTime(currentEndDate);
        calTop32Beg.add(Calendar.DATE,-32);
        calTop32Beg.set(Calendar.AM_PM, 0);
        calTop32Beg.set(Calendar.HOUR, 0);
        calTop32Beg.set(Calendar.MINUTE, 0);
        calTop32Beg.set(Calendar.SECOND, 0);
        Date top32DateBeg = calTop32Beg.getTime();
        String formatTop32DateBeg = formatter.format(top32DateBeg);

        //前33结束
        Calendar calTop32End = Calendar.getInstance();
        calTop32End.setTime(currentEndDate);
        calTop32End.add(Calendar.DATE,-32);
        calTop32End.set(Calendar.AM_PM, 0);
        calTop32End.set(Calendar.HOUR, 23);
        calTop32End.set(Calendar.MINUTE, 59);
        calTop32End.set(Calendar.SECOND, 59);
        Date top32DateEnd = calTop32End.getTime();
        String formatTop32DateEnd = formatter.format(top32DateEnd);
        //前34 开始
        Calendar calTop33Beg = Calendar.getInstance();
        calTop33Beg.setTime(currentEndDate);
        calTop33Beg.add(Calendar.DATE,-33);
        calTop33Beg.set(Calendar.AM_PM, 0);
        calTop33Beg.set(Calendar.HOUR, 0);
        calTop33Beg.set(Calendar.MINUTE, 0);
        calTop33Beg.set(Calendar.SECOND, 0);
        Date top33DateBeg = calTop33Beg.getTime();
        String formatTop33DateBeg = formatter.format(top33DateBeg);

        //前34 结束
        Calendar calTop33End = Calendar.getInstance();
        calTop33End.setTime(currentEndDate);
        calTop33End.add(Calendar.DATE,-33);
        calTop33End.set(Calendar.AM_PM, 0);
        calTop33End.set(Calendar.HOUR, 23);
        calTop33End.set(Calendar.MINUTE, 59);
        calTop33End.set(Calendar.SECOND, 59);
        Date top33DateEnd = calTop33End.getTime();
        String formatTop33DateEnd = formatter.format(top33DateEnd);
        //前35 开始
        Calendar calTop34Beg = Calendar.getInstance();
        calTop34Beg.setTime(currentEndDate);
        calTop34Beg.add(Calendar.DATE,-34);
        calTop34Beg.set(Calendar.AM_PM, 0);
        calTop34Beg.set(Calendar.HOUR, 0);
        calTop34Beg.set(Calendar.MINUTE, 0);
        calTop34Beg.set(Calendar.SECOND, 0);
        Date top34DateBeg = calTop34Beg.getTime();
        String formatTop34DateBeg = formatter.format(top34DateBeg);

        //前35 结束
        Calendar calTop34End = Calendar.getInstance();
        calTop34End.setTime(currentEndDate);
        calTop34End.add(Calendar.DATE,-34);
        calTop34End.set(Calendar.AM_PM, 0);
        calTop34End.set(Calendar.HOUR, 23);
        calTop34End.set(Calendar.MINUTE, 59);
        calTop34End.set(Calendar.SECOND, 59);
        Date top34DateEnd = calTop34End.getTime();
        String formatTop34DateEnd = formatter.format(top34DateEnd);
        //前36 开始
        Calendar calTop35Beg = Calendar.getInstance();
        calTop35Beg.setTime(currentEndDate);
        calTop35Beg.add(Calendar.DATE,-35);
        calTop35Beg.set(Calendar.AM_PM, 0);
        calTop35Beg.set(Calendar.HOUR, 0);
        calTop35Beg.set(Calendar.MINUTE, 0);
        calTop35Beg.set(Calendar.SECOND, 0);
        Date top35DateBeg = calTop35Beg.getTime();
        String formatTop35DateBeg = formatter.format(top35DateBeg);

        //前36 结束
        Calendar calTop35End = Calendar.getInstance();
        calTop35End.setTime(currentEndDate);
        calTop35End.add(Calendar.DATE,-35);
        calTop35End.set(Calendar.AM_PM, 0);
        calTop35End.set(Calendar.HOUR, 23);
        calTop35End.set(Calendar.MINUTE, 59);
        calTop35End.set(Calendar.SECOND, 59);
        Date top35DateEnd = calTop35End.getTime();
        String formatTop35DateEnd = formatter.format(top35DateEnd);

        //前37 开始
        Calendar calTop36Beg = Calendar.getInstance();
        calTop36Beg.setTime(currentEndDate);
        calTop36Beg.add(Calendar.DATE,-36);
        calTop36Beg.set(Calendar.AM_PM, 0);
        calTop36Beg.set(Calendar.HOUR, 0);
        calTop36Beg.set(Calendar.MINUTE, 0);
        calTop36Beg.set(Calendar.SECOND, 0);
        Date top36DateBeg = calTop36Beg.getTime();
        String formatTop36DateBeg = formatter.format(top36DateBeg);

        //前37 结束
        Calendar calTop36End = Calendar.getInstance();
        calTop36End.setTime(currentEndDate);
        calTop36End.add(Calendar.DATE,-36);
        calTop36End.set(Calendar.AM_PM, 0);
        calTop36End.set(Calendar.HOUR, 23);
        calTop36End.set(Calendar.MINUTE, 59);
        calTop36End.set(Calendar.SECOND, 59);
        Date top36DateEnd = calTop36End.getTime();
        String formatTop36DateEnd = formatter.format(top36DateEnd);



        //前90 开始
        Calendar calTop89Beg = Calendar.getInstance();
        calTop89Beg.setTime(currentEndDate);
        calTop89Beg.add(Calendar.DATE,-89);
        calTop89Beg.set(Calendar.AM_PM, 0);
        calTop89Beg.set(Calendar.HOUR, 0);
        calTop89Beg.set(Calendar.MINUTE, 0);
        calTop89Beg.set(Calendar.SECOND, 0);
        Date top89DateBeg = calTop89Beg.getTime();
        String formatTop89DateBeg = formatter.format(top89DateBeg);

        //前90 结束
        Calendar calTop89End = Calendar.getInstance();
        calTop89End.setTime(currentEndDate);
        calTop89End.add(Calendar.DATE,-89);
        calTop89End.set(Calendar.AM_PM, 0);
        calTop89End.set(Calendar.HOUR, 23);
        calTop89End.set(Calendar.MINUTE, 59);
        calTop89End.set(Calendar.SECOND, 59);
        Date top89DateEnd = calTop89End.getTime();
        String formatTop89DateEnd = formatter.format(top89DateEnd);


        //结果存入map(14天时间--满足次日 3日 7日)
        Map<String, String> map = new HashMap<String, String>();
        map.put("formatNextDateBeg", formatNextDateBeg);
        map.put("formatNextDateEnd", formatNextDateEnd);
        map.put("formatDateBeg", formatDateBeg);
        map.put("formatDateEnd", formatDateEnd);
        map.put("formatTopDateBeg", formatTopDateBeg);
        map.put("formatTopDateEnd", formatTopDateEnd);
        map.put("formatTop2DateBeg", formatTop2DateBeg);
        map.put("formatTop2DateEnd", formatTop2DateEnd);
        map.put("formatTop3DateBeg", formatTop3DateBeg);
        map.put("formatTop3DateEnd", formatTop3DateEnd);
        map.put("formatTop4DateBeg", formatTop4DateBeg);
        map.put("formatTop4DateEnd", formatTop4DateEnd);
        map.put("formatTop5DateBeg", formatTop5DateBeg);
        map.put("formatTop5DateEnd", formatTop5DateEnd);
        map.put("formatTop6DateBeg", formatTop6DateBeg);
        map.put("formatTop6DateEnd", formatTop6DateEnd);
        map.put("formatTop7DateBeg", formatTop7DateBeg);
        map.put("formatTop7DateEnd", formatTop7DateEnd);
        map.put("formatTop8DateBeg", formatTop8DateBeg);
        map.put("formatTop8DateEnd", formatTop8DateEnd);
        map.put("formatTop9DateBeg", formatTop9DateBeg);
        map.put("formatTop9DateEnd", formatTop9DateEnd);
        map.put("formatTop10DateBeg", formatTop10DateBeg);
        map.put("formatTop10DateEnd", formatTop10DateEnd);
        map.put("formatTop11DateBeg", formatTop11DateBeg);
        map.put("formatTop11DateEnd", formatTop11DateEnd);
        map.put("formatTop12DateBeg", formatTop12DateBeg);
        map.put("formatTop12DateEnd", formatTop12DateEnd);
        map.put("formatTop13DateBeg", formatTop13DateBeg);
        map.put("formatTop13DateEnd", formatTop13DateEnd);

        map.put("formatNext2DateBeg", formatNext2DateBeg);
        map.put("formatNext2DateEnd", formatNext2DateEnd);
        map.put("formatNext3DateBeg", formatNext3DateBeg);
        map.put("formatNext3DateEnd", formatNext3DateEnd);
        map.put("formatNext4DateBeg", formatNext4DateBeg);
        map.put("formatNext4DateEnd", formatNext4DateEnd);
        map.put("formatNext5DateBeg", formatNext5DateBeg);
        map.put("formatNext5DateEnd", formatNext5DateEnd);
        map.put("formatNext6DateBeg", formatNext6DateBeg);
        map.put("formatNext6DateEnd", formatNext6DateEnd);
        map.put("formatNext7DateBeg", formatNext7DateBeg);
        map.put("formatNext7DateEnd", formatNext7DateEnd);
        map.put("formatTop29DateBeg", formatTop29DateBeg);
        map.put("formatTop29DateEnd", formatTop29DateEnd);
        map.put("formatTop30DateBeg", formatTop30DateBeg);
        map.put("formatTop30DateEnd", formatTop30DateEnd);
        map.put("formatTop31DateBeg", formatTop31DateBeg);
        map.put("formatTop31DateEnd", formatTop31DateEnd);
        map.put("formatTop32DateBeg", formatTop32DateBeg);
        map.put("formatTop32DateEnd", formatTop32DateEnd);
        map.put("formatTop33DateBeg", formatTop33DateBeg);
        map.put("formatTop33DateEnd", formatTop33DateEnd);
        map.put("formatTop34DateBeg", formatTop34DateBeg);
        map.put("formatTop34DateEnd", formatTop34DateEnd);
        map.put("formatTop35DateBeg", formatTop35DateBeg);
        map.put("formatTop35DateEnd", formatTop35DateEnd);
        map.put("formatTop36DateBeg", formatTop36DateBeg);
        map.put("formatTop36DateEnd", formatTop36DateEnd);

        map.put("formatTop89DateBeg", formatTop89DateBeg);
        map.put("formatTop89DateEnd", formatTop89DateEnd);

        return map;
    }
    /**
     * @Description: 整数(秒数)转换为时分秒格式
     * @Date 2020/11/26 16:31
     * @param time
     * @return
    **/
    public static String secToTime(long time) {
        String timeStr = null;
        long hour = 0;
        long minute = 0;
        long second = 0;
        if (time <= 0){
            return "0小时:00分钟:00秒";
        }else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = "0小时:"+ minute + "分:" + second+ "秒";
            } else {
                hour = minute / 60;
                if(hour > 99){
                return "99:59:59"; }
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = hour + "小时:" + minute + "分:" + second+ "秒";

            }
        }
        return timeStr;
    }


}
