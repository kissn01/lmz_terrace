package com.yoooum.entity.charge;

import lombok.Data;

/**
 * @ClassName AnalysisPay
 * @Description TODO
 * @Author kiss
 * @Date 2020/6/4 11:40
 * @Version 1.0
 */
@Data
public class AnalysisPay
{
    private  String dateSign;
    private  int  regNum;
    private  String  regPaySum;
    private  String  payTotal;
    private  int  dau;
    private  int  payNum;
    private  String  payRate;
    private  int  newPayNum;
    private  String  newPayRate;
    private  String  payNumArpu;
    private  String  newNumArpu;
    private  String  dauNumArpu;
    private  String  newDauNumArpu;
    private  Integer platformId;
}
