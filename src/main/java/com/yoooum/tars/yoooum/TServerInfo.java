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
public class TServerInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iSvrID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String sName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public int iType = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iStatue = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iMaxOpenUser = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public String sUrl = "";
	@TarsStructProperty(order = 6, isRequire = false)
	public short nGroupID = (short)0;

	public int getISvrID() {
		return iSvrID;
	}

	public void setISvrID(int iSvrID) {
		this.iSvrID = iSvrID;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public int getIType() {
		return iType;
	}

	public void setIType(int iType) {
		this.iType = iType;
	}

	public int getIStatue() {
		return iStatue;
	}

	public void setIStatue(int iStatue) {
		this.iStatue = iStatue;
	}

	public int getIMaxOpenUser() {
		return iMaxOpenUser;
	}

	public void setIMaxOpenUser(int iMaxOpenUser) {
		this.iMaxOpenUser = iMaxOpenUser;
	}

	public String getSUrl() {
		return sUrl;
	}

	public void setSUrl(String sUrl) {
		this.sUrl = sUrl;
	}

	public short getNGroupID() {
		return nGroupID;
	}

	public void setNGroupID(short nGroupID) {
		this.nGroupID = nGroupID;
	}

	public TServerInfo() {
	}

	public TServerInfo(int iSvrID, String sName, int iType, int iStatue, int iMaxOpenUser, String sUrl, short nGroupID) {
		this.iSvrID = iSvrID;
		this.sName = sName;
		this.iType = iType;
		this.iStatue = iStatue;
		this.iMaxOpenUser = iMaxOpenUser;
		this.sUrl = sUrl;
		this.nGroupID = nGroupID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iSvrID);
		result = prime * result + TarsUtil.hashCode(sName);
		result = prime * result + TarsUtil.hashCode(iType);
		result = prime * result + TarsUtil.hashCode(iStatue);
		result = prime * result + TarsUtil.hashCode(iMaxOpenUser);
		result = prime * result + TarsUtil.hashCode(sUrl);
		result = prime * result + TarsUtil.hashCode(nGroupID);
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
		if (!(obj instanceof TServerInfo)) {
			return false;
		}
		TServerInfo other = (TServerInfo) obj;
		return (
			TarsUtil.equals(iSvrID, other.iSvrID) &&
			TarsUtil.equals(sName, other.sName) &&
			TarsUtil.equals(iType, other.iType) &&
			TarsUtil.equals(iStatue, other.iStatue) &&
			TarsUtil.equals(iMaxOpenUser, other.iMaxOpenUser) &&
			TarsUtil.equals(sUrl, other.sUrl) &&
			TarsUtil.equals(nGroupID, other.nGroupID) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iSvrID, 0);
		if (null != sName) {
			_os.write(sName, 1);
		}
		_os.write(iType, 2);
		_os.write(iStatue, 3);
		_os.write(iMaxOpenUser, 4);
		if (null != sUrl) {
			_os.write(sUrl, 5);
		}
		_os.write(nGroupID, 6);
	}


	public void readFrom(TarsInputStream _is) {
		this.iSvrID = _is.read(iSvrID, 0, false);
		this.sName = _is.readString(1, false);
		this.iType = _is.read(iType, 2, false);
		this.iStatue = _is.read(iStatue, 3, false);
		this.iMaxOpenUser = _is.read(iMaxOpenUser, 4, false);
		this.sUrl = _is.readString(5, false);
		this.nGroupID = _is.read(nGroupID, 6, false);
	}

}
