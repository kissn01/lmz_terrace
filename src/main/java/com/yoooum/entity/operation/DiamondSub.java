package com.yoooum.entity.operation;

import lombok.Data;

@Data
public  class DiamondSub
{
	 private String  dateSign;
	 private Integer subSum;
	 private Integer subPlaySum;
	 private String  subPlayAvg;
	 private Integer retroactive;
	 private Integer retroactivePlay;
	 private Integer merchantExchange;
	 private Integer merchantExchangePlay;
	 private Integer buyItem;
	 private Integer buyItemPlay;
	 private Integer buyBag;
	 private Integer buyBagPlay;
	 private Integer addStar;
	 private Integer addStarPlay;
	 private Integer everyDayTranscript;
	 private Integer everyDayTranscriptPlay;
	 private Integer harvestCat;
	 private Integer harvestCatPlay;
	 private Integer dilatationCatHome;
	 private Integer dilatationCatHomePlay;
	 private Integer unlockHostStory;
	 private Integer unlockHostStoryPlay;

    public DiamondSub(String dateSign, Integer subSum, Integer subPlaySum, String subPlayAvg, Integer retroactive,
                      Integer retroactivePlay, Integer merchantExchange, Integer merchantExchangePlay, Integer buyItem,
                      Integer buyItemPlay, Integer buyBag, Integer buyBagPlay, Integer addStar, Integer addStarPlay,
                      Integer everyDayTranscript, Integer everyDayTranscriptPlay, Integer harvestCat, Integer harvestCatPlay,
                      Integer dilatationCatHome, Integer dilatationCatHomePlay, Integer unlockHostStory,
                      Integer unlockHostStoryPlay) {
        super();
        this.dateSign = dateSign;
        this.subSum = subSum;
        this.subPlaySum = subPlaySum;
        this.subPlayAvg = subPlayAvg;
        this.retroactive = retroactive;
        this.retroactivePlay = retroactivePlay;
        this.merchantExchange = merchantExchange;
        this.merchantExchangePlay = merchantExchangePlay;
        this.buyItem = buyItem;
        this.buyItemPlay = buyItemPlay;
        this.buyBag = buyBag;
        this.buyBagPlay = buyBagPlay;
        this.addStar = addStar;
        this.addStarPlay = addStarPlay;
        this.everyDayTranscript = everyDayTranscript;
        this.everyDayTranscriptPlay = everyDayTranscriptPlay;
        this.harvestCat = harvestCat;
        this.harvestCatPlay = harvestCatPlay;
        this.dilatationCatHome = dilatationCatHome;
        this.dilatationCatHomePlay = dilatationCatHomePlay;
        this.unlockHostStory = unlockHostStory;
        this.unlockHostStoryPlay = unlockHostStoryPlay;
    }
	 
	 
}
