package com.yoooum.controller;

import com.yoooum.entity.operation.*;
import com.yoooum.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OperationController
 * @Description 运营数据总览
 * @Author kiss
 * @Date 2020/5/27 11:12
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("operation")
@PreAuthorize("hasRole('ROLE_OPERATION')")
public class OperationController
{
    @Autowired
    private OperationService operationService;

    @GetMapping("operationData")
    public String operationData()
    {
        log.info("====运营数据总览====");
        return "operation/operationData";
    }

    @ResponseBody
    @PostMapping("operationData")
    public Map<String, List<OperationData>> operationData(String startDate, String expirationDate, Integer platformId)
    {

        List<OperationData> operationDataList = operationService.operationData(startDate,expirationDate,platformId);
        Map<String, List<OperationData>> map = new HashMap<>();
        map.put("data", operationDataList);

        return map;
    }

    @GetMapping("retentionData")
    public String retentionData()
    {
        log.info("====用户留存====");
        return "operation/retentionData";
    }

    @ResponseBody
    @PostMapping("retentionData")
    public Map<String, List<Retention>> retentionData(String startDate, String expirationDate, Integer platformId)
    {
        List<Retention> Retention = operationService.retentionData(startDate,expirationDate,platformId);
        Map<String, List<Retention>> map = new HashMap<>();
        map.put("data", Retention);

        return map;
    }

    @GetMapping("registData")
    public String registData()
    {
        log.info("====新进数据====");
        return "operation/registData";
    }

    @ResponseBody
    @PostMapping("registData")
    public Map<String, List<NewRegistData>> registData(String startDate, String expirationDate, Integer platformId)
    {
        List<NewRegistData> regList = operationService.registData(startDate,expirationDate,platformId);
        Map<String, List<NewRegistData>> map = new HashMap<>();
        map.put("data", regList);

        return map;
    }

    @GetMapping("diamodData")
    public String diamodData()
    {
        log.info("====钻石数据总览====");
        return "operation/diamodData";
    }


    @ResponseBody
    @PostMapping("diamodData")
    public Map<String, List<Diamond>> diamodData(String startDate, String expirationDate, Integer platformId)
    {
        List<Diamond> diamondList = operationService.queryPayDiamond(startDate,expirationDate,platformId);
        Map<String, List<Diamond>> map = new HashMap<>();
        map.put("data", diamondList);

        return map;
    }

    @GetMapping("diamodConsumptionData")
    public String diamodConsumptionData()
    {
        log.info("====钻石消耗途径====");
        return "operation/diamodConsumptionData";
    }

    @ResponseBody
    @PostMapping("diamodConsumptionData")
    public Map<String, List<DiamondSub>> diamodConsumptionData(String startDate, String expirationDate, Integer platformId)
    {

        List<DiamondSub> subDiamondList = operationService.diamodConsumptionData(startDate, expirationDate, platformId);
        Map<String, List<DiamondSub>> map = new HashMap<>();
        map.put("data", subDiamondList);

        return map;
    }

    @GetMapping("coinData")
    public String coinData()
    {
        log.info("====金币数据总览====");
        return "operation/coinData";
    }

    @ResponseBody
    @PostMapping("coinData")
    public Map<String, List<Coin>> coinData(String startDate, String expirationDate, Integer platformId)
    {
        List<Coin> coinList = operationService.coinData(startDate, expirationDate, platformId);
        Map<String, List<Coin>> map = new HashMap<>();
        map.put("data", coinList);

        return map;
    }


}
