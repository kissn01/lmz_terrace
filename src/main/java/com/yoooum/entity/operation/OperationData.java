package com.yoooum.entity.operation;


import lombok.Data;

@Data
public class OperationData
{
	private Integer  id;
	private String  dateSign;
	private Integer newAddUser;
	private Integer activeUser;
	private Integer registSum;
	private String morrowRetention;
	private String threeDayRetention;
    private String fourDayRetention;
    private String fiveDayRetention;
    private String sixDayRetention;
	private String sevenDayRetention;
	private Integer platformId;
}
