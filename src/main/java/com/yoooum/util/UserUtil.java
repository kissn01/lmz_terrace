package com.yoooum.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserUtil {
	public static void main(String[] args) {
		List<Integer> readXlsmToList = getPlanList(10104);
		System.out.println(readXlsmToList.size());
		System.out.println(readXlsmToList);
	}

	//定义正则表达式
    private static Pattern NUMBER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

	// 获取从0开始到最大关卡id(maxLevelId) 的list
	public static List<Integer> getPlanList(Integer maxLevelId) {
		List<Integer> levelList = new ArrayList<>();
		/*
		 * for(int i=1;i<=4;i++) {
		 * levelList.addAll(ReadExcel.readXlsmToList("config/MainDialogue.xlsm",
		 * "Dialogue_90"+i, 8,1)); }
		 */
		levelList.addAll(ReadExcel.readXlsmToList("config/MainTask.xlsm", "MainTaskInfo", 8, 2));

		return levelList.subList(0, levelList.indexOf(maxLevelId) + 1);
	}

	// 判断一个字符串是否为数字型 正则（推荐，速度最快）
	public static boolean isInteger(String str) 
	{
		return NUMBER_PATTERN.matcher(str).matches();
	}

}
