// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_NotifySubType {

	NotifySubType_NULL(0),
	NotifySubType_Exp(1),
	NotifySubType_Lvl(2),
	NotifySubType_Vit(3),
	NotifySubType_UpVit(4),
	NotifySubType_ServerTime(5),
	NotifySubType_DayVitLimit(6),
	NotifySubType_LastOnlineTime(7),
	NotifySubType_GuideId(8),
	NotifySubType_LastVitTime(9),
	NotifySubType_Diamon(10),
	NotifySubType_VipLvl(11),
	NotifySubType_Coin(12),
	NotifySubType_Diamon_AMT(13),
	NotifySubType_Vit_Resume_TIME(14);

	private final int value;

	private EN_NotifySubType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_NotifySubType convert(int value) {
		for(EN_NotifySubType v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
