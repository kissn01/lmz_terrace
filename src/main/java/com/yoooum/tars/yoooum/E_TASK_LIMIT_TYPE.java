// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum E_TASK_LIMIT_TYPE {

	E_TASK_LIMIT_TYPE_COST_ITEM(101),
	E_TASK_LIMIT_TYPE_TASK(102),
	E_TASK_LIMIT_TYPE_CHAPTER(103),
	E_TASK_LIMIT_TYPE_ROUND(104),
	E_TASK_LIMIT_TYPE_WIN_ROUND(105),
	E_TASK_LIMIT_TYPE_DAYS(106),
	E_TASK_LIMIT_TYPE_ONLINE_ROUND(107),
	E_TASK_LIMIT_TYPE_WIN_ONLINE_ROUND(108),
	E_TASK_LIMIT_TYPE_ONLINE_CHAPTER(109);

	private final int value;

	private E_TASK_LIMIT_TYPE(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static E_TASK_LIMIT_TYPE convert(int value) {
		for(E_TASK_LIMIT_TYPE v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
