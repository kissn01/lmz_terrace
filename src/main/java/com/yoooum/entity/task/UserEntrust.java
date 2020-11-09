package com.yoooum.entity.task;

import lombok.Data;

public @Data class UserEntrust 
{
	private Integer taskID;
	private String taskName;
	private int getNum;
	private int passNum;
	private int progress;
	
}
