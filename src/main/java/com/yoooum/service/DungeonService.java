package com.yoooum.service;

import com.yoooum.dao.DungeonDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.entity.common.Item;
import com.yoooum.entity.dungeon.*;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DungeonService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:34
 * @Version 1.0
 */
@Service
public class DungeonService
{
    @Autowired
    private PublicDao publicDao;

    @Autowired
    private DungeonDao dungeonDao;

    private static DecimalFormat df = new DecimalFormat("0.00");

    //茶楼副本
    public List<TeaHouse> teaHouse(String startDate, String expirationDate, Integer platformId)
    {
        List<TeaHouse> teaHouseList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "TeaFlow_" + dateList.get(i).replace("-", "");
            TeaHouse teaHouse = new TeaHouse();
            teaHouse.setDateSign(dateList.get(i));
            teaHouse.setPlaySum(0);
            teaHouse.setPlayDauAvg("0.00%");
            teaHouse.setPlayNumAvg("0.00");
            // 1.查询dau
            int dau = 0;
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.查询当日参与茶楼的人数次数
            try
            {
                DungeonUtil tea = dungeonDao.teaHouse(tbName, platformId);
                if (null != tea)
                {
                    teaHouse.setPlayDauAvg(
                            dau == 0 ? "0.00%" : df.format((float) tea.getSum() / dau * 100) + "%");
                    teaHouse.setPlaySum(tea.getSum());
                    teaHouse.setPlayNumAvg(tea.getSum() == 0 ? "0.00%" : df.format((float) tea.getReason() / tea.getSum()));
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            // 3.参与茶楼层数人数分布按
            try
            {
                List<DungeonUtil> twoList = dungeonDao.teaHouseList(tbName, platformId);
                for (int j = 0; j < twoList.size(); j++)
                {
                    if (twoList.get(j).getReason() == 1)
                    {
                        teaHouse.setHouse01(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 2)
                    {
                        teaHouse.setHouse02(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 3)
                    {
                        teaHouse.setHouse03(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 4)
                    {
                        teaHouse.setHouse04(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 5)
                    {
                        teaHouse.setHouse05(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 6)
                    {
                        teaHouse.setHouse06(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 7)
                    {
                        teaHouse.setHouse07(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 8)
                    {
                        teaHouse.setHouse08(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 9)
                    {
                        teaHouse.setHouse09(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 10)
                    {
                        teaHouse.setHouse10(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 11)
                    {
                        teaHouse.setHouse11(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 12)
                    {
                        teaHouse.setHouse12(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 13)
                    {
                        teaHouse.setHouse13(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 14)
                    {
                        teaHouse.setHouse14(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 15)
                    {
                        teaHouse.setHouse15(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 16)
                    {
                        teaHouse.setHouse16(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 17)
                    {
                        teaHouse.setHouse17(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 18)
                    {
                        teaHouse.setHouse18(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 19)
                    {
                        teaHouse.setHouse19(twoList.get(j).getSum());
                    }
                    if (twoList.get(j).getReason() == 20)
                    {
                        teaHouse.setHouse20(twoList.get(j).getSum());
                    }

                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 设值 参与率
            teaHouseList.add(teaHouse);
        }

        return teaHouseList;

    }

    // 猫探险
    public List<Cat> catExpedition(String startDate, String expirationDate, Integer platformId)
    {
        List<Cat> catList = new ArrayList<Cat>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "GoExploreFlow_" + dateList.get(i).replace("-", "");
            Cat cat = new Cat();
            String playDauAvg = "0.00%";
            String playSumAvg = "0.00";
            // 1.查询dau
            int dau = 0;
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            // 2.查询当日猫探险参与人数和人均参与次数
            int catNum = 0;
            int catSum = 0;
            try
            {
                Cat queryCatNumSum = dungeonDao.catNumSum(tbName, platformId);
                if (null != queryCatNumSum)
                {
                    catNum = queryCatNumSum.getPlaySum();
                    catSum = queryCatNumSum.getCutSum();
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            // 3.泥潭、溪涧、江河、湍流、寒水参与人数
            try
            {
                List<DungeonUtil> catExpedition = dungeonDao.mapNumSum(tbName, platformId);
                for (int j = 0; j < catExpedition.size(); j++)
                {
                    if (catExpedition.get(j).getReason() == 3)
                    {
                        cat.setRivers(catExpedition.get(j).getSum());
                    }
                    if (catExpedition.get(j).getReason() == 2)
                    {
                        cat.setBrooksideSum(catExpedition.get(j).getSum());
                    }
                    if (catExpedition.get(j).getReason() == 4)
                    {
                        cat.setTurbulenceSum(catExpedition.get(j).getSum());
                    }
                    ;
                    if (catExpedition.get(j).getReason() == 5)
                    {
                        cat.setColdWaterSum(catExpedition.get(j).getSum());
                    }
                    if (catExpedition.get(j).getReason() == 1)
                    {
                        cat.setMireSum(catExpedition.get(j).getSum());
                    }
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 设值 参与率
            cat.setDateSign(dateList.get(i));
            cat.setPlaySum(catNum);
            cat.setPlayDauAvg(dau == 0 ? "0.00%" : df.format((float) catNum / dau * 100) + "%");
            cat.setCutSum(catSum);
            cat.setPlaySumAvg(catNum == 0 ? "0.00" : df.format((float) catSum / catNum) + "");
            catList.add(cat);
        }


        return catList;
    }

    // 八卦楼
    public List<BaGuaLou> baGuaFloor(String startDate, String expirationDate, Integer platformId)
    {
        List<BaGuaLou> baGuoLouList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "BaGuaLouFlow_" + dateList.get(i).replace("-", "");
            BaGuaLou bagualou = new BaGuaLou();
            bagualou.setPlaySum(0);
            bagualou.setPlayDauAvg("0.00%");
            // 1.查询dau
            int dau = 0;
            try {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.查询总次数区间分布
            try{
                BaGuaLou queryBAGUALOU = dungeonDao.baGuaLou(tbName, platformId);
                if (null != queryBAGUALOU)
                {
                    bagualou = queryBAGUALOU;
                    bagualou.setPlayDauAvg(
                            dau == 0 ? "0.00%" : df.format((float) bagualou.getPlaySum() / dau * 100) + "%");
                }
            } catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            bagualou.setAnGeSumAvg("0.00");
            bagualou.setQiQingHeSumAvg("0.00");
            bagualou.setShenJiMingSumAvg("0.00");
            bagualou.setLuChenSumAvg("0.00");
            bagualou.setNingBeiSumAvg("0.00");

            // 3.男主次数区间分布
            try
            {
                List<StrTwos> heroList = dungeonDao.hero(tbName, platformId);
                for (int j = 0; j < heroList.size(); j++)
                {
                    if (heroList.get(j).getReason() == 1)
                    {
                        bagualou.setQiQingHeSumAvg(heroList.get(j).getSum());
                    }
                    if (heroList.get(j).getReason() == 2)
                    {
                        bagualou.setAnGeSumAvg(heroList.get(j).getSum());
                    }
                    if (heroList.get(j).getReason() == 3)
                    {
                        bagualou.setNingBeiSumAvg(heroList.get(j).getSum());
                    }
                    ;
                    if (heroList.get(j).getReason() == 4)
                    {
                        bagualou.setLuChenSumAvg(heroList.get(j).getSum());
                    }
                    if (heroList.get(j).getReason() == 5)
                    {
                        bagualou.setShenJiMingSumAvg(heroList.get(j).getSum());
                    }
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            bagualou.setDateSign(dateList.get(i));
            baGuoLouList.add(bagualou);
        }


        return baGuoLouList;
    }

    // 情报委托
    public List<InfoEntrust> intelligenceEntrust(String startDate, String expirationDate, Integer platformId)
    {
        List<InfoEntrust> InfoEntrusts = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "InforTaskFlow_" + dateList.get(i).replace("-", "");
            InfoEntrust infoEntrust = new InfoEntrust();
            // 参与率
            String participationAvg = "0.00%";
            // 人均派遣券消耗
            String speedAvg = "0.00";
            infoEntrust.setDateSign(dateList.get(i));
            // 1.查询dau
            int dau = 0;
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.查询当日参与情报阁的人数次数
            try
            {
                DungeonUtil tea = dungeonDao.infoCountNum(tbName, platformId);
                if (null != tea)
                {
                    infoEntrust.setPlayDauAvg(
                            dau == 0 ? "0.00%" : df.format((float) tea.getSum() / dau * 100) + "%");
                    infoEntrust.setPlaySum(tea.getSum());
                    infoEntrust.setPlayNumAvg(tea.getSum() == 0 ? "0.00" : df.format((float) tea.getReason() / tea.getSum()));
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            // 3.情报委托参与次数
            List<DungeonUtil> twos = new ArrayList<>();
            int sumCount = 0;
            try
            {
                twos = dungeonDao.queryInfoCount(tbName, platformId);
                int Count05 = 0;
                for (int j = 0; j < twos.size(); j++)
                {
                    if (twos.get(j).getReason() == 1)
                    {
                        infoEntrust.setParticipationCount01(twos.get(j).getSum());
                    }
                    if (twos.get(j).getReason() == 2)
                    {
                        infoEntrust.setParticipationCount02(twos.get(j).getSum());
                    }
                    if (twos.get(j).getReason() == 3)
                    {
                        infoEntrust.setParticipationCount03(twos.get(j).getSum());
                    }
                    if (twos.get(j).getReason() == 4)
                    {
                        infoEntrust.setParticipationCount04(twos.get(j).getSum());
                    }
                    if (twos.get(j).getReason() > 4)
                    {
                        Count05 += twos.get(j).getSum();
                    }
                }
                infoEntrust.setParticipationCount05(Count05);

            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 4.情报委托参与人数
            Info infoNum = new Info();
            try
            {
                infoNum = dungeonDao.infoNum(tbName, platformId);
                // 设值
                infoEntrust.setCountAvg(infoNum.getCountAvg());
                infoEntrust.setParticipationSum(infoNum.getParticipationSum());
                infoEntrust.setParticipationNum01(infoNum.getParticipation01());
                infoEntrust.setParticipationNum02(infoNum.getParticipation02());
                infoEntrust.setParticipationNum03(infoNum.getParticipation03());
                infoEntrust.setParticipationNum04(infoNum.getParticipation04());
                infoEntrust.setParticipationNum05(infoNum.getParticipation05());
                sumCount = infoEntrust.getCountSum();
                System.out.println(sumCount);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            participationAvg = (dau == 0 ? "0"
                    : df.format((float) sumCount * 100 / dau) + "%");
            // 5.扫荡券使用次数和人数
            Item plan = new Item();
            try
            {
                plan = dungeonDao.speedTicket("ItemFlow_" + dateList.get(i).replace("-", ""), platformId);
                speedAvg = (dau == 0 ? "0" : df.format((float) plan.getLevelId() / dau));
                infoEntrust.setSpeedSum(plan.getUserNum());
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            // 设值 参与率
            infoEntrust.setParticipationAvg(participationAvg);
            infoEntrust.setSpeedAvg(speedAvg);
            InfoEntrusts.add(infoEntrust);
        }


        return InfoEntrusts;
    }

    // 精英副本(文书阁)挑战情况
    public List<Elite> eliteDungeon(String startDate, String expirationDate, Integer platformId)
    {
        List<Elite> eliteList = new ArrayList<Elite>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            String tbName = "WenShuGeFlow_" + dateList.get(i).replace("-", "");
            Elite elite = new Elite();
            String playDauAvg = "0.00%";
            String playSumAvg = "0.00";
            // 1.查询dau
            int dau = 0;
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            System.out.println("dau:" + dau);
            // 2.情报委托参与次数
            try
            {
                Elite queryEliteCopy = dungeonDao.eliteCopy(tbName, platformId);
                if (null != queryEliteCopy)
                {
                    elite = queryEliteCopy;
                    playDauAvg = (dau == 0 ? "0" : df.format((float) elite.getPlaySum() * 100 / dau) + "%");
                    playSumAvg = (elite.getPlaySum() == 0 ? "0"
                            : df.format((float) elite.getCutSum() / elite.getPlaySum()));
                }
            } catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 设值 参与率
            elite.setDateSign(dateList.get(i));
            elite.setPlayDauAvg(playDauAvg);
            elite.setPlaySumAvg(playSumAvg);
            eliteList.add(elite);

        }

        return eliteList;
    }

}
