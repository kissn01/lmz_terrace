//package com.yoooum.controller;
//
//import com.yoooum.entity.charge.Ltv;
//import com.yoooum.service.UserInfoService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName UserInfoController
// * @Description TODO
// * @Author kiss
// * @Date 2020/6/9 11:03
// * @Version 1.0
// */
//@Slf4j
//@Controller
//@RequestMapping("userInfo")
//@PreAuthorize("hasRole('ROLE_USERINFO')")
//public class UserInfoController
//{
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @GetMapping("basicBehavior")
//    public String basicBehavior()
//    {
//        log.info("===玩家基础行为===");
//        return "userInfo/basicBehavior";
//    }
//    @ResponseBody
//    @PostMapping("basicBehavior")
//    public Map<String, List<Ltv>> basicBehavior(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = userInfoService.basicBehavior(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
//
//    @GetMapping("gameOnLineTime")
//    public String gameOnLineTime()
//    {
//        log.info("===游戏在线时长===");
//        return "userInfo/gameOnLineTime";
//    }
//    @ResponseBody
//    @PostMapping("gameOnLineTime")
//    public Map<String, List<Ltv>> gameOnLineTime(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = userInfoService.gameOnLineTime(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
//
//    @GetMapping("catHouseOnLineTime")
//    public String catHouseOnLineTime()
//    {
//        log.info("===猫后院在线时长===");
//        return "userInfo/catHouseOnLineTime";
//    }
//    @ResponseBody
//    @PostMapping("catHouseOnLineTime")
//    public Map<String, List<Ltv>> catHouseOnLineTime(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = userInfoService.catHouseOnLineTime(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
//
//    @GetMapping("activeUserLvlData")
//    public String activeUserLvlData()
//    {
//        log.info("===活跃用户等级分布===");
//        return "userInfo/activeUserLvlData";
//    }
//    @ResponseBody
//    @PostMapping("activeUserLvlData")
//    public Map<String, List<Ltv>> activeUserLvlData(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = userInfoService.activeUserLvlData(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
//
//    @GetMapping("checkUser")
//    public String checkUser()
//    {
//        log.info("===指定玩家游戏行为查询===");
//        return "userInfo/checkUser";
//    }
//    @ResponseBody
//    @PostMapping("checkUser")
//    public Map<String, List<Ltv>> checkUser(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = userInfoService.checkUser(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
//}
