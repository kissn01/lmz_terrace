package com.yoooum.entity.operation;


import lombok.Data;

@Data
public class OperationData
{
	private Integer  id;
	private String  myDate;
	private Integer newAddUser;
	private Integer activeUser;
	private Integer topUpUser;
	private String topUpAmount;
	private String arppu;
	private String arpu;
	private String topUpPermeability;
	private String morrowRetention;
	private String threeDayRetention;
	private String sevenDayRetention;
	private String fifteenDayRetention;
	private Integer platformId;
}
