package com.yoooum.service;

import com.yoooum.dao.ExportUinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 21:22
 * @描述:
 */
@Service
public class ExportUinServices
{
    @Autowired
    private ExportUinDao exportUinDao;

    //导出当日付费用户的uin
    public List<Integer>  exportChargeUin (String searchDate,Integer platformId)
    {

        List<Integer> list = new ArrayList<Integer>();
        if(searchDate!=null)
        {
            list=exportUinDao.exportChargeUin(("ChargeFlow_"+searchDate.subSequence(0,10)).replace("-","" ), platformId);
        }

        return list;
    }


}
