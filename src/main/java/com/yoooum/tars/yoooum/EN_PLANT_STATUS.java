// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_PLANT_STATUS {

	EN_PLANT_STATUS_SEED(0),
	EN_PLANT_STATUS_LITTLE(1),
	EN_PLANT_STATUS_BIG(2),
	EN_PLANT_STATUS_FLOWER(3),
	EN_PLANT_STATUS_GROWN(4);

	private final int value;

	private EN_PLANT_STATUS(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_PLANT_STATUS convert(int value) {
		for(EN_PLANT_STATUS v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
