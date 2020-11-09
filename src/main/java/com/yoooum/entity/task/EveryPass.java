package com.yoooum.entity.task;

import lombok.Data;

public @Data class EveryPass
{
	private String taskID;
	private String taskName;
	private int openCount;
	private int passConut;
	private double passRate;
	private double passRateStar;
	private double openCountAvg;
	private int zeroStar;
	private int oneStar;
	private int twoStar;
	private int threeStar;
}
