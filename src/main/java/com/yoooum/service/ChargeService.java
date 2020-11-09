package com.yoooum.service;

import com.yoooum.dao.ChargeDao;
import com.yoooum.dao.PublicDao;
import com.yoooum.entity.charge.*;
import com.yoooum.entity.common.Twos;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChargeService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/4 10:56
 * @Version 1.0
 */
@Service
public class ChargeService
{
    @Autowired
    private ChargeDao chargeDao;

    @Autowired
    private PublicDao publicDao;

    private static DecimalFormat df = new DecimalFormat("0.00");

    // 用户长期回本
    public List<Ltv> chargeData(String startDate, String expirationDate, Integer platformId)
    {
        List<Ltv> ltvList = new ArrayList<>();
        //获取系统日期和查询日期
        String today = cn.hutool.core.date.DateUtil.today();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            Ltv ltv = new Ltv();
            String checkDate = dateList.get(i).replace("-", "");
            String chargeTbName = "ChargeFlow_" + checkDate;
            Integer begTs = DateUtil.strToStamp(dateList.get(i) + " 0:00:00");
            Integer endTs = DateUtil.strToStamp(dateList.get(i) + " 23:59:59");
            //设置日期
            ltv.setDateSign(dateList.get(i));
            //1.新增玩家
            int registerNunm = 0;
            try
            {
                registerNunm = publicDao.queryRegisterSum("PlayerRegister_" + checkDate, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setRegNum(registerNunm);
            //3.累计充值金额：首日~7日 14日  30日 60日
            //获取当天到7,14,30,60天的日期集合
            List<String> betweenDate07 = DateUtil.getBetweenDateByString(dateList.get(i), DateUtil.getDateAfter(dateList.get(i), 6, "yyyy-MM-dd"));
            List<String> betweenDate14 = DateUtil.getBetweenDateByString(dateList.get(i), DateUtil.getDateAfter(dateList.get(i), 13, "yyyy-MM-dd"));
            List<String> betweenDate30 = DateUtil.getBetweenDateByString(dateList.get(i), DateUtil.getDateAfter(dateList.get(i), 29, "yyyy-MM-dd"));
            List<String> betweenDate60 = DateUtil.getBetweenDateByString(dateList.get(i), DateUtil.getDateAfter(dateList.get(i), 59, "yyyy-MM-dd"));
            //1)获取首日总充值金额
            int tempCharge = 0;
            int chargeDate01 = 0;
            try
            {
                chargeDate01 = chargeDao.chargesSum(chargeTbName, begTs, endTs, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常:" + e.getMessage());
            }
            ltv.setChargeSum01(chargeDate01);

            //新增--7日内
            int chargeDate02 = chargeDate01;
            //比较当前日期和查询时期--判断是否查询
            if (today.compareTo(betweenDate07.get(1)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(1).replace("-", ""), begTs, endTs, platformId);
                chargeDate02 += tempCharge;
            }
            ltv.setChargeSum02(chargeDate02);

            int chargeDate03 = chargeDate02;
            if (today.compareTo(betweenDate07.get(2)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(2).replace("-", ""), begTs, endTs, platformId);
                chargeDate03 += tempCharge;
            }
            ltv.setChargeSum03(chargeDate03);

            int chargeDate04 = chargeDate03;
            if (today.compareTo(betweenDate07.get(3)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(3).replace("-", ""), begTs, endTs, platformId);
                chargeDate04 += tempCharge;
            }
            ltv.setChargeSum04(chargeDate04);

            int chargeDate05 = chargeDate04;
            if (today.compareTo(betweenDate07.get(4)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(4).replace("-", ""), begTs, endTs, platformId);
                chargeDate05 += tempCharge;
            }
            ltv.setChargeSum05(chargeDate05);

            int chargeDate06 = chargeDate05;
            if (today.compareTo(betweenDate07.get(5)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(5).replace("-", ""), begTs, endTs, platformId);
                chargeDate06 += tempCharge;
            }
            ltv.setChargeSum06(chargeDate06);

            int chargeDate07 = chargeDate06;
            if (today.compareTo(betweenDate07.get(6)) > 0)
            {
                tempCharge = chargeDao.chargesSum("ChargeFlow_" + betweenDate07.get(6).replace("-", ""), begTs, endTs, platformId);
                chargeDate07 += tempCharge;
            }
            ltv.setChargeSum07(chargeDate07);

            //3)获取14日总充值金额
            int chargeDate14 = chargeDate07;
            for (int j = 7; j < betweenDate14.size(); j++)
            {
                int chargeDate = 0;
                if (today.compareTo( betweenDate14.get(j)) > 0)
                {
                    chargeDate = chargeDao.chargesSum("ChargeFlow_" + betweenDate14.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate14 += chargeDate;
                }

            }
            ltv.setChargeSum14(chargeDate14);

            //4)获取30日总充值金额
            int chargeDate30 = chargeDate14;
            for (int j = 14; j < betweenDate30.size(); j++)
            {
                int chargeDate = 0;
                if (today.compareTo( betweenDate30.get(j)) > 0)
                {
                    chargeDate = chargeDao.chargesSum("ChargeFlow_" + betweenDate30.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate30 += chargeDate;
                }
            }
            ltv.setChargeSum30(chargeDate30);

            //5)获取60日总充值金额
            int chargeDate60 = chargeDate30;
            for (int j = 30; j < betweenDate60.size(); j++)
            {
                int chargeDate = 0;
                if (today.compareTo( betweenDate60.get(j)) > 0)
                {
                    chargeDate = chargeDao.chargesSum("ChargeFlow_" + betweenDate60.get(j).replace("-", ""), begTs, endTs, platformId);
                    chargeDate60 += chargeDate;
                }

            }
            ltv.setChargeSum60(chargeDate60);

            //4.LTV：  首日~7日 14日  30日 60日
            //1)获取首日LTV
            ltv.setLtv01(registerNunm == 0 ? "0" : df.format((float) chargeDate01 / registerNunm));
            //新增
            ltv.setLtv02(registerNunm == 0 ? "0" : df.format((float) chargeDate02 / registerNunm));
            ltv.setLtv03(registerNunm == 0 ? "0" : df.format((float) chargeDate03 / registerNunm));
            ltv.setLtv04(registerNunm == 0 ? "0" : df.format((float) chargeDate04 / registerNunm));
            ltv.setLtv05(registerNunm == 0 ? "0" : df.format((float) chargeDate05 / registerNunm));
            ltv.setLtv06(registerNunm == 0 ? "0" : df.format((float) chargeDate06 / registerNunm));
            //2)获取7日LTV
            ltv.setLtv07(registerNunm == 0 ? "0" : df.format((float) chargeDate07 / registerNunm));
            //3)获取14日LTV
            ltv.setLtv14(registerNunm == 0 ? "0" : df.format((float) chargeDate14 / registerNunm));
            //4)获取30日LTV
            ltv.setLtv30(registerNunm == 0 ? "0" : df.format((float) chargeDate30 / registerNunm));
            //5)获取60日LTV
            ltv.setLtv60(registerNunm == 0 ? "0" : df.format((float) chargeDate60 / registerNunm));

            ltvList.add(ltv);
        }

        return ltvList;
    }

    // 用户付费解析
    public List<AnalysisPay> chargeAnalysis(String startDate, String expirationDate, Integer platformId)
    {
        List<AnalysisPay> analysisPays = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            AnalysisPay analysisPay = new AnalysisPay();
            analysisPay.setDateSign(dateList.get(i));
            // 0.设置时间
            analysisPay.setDateSign(dateList.get(i));
            Integer register = 0;
            int newChargeNum = 0;
            String newCharge = "0.00";
            String chargeSum = "0.00";
            Integer dau = 0;
            Integer chargeNum = 0;
            String arppu = "0.00";

            // 1.TbName
            String sufTbName = dateList.get(i).replace("-", "");
            try
            {
                // 2.新增用户数
                register = publicDao.queryRegisterSum("PlayerRegister_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }
            try
            {
                // 3.新进用户的付费人数
                newChargeNum = chargeDao.chargeNumByReg("ChargeFlow_" + sufTbName,
                        DateUtil.strToStamp(dateList.get(i) + " 0:00:00"),
                        DateUtil.strToStamp(dateList.get(i) + " 23:59:59"), platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }
            try
            {
                // 4.新增用户付费金额
                Integer tempNewCharge = chargeDao.newChargeSum("ChargeFlow_" + sufTbName,
                        DateUtil.strToStamp(dateList.get(i) + " 0:00:00"),
                        DateUtil.strToStamp(dateList.get(i) + " 23:59:59"), platformId) / 100;
                newCharge = tempNewCharge != 0 ? df.format((float) tempNewCharge / 100) : "0.00";
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }
            try
            {

                // 1.总付费金额
                Integer tempChargeSum = chargeDao.chargeUserSum("ChargeFlow_" + sufTbName, platformId);
                chargeSum = tempChargeSum != 0 ? df.format((float) tempChargeSum / 100) : "0.00";
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }
            try
            {
                // 2.DAU
                dau = publicDao.queryLoginSum("PlayerLogin_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }
            try
            {
                // 3.付费用户数
                chargeNum = chargeDao.chargeUserNum("ChargeFlow_" + sufTbName, platformId);
            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e);
            }

            // 设值
            analysisPay.setRegNum(register != null ? register : 0);
            analysisPay.setNewPayNum(newChargeNum);
            analysisPay.setRegPaySum(newCharge);
            analysisPay.setPayTotal(chargeSum != null ? chargeSum : "0");
            analysisPay.setDau(dau != null ? dau : 0);
            analysisPay.setPayNum(chargeNum != null ? chargeNum : 0);
            // 4.付费渗透率 充值玩家/活跃玩家
            analysisPay.setPayRate(dau != 0 ? df.format((float) chargeNum * 100 / dau) : "0.00");
            // 5.总付费用户ARPU值 当天的总收入/当天的付费用户总数
            analysisPay.setPayNumArpu(chargeNum != 0 ? df.format(Float.parseFloat(chargeSum) / chargeNum) : "0.00");
            // 5.新用户付费率 新进用户的付费人数/新增用户数*100%
            analysisPay.setNewPayRate(register != 0 ? df.format((float) newChargeNum * 100 / register) : "0.00");
            // 6.新付费用户ARPU值 新用户当日的充值金额/新用户付费人数
            analysisPay.setNewNumArpu(newChargeNum != 0 ? df.format(Float.parseFloat(newCharge) / newChargeNum) : "0.00");
            // 6.活跃用户ARPU值 当天的总收入/DAU
            arppu = dau != 0 ? df.format(Float.parseFloat(chargeSum) / dau) : "0.00";
            analysisPay.setDauNumArpu(arppu);
            // 7.新增活跃用户ARPU值 当天新注册的用户总付费数/当天的新增用户数
            analysisPay.setNewDauNumArpu(register != 0 ? df.format(Float.parseFloat(newCharge) / register) : "0.00");
            // 8.设置渠道id
            analysisPay.setPlatformId(platformId);

            analysisPays.add(analysisPay);
        }

        return analysisPays;

    }

    //玩家充值区间
    public List<ChargeInterval> chargeInterval(String startDate, String expirationDate, Integer platformId)
    {
        List<ChargeInterval> userChargeAlls = new ArrayList<>();
        Integer[] minMoneyArr = {0, 1000, 3000, 5000, 10000, 20000, 30000, 50000};
        Integer[] maxMoneyArr = {999, 2999, 4999, 9999, 19999, 29999, 49999, 999999999};
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i < dateList.size(); i++)
        {
            ChargeInterval chargeInterval = new ChargeInterval();
            List<Twos> twoList = new ArrayList<>();
            String tbName = "ChargeFlow_" + dateList.get(i).replace("-", "");
            try
            {
                //查询不同区间8次
                for (int j = 0; j < 8; j++)
                {
                    Twos two = chargeDao.chargeSumAndCount(tbName, minMoneyArr[j], maxMoneyArr[j], platformId);
                    twoList.add(two);
                }
                chargeInterval.setDateSign(dateList.get(i));
                chargeInterval.setSumMoney10Num(twoList.get(0).getLevelId());
                chargeInterval.setSumMoney10(twoList.get(0).getUserNum());
                chargeInterval.setSumMoney30Num(twoList.get(1).getLevelId());
                chargeInterval.setSumMoney30(twoList.get(1).getUserNum());
                chargeInterval.setSumMoney50Num(twoList.get(2).getLevelId());
                chargeInterval.setSumMoney50(twoList.get(2).getUserNum());
                chargeInterval.setSumMoney100Num(twoList.get(3).getLevelId());
                chargeInterval.setSumMoney100(twoList.get(3).getUserNum());
                chargeInterval.setSumMoney200Num(twoList.get(4).getLevelId());
                chargeInterval.setSumMoney200(twoList.get(4).getUserNum());
                chargeInterval.setSumMoney300Num(twoList.get(5).getLevelId());
                chargeInterval.setSumMoney300(twoList.get(5).getUserNum());
                chargeInterval.setSumMoney500Num(twoList.get(6).getLevelId());
                chargeInterval.setSumMoney500(twoList.get(6).getUserNum());
                chargeInterval.setSumTop500Num(twoList.get(7).getLevelId());
                chargeInterval.setSumTop500(twoList.get(7).getUserNum());
                //充值金额
                Integer chargeSum = chargeDao.chargeUserSum("ChargeFlow_" + dateList.get(i).replace("-", ""), platformId);
                chargeInterval.setSumMoney20Num(chargeSum == null ? 0 : chargeSum);
                userChargeAlls.add(chargeInterval);

            }
            catch (Exception e)
            {
                System.out.println("SQL查询异常：" + e.getMessage());
            }
        }

        return userChargeAlls;
    }

    //玩家充值查询--UIN
    public List<chargeRecord> chargeSearchByUin(String startDate, String expirationDate, Integer uin)
    {
        List<chargeRecord> eventChargeList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        if (startDate != "" && expirationDate != "" && uin != null)
        {

            for (int i = 0; i < dateList.size(); i++)
            {
                String tbName = ("ChargeFlow_" + dateList.get(i)).replace("-", "");
                try
                {
                    List<chargeRecord> eventCharges = chargeDao.chargeSearchByUin(tbName, uin);
                    System.out.println(eventCharges);
                    eventChargeList.addAll(eventCharges);
                }
                catch (Exception e)
                {
                    System.out.println("SQL查询异常：" + e.getMessage());
                }

            }
        }


        return eventChargeList;
    }

    //玩家充值查询--DATE
    public List<chargeRecord> chargeSearchDate(String startDate, String expirationDate, Integer uin)
    {
        List<chargeRecord> eventChargeList = new ArrayList<>();
        List<String> dateList = DateUtil.getBetweenDateByString(startDate, expirationDate);

        if (startDate != "" && expirationDate != "" && uin != null)
        {
            for (int i = 0; i < dateList.size(); i++)
            {
                String tbName = ("ChargeFlow_" + dateList.get(i)).replace("-", "");
                try
                {
                    List<chargeRecord> eventCharges = chargeDao.chargeSearchDate(tbName, uin);
                    System.out.println(eventCharges);
                    eventChargeList.addAll(eventCharges);
                }
                catch (Exception e)
                {
                    System.out.println("SQL查询异常：" + e.getMessage());
                }

            }
        }


        return eventChargeList;
    }

}
