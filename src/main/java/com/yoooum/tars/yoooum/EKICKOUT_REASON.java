// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EKICKOUT_REASON {

	E_KICKOUT_OFFLINE(0),
	E_KICKOUT_LAST_CONNECT(1),
	E_KICKOUT_IN_OTHER_GAME(2),
	E_KICKOUT_LOGOUT(3),
	E_KICKOUT_ANTI(4);

	private final int value;

	private EKICKOUT_REASON(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EKICKOUT_REASON convert(int value) {
		for(EKICKOUT_REASON v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
