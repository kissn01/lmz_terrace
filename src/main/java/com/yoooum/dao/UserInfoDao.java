package com.yoooum.dao;

import com.yoooum.entity.common.Twos;
import com.yoooum.entity.userinfo.TimeSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserInfoDao
 * @Description TODO
 * @Author kiss
 * @Date 2020/11/26 16:09
 * @Version 1.0
 */
public interface UserInfoDao
{
    long queryGameTime(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    long queryPlanTime(@Param("tbName") String tbName,@Param("platformId") Integer platformId);

    TimeSort queryGameTimeSort(@Param("tbName") String tbName,@Param("platformId") Integer platformId,@Param("activeUserId") Integer activeUserId,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs);

    TimeSort queryPlanTimeSort(@Param("tbName") String tbName,@Param("platformId") Integer platformId,@Param("activeUserId") Integer activeUserId,@Param("begRegTs") Integer begRegTs, @Param("endRegTs") Integer endRegTs);

    List<Twos> queryRoleUseCount(@Param("tbName") String tbName, @Param("platformId") Integer platformId);

    List<Twos> queryRolePlayCount(@Param("tbName") String tbName,@Param("platformId") Integer platformId,@Param("roleId") Integer roleId);

    String queryRolePlayCountAvg(@Param("tbName") String tbName,@Param("platformId") Integer platformId);
}
