package com.yoooum.service;

import cn.hutool.core.date.DateUtil;
import com.yoooum.entity.util.Mail;
import com.yoooum.tars.account.ServerMail;
import com.yoooum.tars.account.TAccessoryItem;
import com.yoooum.tars.account.TMailItem;
import com.yoooum.tars.yoooum.TAccountID;
import com.yoooum.util.TarsUtil;
import com.yoooum.tars.yoooum.IdipServantPrx;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.qq.tars.common.support.Holder;

import java.util.*;


/**
 * @ClassName UtilService
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/10 10:36
 * @Version 1.0
 */
@Service
public class UtilService
{
    private static String  nowTime =DateUtil.now();


    /**
     *  发送个人邮件
     * @param mail
     * @return
     */
    public Map<String, List<TAccountID>> sendMail(Mail mail)
    {
        //1.生成代理对象 默认为114
        IdipServantPrx idipServantPrxs = TarsUtil.getIdipServantPrx(mail.getEnvironmentId());
        //2.设值
        //uin
        List<TAccountID> vecAccountID = TarsUtil.fmtUserList(mail.getUserList());
        //邮件配置
        TMailItem stMailItem = new TMailItem();
        stMailItem.setIID(0);
        stMailItem.setSContent(mail.getEmailDesc());
        stMailItem.setSTitle(mail.getEmailTitle());
        //道具列表
        List<TAccessoryItem> vaccessoryitem = TarsUtil.fmtItem(mail.getItemList());
        stMailItem.setVAccessoryItem(vaccessoryitem);
        //3.发送用户
        String sendName = SecurityContextHolder.getContext().getAuthentication().getName();

        //4.定义成功时和失败时接收的参数
        Holder<List<TAccountID>> vecSuccAccountID = new Holder<>();
        Holder<List<TAccountID>> vecFailAccountID = new Holder<>();

        //4.调用接口
        System.out.println(nowTime+"||"+sendName+"||"+vecAccountID+"||"+stMailItem);
        int code = idipServantPrxs.PlatSendMail(vecAccountID,stMailItem,sendName,vecSuccAccountID,vecFailAccountID);
        System.out.println("返回状态码："+code);

        List<TAccountID> succValue = vecSuccAccountID.getValue();
        List<TAccountID> failValue = vecFailAccountID.getValue();

        //5.结果存入map
        Map<String,List<TAccountID>> map=new HashMap<>();
        map.put("succValue", succValue);
        map.put("failValue", failValue);

        //6.状态码存入
        String errorStr = TarsUtil.getError(code);
        System.out.println("发送结果："+errorStr);


        return map;
    }


    public int sendServerMail(Mail mail)
    {
        //1.生成代理对象 默认为114
        IdipServantPrx idipServantPrxs = TarsUtil.getIdipServantPrx(mail.getEnvironmentId());
        //2.设值
        ServerMail stServerMailData = new ServerMail();
        Map<String, String> ctx = new HashMap<>();
        //2.1设置区ID
        List<Integer> zoneIDList = new ArrayList<>();
        zoneIDList.add(mail.getRegion());
        stServerMailData.setVecZoneID(zoneIDList);
        //2.2生效时间
        stServerMailData.setLSendTime(com.yoooum.util.DateUtil.StringToTimestamp(mail.getSendTime()));
        //2.3结束时间
        stServerMailData.setLOverTime(com.yoooum.util.DateUtil.StringToTimestamp(mail.getEndTime()));
        //2.4标题
        stServerMailData.setSTitle(mail.getEmailTitle());
        //2.5内容
        stServerMailData.setSContent(mail.getEmailDesc());
        //2.6邮件附件(道具列表)
        List<TAccessoryItem> vaccessoryitem = TarsUtil.fmtItem(mail.getItemList());
        stServerMailData.setVAccessoryItem(vaccessoryitem);
        //2.7发件人
        String sendName = SecurityContextHolder.getContext().getAuthentication().getName();
        stServerMailData.setSSender(sendName);

        //3.定义成功时和失败时接收的参数
        Holder<List<TAccountID>> vecSuccAccountID = new Holder<>();
        Holder<List<TAccountID>> vecFailAccountID = new Holder<>();

        //4.调用接口
        System.out.println(nowTime+"||"+sendName+"||"+stServerMailData);
        int code =  idipServantPrxs.SendServerMail(stServerMailData,ctx);
        System.out.println("返回状态码："+code);

        List<TAccountID> SuccValue = vecSuccAccountID.getValue();
        List<TAccountID> FailValue = vecFailAccountID.getValue();

        //5.结果存入map
        Map<String,List<TAccountID>> map=new HashMap<>();
        map.put("succValue", SuccValue);
        map.put("failValue", FailValue);

        //6.状态码存入
        String statusStr = TarsUtil.getError(code);
        System.out.println("发送结果："+statusStr);

        return code;
    }


    /**
     * 删除邮件
     * @param mail
     * @return
     */
/*    public Map<String, List<TAccountID>> delMail(Mail mail)
    {
        //1.生成代理对象
        IdipServantPrx idipServantPrxs = TarsUtil.getIdipServantPrx(mail.getEnvironmentId());
        //2.设值
        List<TAccountID> vecAccountID = TarsUtil.fmtMail(mail.getUserList());
        //3.邮件类型设值
        int iMailId=mail.getEmailId();

        Holder<List<TAccountID>> vecSuccAccountID =new Holder<List<TAccountID>>();
        Holder<List<TAccountID>> vecFailAccountID=new Holder<List<TAccountID>>();

        //4.调用接口
        int sendMail = idipServantPrxs.DelMail(vecAccountID,iMailId,vecSuccAccountID,vecFailAccountID);
        List<TAccountID> SuccValue = vecSuccAccountID.getValue();
        List<TAccountID> FailValue = vecFailAccountID.getValue();

        Map<String,List<TAccountID>> map=new HashMap<String, List<TAccountID>>();
        map.put("succValue", SuccValue);
        map.put("failValue", FailValue);
        return map;
    }

    public UserInfo QueryPlayerData(Integer uin, Integer osType, Integer zoneId)
    {
        //对象封装数据
        UserInfo userInfo =new UserInfo();
        if(null!=uin&&null!=osType&&null!=zoneId)
        {
            CommunicatorConfig cfg = new CommunicatorConfig();
            //构建通信器
            Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);
            //通过通信器，生成代理对象
            IdipServantPrx idipServantPrx = TarsUtil.getIdipServantPrx(118);
            //定义参数
            TAccountID stAccountID = new TAccountID();
            stAccountID.setUuin(uin);
            stAccountID.setIosType(osType);
            stAccountID.setIzoneId(zoneId);
            Holder<TAccountData> stAccountData  = new Holder<TAccountData> ();

            //调用接口
            int i = idipServantPrx.QueryPlayerData(stAccountID, stAccountData);
            TAccountData taData = stAccountData.getValue();

            //获取渠道
            int iOpenPlatType = taData.getStAccountID().getIopenPlatType();
            userInfo.setPlatformId(iOpenPlatType);
            //获取日期
            String lCreateTime = DateUtil.longToDate(taData.getLCreateTime());
            userInfo.setCreateTime(lCreateTime);

            //累计充值
            if(taData.getStAccountID().getIosType()==1)
            {
                userInfo.setChargeSum(taData.getStUserBaseInfo().getBaseInfo().getBaseValue().get(3));
            }else
            {
                userInfo.setChargeSum(taData.getStUserBaseInfo().getBaseInfo().getBaseValue().get(7));
            }
            //当前等级
            userInfo.setOnlineLevel(taData.getStUserBaseInfo().getBaseInfo().getBaseValue().get(4));
        }


        return userInfo;
    }


    public static void checkUser(String filePath,String xlsxPath)throws Exception
    {
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(xlsxPath);
        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //1.读取文件
        List<Integer> list = FileUtil.readFileToList(filePath);
        System.out.println(list);
        for (int i=0;i<list.size();i++)
        {
            //2.获取数据
            UtilService us = new UtilService();
            UserInfo userInfo = us.QueryPlayerData(list.get(i), 1, 1);
            //构造写入的数据
            List<String> row = CollUtil.newArrayList(String.valueOf(list.get(i)), userInfo.getCreateTime(),String.valueOf(userInfo.getChargeSum()), String.valueOf(userInfo.getOnlineLevel()));
            List<List<String>> rows = CollUtil.newArrayList();
            rows.add(row);

            // 一次性写出内容，使用默认样式
            writer.write(rows, true);
            System.out.println(list.get(i)+"|"+userInfo.getPlatformId()+"|"+userInfo.getCreateTime()+"|"+userInfo.getChargeSum()+"|"+userInfo.getOnlineLevel());

            //每50行暂停一下
            if(i%50==0)
            {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }

        // 关闭writer，释放内存
        writer.close();
    }


    public static void main(String[] args)  throws Exception
    {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        String filePath = "G:\\work\\炮打僵尸\\analyze\\src\\main\\resources\\config\\retoppo19.log";
        String xlsxPath="G:\\work\\炮打僵尸\\analyze\\src\\main\\resources\\config\\oppo16号注册19号留存用户19号数据.xlsx";
        checkUser(filePath,xlsxPath);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) / 1000 + "s");
    }*/

}
