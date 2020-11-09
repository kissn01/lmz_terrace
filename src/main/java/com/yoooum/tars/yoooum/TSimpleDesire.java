// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class TSimpleDesire {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iDesireId = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String sDesireName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public int iDesireNum = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public byte bDesireType = (byte)0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iCurrentNum = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public int iItemId = 0;
	@TarsStructProperty(order = 6, isRequire = false)
	public int iCommonId = 0;
	@TarsStructProperty(order = 7, isRequire = false)
	public String sJumpTo = "";
	@TarsStructProperty(order = 8, isRequire = false)
	public short nPriority = (short)0;

	public int getIDesireId() {
		return iDesireId;
	}

	public void setIDesireId(int iDesireId) {
		this.iDesireId = iDesireId;
	}

	public String getSDesireName() {
		return sDesireName;
	}

	public void setSDesireName(String sDesireName) {
		this.sDesireName = sDesireName;
	}

	public int getIDesireNum() {
		return iDesireNum;
	}

	public void setIDesireNum(int iDesireNum) {
		this.iDesireNum = iDesireNum;
	}

	public byte getBDesireType() {
		return bDesireType;
	}

	public void setBDesireType(byte bDesireType) {
		this.bDesireType = bDesireType;
	}

	public int getICurrentNum() {
		return iCurrentNum;
	}

	public void setICurrentNum(int iCurrentNum) {
		this.iCurrentNum = iCurrentNum;
	}

	public int getIItemId() {
		return iItemId;
	}

	public void setIItemId(int iItemId) {
		this.iItemId = iItemId;
	}

	public int getICommonId() {
		return iCommonId;
	}

	public void setICommonId(int iCommonId) {
		this.iCommonId = iCommonId;
	}

	public String getSJumpTo() {
		return sJumpTo;
	}

	public void setSJumpTo(String sJumpTo) {
		this.sJumpTo = sJumpTo;
	}

	public short getNPriority() {
		return nPriority;
	}

	public void setNPriority(short nPriority) {
		this.nPriority = nPriority;
	}

	public TSimpleDesire() {
	}

	public TSimpleDesire(int iDesireId, String sDesireName, int iDesireNum, byte bDesireType, int iCurrentNum, int iItemId, int iCommonId, String sJumpTo, short nPriority) {
		this.iDesireId = iDesireId;
		this.sDesireName = sDesireName;
		this.iDesireNum = iDesireNum;
		this.bDesireType = bDesireType;
		this.iCurrentNum = iCurrentNum;
		this.iItemId = iItemId;
		this.iCommonId = iCommonId;
		this.sJumpTo = sJumpTo;
		this.nPriority = nPriority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iDesireId);
		result = prime * result + TarsUtil.hashCode(sDesireName);
		result = prime * result + TarsUtil.hashCode(iDesireNum);
		result = prime * result + TarsUtil.hashCode(bDesireType);
		result = prime * result + TarsUtil.hashCode(iCurrentNum);
		result = prime * result + TarsUtil.hashCode(iItemId);
		result = prime * result + TarsUtil.hashCode(iCommonId);
		result = prime * result + TarsUtil.hashCode(sJumpTo);
		result = prime * result + TarsUtil.hashCode(nPriority);
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
		if (!(obj instanceof TSimpleDesire)) {
			return false;
		}
		TSimpleDesire other = (TSimpleDesire) obj;
		return (
			TarsUtil.equals(iDesireId, other.iDesireId) &&
			TarsUtil.equals(sDesireName, other.sDesireName) &&
			TarsUtil.equals(iDesireNum, other.iDesireNum) &&
			TarsUtil.equals(bDesireType, other.bDesireType) &&
			TarsUtil.equals(iCurrentNum, other.iCurrentNum) &&
			TarsUtil.equals(iItemId, other.iItemId) &&
			TarsUtil.equals(iCommonId, other.iCommonId) &&
			TarsUtil.equals(sJumpTo, other.sJumpTo) &&
			TarsUtil.equals(nPriority, other.nPriority) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iDesireId, 0);
		if (null != sDesireName) {
			_os.write(sDesireName, 1);
		}
		_os.write(iDesireNum, 2);
		_os.write(bDesireType, 3);
		_os.write(iCurrentNum, 4);
		_os.write(iItemId, 5);
		_os.write(iCommonId, 6);
		if (null != sJumpTo) {
			_os.write(sJumpTo, 7);
		}
		_os.write(nPriority, 8);
	}


	public void readFrom(TarsInputStream _is) {
		this.iDesireId = _is.read(iDesireId, 0, false);
		this.sDesireName = _is.readString(1, false);
		this.iDesireNum = _is.read(iDesireNum, 2, false);
		this.bDesireType = _is.read(bDesireType, 3, false);
		this.iCurrentNum = _is.read(iCurrentNum, 4, false);
		this.iItemId = _is.read(iItemId, 5, false);
		this.iCommonId = _is.read(iCommonId, 6, false);
		this.sJumpTo = _is.readString(7, false);
		this.nPriority = _is.read(nPriority, 8, false);
	}

}
