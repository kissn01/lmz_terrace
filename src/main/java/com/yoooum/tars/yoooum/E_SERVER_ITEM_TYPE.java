// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_SERVER_ITEM_TYPE {

	E_SERVER_ITEM_TYPE_BASE_INFO(1),
	E_SERVER_ITEM_TYPE_BASE_ITEM(2),
	E_SERVER_ITEM_TYPE_EQUIPMENT(3),
	E_SERVER_ITEM_TYPE_TIMER_ITEM(4),
	E_SERVER_ITEM_TYPE_PACKAGE(5),
	E_SERVER_ITEM_TYPE_NATURAL(6),
	E_SERVER_ITEM_TYPE_SOLDIER(7),
	E_SERVER_ITEM_TYPE_HEOR(8),
	E_SERVER_ITEM_TYPE_SKIN(9),
	E_SERVER_ITEM_TYPE_SKILL(10),
	E_SERVER_ITEM_TYPE_BUFF(11),
	E_SERVER_ITEM_TYPE_PROP(12),
	E_SERVER_ITEM_TYPE_PROTRAIT(13),
	E_SERVER_ITEM_TYPE_TASK(14),
	E_SERVER_ITEM_TYPE_SPECAIL_EFFECT(15),
	E_SERVER_ITEM_TYPE_MEDAL_PRIVILEGE(16),
	E_SERVER_ITEM_TYPE_STORE(17),
	E_SERVER_ITEM_TYPE_HIDE(100);

	private final int value;

	private E_SERVER_ITEM_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_SERVER_ITEM_TYPE convert(int value) {
		for(E_SERVER_ITEM_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}