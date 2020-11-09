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
public class TServerGroupInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public short nGroupID = (short)0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String sGroupName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public java.util.List<TUserZoneInfo> vecZoneInfo = null;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iRoleNum = 0;

	public short getNGroupID() {
		return nGroupID;
	}

	public void setNGroupID(short nGroupID) {
		this.nGroupID = nGroupID;
	}

	public String getSGroupName() {
		return sGroupName;
	}

	public void setSGroupName(String sGroupName) {
		this.sGroupName = sGroupName;
	}

	public java.util.List<TUserZoneInfo> getVecZoneInfo() {
		return vecZoneInfo;
	}

	public void setVecZoneInfo(java.util.List<TUserZoneInfo> vecZoneInfo) {
		this.vecZoneInfo = vecZoneInfo;
	}

	public int getIRoleNum() {
		return iRoleNum;
	}

	public void setIRoleNum(int iRoleNum) {
		this.iRoleNum = iRoleNum;
	}

	public TServerGroupInfo() {
	}

	public TServerGroupInfo(short nGroupID, String sGroupName, java.util.List<TUserZoneInfo> vecZoneInfo, int iRoleNum) {
		this.nGroupID = nGroupID;
		this.sGroupName = sGroupName;
		this.vecZoneInfo = vecZoneInfo;
		this.iRoleNum = iRoleNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(nGroupID);
		result = prime * result + TarsUtil.hashCode(sGroupName);
		result = prime * result + TarsUtil.hashCode(vecZoneInfo);
		result = prime * result + TarsUtil.hashCode(iRoleNum);
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
		if (!(obj instanceof TServerGroupInfo)) {
			return false;
		}
		TServerGroupInfo other = (TServerGroupInfo) obj;
		return (
			TarsUtil.equals(nGroupID, other.nGroupID) &&
			TarsUtil.equals(sGroupName, other.sGroupName) &&
			TarsUtil.equals(vecZoneInfo, other.vecZoneInfo) &&
			TarsUtil.equals(iRoleNum, other.iRoleNum) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(nGroupID, 0);
		if (null != sGroupName) {
			_os.write(sGroupName, 1);
		}
		if (null != vecZoneInfo) {
			_os.write(vecZoneInfo, 2);
		}
		_os.write(iRoleNum, 3);
	}

	static java.util.List<TUserZoneInfo> cache_vecZoneInfo;
	static { 
		cache_vecZoneInfo = new java.util.ArrayList<TUserZoneInfo>();
		TUserZoneInfo var_58 = new TUserZoneInfo();
		cache_vecZoneInfo.add(var_58);
	}

	public void readFrom(TarsInputStream _is) {
		this.nGroupID = _is.read(nGroupID, 0, false);
		this.sGroupName = _is.readString(1, false);
		this.vecZoneInfo = (java.util.List<TUserZoneInfo>) _is.read(cache_vecZoneInfo, 2, false);
		this.iRoleNum = _is.read(iRoleNum, 3, false);
	}

}