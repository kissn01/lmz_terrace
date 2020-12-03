package com.yoooum.entity.operation;

import lombok.Data;

/**
 * @ClassName MiNiCoin
 * @Description TODO
 * @Author kiss
 * @Date 2020/11/24 13:55
 * @Version 1.0
 */
@Data
public class MiNiCoin
{
    private String dateSign;
    private long addSum;
    private long subSum;
    private long welfareSum;
    private long planSum;
    private long  chargeSum;
    private String subSumAvg;
    private String planSumAvg;
    private String storageAvg;
    private int  platformId;
}
