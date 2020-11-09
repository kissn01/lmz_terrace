package com.yoooum.controller;

import com.yoooum.entity.util.Mail;
import com.yoooum.service.UtilService;
import com.yoooum.tars.yoooum.TAccountID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ClassName UtilController
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/9 11:03
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("util")
@PreAuthorize("hasRole('ROLE_UTIL')")
public class UtilController
{
    @Autowired
    private UtilService utilService;

    @GetMapping("sendMail")
    public String sendMail()
    {
        log.info("===个人邮件发送===");
        return "util/sendMail";
    }
    @ResponseBody
    @PostMapping("sendMail")
    public Map<String, List<TAccountID>> sendMail(Mail mail)
    {
        System.out.println("========个人邮件发送==========");
        System.out.println(mail);
        Map<String, List<TAccountID>> map = new HashMap<>();
        if(null!=mail.getUserList() &&  null !=mail.getItemList())
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");


            map.put("successData", succList);
            map.put("errorData", failList);
        }


        return map;
    }

    @GetMapping("sendServerMail")
    public String sendServerMail()
    {
        log.info("===全服邮件发送===");
        return "util/sendServerMail";
    }
    @ResponseBody
    @PostMapping("sendServerMail")
    public Map<String, List<TAccountID>> sendServerMail(Mail mail)
    {
        System.out.println("=========全服邮件发送=========");
        System.out.println(mail);
        Map<String, List<TAccountID>> map = new HashMap<>();
        if(null!=mail.getUserList() &&  null !=mail.getItemList())
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendServerMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");


            map.put("successData", succList);
            map.put("errorData", failList);
        }


        return map;
    }
//
//    @GetMapping("checkMailRecord")
//    public String checkMailRecord()
//    {
//        log.info("===邮件查询===");
//        return "userInfo/checkMailRecord";
//    }
//    @ResponseBody
//    @PostMapping("checkMailRecord")
//    public Map<String, List<Ltv>> checkMailRecord(String startDate, String expirationDate, Integer platformId)
//    {
//        List<Ltv> generaldutyList = utilService.checkMailRecord(startDate,expirationDate,platformId);
//        Map<String, List<Ltv>> map = new HashMap<>();
//        map.put("data", generaldutyList);
//
//        return map;
//    }
}
