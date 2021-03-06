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
public class TTaskAcceptLimitCfg {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iLimitType = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iJudgeType = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public int iLimitValue = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public String sParam1 = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public String sParam2 = "";
	@TarsStructProperty(order = 5, isRequire = false)
	public short nNecessary = (short)0;

	public int getILimitType() {
		return iLimitType;
	}

	public void setILimitType(int iLimitType) {
		this.iLimitType = iLimitType;
	}

	public int getIJudgeType() {
		return iJudgeType;
	}

	public void setIJudgeType(int iJudgeType) {
		this.iJudgeType = iJudgeType;
	}

	public int getILimitValue() {
		return iLimitValue;
	}

	public void setILimitValue(int iLimitValue) {
		this.iLimitValue = iLimitValue;
	}

	public String getSParam1() {
		return sParam1;
	}

	public void setSParam1(String sParam1) {
		this.sParam1 = sParam1;
	}

	public String getSParam2() {
		return sParam2;
	}

	public void setSParam2(String sParam2) {
		this.sParam2 = sParam2;
	}

	public short getNNecessary() {
		return nNecessary;
	}

	public void setNNecessary(short nNecessary) {
		this.nNecessary = nNecessary;
	}

	public TTaskAcceptLimitCfg() {
	}

	public TTaskAcceptLimitCfg(int iLimitType, int iJudgeType, int iLimitValue, String sParam1, String sParam2, short nNecessary) {
		this.iLimitType = iLimitType;
		this.iJudgeType = iJudgeType;
		this.iLimitValue = iLimitValue;
		this.sParam1 = sParam1;
		this.sParam2 = sParam2;
		this.nNecessary = nNecessary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iLimitType);
		result = prime * result + TarsUtil.hashCode(iJudgeType);
		result = prime * result + TarsUtil.hashCode(iLimitValue);
		result = prime * result + TarsUtil.hashCode(sParam1);
		result = prime * result + TarsUtil.hashCode(sParam2);
		result = prime * result + TarsUtil.hashCode(nNecessary);
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
		if (!(obj instanceof TTaskAcceptLimitCfg)) {
			return false;
		}
		TTaskAcceptLimitCfg other = (TTaskAcceptLimitCfg) obj;
		return (
			TarsUtil.equals(iLimitType, other.iLimitType) &&
			TarsUtil.equals(iJudgeType, other.iJudgeType) &&
			TarsUtil.equals(iLimitValue, other.iLimitValue) &&
			TarsUtil.equals(sParam1, other.sParam1) &&
			TarsUtil.equals(sParam2, other.sParam2) &&
			TarsUtil.equals(nNecessary, other.nNecessary) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iLimitType, 0);
		_os.write(iJudgeType, 1);
		_os.write(iLimitValue, 2);
		if (null != sParam1) {
			_os.write(sParam1, 3);
		}
		if (null != sParam2) {
			_os.write(sParam2, 4);
		}
		_os.write(nNecessary, 5);
	}


	public void readFrom(TarsInputStream _is) {
		this.iLimitType = _is.read(iLimitType, 0, false);
		this.iJudgeType = _is.read(iJudgeType, 1, false);
		this.iLimitValue = _is.read(iLimitValue, 2, false);
		this.sParam1 = _is.readString(3, false);
		this.sParam2 = _is.readString(4, false);
		this.nNecessary = _is.read(nNecessary, 5, false);
	}

}
