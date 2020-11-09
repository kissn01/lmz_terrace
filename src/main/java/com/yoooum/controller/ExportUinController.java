package com.yoooum.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.yoooum.service.ExportUinServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 
 * @Date 2020/6/5 14:55
 * @param
 * @return 
**/
@Controller
@RequestMapping("export")
public class ExportUinController
{
    @Autowired
    private ExportUinServices exportUinServices;

    /**
     * 导出当日付费用户的uin
     * @param searchDate
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_CHARGE')")
    @RequestMapping(value = "chargeUin",method = RequestMethod.GET)
    public void exportChargeUin(HttpServletResponse response, @RequestParam("searchDate") String searchDate, @RequestParam("platformId") Integer platformId) throws IOException
    {
        System.out.println("===导出当日付费用户的uin===");
        //查询数据库
        List<Integer> chargeUinList = exportUinServices.exportChargeUin(searchDate,platformId);

        List<HashMap<String, Integer>> maps = chargeUinList.stream().map(u -> {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("uid", u);
            return map;
        }).collect(Collectors.toList());

        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(maps, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String excelName = searchDate.replace("-", "")+"号付费用户uin";
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName.getBytes("gb2312"), "ISO8859-1") + ".xls");
        response.flushBuffer();
        ServletOutputStream stream = response.getOutputStream();
        writer.flush(stream, true);
        writer.close();
        IoUtil.close(stream);

    }

}
