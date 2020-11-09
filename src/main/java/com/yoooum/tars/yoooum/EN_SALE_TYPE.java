// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_SALE_TYPE {

	EN_SALE_TYPE_ALL(0),
	EN_SALE_TYPE_DISCOUNT(1),
	EN_SALE_TYPE_BOX_KEY(2),
	EN_SALE_TYPE_DAY_SELECTION(3),
	EN_SALE_TYPE_HERO(4),
	EN_SALE_TYPE_SKIN(5),
	EN_SALE_TYPE_DIAMON(6),
	EN_SALE_TYPE_GOLD(7),
	EN_SALE_TYPE_VIT(8),
	EN_SALE_TYPE_LIMIT_ITEM(9),
	EN_SALE_TYPE_MYSTICAL(10);

	private final int value;

	private EN_SALE_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_SALE_TYPE convert(int value) {
		for(EN_SALE_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
