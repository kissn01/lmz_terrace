package com.yoooum.controller;

import com.yoooum.entity.dungeon.*;
import com.yoooum.service.DungeonService;
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
 * @ClassName DungeonController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:02
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("dungeon")
@PreAuthorize("hasRole('ROLE_DUNGEON')")
public class DungeonController
{

    @Autowired
    private DungeonService dungeonService;

    @GetMapping("teaHouse")
    public String teaHouse()
    {
        log.info("===茶楼副本===");
        return "dungeon/teaHouse";
    }

    @ResponseBody
    @PostMapping("teaHouse")
    public Map<String, List<TeaHouse>> teaHouse(String startDate, String expirationDate, Integer platformId)
    {
        List<TeaHouse> dungeonList = dungeonService.teaHouse(startDate,expirationDate,platformId);
        Map<String, List<TeaHouse>> map = new HashMap<>();
        map.put("data", dungeonList);

        return map;
    }

    @GetMapping("catExpedition")
    public String catExpedition()
    {
        log.info("===猫探险副本===");
        return "dungeon/catExpedition";
    }

    @ResponseBody
    @PostMapping("catExpedition")
    public Map<String, List<Cat>> catExpedition(String startDate, String expirationDate, Integer platformId)
    {
        List<Cat> dungeonList = dungeonService.catExpedition(startDate,expirationDate,platformId);
        Map<String, List<Cat>> map = new HashMap<>();
        map.put("data", dungeonList);

        return map;
    }

    @GetMapping("baGuaFloor")
    public String baGuaFloor()
    {
        log.info("===八卦楼副本===");
        return "dungeon/baGuaFloor";
    }

    @ResponseBody
    @PostMapping("baGuaFloor")
    public Map<String, List<BaGuaLou>> baGuaFloor(String startDate, String expirationDate, Integer platformId)
    {
        List<BaGuaLou> dungeonList = dungeonService.baGuaFloor(startDate,expirationDate,platformId);
        Map<String, List<BaGuaLou>> map = new HashMap<>();
        map.put("data", dungeonList);

        return map;
    }

    @GetMapping("intelligenceEntrust")
    public String intelligenceEntrust()
    {
        log.info("===情报委托副本===");
        return "dungeon/intelligenceEntrust";
    }

    @ResponseBody
    @PostMapping("intelligenceEntrust")
    public Map<String, List<InfoEntrust>> intelligenceEntrust(String startDate, String expirationDate, Integer platformId)
    {
        List<InfoEntrust> dungeonList = dungeonService.intelligenceEntrust(startDate,expirationDate,platformId);
        Map<String, List<InfoEntrust>> map = new HashMap<>();
        map.put("data", dungeonList);

        return map;
    }

    @GetMapping("eliteDungeon")
    public String eliteDungeon()
    {
        log.info("===精英副本===");
        return "dungeon/eliteDungeon";
    }

    @ResponseBody
    @PostMapping("eliteDungeon")
    public Map<String, List<Elite>> eliteDungeon(String startDate, String expirationDate, Integer platformId)
    {
        List<Elite> dungeonList = dungeonService.eliteDungeon(startDate,expirationDate,platformId);
        Map<String, List<Elite>> map = new HashMap<>();
        map.put("data", dungeonList);

        return map;
    }
}
