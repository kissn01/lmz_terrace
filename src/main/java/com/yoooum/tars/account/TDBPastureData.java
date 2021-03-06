// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.account;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class TDBPastureData {

	@TarsStructProperty(order = 0, isRequire = false)
	public short usLevel = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public java.util.List<TPastureSlotInfo> vPastureSlot = null;
	@TarsStructProperty(order = 2, isRequire = false)
	public short usShitNum = (short)0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iFodderNum = 0;

	public short getUsLevel() {
		return usLevel;
	}

	public void setUsLevel(short usLevel) {
		this.usLevel = usLevel;
	}

	public java.util.List<TPastureSlotInfo> getVPastureSlot() {
		return vPastureSlot;
	}

	public void setVPastureSlot(java.util.List<TPastureSlotInfo> vPastureSlot) {
		this.vPastureSlot = vPastureSlot;
	}

	public short getUsShitNum() {
		return usShitNum;
	}

	public void setUsShitNum(short usShitNum) {
		this.usShitNum = usShitNum;
	}

	public int getIFodderNum() {
		return iFodderNum;
	}

	public void setIFodderNum(int iFodderNum) {
		this.iFodderNum = iFodderNum;
	}

	public TDBPastureData() {
	}

	public TDBPastureData(short usLevel, java.util.List<TPastureSlotInfo> vPastureSlot, short usShitNum, int iFodderNum) {
		this.usLevel = usLevel;
		this.vPastureSlot = vPastureSlot;
		this.usShitNum = usShitNum;
		this.iFodderNum = iFodderNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(usLevel);
		result = prime * result + TarsUtil.hashCode(vPastureSlot);
		result = prime * result + TarsUtil.hashCode(usShitNum);
		result = prime * result + TarsUtil.hashCode(iFodderNum);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TDBPastureData)) {
			return false;
		}
		TDBPastureData other = (TDBPastureData) obj;
		return (
			TarsUtil.equals(usLevel, other.usLevel) &&
			TarsUtil.equals(vPastureSlot, other.vPastureSlot) &&
			TarsUtil.equals(usShitNum, other.usShitNum) &&
			TarsUtil.equals(iFodderNum, other.iFodderNum) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(usLevel, 0);
		if (null != vPastureSlot) {
			_os.write(vPastureSlot, 1);
		}
		_os.write(usShitNum, 2);
		_os.write(iFodderNum, 3);
	}

	static java.util.List<TPastureSlotInfo> cache_vPastureSlot;
	static { 
		cache_vPastureSlot = new java.util.ArrayList<TPastureSlotInfo>();
		TPastureSlotInfo var_36 = new TPastureSlotInfo();
		cache_vPastureSlot.add(var_36);
	}

	public void readFrom(TarsInputStream _is) {
		this.usLevel = _is.read(usLevel, 0, false);
		this.vPastureSlot = (java.util.List<TPastureSlotInfo>) _is.read(cache_vPastureSlot, 1, false);
		this.usShitNum = _is.read(usShitNum, 2, false);
		this.iFodderNum = _is.read(iFodderNum, 3, false);
	}

}
