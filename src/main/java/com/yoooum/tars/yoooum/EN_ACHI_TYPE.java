// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_ACHI_TYPE {

	EN_ACHI_TYPE_TIME_PASS(1),
	EN_ACHI_TYPE_KILL_NUM(2),
	EN_ACHI_TYPE_PASS_COUNT(3),
	EN_ACHI_TYPE_EXPRESS_COUNT(4),
	EN_ACHI_TYPE_CHOP_TREE_COUNT(5),
	EN_ACHI_TYPE_BUY_ALL_WEAPON3000(6),
	EN_ACHI_TYPE_CHALLENGE_KING(7),
	EN_ACHI_TYPE_DRINK_WELL_WATER(8),
	EN_ACHI_TYPE_SAY_LOVE_COUNT(9),
	EN_ACHI_TYPE_USE_WEAPON_COUNT(10),
	EN_ACHI_TYPE_GROUP_PASS_COUNT(11);

	private final int value;

	private EN_ACHI_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_ACHI_TYPE convert(int value) {
		for(EN_ACHI_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}