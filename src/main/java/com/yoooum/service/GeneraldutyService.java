package com.yoooum.service;

import com.yoooum.dao.GeneraldutyDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.entity.common.Item;
import com.yoooum.entity.generalduty.Hero;
import com.yoooum.entity.common.Util;
import com.yoooum.entity.generalduty.Level;
import com.yoooum.entity.generalduty.Order;
import com.yoooum.entity.generalduty.RetenPlann;
import com.yoooum.util.DateUtil;
import com.yoooum.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName GeneraldutyService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:34
 * @Version 1.0
 */
@Service
public class GeneraldutyService
{
    @Autowired
    private GeneraldutyDao generaldutyDao;

    @Autowired
    private PublicDao publicDao;

    // 保留2位小数
    private static DecimalFormat df = new DecimalFormat("0.00");

    //男主好感度
    public List<Hero> menLove(String startDate, String expirationDate,Integer checkId, Integer platformId)
    {
        List<Hero> heroList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "ProtagFavorFlow_" + dateList.get(i).replace("-", "");
            Hero hero = new Hero();
            hero.setDateSign(dateList.get(i));
            hero.setProperSum(0);
            hero.setProperAvg("0.00");
            hero.setDauAvg("0.00%");
            // 1.查询dau
            int dau = 0;
            try{
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.查询当日升级好感度的人数和人均次数
            try{
                Util hc = generaldutyDao.heroCount(tbName, platformId, checkId);
                System.out.println(hc);
                if (null != hc)
                {
                    hero.setProperSum(hc.getSum());
                    hero.setDauAvg(dau == 0 ? "0.00%" : df.format((float) hc.getSum() / dau * 100) + "%");
                    hero.setProperAvg(hc.getReason() == 0 ? "0.00%" : df.format((float) hc.getReason() / hc.getSum()));
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            //3.分布区间
            int cut5 = 0, cut10 = 0, cut15 = 0, cut20 = 0, cuts = 0;
            try{
                List<Util> twoList = generaldutyDao.hero(tbName, platformId, checkId);
                for (int j = 0; j < twoList.size(); j++)
                {
                    if (twoList.get(j).getReason() <= 5)
                    {
                        cut5 += twoList.get(j).getSum();
                    }
                    if (twoList.get(j).getReason() > 5 && twoList.get(j).getReason() <= 10)
                    {
                        cut10 += twoList.get(j).getSum();
                    }
                    if (twoList.get(j).getReason() > 10 && twoList.get(j).getReason() <= 15)
                    {
                        cut15 += twoList.get(j).getSum();
                    }
                    if (twoList.get(j).getReason() > 15 && twoList.get(j).getReason() <= 20)
                    {
                        cut20 += twoList.get(j).getSum();
                    }
                    if (twoList.get(j).getReason() > 20)
                    {
                        cuts += twoList.get(j).getSum();
                    }
                }
            } catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 设值 参与率
            hero.setCut5(cut5);
            hero.setCut10(cut10);
            hero.setCut15(cut15);
            hero.setCut20(cut20);
            hero.setCuts(cuts);
            //4.全体平均   升级用户平均
            int flSum = 0;
            try
            {
                flSum = generaldutyDao.queryFlSum(tbName, platformId, checkId);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            hero.setFlSumAvg(hero.getProperSum() == 0 ? "0.00" : df.format((float) flSum / hero.getProperSum()));
            hero.setFlDauAvg(dau == 0 ? "0.00" : df.format((float) flSum / dau));
            heroList.add(hero);
        }


        return heroList;
    }

    //订单完成情况统计
    public Order orderData(String searchDate,Integer checkId, Integer platformId)
    {
        Order order = new Order();
        if (searchDate != null)
        {
            String tbName = "OrderFlow_" + searchDate.replace("-", "");
            String begRegTime = searchDate + " 0:00:00";
            String endRegTime = searchDate + " 23:59:59";
            List<Item> planList = new ArrayList<>();
            try{
                planList = generaldutyDao.queryUserOrder(tbName, DateUtil.strToStamp(begRegTime), DateUtil.strToStamp(endRegTime),
                        platformId, checkId);
            } catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            for (int i = 0; i < planList.size(); i++)
            {
                try
                {
                    if (planList.get(i).getLevelId() == 1)
                    {
                        order.setOrder01(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 2)
                    {
                        order.setOrder02(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 3)
                    {
                        order.setOrder03(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 4)
                    {
                        order.setOrder04(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 5)
                    {
                        order.setOrder05(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 6)
                    {
                        order.setOrder06(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 7)
                    {
                        order.setOrder07(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 8)
                    {
                        order.setOrder08(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 9)
                    {
                        order.setOrder09(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 10)
                    {
                        order.setOrder10(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 11)
                    {
                        order.setOrder11(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
                try
                {
                    if (planList.get(i).getLevelId() == 12)
                    {
                        order.setOrder12(planList.get(i).getUserNum());
                    }
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
            order.setPersonTotal(order.getOrder01() + order.getOrder02() + order.getOrder03() + order.getOrder04() + order.getOrder05() + order.getOrder06() + order.getOrder07() + order.getOrder08() + order.getOrder09() + order.getOrder10() + order.getOrder11() + order.getOrder12());
        }

        return order;
    }

    // 留存用户等级成长跟踪
    public List<Level> userLvlData(String searchDate, Integer platformId)
    {
        List<List<Item>> planList = new ArrayList<>();
        List<Level> levList = new ArrayList<>();
        String begDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (searchDate != null)
        {
            begDay = searchDate;
        }
        List<String> betweenDate = DateUtil.getBetweenDate(begDay, DateUtil.getDateByNum(begDay, 6));
        Integer maxLev = 0;

        for (int i = 0; i < betweenDate.size(); i++)
        {
            String tbName = ("PlayerLvlFlow_" + betweenDate.get(i).replace("-", ""));
            List<Item> planns = new ArrayList<>();
            try
            {
                planns = generaldutyDao.queryUserLevel(tbName, betweenDate.get(i) + " 0:00:00",
                        betweenDate.get(i) + " 23:59:59", DateUtil.strToStamp(begDay + " 0:00:00"),
                        DateUtil.strToStamp(begDay + " 23:59:59"), platformId);

            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            } finally
            {
                planList.add(planns);
            }

            // 获取最大等级
            for (int j = 0; j < planns.size(); j++)
            {
                maxLev = maxLev > planns.get(j).getLevelId() ? maxLev : planns.get(j).getLevelId();
            }
        }
        for (int l = 0; l < planList.size(); l++)
        {
            List<Integer> idList = new ArrayList();
            List<Integer> addList = new ArrayList();
            // 获取planList中指定个list中所有id存入 idList
            for (int i = 0; i < planList.get(l).size(); i++)
            {
                idList.add(planList.get(l).get(i).getLevelId());
            }
            // 获取需要补齐的id(0-最大等级中 不在idList中的id)
            for (int i = 1; i <= maxLev; i++)
            {
                if (idList.contains(i) == false)
                {
                    addList.add(i);
                }
            }
            // 补齐list
            for (int i = 0; i < addList.size(); i++)
            {
                planList.get(l).add(new Item((int) addList.get(i), 0));
            }
        }

        // 构造1-maxLev 个数据
        for (int i = 1; i <= maxLev; i++)
        {
            Level level = new Level();
            for (int j = 0; j < maxLev; j++)
            {
                if (planList.get(0).get(j).getLevelId() == i)
                {
                    level.setLevel01(i);
                    level.setNum01(planList.get(0).get(j).getUserNum());
                }
                if (planList.get(1).get(j).getLevelId() == i)
                {
                    level.setLevel02(i);
                    level.setNum02(planList.get(1).get(j).getUserNum());
                }
                if (planList.get(2).get(j).getLevelId() == i)
                {
                    level.setLevel03(i);
                    level.setNum03(planList.get(2).get(j).getUserNum());
                }
                if (planList.get(3).get(j).getLevelId() == i)
                {
                    level.setLevel04(i);
                    level.setNum04(planList.get(3).get(j).getUserNum());
                }
                if (planList.get(4).get(j).getLevelId() == i)
                {
                    level.setLevel05(i);
                    level.setNum05(planList.get(4).get(j).getUserNum());
                }
                if (planList.get(5).get(j).getLevelId() == i)
                {
                    level.setLevel06(i);
                    level.setNum06(planList.get(5).get(j).getUserNum());
                }
                if (planList.get(6).get(j).getLevelId() == i)
                {
                    level.setLevel07(i);
                    level.setNum07(planList.get(6).get(j).getUserNum());
                }
            }

            levList.add(level);
        }
        System.out.println(levList.size());
        System.out.println(levList);

        return levList;
    }

    //留存用户关卡成长跟踪
    public List<RetenPlann> userCounterpartData(String searchDate, Integer platformId)
    {
        List<RetenPlann> retenPlannList = new ArrayList<>();
        List<List<Item>> planList = new ArrayList<>();
        // 默认15日的日期
        String fiftenDate = DateUtil.getPastDate(-14);
        // 查询的注册时间 不变定义在外面
        String begRegTime = DateUtil.getPastDate(0) + " 00:00:00";
        String endRegTime = DateUtil.getPastDate(0) + " 23:59:59";
        // 获取当天到15日留存日期集合
        List<String> betweenDate = DateUtil.getBetweenDate(DateUtil.getPastDate(0) + "", fiftenDate);
        if (searchDate != null)
        {
            String begDate = searchDate.subSequence(0, 10) + "";
            fiftenDate = DateUtil.getDateAfter(begDate, 14, "yyyy-MM-dd");
            begRegTime = searchDate.subSequence(0, 10) + " 00:00:00";
            endRegTime = searchDate.subSequence(0, 10) + " 23:59:59";
            betweenDate = DateUtil.getBetweenDate(begDate, fiftenDate);

        }

        Integer maxLevelId = 0;
        // 查询所有天的关卡
        for (int i = 0; i < betweenDate.size(); i++)
        {
            String tbName = ("MainTaskFlow_" + betweenDate.get(i).replace("-", ""));
            System.out.println(tbName);
            List<Item> planns = new ArrayList<>();
            try
            {
                System.out.println(tbName + "||" + DateUtil.strToStamp(begRegTime) + "||" + DateUtil.strToStamp(endRegTime) + "||" + platformId);
                planns = generaldutyDao.queryPlann(tbName, DateUtil.strToStamp(begRegTime), DateUtil.strToStamp(endRegTime),
                        platformId, 1);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常:" + e.getMessage());
            } finally
            {
                planList.add(planns);
                // 获取最大关卡id
                for (int j = 0; j < planns.size(); j++)
                {
                    maxLevelId = maxLevelId > planns.get(j).getLevelId() ? maxLevelId : planns.get(j).getLevelId();
                }
            }
        }
        // 获取最大的Level的集合
        List<Integer> maxLevelidList = UserUtil.getPlanList(maxLevelId);
        for (int i = 0; i < planList.size(); i++)
        {

            // 1.获取planList中指定list中所有id存入 idList
            List<Integer> idList = new ArrayList();
            for (int l = 0; l < planList.get(i).size(); l++)
            {
                idList.add(planList.get(i).get(l).getLevelId());
            }
            // 2.获取需要补齐的levelid
            List<Integer> addList = new ArrayList<>();
            //
            for (int j = 0; j < maxLevelidList.size(); j++)
            {
                if (idList.contains(maxLevelidList.get(j)) == false)
                {
                    addList.add(maxLevelidList.get(j));
                }
            }

            // 2.补齐levelid
            // 补齐list
            for (int k = 0; k < addList.size(); k++)
            {
                planList.get(i).add(new Item((int) addList.get(k), 0));
            }
        }
        // 构造1-maxLevelidList.size() 个数据
        for (int i = 0; i < maxLevelidList.size(); i++)
        {
            RetenPlann retenPlann = new RetenPlann();
            retenPlann.setLevelId(maxLevelidList.get(i));
            for (int j = 0; j < maxLevelidList.size(); j++)
            {
                if (planList.get(0).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum01(planList.get(0).get(j).getUserNum());
                }
                if (planList.get(1).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum02(planList.get(1).get(j).getUserNum());
                }
                if (planList.get(2).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum03(planList.get(2).get(j).getUserNum());
                }
                if (planList.get(3).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum04(planList.get(3).get(j).getUserNum());
                }
                if (planList.get(4).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum05(planList.get(4).get(j).getUserNum());
                }
                if (planList.get(5).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum06(planList.get(5).get(j).getUserNum());
                }
                if (planList.get(6).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum07(planList.get(6).get(j).getUserNum());
                }
                if (planList.get(7).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum08(planList.get(7).get(j).getUserNum());
                }
                if (planList.get(8).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum09(planList.get(8).get(j).getUserNum());
                }
                if (planList.get(9).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum10(planList.get(9).get(j).getUserNum());
                }
                if (planList.get(10).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum11(planList.get(10).get(j).getUserNum());
                }
                if (planList.get(11).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum12(planList.get(11).get(j).getUserNum());
                }
                if (planList.get(12).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum13(planList.get(12).get(j).getUserNum());
                }
                if (planList.get(13).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum14(planList.get(13).get(j).getUserNum());
                }
                if (planList.get(14).get(j).getLevelId().equals(maxLevelidList.get(i)))
                {
                    retenPlann.setNum15(planList.get(14).get(j).getUserNum());
                }

            }
            retenPlannList.add(retenPlann);
        }

        return retenPlannList;
    }




}
