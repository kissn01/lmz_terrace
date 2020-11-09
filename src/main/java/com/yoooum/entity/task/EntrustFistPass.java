package com.yoooum.entity.task;

import lombok.Data;

public @Data class EntrustFistPass
{
	private Integer entrustID;
	private String entrustName;
	private Integer openNum;
	private Integer oneStarNum;
	private Integer twoStarNum;
	private Integer thrStarNum;
	private double onePassRate;
	private double twoPassRate;
	private double thrPassRate;
	private double totalPassRate;
}
