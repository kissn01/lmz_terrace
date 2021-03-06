// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_RES_PKG_TYPE {

	E_RES_PKG_TYPE_BIN(1),
	E_RES_PKG_TYPE_PIC(2),
	E_RES_PKG_TYPE_CONF(3),
	E_RES_PKG_TYPE_AUDIO(4),
	E_RES_PKG_TYPE_APK(5);

	private final int value;

	private E_RES_PKG_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_RES_PKG_TYPE convert(int value) {
		for(E_RES_PKG_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
