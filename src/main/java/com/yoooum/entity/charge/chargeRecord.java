package com.yoooum.entity.charge;

import lombok.Data;

/**
 * @ClassName chargeRecord
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/4 11:47
 * @Version 1.0
 */
@Data
public class chargeRecord
{
    private String dateSign;
    private int platformId;
    private int monney;
    private int diamond;
    private String itemName;
    private int itemID;
    private String orderID;
    private int payMode;
    private int result;
    private int totalDiamond;
    private int totalMoney;
    private int lvl;
    private String registTime;
}
