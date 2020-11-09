// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_TASK_TARGET_SUB_TYPE {

	E_TASK_TARGET_SUB_TYPE_DESIRE_ID(2000),
	E_TASK_TARGET_SUB_TYPE_DIALOG_ID(2001),
	E_TASK_TARGET_SUB_TYPE_KILL_ID(2002),
	E_TASK_TARGET_SUB_TYPE_ITEM_ID(2003),
	E_TASK_TARGET_SUB_TYPE_ITEM_CNT(2004),
	E_TASK_TARGET_SUB_TYPE_CHAPTER_ID(2005),
	E_TASK_TARGET_SUB_TYPE_SECTION_ID(2006),
	E_TASK_TARGET_SUB_TYPE_RESUCE_ID(2007),
	E_TASK_TARGET_SUB_TYPE_ONLINE_CHAPTER_ID(2008),
	E_TASK_TARGET_SUB_TYPE_ONLINE_SECTION_ID(2009);

	private final int value;

	private E_TASK_TARGET_SUB_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_TASK_TARGET_SUB_TYPE convert(int value) {
		for(E_TASK_TARGET_SUB_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}