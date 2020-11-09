package com.yoooum.service;

import com.yoooum.dao.ScenarioDao;
import com.yoooum.entity.scenario.MainStoryFlow;
import com.yoooum.entity.scenario.MainStorySelectFlow;
import com.yoooum.util.DateUtil;
import com.yoooum.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ScenarioService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:35
 * @Version 1.0
 */
@Service
public class ScenarioService
{
    @Autowired
    private ScenarioDao scenarioDao;

    public List<MainStoryFlow> mainScenario(String searchDate, Integer platformId)
    {
        // 格式化标题
        Map<Integer, String> map = ReadExcel.readXlsmToMap("config/MainChapter.xlsm", "ChapterBaseCfg", 8, 1, 2);
        // 默认查询当天
        String tbName = "MainStoryFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null) {
            tbName = "MainStoryFlow_" + searchDate.replace("-", "");
        }
        List<MainStoryFlow> mainStoryFlow = new ArrayList<>();
        try {
            mainStoryFlow = scenarioDao.mainStoryFlow(tbName, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询错误：" + e.getMessage());
        }
        // 格式化章节名称
        for (int i = 0; i < mainStoryFlow.size(); i++) {
            if (map.get(mainStoryFlow.get(i).getChapterID()) != null) {
                mainStoryFlow.get(i).setChapterName(map.get(mainStoryFlow.get(i).getChapterID()));
            }

        }

        return mainStoryFlow;
    }

    public List<MainStorySelectFlow> mainScenarioSelect(String searchDate, Integer platformId)
    {
        // 定义Map 格式化章节名称
        Map<Integer, String> chareMap = ReadExcel.readXlsmToMap("config/MainChapter.xlsm", "ChapterBaseCfg", 8, 1, 2);
        Map<Integer, String> map_901 = ReadExcel.readXlsmToMap("config/MainDialogue.xlsm", "Dialogue_901", 8, 1, 7);
        Map<Integer, String> map_902 = ReadExcel.readXlsmToMap("config/MainDialogue.xlsm", "Dialogue_902", 8, 1, 7);
        Map<Integer, String> map_903 = ReadExcel.readXlsmToMap("config/MainDialogue.xlsm", "Dialogue_903", 8, 1, 7);
        Map<Integer, String> map_904 = ReadExcel.readXlsmToMap("config/MainDialogue.xlsm", "Dialogue_904", 8, 1, 7);
        Map<Integer, String> allMap = new HashMap<Integer, String>();
        allMap.putAll(map_901);
        allMap.putAll(map_902);
        allMap.putAll(map_903);
        allMap.putAll(map_904);

        // 默认查询当天
        String tbName = "MainStorySelectFlow_" + DateUtil.getNowDate().replace("-", "");
        if (searchDate != null) {
            tbName = "MainStorySelectFlow_" + searchDate.replace("-", "");
        }

        List<MainStorySelectFlow>  queryList = new ArrayList<MainStorySelectFlow>();
        try {
            queryList = scenarioDao.mainStorySelectFlow(tbName, platformId);
        } catch (Exception e) {
            System.out.println("SQL查询错误：" + e.getMessage());
        }

        // 格式化章节名称
        for (int i = 0; i < queryList.size(); i++) {
            if (chareMap.get(queryList.get(i).getIchapterID()) != null) {
                queryList.get(i).setChapterName(null==chareMap.get(queryList.get(i).getIchapterID())?String.valueOf(queryList.get(i).getIchapterID()):chareMap.get(queryList.get(i).getIchapterID()));
            }

            if (allMap.get(queryList.get(i).getIdialogueID()) != null) {
                queryList.get(i).setIdialogueName(null==queryList.get(i).getIdialogueID()?String.valueOf(queryList.get(i).getIdialogueID()):allMap.get(queryList.get(i).getIdialogueID()));
            } else {
                queryList.get(i).setIdialogueName(String.valueOf(queryList.get(i).getIdialogueID()));
            }
            if (allMap.get(queryList.get(i).getIpreDialogueID()) != null) {
                queryList.get(i).setIpreDialogueName(allMap.get(queryList.get(i).getIpreDialogueID()).equals("")?String.valueOf(queryList.get(i).getIpreDialogueID()):allMap.get(queryList.get(i).getIpreDialogueID()));
            } else {
                queryList.get(i).setIpreDialogueName(String.valueOf(queryList.get(i).getIpreDialogueID()));
            }

        }

        return queryList;
    }

}
