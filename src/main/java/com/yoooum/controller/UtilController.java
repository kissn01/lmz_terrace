package com.yoooum.controller;

import com.yoooum.entity.util.Mail;
import com.yoooum.service.UtilService;
import com.yoooum.tars.yoooum.TAccountID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @PostMapping("sendMail")
    public  String sendMail(HttpServletRequest request, Mail mail)
    {
        System.out.println("========个人邮件发送==========");
        System.out.println(mail);
        if(null!=mail.getUserList() &&  !"".equals(mail.getUserList()))
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");
            request.setAttribute("successData", succList);
            request.setAttribute("errorData", failList);
        }

        return "util/sendMail";
    }

    @GetMapping("sendServerMail")
    public String sendServerMail()
    {
        log.info("===全服邮件发送===");
        return "util/sendServerMail";
    }
    @PostMapping("sendServerMail")
    public String sendServerMail(HttpServletRequest request, Mail mail)
    {
        System.out.println("=========全服邮件发送=========");
        System.out.println(mail);
        if(null!=mail.getSendTime() &&  !"".equals(mail.getSendTime()))
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendServerMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");

            request.setAttribute("successData", succList);
            request.setAttribute("errorData", failList);
        }

        return "util/sendServerMail";
    }


    /**
     * @Description:  dataTable 方式
     * @Date / 14:05
     * @param mail
     * @return
     **/
/*    @ResponseBody
    @PostMapping("sendMail")
    public  Map<String, List<TAccountID>> sendMail(Mail mail)
    {
        System.out.println("========个人邮件发送==========");
        System.out.println(mail);
        Map<String, List<TAccountID>> map = new HashMap<>();
        if(null!=mail.getUserList() &&  !"".equals(mail.getUserList()))
        {
            Map<String, List<TAccountID>> resultMap = utilService.sendMail(mail);
            List<TAccountID> succList = resultMap.get("succValue");
            List<TAccountID> failList = resultMap.get("failValue");

            map.put("data", succList);
            map.put("errorData", failList);
        }

        return map;
    }*/

    /**
     * @Description: dataTable 方式
     * @Date 2020/11/11 14:13
     * @param mail
     * @return
     **/
    /*@ResponseBody
    @PostMapping("sendServerMail")
    public Map<String, List<TAccountID>> sendServerMail(Mail mail)
    {
        System.out.println("=========全服邮件发送=========");
        System.out.println(mail);
        Map<String, List<TAccountID>> map = new HashMap<>();
        Map<String, List<TAccountID>> resultMap = utilService.sendServerMail(mail);
        List<TAccountID> succList = resultMap.get("succValue");
        List<TAccountID> failList = resultMap.get("failValue");
        map.put("successData", succList);
        map.put("errorData", failList);

        return map;
    }*/




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
