// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_SOIL_STATUS {

	EN_SOIL_STATUS_DEFAULT(0),
	EN_SOIL_STATUS_DRY(1),
	EN_SOIL_STATUS_USEING(2),
	EN_SOIL_STATUS_HUAFEI(3),
	EN_SOIL_STATUS_CAN_UNLOCK(4),
	EN_SOIL_STATUS_LOCK(5),
	EN_SOIL_STATUS_GROWN(6);

	private final int value;

	private EN_SOIL_STATUS(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_SOIL_STATUS convert(int value) {
		for(EN_SOIL_STATUS v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
