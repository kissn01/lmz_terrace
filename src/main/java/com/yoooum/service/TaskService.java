package com.yoooum.service;

import com.yoooum.dao.TaskDao;
import com.yoooum.entity.task.*;
import com.yoooum.util.DateUtil;
import com.yoooum.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName TaskService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:35
 * @Version 1.0
 */
@Service
public class TaskService
{
    @Autowired
    private TaskDao taskDao;

    //委托关卡每日通过情况
    public List<EveryPass> everyDayPassData(String searchDate, Integer platformId)
    {
        // 格式化标题readXlsmToMap
        Map<Integer, String> map = ReadExcel.readXlsmToMap("config/InforTrust.xlsm", "InforTrust", 9, 1, 12);
        // 默认查询当天
        String tbName = "InforTaskFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null) {
            tbName = "InforTaskFlow_" + searchDate.replace("-", "");
        }
        List<EveryPass> everydayPass = new ArrayList<>();
        try {
            everydayPass = taskDao.getEverydayPass(tbName, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询异常:" + e.getMessage());
        }

        List<PassStar> passStar = new ArrayList<>();
        try {
            taskDao.getPassStar(tbName, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询异常:" + e.getMessage());
        }

        for (int i = 0; i < everydayPass.size(); i++)
        {
            for (int j = 0; j < passStar.size(); j++)
            {
                if (everydayPass.get(i).getTaskID().equals(passStar.get(j).getTaskID()))
                {
                    if (passStar.get(j).getStar() == 0) {
                        everydayPass.get(i).setZeroStar(passStar.get(j).getOpenCount());
                    } else if (passStar.get(j).getStar() == 1) {
                        everydayPass.get(i).setOneStar(passStar.get(j).getOpenCount());
                    } else if (passStar.get(j).getStar() == 2) {
                        everydayPass.get(i).setTwoStar(passStar.get(j).getOpenCount());
                    } else if (passStar.get(j).getStar() == 3) {
                        everydayPass.get(i).setThreeStar(passStar.get(j).getOpenCount());
                    }
                }
                // 设置星级通关率
                if (0 != everydayPass.get(i).getPassConut()) {
                    double passRateStar = (everydayPass.get(i).getOneStar() + everydayPass.get(i).getTwoStar()
                            + everydayPass.get(i).getThreeStar()) * 100 / everydayPass.get(i).getOpenCount();
                    passRateStar = Double.parseDouble(String.format("%.2f", passRateStar));
                    everydayPass.get(i).setPassRateStar(passRateStar);
                }

            }

        }
        // 格式化标题
        for(int n=0;n<everydayPass.size();n++)
        {
            if (null != everydayPass.get(n).getTaskID())
            {
                if(!map.get(Integer.parseInt(everydayPass.get(n).getTaskID())).equals("")) {
                    everydayPass.get(n).setTaskName(map.get(Integer.parseInt(everydayPass.get(n).getTaskID())));
                }else {
                    everydayPass.get(n).setTaskName(everydayPass.get(n).getTaskID());
                }
            }
        }


        return everydayPass;
    }

    //委托首次通过情况
    public List<EntrustFistPass> firstPassData(String searchDate, Integer platformId)
    {
        // 格式化标题
        Map<Integer, String> map = ReadExcel.readXlsmToMap("/config/InforTrust.xlsm", "InforTrust", 9, 1, 12);
        // 默认查询当天
        String tbName = "InforTaskFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null) {
            tbName = "InforTaskFlow_" + searchDate.replace("-", "");
        }
        List<EntrustFistPass> entrustFistPass = taskDao.getEntrustFistPass(tbName, platformId);
        List<StarPassNum> twoPassRate = taskDao.getStarPassNum(tbName, platformId, 2);
        List<StarPassNum> thrPassRate = taskDao.getStarPassNum(tbName, platformId, 3);

        for (int i = 0; i < entrustFistPass.size(); i++) {
            for (int j = 0; j < twoPassRate.size(); j++) {
                if (entrustFistPass.get(i).getEntrustID() == twoPassRate.get(j).getEntrustID()) {
                    entrustFistPass.get(i).setTwoStarNum(twoPassRate.get(j).getStarNum());
                    entrustFistPass.get(i).setTwoPassRate(twoPassRate.get(j).getPassRate());
                }
            }

            for (int k = 0; k < thrPassRate.size(); k++) {
                if (entrustFistPass.get(i).getEntrustID() == thrPassRate.get(k).getEntrustID()) {
                    entrustFistPass.get(i).setThrStarNum(thrPassRate.get(k).getStarNum());
                    entrustFistPass.get(i).setThrPassRate(thrPassRate.get(k).getPassRate());
                }
            }
            entrustFistPass.get(i).setEntrustName(map.get(entrustFistPass.get(i).getEntrustID()));
        }

        return entrustFistPass;
    }

    //指定玩家委托·查询
    public List<InforTaskFlow> checkUser(String searchDate, Integer platformId, Integer playUin) {
        // 默认查询当天
        String tbName = "InforTaskFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null && searchDate != "" && playUin != null) {
            tbName = "InforTaskFlow_" + searchDate.replace("-", "");
        }
        List<InforTaskFlow> checkUser = new ArrayList<>();
        try {
            checkUser = taskDao.getCheckUser(tbName, playUin, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询异常:" + e.getMessage());
        }

        return checkUser;
    }

    //委托通过·玩家 等级分布
    public Map<String, List> userLvlData(String searchDate, Integer platformId)
    {
        Map<Integer, String> map = ReadExcel.readXlsmToMap("/config/InforTrust.xlsm", "InforTrust", 9, 1, 12);
        Map<String, List> resMap = new HashMap<>();
        String tbName = "InforTaskFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null) {
            tbName = "InforTaskFlow_" + searchDate.replace("-", "");
        }

        List<UserLevel> userLevel = new ArrayList<UserLevel>();
        try {
            userLevel = taskDao.getUserLevel(tbName, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询异常:" + e.getMessage());
        }
        System.out.println("======UserLevel======");
        System.out.println(userLevel);
        // 表头等级
        List<Integer> levList = new ArrayList<>();
        // 玩家人数
        List<Integer> userNum = new ArrayList<>();

        // 定义返回行，每行为一个map
        List<Map<String, Integer>> rows = new ArrayList<>();
        Map<String, Integer> row = null;
        int lastLevel = 0;
        for (int i = 0; i < userLevel.size(); i++) {
            UserLevel ul = userLevel.get(i);
            if (lastLevel != ul.getLvl()) {
                lastLevel = ul.getLvl();
                if (row != null) {
                    rows.add(row);
                }
                // 获取表头玩家等级和玩家人数
                levList.add(lastLevel);
                userNum.add(ul.getTotal());
                row = new LinkedHashMap<>();
                row.put("level", lastLevel);
                row.put("total", ul.getTotal());
            }

            String key = String.valueOf(ul.getTaskID()) + String.valueOf(ul.getStar());
            row.put(key, ul.getUserNum());
            if (i == userLevel.size() - 1) {
                rows.add(row);
            }
        }

        // 委托星级
        List<List> taskStar = new ArrayList<>();
        List<String> tempList0 = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>();
        List<String> tempList3 = new ArrayList<>();
        // taskID 1-39
        for (int i = 1; i < 40; i++) {
            tempList0 = UserLelUtil(map, rows, i, 0);
            tempList1 = UserLelUtil(map, rows, i, 1);
            tempList2 = UserLelUtil(map, rows, i, 2);
            tempList3 = UserLelUtil(map, rows, i, 3);
            taskStar.add(tempList0);
            taskStar.add(tempList1);
            taskStar.add(tempList2);
            taskStar.add(tempList3);
        }
        // taskID 1001 - 1005
        for (int i = 1001; i < 1006; i++) {
            tempList0 = UserLelUtil(map, rows, i, 0);
            tempList1 = UserLelUtil(map, rows, i, 1);
            tempList2 = UserLelUtil(map, rows, i, 2);
            tempList3 = UserLelUtil(map, rows, i, 3);
            taskStar.add(tempList0);
            taskStar.add(tempList1);
            taskStar.add(tempList2);
            taskStar.add(tempList3);
        }

        resMap.put("taskStar", taskStar);
        // 格式化等级名 +"级"
        List<String> levName = new ArrayList<String>();
        for (int i = 0; i < levList.size(); i++) {
            levName.add(levList.get(i) + "级玩家人数");
        }

        resMap.put("levList", levName);
        resMap.put("userNum", userNum);

        return resMap;
    }

    public static List<String> UserLelUtil(Map<Integer, String> map, List<Map<String, Integer>> rows, Integer taskId,
                                           Integer star) {
        List<String> userNumList = new ArrayList<String>();
        Integer userNum = 0;
        // 添加委托id
        // 读取配置 获取id 和name

        userNumList.add(map.get(taskId) + "(" + star + ")" + "星");
        // 构造委托任务星级数据
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).get(String.valueOf(taskId) + String.valueOf(star)) != null) {
                userNum = rows.get(i).get(String.valueOf(taskId) + String.valueOf(star));
            } else {
                userNum = 0;
            }
            userNumList.add(String.valueOf(userNum));
        }

        return userNumList;
    }

}
