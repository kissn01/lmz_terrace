package com.yoooum.service;

import com.yoooum.dao.PublicDao;
import com.yoooum.dao.UserInfoDao;
import com.yoooum.entity.common.Twos;
import com.yoooum.entity.userinfo.Role;
import com.yoooum.entity.userinfo.TimeSort;
import com.yoooum.entity.userinfo.UserBehavior;
import com.yoooum.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserInfoService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:35
 * @Version 1.0
 */
@Service
public class UserInfoService
{

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private PublicDao publicDao;
    
    /**
     * @Description: 玩家基础行为数据
     * @Date 2020/11/27 11:24
     * @param startDate
     * @param expirationDate
     * @param platformId
     * @return 
    **/
    public List<UserBehavior> basicBehavior(String startDate, String expirationDate, Integer platformId)
    {
        List<UserBehavior> behaviorList = new ArrayList<>();
        List<String> checkDateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i <checkDateList.size() ; i++)
        {
            UserBehavior userBehavior = new UserBehavior(checkDateList.get(i),0,0,"0小时0分钟0秒","0小时0分钟0秒","0小时0分钟0秒");
            String sufTbName = checkDateList.get(i).replace("-", "");
            //1.DAU	登录次数
            Integer dau = 0;
            Integer loginCount = 0;
            try{
                Twos two =  publicDao.queryLoginSumAndCount("PlayerLogin_" + sufTbName, platformId);
                dau = two.getLevelId();
                loginCount = two.getUserNum();
            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            userBehavior.setDau(dau);
            userBehavior.setLoginCount(loginCount);
            //2.游戏时长
            long gameTime = 0;
            try{
                gameTime =  userInfoDao.queryGameTime("OnlineTime_" + sufTbName, platformId);

            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            userBehavior.setGameTime(DateUtil.secToTime(gameTime));
            //3.副本时长
            long planTime = 0;
            try{
                planTime =  userInfoDao.queryPlanTime("BattleFlow_" + sufTbName, platformId);

            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
            userBehavior.setPlanTime(DateUtil.secToTime(planTime));
            //4.小镇时长
            userBehavior.setCityTime(DateUtil.secToTime((gameTime-planTime)));
            behaviorList.add(userBehavior);
        }

        return behaviorList;
    }
    
    /**
     * @Description: 在线时长区间分布
     * @Date 2020/11/27 11:25
     * @param startDate
     * @param expirationDate
     * @param platformId
     * @return 
    **/
    public List<TimeSort> onlineTimeSort(String startDate, String expirationDate, Integer platformId,Integer activeUserId)
    {
        List<TimeSort> timeSortList = new ArrayList<>();
        List<String> checkDateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i <checkDateList.size() ; i++)
        {
            String sufTbName = checkDateList.get(i).replace("-", "");
            try{
                TimeSort timeSort = userInfoDao.queryGameTimeSort("OnlineTime_" + sufTbName, platformId,activeUserId,DateUtil.strToStamp(checkDateList.get(i)+" 0:00:00"),DateUtil.strToStamp(checkDateList.get(i)+" 23:59:59"));
                timeSort.setDateSign(checkDateList.get(i));
                timeSortList.add(timeSort);
            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
        }

        return timeSortList;
    }

    /**
     * @Description: 副本时长区间分布
     * @Date 2020/11/27 11:26
     * @param startDate
     * @param expirationDate
     * @param platformId
     * @return
    **/
    public List<TimeSort> planTimeSort(String startDate, String expirationDate, Integer platformId,Integer activeUserId)
    {
        List<TimeSort> timeSortList = new ArrayList<>();
        List<String> checkDateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i <checkDateList.size() ; i++)
        {
            String sufTbName = checkDateList.get(i).replace("-", "");
            try{
                TimeSort timeSort = userInfoDao.queryPlanTimeSort("BattleFlow_" + sufTbName, platformId,activeUserId,DateUtil.strToStamp(checkDateList.get(i)+" 0:00:00"),DateUtil.strToStamp(checkDateList.get(i)+" 23:59:59"));
                timeSort.setDateSign(checkDateList.get(i));
                timeSortList.add(timeSort);
            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
        }

        return timeSortList;
    }
    
    /**
     * @Description: 玩家角色使用情况
     * @Date 2020/12/1 14:41
     * @param startDate
     * @param expirationDate
     * @param platformId
     * @return 
    **/
    public List<Role> roleUseCount(String startDate, String expirationDate, Integer platformId)
    {
        List<Role> roleList = new ArrayList<>();
        List<String> checkDateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i <checkDateList.size() ; i++)
        {
            Role role = new Role(checkDateList.get(i),0,0,0,0,0,0,0);
            String sufTbName = checkDateList.get(i).replace("-", "");
            try{
                List<Twos> twos = userInfoDao.queryRoleUseCount("BattleFlow_" + sufTbName, platformId);
                for (int j = 0; j <twos.size() ; j++)
                {
                    if(twos.get(j).getLevelId()==1101){
                        role.setSumKaKa(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1001){
                        role.setSumNiNi(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1002){
                        role.setSumYeXiaoLong(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1003){
                        role.setSumLiLiSi(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1004){
                        role.setSumHuaXiaoLou(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1005){
                        role.setSumLi(twos.get(j).getUserNum());
                    }else if(twos.get(j).getLevelId()==1006){
                        role.setSumLanSiLuoTe(twos.get(j).getUserNum());
                    }
                }

                roleList.add(role);
            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
        }

        return roleList;
    }

    /**
     * @Description: 角色出战频次
     * @Date 2020/12/1 14:41
     * @param startDate
     * @param expirationDate
     * @param platformId
     * @return
     **/
   /* public List<Role> rolePlayCount(String startDate, String expirationDate, Integer platformId,Integer roleId)
    {
        List<Role> roleList = new ArrayList<>();
        List<String> checkDateList = DateUtil.getBetweenDateByString(startDate, expirationDate);
        for (int i = 0; i <checkDateList.size() ; i++)
        {
            Role role = new Role(checkDateList.get(i),0,0,0,0,0,0,0);
            String sufTbName = checkDateList.get(i).replace("-", "");
            try{
                Twos twos = userInfoDao.queryRolePlayCount("BattleFlow_" + sufTbName, platformId,roleId);
                roleList.add(role);
            }catch (Exception e){
                System.out.println("SQL查询异常！" + e.getMessage());
            }
        }

        return roleList;
    }*/
}
