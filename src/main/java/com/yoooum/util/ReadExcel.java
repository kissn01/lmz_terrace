package com.yoooum.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

public class ReadExcel {

	public static void main(String[] args)
	{
		 //格式化道具名称
        Map<Integer, String> map = ReadExcel.readXlsmToMap("config/MainChapter.xlsm", "ChapterBaseCfg", 8, 1, 2);
        System.out.println(map);
		

	}
	public static Map<Integer,String> readXlsmToMap(String readName,String sheetName,Integer begRow,Integer keyCol,Integer resCol)
    {
        Map<Integer,String> map =new HashMap<>();
        //通过sheet名获取
        //ExcelReader  reader = ExcelUtil.getReader(FileUtil.file(readName),sheetName );
        ExcelReader  reader = ExcelUtil.getReader(ReadExcel.class.getClassLoader().getResourceAsStream(readName),sheetName );
        List<List<Object>> readAll = reader.read();
        for(int i=0;i<readAll.size();i++)
        {
            if(i>=begRow)
            {
            	
                if(readAll.get(i).get(0)!=null&&readAll.get(i).get(0).equals("*"))
                {
                    map.put(new Integer(String.valueOf((long)readAll.get(i).get(keyCol))), String.valueOf(readAll.get(i).get(resCol)));
                }

            }

        }
        reader.close();

        return map;
    }
	
	
	//获取指定列的值
    public static List<Integer> readXlsmToList(String readName,String sheetName,Integer begRow,Integer resCol)
    {
        List<Integer> list =new ArrayList<>();
        //通过sheet名获取
        ExcelReader  reader = ExcelUtil.getReader(ReadExcel.class.getClassLoader().getResourceAsStream(readName),sheetName );
        List<List<Object>> readAll = reader.read();
        for(int i=0;i<readAll.size();i++)
        {
            if(i>=begRow)
            {
                if(readAll.get(i).get(0)!=null&&readAll.get(i).get(0).equals("*"))
                {
                    list.add(Integer.parseInt(String.valueOf(readAll.get(i).get(resCol))));
                }

            }

        }
        reader.close();

        return list;
    }
}