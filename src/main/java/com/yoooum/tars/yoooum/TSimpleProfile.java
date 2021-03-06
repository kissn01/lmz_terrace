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
public class TSimpleProfile {

	@TarsStructProperty(order = 0, isRequire = false)
	public long uUin = 0L;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iZoneID = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public int eOpenPlatType = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public String sNickName = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public String sHeadUrl = "";
	@TarsStructProperty(order = 5, isRequire = false)
	public short nLvl = (short)0;
	@TarsStructProperty(order = 6, isRequire = false)
	public int iState = 0;

	public long getUUin() {
		return uUin;
	}

	public void setUUin(long uUin) {
		this.uUin = uUin;
	}

	public int getIZoneID() {
		return iZoneID;
	}

	public void setIZoneID(int iZoneID) {
		this.iZoneID = iZoneID;
	}

	public int getEOpenPlatType() {
		return eOpenPlatType;
	}

	public void setEOpenPlatType(int eOpenPlatType) {
		this.eOpenPlatType = eOpenPlatType;
	}

	public String getSNickName() {
		return sNickName;
	}

	public void setSNickName(String sNickName) {
		this.sNickName = sNickName;
	}

	public String getSHeadUrl() {
		return sHeadUrl;
	}

	public void setSHeadUrl(String sHeadUrl) {
		this.sHeadUrl = sHeadUrl;
	}

	public short getNLvl() {
		return nLvl;
	}

	public void setNLvl(short nLvl) {
		this.nLvl = nLvl;
	}

	public int getIState() {
		return iState;
	}

	public void setIState(int iState) {
		this.iState = iState;
	}

	public TSimpleProfile() {
	}

	public TSimpleProfile(long uUin, int iZoneID, int eOpenPlatType, String sNickName, String sHeadUrl, short nLvl, int iState) {
		this.uUin = uUin;
		this.iZoneID = iZoneID;
		this.eOpenPlatType = eOpenPlatType;
		this.sNickName = sNickName;
		this.sHeadUrl = sHeadUrl;
		this.nLvl = nLvl;
		this.iState = iState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(uUin);
		result = prime * result + TarsUtil.hashCode(iZoneID);
		result = prime * result + TarsUtil.hashCode(eOpenPlatType);
		result = prime * result + TarsUtil.hashCode(sNickName);
		result = prime * result + TarsUtil.hashCode(sHeadUrl);
		result = prime * result + TarsUtil.hashCode(nLvl);
		result = prime * result + TarsUtil.hashCode(iState);
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
		if (!(obj instanceof TSimpleProfile)) {
			return false;
		}
		TSimpleProfile other = (TSimpleProfile) obj;
		return (
			TarsUtil.equals(uUin, other.uUin) &&
			TarsUtil.equals(iZoneID, other.iZoneID) &&
			TarsUtil.equals(eOpenPlatType, other.eOpenPlatType) &&
			TarsUtil.equals(sNickName, other.sNickName) &&
			TarsUtil.equals(sHeadUrl, other.sHeadUrl) &&
			TarsUtil.equals(nLvl, other.nLvl) &&
			TarsUtil.equals(iState, other.iState) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(uUin, 0);
		_os.write(iZoneID, 1);
		_os.write(eOpenPlatType, 2);
		if (null != sNickName) {
			_os.write(sNickName, 3);
		}
		if (null != sHeadUrl) {
			_os.write(sHeadUrl, 4);
		}
		_os.write(nLvl, 5);
		_os.write(iState, 6);
	}


	public void readFrom(TarsInputStream _is) {
		this.uUin = _is.read(uUin, 0, false);
		this.iZoneID = _is.read(iZoneID, 1, false);
		this.eOpenPlatType = _is.read(eOpenPlatType, 2, false);
		this.sNickName = _is.readString(3, false);
		this.sHeadUrl = _is.readString(4, false);
		this.nLvl = _is.read(nLvl, 5, false);
		this.iState = _is.read(iState, 6, false);
	}

}
