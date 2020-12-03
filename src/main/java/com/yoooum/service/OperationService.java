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
        List<OperationData> OperationDataList = new ArrayList<>();
        List<String> betweenDate = DateUtil.getBetweenDateByString(startDate, expirationDate);
        if(null==startDate || null==expirationDate){
            betweenDate = DateUtil.getLastSevenDay(0,7);
        }


        for (int i = 0; i <betweenDate.size() ; i++)
        {
            OperationData  operationData= new OperationData();
            operationData.setDateSign(betweenDate.get(i));
            String sufTbName = betweenDate.get(i).replace("-", "");

            //1.查询新增用户
            Integer register = 0;
            try
            {
                register =  publicDao.queryRegisterSum("PlayerRegister_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            operationData.setNewAddUser(register);
            //2.查询dau
            Integer dau = 0;
            try
            {
                dau =  publicDao.queryLoginSum("PlayerLogin_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }

            operationData.setActiveUser(dau);
            //3.查询总注册人数=昨天总累计注册人数+今天累计注册人数  今天时间戳-86400得到昨天的时间戳
            Integer registSum = register;
            try
            {
                registSum +=  publicDao.queryregistTotal((DateUtil.StringToTimestamp(betweenDate.get(i)+" 23:59:59")-86400),platformId);
                System.out.println("截止"+betweenDate.get(i)+"累计注册人数："+registSum);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            operationData.setRegistSum(registSum);
            System.out.println("注册人数:"+register);
            //4.查询次日留存
            operationData.setMorrowRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 1, platformId) * 100 / register)
                    : "0.00");
            //5.查询3日留存
            operationData.setThreeDayRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 2, platformId) * 100 / register)
                    : "0.00");
            //6.查询4日留存
            operationData.setFourDayRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 3, platformId) * 100 / register)
                    : "0.00");
            //7.查询5日留存
            operationData.setFiveDayRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 4, platformId) * 100 / register)
                    : "0.00");
            //8.查询6日留存
            operationData.setSixDayRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 5, platformId) * 100 / register)
                    : "0.00");
            //9.查询7日留存
            operationData.setSevenDayRetention(register != 0
                    ? df.format((float) queryRetention(betweenDate.get(i), 6, platformId) * 100 / register)
                    : "0.00");
            OperationDataList.add(operationData);
        }

        return OperationDataList;
    }

    //新进数据
    public List<TwoHourReg> queryHourPeopleNum(String startDate, String expirationDate, Integer platformId) {
        String startTime = DateUtil.getDays(7).get("begTime");
        String endTime = DateUtil.getDays(1).get("endTime");
        if (startDate != null) {
            startTime = startDate + "  0:00:00";
            endTime = expirationDate + "  23:59:59";
        }

        List<String> dateList = DateUtil.getBetweenDateByString(startTime, endTime);
        List<TwoHourReg> regList = new ArrayList<>();

        for (int i = dateList.size() - 1; i >= 0; i--) {
            String tbName = "PlayerRegister_" + dateList.get(i).replace("-", "");
            try {
                TwoHourReg queryHourPeopleNum = queryHourPeoUtil(dateList.get(i), tbName, DateUtil.strToStamp(dateList.get(i) + " 0:00:00"), DateUtil.strToStamp(dateList.get(i) + " 23:59:59"), platformId);
                regList.add(queryHourPeopleNum);
            } catch (Exception e) {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }


        return regList;
    }

    public TwoHourReg queryHourPeoUtil(String queryDate, String tbName, Integer begTime, Integer endTime, Integer platformId) {
        List<RegistByHour> HourPeopleNum = operationDao.queryRegistByHour(tbName, begTime, endTime, platformId);
        //声明12长度的数组  存放每2小时登陆的个数赋初值各为0
        int s[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < HourPeopleNum.size(); i++) {
            if (HourPeopleNum.get(i).getHourNum() == 0) {
                s[0] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 1) {
                s[0] = s[0] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 2) {
                s[1] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 3) {
                s[1] = s[1] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 4) {
                s[2] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 5) {
                s[2] = s[2] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 6) {
                s[3] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 7) {
                s[3] = s[3] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 8) {
                s[4] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 9) {
                s[4] = s[4] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 10) {
                s[5] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 11) {
                s[5] = s[5] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 12) {
                s[6] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 13) {
                s[6] = s[6] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 14) {
                s[7] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 15) {
                s[7] = s[7] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 16) {
                s[8] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 17) {
                s[8] = s[8] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 18) {
                s[9] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 19) {
                s[9] = s[9] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 20) {
                s[10] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 21) {
                s[10] = s[10] + HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 22) {
                s[11] = HourPeopleNum.get(i).getPeopleNum();
            }
            else if (HourPeopleNum.get(i).getHourNum() == 23) {
                s[11] = s[11] + HourPeopleNum.get(i).getPeopleNum();
            }

        }

        //构造实体类
        Integer peopleNum = s[0] + s[1] + s[2] + s[3] + s[4] + s[5] + s[6] + s[7] + s[8] + s[9] + s[10] + s[11];
        TwoHourReg taTime = new TwoHourReg(queryDate, peopleNum, s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], platformId);

        return taTime;
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
        if (today.compareTo(checksDate) >= 0)
        {
            // 1)获取当天注册uin
            List<Integer> regUinList = new ArrayList();
            try
            {
                regUinList = publicDao.queryRegisterUin("PlayerRegister_" + checkDate.replace("-", ""), platformId);
                System.out.println("======当天注册uin======");
                System.out.println(regUinList.size());
                System.out.println(regUinList);
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
                System.out.println("======次日登陆uin======");
                System.out.println(loginUinList.size());
                System.out.println(loginUinList);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            // 3)获取集合中相同元素的个数
            sanmeSize = CollectionUtil.getSame(regUinList, loginUinList).size();
            System.out.println("集合中相同元素的个数:"+sanmeSize);
        }

        return sanmeSize;
    }


    //迷你币数据总览
    public List<MiNiCoin> queryPayDiamond(String startDate, String expirationDate, Integer platformId)
    {
        List<MiNiCoin> miNiCoinList = new ArrayList<>();
        // 获取需要查询的日期
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            MiNiCoin miNiCoin = new MiNiCoin();
            miNiCoin.setDateSign(dateList.get(i));
            long addSum = 0;
            long subSum = 0;
            long chargeSum = 0;
            long welfareSum = 0;
            long planSum = 0;

            int dau = 0;
            List<MiNiTwos> miNiTwosAdd = new ArrayList<>();
            List<MiNiTwos> miNiTwosSub = new ArrayList<>();
            int iAfterCount = 0;
            // 1.查询dau
            try{
                dau = publicDao.queryLoginSum("PlayerLogin_" + dateList.get(i).replace("-", ""), platformId);
            }catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            // 2.迷你币产出
            try{
                miNiTwosAdd = operationDao.queryMiNiCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        1,platformId);
            }catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            for (int j = 0; j < miNiTwosAdd.size(); j++)
            {
                int reason = miNiTwosAdd.get(j).getReason();
                //获取总产生的--去除GM(reason==1000)添加的
                if(reason!=1000){addSum += miNiTwosAdd.get(j).getSum();}

                // 获取充值产生的
                if (reason == 16){chargeSum = miNiTwosAdd.get(j).getSum();}

                //获取副本产生的 13
                if (reason == 13){planSum = miNiTwosAdd.get(j).getSum();}

                //获取福利产生的 reason非13   16  1000
                if (reason != 13 && reason != 16 && reason != 1000 ){
                    welfareSum += miNiTwosAdd.get(j).getSum();
                }
            }
            try{// 3.迷你币消耗
                miNiTwosSub = operationDao.queryMiNiCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        2, platformId);
                // 4.迷你币存量
                iAfterCount = operationDao.queryDiamondAfterCount(
                        "DiamondChangeFlow_" + dateList.get(i).replace("-", ""), dateList.get(i) + " 0:00:00",
                        dateList.get(i) + " 23:59:59", platformId);
                System.out.println("============迷你币存量============");
                System.out.println(iAfterCount);
            }catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }
            for (int k = 0; k < miNiTwosSub.size(); k++)
            {
                subSum += miNiTwosSub.get(k).getSum();
            }
            // 设值
            miNiCoin.setAddSum(addSum);
            miNiCoin.setSubSum(-subSum);
            miNiCoin.setChargeSum(chargeSum);
            miNiCoin.setWelfareSum(welfareSum);
            miNiCoin.setPlanSum(planSum);
            miNiCoin.setSubSumAvg(dau == 0 ? "0" : df.format((float) -subSum / dau));
            miNiCoin.setPlanSumAvg(dau == 0 ? "0" : df.format((float) planSum / dau));
            miNiCoin.setStorageAvg(dau == 0 ? "0" : df.format((float) iAfterCount / dau));
            miNiCoinList.add(miNiCoin);
        }

        return miNiCoinList;
    }

    //钻石消耗途径分布
    public List<MiNiCoinSub> diamodConsumptionData(String startDate, String expirationDate, Integer platformId)
    {
        List<MiNiCoinSub> miNiCoinSubList = new ArrayList<>();
        // 获取需要查询的日期
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            MiNiCoinSub miNiCoinSub = new MiNiCoinSub(dateList.get(i),0,0,0,0,0,0);
            List<MiNiTwos> miNiTwos = new ArrayList<>();
            try{
                miNiTwos = operationDao.queryMiNiCharge("DiamondChangeFlow_" + dateList.get(i).replace("-", ""),
                        2, platformId);
            }catch (Exception e){
                System.out.println("SQL查询异常：" + e.getMessage());
            }

            for (int k = 0; k < miNiTwos.size(); k++)
            {
                if (miNiTwos.get(k).getReason() == 31)
                {
                    miNiCoinSub.setUnlockCharacter(-miNiTwos.get(k).getSum());
                }else if (miNiTwos.get(k).getReason() == 20)
                {
                    miNiCoinSub.setRisingStarRole(-miNiTwos.get(k).getSum());
                }else if (miNiTwos.get(k).getReason() == 46)
                {
                    miNiCoinSub.setRefreshStore(-miNiTwos.get(k).getSum());
                }else if (miNiTwos.get(k).getReason() == 4)
                {
                    miNiCoinSub.setShopPurchase(-miNiTwos.get(k).getSum());
                }else if (miNiTwos.get(k).getReason() == 25)
                {
                    miNiCoinSub.setUnlockedFarmland(-miNiTwos.get(k).getSum());
                }else if (miNiTwos.get(k).getReason() == 36)
                {
                    miNiCoinSub.setRanchUpgrade(-miNiTwos.get(k).getSum());
                }

            }


            miNiCoinSubList.add(miNiCoinSub);
        }

        return miNiCoinSubList;
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
