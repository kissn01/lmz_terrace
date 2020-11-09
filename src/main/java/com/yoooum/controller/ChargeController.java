package com.yoooum.controller;

import com.yoooum.dao.PublicDao;
import com.yoooum.entity.charge.AnalysisPay;
import com.yoooum.entity.charge.ChargeInterval;
import com.yoooum.entity.charge.Ltv;
import com.yoooum.entity.charge.chargeRecord;
import com.yoooum.entity.operation.OperationData;
import com.yoooum.service.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ChargeController
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/27 14:32
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("charge")
@PreAuthorize("hasRole('ROLE_CHARGE')")
public class ChargeController
{

    @Autowired
    private PublicDao publicDao;

    @Autowired
    private ChargeService chargeService;

    @GetMapping("chargeData")
    public String chargeData()
    {
        log.info("===用户充值总览===");
        return "charge/chargeData";
    }

    @GetMapping("chargeAnalysis")
    public String chargeAnalysis()
    {
        log.info("===用户付费解析===");
        return "charge/chargeAnalysis";
    }

    @GetMapping("chargeInterval")
    public String chargeInterval()
    {
        log.info("===用户充值区间===");
        return "charge/chargeInterval";
    }

    @GetMapping("chargeSearchByUin")
    public String chargeSearchByUin()
    {
        log.info("===指定用户查询===");
        return "charge/chargeSearchByUin";
    }

    @GetMapping("chargeSearchDate")
    public String chargeSearchDate()
    {
        log.info("===指定日期查询===");
        return "charge/chargeSearchDate";
    }

    @ResponseBody
    @PostMapping("chargeData")
    public Map<String, List<Ltv>> chargeData(String startDate, String expirationDate, Integer platformId)
    {
        List<Ltv> chargeDataList = chargeService.chargeData(startDate,expirationDate,platformId);
        Map<String, List<Ltv>> map = new HashMap<>();
        map.put("data", chargeDataList);

        return map;
    }

    @ResponseBody
    @PostMapping("chargeAnalysis")
    public Map<String, List<AnalysisPay>> chargeAnalysis(String startDate, String expirationDate, Integer platformId)
    {
        List<AnalysisPay> chargeDataList = chargeService.chargeAnalysis(startDate,expirationDate,platformId);
        Map<String, List<AnalysisPay>> map = new HashMap<>();
        map.put("data", chargeDataList);

        return map;
    }

    @ResponseBody
    @PostMapping("chargeInterval")
    public Map<String, List<ChargeInterval>> chargeInterval(String startDate, String expirationDate, Integer platformId)
    {
        List<ChargeInterval> chargeDataList = chargeService.chargeInterval(startDate,expirationDate,platformId);
        Map<String, List<ChargeInterval>> map = new HashMap<>();
        map.put("data", chargeDataList);

        return map;
    }

    @ResponseBody
    @PostMapping("chargeSearchByUin")
    public Map<String, List<chargeRecord>> chargeSearchByUin(String startDate, String expirationDate, Integer uin)
    {
        List<chargeRecord> chargeDataList = chargeService.chargeSearchByUin(startDate,expirationDate,uin);
        Map<String, List<chargeRecord>> map = new HashMap<>();
        map.put("data", chargeDataList);

        return map;
    }

    @ResponseBody
    @PostMapping("chargeSearchDate")
    public Map<String, List<chargeRecord>> chargeSearchDate(String startDate, String expirationDate, Integer uin)
    {
        List<chargeRecord> chargeDataList = chargeService.chargeSearchDate(startDate,expirationDate,uin);
        Map<String, List<chargeRecord>> map = new HashMap<>();
        map.put("data", chargeDataList);

        return map;
    }

}
