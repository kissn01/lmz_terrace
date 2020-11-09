package com.yoooum.service;

import com.yoooum.dao.OperationDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.entity.operation.*;
import com.yoooum.util.CollectionUtil;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OperationService
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 17:43
 * @Version 1.0
 */
@Service
public class OperationService
{
    //格式化--保留2位小数
    private static DecimalFormat df = new DecimalFormat("0.00");

    @Autowired
    private OperationDao operationDao;

    @Autowired
    private PublicDao publicDao;

    //运营数据总览
    public List<OperationData> operationData(String startDate, String expirationDate, Integer platformId)
    {

        String tbName = "MyOperationDatas";
        if (platformId != null && platformId != 0)
        {
            tbName = "MyOperationData";
        }
        List<OperationData> OperationDataList = operationDao.operationData(tbName, startDate, expirationDate, platformId);


        return OperationDataList;
    }

    // 查询玩家留存
    public List<Retention> retentionData(String startDate, String expirationDate, Integer platformId)
    {
        List<Retention> retentionList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            Retention Retention = new Retention();
            // 0.拼接
            String sufTbName = dateList.get(i).replace("-", "");
            // 1.设置时间
            Retention.setDateSign(dateList.get(i));
            // 2.新增玩家
            Integer register = 0;
            try
            {
                register = publicDao.queryRegisterSum("PlayerRegister_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            Retention.setNewAddUser(register);
            // 3.活跃玩家
            Integer dau = 0;
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            Retention.setActiveUser(dau);
            // 4. 次日留存
            Retention.setTwoDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 1, platformId) * 100 / register)
                    : "0.00");
            // 5. 3日留存
            Retention.setThreeDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 2, platformId) * 100 / register)
                    : "0.00");
            // 6. 4日留存
            Retention.setFourDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 3, platformId) * 100 / register)
                    : "0.00");
            // 7. 5日留存
            Retention.setFiveDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 4, platformId) * 100 / register)
                    : "0.00");
            // 8. 6日留存
            Retention.setSixDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 5, platformId) * 100 / register)
                    : "0.00");
            // 9. 7日留存
            Retention.setSevenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 6, platformId) * 100 / register)
                    : "0.00");
            // 10. 8日留存
            Retention.setEightDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 7, platformId) * 100 / register)
                    : "0.00");
            // 11. 9日留存
            Retention.setNineDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 8, platformId) * 100 / register)
                    : "0.00");
            // 12. 10日留存
            Retention.setTenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 9, platformId) * 100 / register)
                    : "0.00");
            // 13. 11日留存
            Retention.setElevenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 10, platformId) * 100 / register)
                    : "0.00");
            // 14. 12日留存
            Retention.setTwelveDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 11, platformId) * 100 / register)
                    : "0.00");
            // 15. 13日留存
            Retention.setThirteenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 12, platformId) * 100 / register)
                    : "0.00");
            // 16. 14日留存
            Retention.setFourteenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 13, platformId) * 100 / register)
                    : "0.00");
            // 17. 15日留存
            Retention.setFifteenDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 14, platformId) * 100 / register)
                    : "0.00");
            // 18. 30日留存
            Retention.setThirtyDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 29, platformId) * 100 / register)
                    : "0.00");
            // 19. 60日留存
            Retention.setSixtyDayRet(register != 0
                    ? df.format((float) queryRetention(dateList.get(i), 59, platformId) * 100 / register)
                    : "0.00");

            retentionList.add(Retention);
        }

        return retentionList;

    }

    // 获取指定日期注册uin和他前(后)n天登陆用户uin相同的个数
    public int queryRetention(String checkDate, int passDate, Integer platformId)
    {
        //获取系统日期和查询日期
        String today = cn.hutool.core.date.DateUtil.today();
        String checksDate = DateUtil.getDateAfter(checkDate, passDate, "yyyy-MM-dd");
        int sanmeSize = 0;
        if (today.compareTo(checksDate) > 0)
        {
            // 1)获取当天注册uin
            List<Integer> regUinList = new ArrayList();
            try
            {
                regUinList = publicDao.queryRegisterUin("PlayerRegister_" + checkDate.replace("-", ""), platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            // 2)获取次日登陆uin
            List<Integer> loginUinList = new ArrayList<>();
            try
            {
                loginUinList = publicDao
                        .queryLoginUin("PlayerLogin_" + DateUtil.getDateAfter(checkDate, passDate, "yyyyMMdd"), platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            // 3)获取集合中相同元素的个数
            sanmeSize = CollectionUtil.getSame(regUinList, loginUinList).size();
        }

        return sanmeSize;
    }

    //每小时新增用户
    public List<NewRegistData> registData(String startDate, String expirationDate, Integer platformId)
    {
        List<NewRegistData> regList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int j = dateList.size() - 1; j >= 0; j--)
        {
            String tbName = ("PlayerRegister_" + dateList.get(j).replace("-", ""));
            List<HourNum> HourPeopleNum = new ArrayList<>();
            try
            {
                HourPeopleNum = operationDao.queryHourPeopleNum(tbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL异常：" + e.getMessage());
            }

            //声明12长度的数组  存放每2小时登陆的个数赋初值各为0
            int s[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < HourPeopleNum.size(); i++)
            {
                if (HourPeopleNum.get(i).getHour() == 0)
                {
                    s[0] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 1)
                {
                    s[0] = s[0] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 2)
                {
                    s[1] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 3)
                {
                    s[1] = s[1] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 4)
                {
                    s[2] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 5)
                {
                    s[2] = s[2] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 6)
                {
                    s[3] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 7)
                {
                    s[3] = s[3] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 8)
                {
                    s[4] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 9)
                {
                    s[4] = s[4] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 10)
                {
                    s[5] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 11)
                {
                    s[5] = s[5] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 12)
                {
                    s[6] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 13)
                {
                    s[6] = s[6] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 14)
                {
                    s[7] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 15)
                {
                    s[7] = s[7] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 16)
                {
                    s[8] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 17)
                {
                    s[8] = s[8] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 18)
                {
                    s[9] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 19)
                {
                    s[9] = s[9] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 20)
                {
                    s[10] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 21)
                {
                    s[10] = s[10] + HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 22)
                {
                    s[11] = HourPeopleNum.get(i).getPeopleNum();
                }
                else if (HourPeopleNum.get(i).getHour() == 23)
                {
                    s[11] = s[11] + HourPeopleNum.get(i).getPeopleNum();
                }

            }

            //构造实体类
            Integer peopleNum = s[0] + s[1] + s[2] + s[3] + s[4] + s[5] + s[6] + s[7] + s[8] + s[9] + s[10] + s[11];
            NewRegistData taTime = new NewRegistData(dateList.get(j), peopleNum, s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11]);

            regList.add(taTime);
        }


        return regList;
    }

    //钻石数据总览
    public List<Diamond> queryPayDiamond(String startDate, String expirationDate, Integer platformId)
    {
        List<Diamond> diamondList = new ArrayList<>();
        // 获取需要查询的日期
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            Diamond diamond = new Diamond();
            diamond.setDateSign(dateList.get(i));
            long addSum = 0;
            long subSum = 0;
            long chargeSum = 0;
            long welfareSum = 0;

            int dau = 0;
            List<DiamodTwos> diamondAdd = new ArrayList<>();
            List<DiamodTwos> diamondSub = new ArrayList<>();
            int iAfterCount = 0;
            // 1.查询dau
            try
            {
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.钻石产出
            try
            {
                diamondAdd = operationDao.queryDiamondCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        1, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            for (int j = 0; j < diamondAdd.size(); j++)
            {
                int reason = diamondAdd.get(j).getReason();
                addSum += diamondAdd.get(j).getSum();
                // 39充值
                if (reason == 39)
                {
                    chargeSum = diamondAdd.get(j).getSum();
                }
                // 福利产生钻石量 1、2、3、4、25、26、27、30、32、33、44、89、110、114、115、128、129、130、135、138
                if (reason == 1 || reason == 2 || reason == 3 || reason == 4 || reason == 25 || reason == 26
                        || reason == 27 || reason == 30 || reason == 32 || reason == 33 || reason == 44
                        || reason == 89 || reason == 110 || reason == 114 || reason == 115 || reason == 128
                        || reason == 129 || reason == 130 || reason == 135 || reason == 138)
                {
                    welfareSum += diamondAdd.get(j).getSum();
                }
            }
            try
            {// 3.钻石消耗
                diamondSub = operationDao.queryDiamondCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        2, platformId);
                // 4.钻石存量
                iAfterCount = operationDao.queryDiamondAfterCount(
                        "DiamondChangeFlow_" + dateList.get(i).replace("-", ""), dateList.get(i) + " 0:00:00",
                        dateList.get(i) + " 23:59:59", platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            for (int k = 0; k < diamondSub.size(); k++)
            {
                subSum += diamondSub.get(k).getSum();
            }
            // 设值
            diamond.setAddSum(addSum);
            diamond.setSubSum(-subSum);
            diamond.setChargeSum(chargeSum);
            diamond.setWelfareSum(welfareSum);
            diamond.setSubAvg(dau == 0 ? "0" : df.format((float) -subSum / dau));
            diamond.setWelfareSumAvg(dau == 0 ? "0" : df.format((float) welfareSum / dau));
            diamond.setStorageAvg(dau == 0 ? "0" : df.format((float) iAfterCount / dau));
            diamondList.add(diamond);
        }

        return diamondList;
    }

    //钻石消耗途径分布
    public List<DiamondSub> diamodConsumptionData(String startDate, String expirationDate, Integer platformId)
    {
        List<DiamondSub> DiamondSubs = new ArrayList<>();
        // 获取需要查询的日期
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            DiamondSub DiamondSub = new DiamondSub(dateList.get(i), 0, 0, "0.00", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0);
            Integer subSum = 0;
            Integer subPlaySum = 0;
            List<DiamodTwos> diamondSub = new ArrayList<>();
            try{
                diamondSub = operationDao.queryDiamondCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        2, platformId);
            }catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            for (int k = 0; k < diamondSub.size(); k++)
            {
                subSum += diamondSub.get(k).getSum();
                subPlaySum += diamondSub.get(k).getPlayNum();
                if (diamondSub.get(k).getReason() == 31)
                {
                    DiamondSub.setRetroactive(-diamondSub.get(k).getSum());
                    DiamondSub.setRetroactivePlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 51)
                {
                    DiamondSub.setMerchantExchange(-diamondSub.get(k).getSum());
                    DiamondSub.setMerchantExchangePlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 53)
                {
                    DiamondSub.setBuyItem(-diamondSub.get(k).getSum());
                    DiamondSub.setBuyItemPlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 98)
                {
                    DiamondSub.setAddStar(-diamondSub.get(k).getSum());
                    DiamondSub.setAddStarPlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 119)
                {
                    DiamondSub.setEveryDayTranscript(-diamondSub.get(k).getSum());
                    DiamondSub.setEveryDayTranscriptPlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 122)
                {
                    DiamondSub.setHarvestCat(-diamondSub.get(k).getSum());
                    DiamondSub.setHarvestCatPlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 126)
                {
                    DiamondSub.setDilatationCatHome(-diamondSub.get(k).getSum());
                    DiamondSub.setDilatationCatHomePlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 136)
                {
                    DiamondSub.setUnlockHostStory(-diamondSub.get(k).getSum());
                    DiamondSub.setUnlockHostStoryPlay(diamondSub.get(k).getPlayNum());
                }
                if (diamondSub.get(k).getReason() == 137)
                {
                    DiamondSub.setBuyBag(-diamondSub.get(k).getSum());
                    DiamondSub.setBuyBagPlay(diamondSub.get(k).getPlayNum());
                }
            }
            DiamondSub.setSubSum(-subSum);
            DiamondSub.setSubPlaySum(subPlaySum);
            DiamondSub.setSubPlayAvg(DiamondSub.getSubPlaySum() != 0
                    ? df.format((float) DiamondSub.getSubSum() / DiamondSub.getSubPlaySum())
                    : "0.00");

            DiamondSubs.add(DiamondSub);
        }

        return DiamondSubs;
    }

    //金币查询
    public List<Coin> coinData(String startDate, String expirationDate, Integer platformId) {
        List<Coin> coinList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i=0;i<dateList.size();i++)
        {
            Coin coin = new Coin();
            coin.setDateSign(dateList.get(i));
            // 2.查询玩家金币总增量和总消耗
            long addSum = 0;
            long subSum = 0;
            String addSumAvg = "0.00";
            String subSumAvg = "0.00";
            String tableName = "CoinChangeFlow_" + dateList.get(i).replace("-", "");
            List<CoinTwos> CoinTwoList = new ArrayList<>();
            try {
                CoinTwoList = operationDao.coinChange(tableName, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 获取总增量/总消耗 和 人均增量/人均消耗
            for (int j = 0; j < CoinTwoList.size(); j++) {
                if (CoinTwoList.get(j).getCoin() >= 0) {
                    addSum = CoinTwoList.get(j).getCoin();
                    addSumAvg = df.format(CoinTwoList.get(j).getAvgCoin() == 0 ? "0.00"
                            : (float) addSum / CoinTwoList.get(j).getAvgCoin());
                } else {
                    // 去除-号
                    subSum = -CoinTwoList.get(j).getCoin();
                    subSumAvg = df.format(CoinTwoList.get(j).getAvgCoin() == 0 ? "0.00"
                            : (float) subSum / CoinTwoList.get(j).getAvgCoin());
                }

            }

            // 3.查询玩家产生金币途径
            long welfare = 0;
            long goldByUser = 0;
            List<CoinTwos> userCoin = new ArrayList<>();
            try {
                userCoin = operationDao.userCoinPathway(tableName, platformId);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            for (int m = 0; m < userCoin.size(); m++) {
                // reason 75玩家自行生产金币量
                if (userCoin.get(m).getCoin() == 75 || userCoin.get(m).getCoin() == 76) {
                    goldByUser += userCoin.get(m).getAvgCoin();
                }
                // 福利产生金币量
                if (userCoin.get(m).getCoin() == 11 || userCoin.get(m).getCoin() == 24
                        || userCoin.get(m).getCoin() == 25 || userCoin.get(m).getCoin() == 27
                        || userCoin.get(m).getCoin() == 30 || userCoin.get(m).getCoin() == 32
                        || userCoin.get(m).getCoin() == 33 || userCoin.get(m).getCoin() == 120
                        || userCoin.get(m).getCoin() == 138 || userCoin.get(m).getCoin() == 1000) {
                    welfare += userCoin.get(m).getAvgCoin();
                }
                // 钻石购买金币产量 暂无

            }
            // 4.设置
            coin.setCoinByWelfare(welfare);
            coin.setCoinByUser(goldByUser);
            coin.setAddCoin(addSum);
            coin.setConsumeCoin(subSum);
            coin.setAvgAddCoin(addSumAvg);
            coin.setAvgConsumeCoin(subSumAvg);
            coinList.add(coin);
        }


        return coinList;
    }
}