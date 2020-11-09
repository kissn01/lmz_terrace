package com.yoooum.entity.scenario;

import lombok.Data;

/**
 * 主线剧情流水
 * @author Administrator
 *
 */
@Data
public  class MainStoryFlow {
	private String chapterName;
	private Integer chapterID;
	private Integer sectionID;
	//通过人数
	private int passNum;
	//未通过人数
	private int notPassNum;
	//通过率
	private String passingRate;


}