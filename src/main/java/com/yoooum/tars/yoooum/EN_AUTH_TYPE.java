// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_AUTH_TYPE {

	EN_AUTH_ADULTS(1),
	EN_AUTH_MINORS(2),
	EN_AUTH_NONE(3),
	EN_AUTH_CHILDREN(4),
	EN_AUTH_INFANCY(5);

	private final int value;

	private EN_AUTH_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_AUTH_TYPE convert(int value) {
		for(EN_AUTH_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
