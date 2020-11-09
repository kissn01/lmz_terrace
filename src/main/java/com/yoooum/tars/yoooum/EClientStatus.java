// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EClientStatus {

	E_CS_TYPE_OFFLINE(0),
	E_CS_TYPE_ONLINE(1),
	E_CS_TYPE_PLAYING(2);

	private final int value;

	private EClientStatus(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EClientStatus convert(int value) {
		for(EClientStatus v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
