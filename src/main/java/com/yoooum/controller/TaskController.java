package com.yoooum.controller;

import com.yoooum.entity.charge.Ltv;
import com.yoooum.entity.task.EntrustFistPass;
import com.yoooum.entity.task.EveryPass;
import com.yoooum.entity.task.InforTaskFlow;
import com.yoooum.service.TaskService;
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
 * @ClassName TaskController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:02
 * @Version 1.0
 */

@Slf4j
@Controller
@RequestMapping("task")
@PreAuthorize("hasRole('ROLE_USERINFO')")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping("firstPassData")
    public String firstPassData()
    {
        log.info("===委托首次通过情况===");
        return "task/firstPassData";
    }
    @ResponseBody
    @PostMapping("firstPassData")
    public Map<String, List<EntrustFistPass>> firstPassData(String searchDate, Integer platformId)
    {
        List<EntrustFistPass> generaldutyList = taskService.firstPassData(searchDate,platformId);
        Map<String, List<EntrustFistPass>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }

    @GetMapping("everyDayPassData")
    public String everyDayPassData()
    {
        log.info("===委托关卡每日通过情况===");
        return "task/everyDayPassData";
    }
    @ResponseBody
    @PostMapping("everyDayPassData")
    public Map<String, List<EveryPass>> everyDayPassData(String searchDate, Integer platformId)
    {
        List<EveryPass> generaldutyList = taskService.everyDayPassData(searchDate, platformId);
        Map<String, List<EveryPass>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }

    @GetMapping("userLvlData")
    public String userLvlData()
    {
        log.info("===委托通过玩家等级分布===");
        return "task/userLvlData";
    }
    @ResponseBody
    @PostMapping("userLvlData")
    public Map<String, Map<String, List>> userLvlData(String searchDate, Integer platformId)
    {
        Map<String, List> stringListMap = taskService.userLvlData(searchDate, platformId);


        Map<String, Map<String, List>> map = new HashMap<>();
        map.put("data", stringListMap);

        return map;
    }

    @GetMapping("checkUser")
    public String checkUser()
    {
        log.info("===指定玩家委托情况查询===");
        return "task/checkUser";
    }
    @ResponseBody
    @PostMapping("checkUser")
    public Map<String, List<InforTaskFlow>> checkUser(String searchDate, Integer platformId, Integer playUin)
    {
        List<InforTaskFlow> generaldutyList = taskService.checkUser(searchDate,platformId,playUin);
        Map<String, List<InforTaskFlow>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }
}
