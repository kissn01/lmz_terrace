package com.yoooum.controller;

import com.yoooum.entity.generalduty.Hero;
import com.yoooum.entity.generalduty.Level;
import com.yoooum.entity.generalduty.Order;
import com.yoooum.entity.generalduty.RetenPlann;
import com.yoooum.service.GeneraldutyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName generaldutyController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:01
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("generalduty")
@PreAuthorize("hasRole('ROLE_GENERALDUTY')")
public class GeneraldutyController
{
    @Autowired
    private GeneraldutyService generaldutyService;

    @GetMapping("menLove")
    public String menLove()
    {
        log.info("===男主好感===");
        return "generalduty/menLove";
    }
    @ResponseBody
    @PostMapping("menLove")
    public Map<String, List<Hero>> menLove(String startDate, String expirationDate,Integer checkId, Integer platformId)
    {
        List<Hero> generaldutyList = generaldutyService.menLove(startDate,expirationDate,checkId,platformId);
        System.out.println(generaldutyList);
        Map<String, List<Hero>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }

    @GetMapping("orderData")
    public String orderData()
    {
        log.info("===订单完成情况统计===");
        return "generalduty/orderData";
    }
    @ResponseBody
    @PostMapping("orderData")
    public Map<String, List<Order>> orderData(String searchDate,Integer checkId, Integer platformId)
    {
        Order order = generaldutyService.orderData(searchDate, platformId, checkId);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        Map<String, List<Order>> map = new HashMap<>();
        map.put("data", orderList);

        return map;
    }

    @GetMapping("userLvlData")
    public String userLvlData()
    {
        log.info("===留存用户等级分布===");
        return "generalduty/userLvlData";
    }

    @ResponseBody
    @PostMapping("userLvlData")
    public Map<String, List<Level>> userLvlData(String searchDate, Integer platformId)
    {
        List<Level> generaldutyList = generaldutyService.userLvlData(searchDate,platformId);
        Map<String, List<Level>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }

    @GetMapping("userCounterpartData")
    public String userCounterpartData()
    {
        log.info("===留存用户关卡成长跟踪===");
        return "generalduty/userCounterpartData";
    }
    @ResponseBody
    @PostMapping("userCounterpartData")
    public Map<String, List<RetenPlann>> userCounterpartData(String searchDate, Integer platformId)
    {
        List<RetenPlann> generaldutyList = generaldutyService.userCounterpartData(searchDate,platformId);
        Map<String, List<RetenPlann>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }
}
