package com.yoooum.util;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/17 19:35
 * @描述:
 */

import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;
import com.yoooum.tars.account.TAccessoryItem;
import com.yoooum.tars.yoooum.TAccountID;
import com.yoooum.tars.yoooum.IdipServantPrx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tars 工具类
 */
public class TarsUtil
{
    //通信器
    static CommunicatorConfig cfg=new CommunicatorConfig();

    static Communicator communicator = getCommunicator();

    /**
     * //构建通信器
     * @return
     */
    public static Communicator getCommunicator()
    {
        CommunicatorConfig cfg = new CommunicatorConfig();

        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);

        return communicator;

    }


    /**
     *  通过服务器 获得代理对象
     */
    public static IdipServantPrx getIdipServantPrx(Integer environmentId)
    {
        IdipServantPrx idipServantPrx;
        /**
         * 默认为112 -- jsx
         * 118-- 为外网正式环境
         */

        if(environmentId==113)
        {
            idipServantPrx=communicator.stringToProxy(IdipServantPrx.class,  "JSX.IdipSvr.IdipServantObj@tcp -h 192.168.18.114 -p 22312 ");
        }else if(environmentId==114) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "MiniGame.IdipSvr.IdipServantObj@tcp -h 192.168.18.114 -p 22312 ");
        }else if(environmentId==118) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 47.99.226.188 -p 10006 ");
        }else if(environmentId==120) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 47.111.119.39 -p 10020 ");
        }else if(environmentId==121) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 121.41.51.10 -p 10023 ");
        }else if(environmentId==124) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 124.156.200.40 -p 10008 ");
        }else if(environmentId==210) {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 47.97.109.210 -p 10023 ");
        }else {
            idipServantPrx = communicator.stringToProxy(IdipServantPrx.class, "JSX.IdipSvr.IdipServantObj@tcp -h 192.168.18.112 -p 10078 ");
        }


        return idipServantPrx;
    }




    /**
     * 格式化玩家列表
     * @param userList
     * @return
     */
    public static List<TAccountID> fmtUserList(String userList)
    {
        System.out.println("玩家列表:"+userList);
        String[] splitAddress=userList.split("\\||;");
        List <TAccountID> vecAccountID = new ArrayList<>();
        for (int i = 0; i < splitAddress.length/2; i++)
        {
            TAccountID ta=new TAccountID();
            ta.setUuin(Integer.parseInt(splitAddress[2*i]));
            ta.setIzoneId(Integer.parseInt(splitAddress[2*i+1]));
            ta.setSopenID("10001");
            vecAccountID.add(ta);
        }

        return vecAccountID;
    }

    public static void main(String[] args)
    {
        String str = "134156|0;1|7;";
        List<TAccountID> tAccountIDS = fmtUserList(str);
        System.out.println(tAccountIDS.get(0).getUuin());
        System.out.println(tAccountIDS);
//        String strs = "1|100;2|100;1010105|100;";
//        List<TAccessoryItem> tAccessoryItems = fmtItem(strs);
//        System.out.println(tAccessoryItems.get(0).getIItemID());
    }

    /**
     * 格式化item
     * @param
     * @return
     */
    public static List<TAccessoryItem> fmtItem(String itemList)
    {
        System.out.println("道具列表:"+itemList);
        List<TAccessoryItem> vaccessoryitem = new ArrayList<>();
        if(null!=itemList &&  !"".equals(itemList)){
            String[] splitAddress=itemList.split("\\||;");
            for (int i = 0; i < splitAddress.length/2; i++)
            {
                TAccessoryItem ta=new TAccessoryItem();

                ta.setIItemID(Integer.parseInt(splitAddress[2*i]));
                ta.setIItemNum(Integer.parseInt(splitAddress[2*i+1]));

                vaccessoryitem.add(ta);
            }
        }


        return vaccessoryitem;
    }


    /**
     * 读取邮件发送失败原因
     * @param code
     * @return
     */
    public static String getError(Integer code) {
        Map<Integer, String> codeMap = new HashMap<>();
        codeMap.put(0, "发送成功");
        codeMap.put(601, "邮件配置不存在");
        codeMap.put(602, "邮件不存在");
        codeMap.put(603, "重复读取邮件");
        codeMap.put(604, "邮件未生效");
        codeMap.put(605, "邮件已结束");
        codeMap.put(606, "邮件系统不符");
        codeMap.put(607, "邮件客户端版本不符");
        codeMap.put(608, "邮件已存在");
        codeMap.put(609, "重复领取邮件");
        codeMap.put(610, "邮件附件为空");
        codeMap.put(611, "邮件状态错误");
        codeMap.put(612, "邮件未查收,不能删除");
        codeMap.put(613, "渠道不匹配");

        return codeMap.get(code);
    }

}
