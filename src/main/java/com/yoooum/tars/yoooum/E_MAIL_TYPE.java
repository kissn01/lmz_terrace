// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_MAIL_TYPE {

	E_MAIL_TYPE_FRIEND_MAIL(1),
	E_MAIL_TYPE_SYS_MAIL(2),
	E_MAIL_TYPE_SYS_BUSI_MAIL(3);

	private final int value;

	private E_MAIL_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_MAIL_TYPE convert(int value) {
		for(E_MAIL_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
