package com.yoooum.entity.operation;

import lombok.Data;

/**
 * @ClassName NewRegistData
 * @Description TODO
 * @Author kiss
 * @Date 2020/5/28 17:34
 * @Version 1.0
 */
@Data
public class NewRegistData
{
    private String  dateSign;
    private Integer peopleSum;
    private Integer zeroToTwoNum;
    private Integer twoAndFourNum;
    private Integer fourAndSixNum;
    private Integer sixAndEightNum;
    private Integer eightAndTenNum;
    private Integer tenAndTwelveNum;
    private Integer twelveAndFourteenNum;
    private Integer fourteenAndSixteeenNum;
    private Integer sixteeenAndEighteenNum;
    private Integer eighteenAndTwentyNum;
    private Integer twentyAndTwentyTwoNum;
    private Integer twentyTwoAndTwentyFourNum;

    public NewRegistData() {
        super();
        // TODO Auto-generated constructor stub
    }
    public NewRegistData(String dateSign, Integer peopleSum, Integer zeroToTwoNum,
                      Integer twoAndFourNum, Integer fourAndSixNum, Integer sixAndEightNum,
                      Integer eightAndTenNum, Integer tenAndTwelveNum,
                      Integer twelveAndFourteenNum, Integer fourteenAndSixteeenNum,
                      Integer sixteeenAndEighteenNum, Integer eighteenAndTwentyNum,
                      Integer twentyAndTwentyTwoNum, Integer twentyTwoAndTwentyFourNum) {
        super();
        this.dateSign = dateSign;
        this.peopleSum = peopleSum;
        this.zeroToTwoNum = zeroToTwoNum;
        this.twoAndFourNum = twoAndFourNum;
        this.fourAndSixNum = fourAndSixNum;
        this.sixAndEightNum = sixAndEightNum;
        this.eightAndTenNum = eightAndTenNum;
        this.tenAndTwelveNum = tenAndTwelveNum;
        this.twelveAndFourteenNum = twelveAndFourteenNum;
        this.fourteenAndSixteeenNum = fourteenAndSixteeenNum;
        this.sixteeenAndEighteenNum = sixteeenAndEighteenNum;
        this.eighteenAndTwentyNum = eighteenAndTwentyNum;
        this.twentyAndTwentyTwoNum = twentyAndTwentyTwoNum;
        this.twentyTwoAndTwentyFourNum = twentyTwoAndTwentyFourNum;
    }
}
