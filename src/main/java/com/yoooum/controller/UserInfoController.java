package com.yoooum.controller;

import com.yoooum.entity.charge.Ltv;
import com.yoooum.entity.userinfo.Role;
import com.yoooum.entity.userinfo.TimeSort;
import com.yoooum.entity.userinfo.UserBehavior;
import com.yoooum.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:03
 * @Version 1.0
 */

@Slf4j
@Controller
@RequestMapping("userInfo")
@PreAuthorize("hasRole('ROLE_USERINFO')")
public class UserInfoController
{
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("basicBehavior")
    public String basicBehavior()
    {
        log.info("===玩家基础行为===");
        return "userInfo/basicBehavior";
    }

    @ResponseBody
    @PostMapping("basicBehavior")
    public Map<String, List<UserBehavior>> basicBehavior(String startDate, String expirationDate, Integer platformId)
    {
        List<UserBehavior> userBehaviorList = userInfoService.basicBehavior(startDate,expirationDate,platformId);
        Map<String, List<UserBehavior>> map = new HashMap<>();
        map.put("data", userBehaviorList);

        return map;
    }

    @GetMapping("onlineTimeSort")
    public String onlineTimeSort()
    {
        log.info("===在线时长区间分布===");
        return "userInfo/onlineTimeSort";
    }

    @ResponseBody
    @PostMapping("onlineTimeSort")
    public Map<String, List<TimeSort>> onlineTimeSort(String startDate, String expirationDate, Integer platformId, Integer activeUserId)
    {
        List<TimeSort> timeSortList = userInfoService.onlineTimeSort(startDate,expirationDate,platformId,activeUserId);
        Map<String, List<TimeSort>> map = new HashMap<>();
        map.put("data", timeSortList);

        return map;
    }

    @GetMapping("planTimeSort")
    public String planTimeSort()
    {
        log.info("===副本时长区间分布===");
        return "userInfo/planTimeSort";
    }

    @ResponseBody
    @PostMapping("planTimeSort")
    public Map<String, List<TimeSort>> planTimeSort(String startDate, String expirationDate, Integer platformId, Integer activeUserId)
    {
        List<TimeSort> timeSortList = userInfoService.planTimeSort(startDate,expirationDate,platformId,activeUserId);
        Map<String, List<TimeSort>> map = new HashMap<>();
        map.put("data", timeSortList);

        return map;
    }

    @GetMapping("roleUseCount")
    public String roleUseCount()
    {
        log.info("===玩家角色使用情况===");
        return "userInfo/roleUseCount";
    }

    @ResponseBody
    @PostMapping("roleUseCount")
    public Map<String, List<Role>> roleUseCount(String startDate, String expirationDate, Integer platformId)
    {
        List<Role> roleList = userInfoService.roleUseCount(startDate,expirationDate,platformId);
        Map<String, List<Role>> map = new HashMap<>();
        map.put("data", roleList);

        return map;
    }

    @GetMapping("rolePlayCount")
    public String rolePlayCount()
    {
        log.info("===角色出战频次===");
        return "userInfo/rolePlayCount";
    }

//    @ResponseBody
//    @PostMapping("rolePlayCount")
//    public Map<String, List<Role>> rolePlayCount(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Role> roleList = userInfoService.queryRoleCount(startDate,expirationDate,platformId);
//        Map<String, List<Role>> map = new HashMap<>();
//        map.put("data", roleList);
//
//        return map;
//    }

    @GetMapping("roleStarRating")
    public String roleStarRating()
    {
        log.info("===角色星级情况===");
        return "userInfo/roleStarRating";
    }

//    @ResponseBody
//    @PostMapping("roleStarRating")
//    public Map<String, List<Role>> roleStarRating(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Role> roleList = userInfoService.queryRoleCount(startDate,expirationDate,platformId);
//        Map<String, List<Role>> map = new HashMap<>();
//        map.put("data", roleList);
//
//        return map;
//    }

}

