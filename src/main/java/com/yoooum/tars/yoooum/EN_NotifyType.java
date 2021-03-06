// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

public enum EN_NotifyType {

	NotifyType_System(1),
	NotifyType_Profile(2),
	NotifyType_Item(3),
	NotifyType_EquipmentAdd(4),
	NotifyType_EquipmentDel(5),
	NotifyType_Hero(6),
	NotifyType_Skin(7),
	NotifyType_Skill(8),
	NotifyType_Buff(9),
	NotifyType_Charge(10),
	NotifyType_Task(11),
	NotifyType_TimedItem(12),
	NotifyType_Privilege_Card(13),
	NotifyType_Store(14),
	NotifyType_Npc(15),
	NotifyTYPE_Npc_Lvl(16);

	private final int value;

	private EN_NotifyType(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.name() + ":" + this.value;
	}

	public static EN_NotifyType convert(int value) {
		for(EN_NotifyType v : values()) {
			if(v.value() == value) {
				return v;
			}
		}
		return null;
	}
}
