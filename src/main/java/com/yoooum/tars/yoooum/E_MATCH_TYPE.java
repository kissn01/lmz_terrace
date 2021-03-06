// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_MATCH_TYPE {

	MATCH_TYPE_OLD(0),
	MATCH_TYPE_CREATE_ROOM_SINGLE(1),
	MATCH_TYPE_CREATE_ROOM_MULTI(2),
	MATCH_TYPE_MAX(3);

	private final int value;

	private E_MATCH_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_MATCH_TYPE convert(int value) {
		for(E_MATCH_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
