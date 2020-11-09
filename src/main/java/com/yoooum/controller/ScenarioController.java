package com.yoooum.controller;

import com.yoooum.entity.scenario.MainStoryFlow;
import com.yoooum.entity.scenario.MainStorySelectFlow;
import com.yoooum.service.ScenarioService;
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
 * @ClassName ScenarioController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:02
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("scenario")
@PreAuthorize("hasRole('ROLE_SCENARIO')")
public class ScenarioController
{
    @Autowired
    private ScenarioService scenarioService;

    @GetMapping("mainScenario")
    public String mainScenario()
    {
        log.info("===主线剧情分析===");
        return "scenario/mainScenario";
    }
    @ResponseBody
    @PostMapping("mainScenario")
    public Map<String, List<MainStoryFlow>> mainScenario(String searchDate, Integer platformId)
    {
        List<MainStoryFlow> generaldutyList = scenarioService.mainScenario(searchDate,platformId);
        Map<String, List<MainStoryFlow>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }

    @GetMapping("mainScenarioSelect")
    public String mainScenarioSelect()
    {
        log.info("===主线剧情多选一分析===");
        return "scenario/mainScenarioSelect";
    }
    @ResponseBody
    @PostMapping("mainScenarioSelect")
    public Map<String, List<MainStorySelectFlow>> mainScenarioSelect(String searchDate, Integer platformId)
    {
        List<MainStorySelectFlow> generaldutyList = scenarioService.mainScenarioSelect(searchDate,platformId);
        Map<String, List<MainStorySelectFlow>> map = new HashMap<>();
        map.put("data", generaldutyList);

        return map;
    }
}
