// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

/************************************************************************************/
@TarsStruct
public class TSigInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public String sProtoSecretKey = "";
	@TarsStructProperty(order = 1, isRequire = false)
	public String sOpenID = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public int iTimeStamp = 0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iValidTime = 0;

	public String getSProtoSecretKey() {
		return sProtoSecretKey;
	}

	public void setSProtoSecretKey(String sProtoSecretKey) {
		this.sProtoSecretKey = sProtoSecretKey;
	}

	public String getSOpenID() {
		return sOpenID;
	}

	public void setSOpenID(String sOpenID) {
		this.sOpenID = sOpenID;
	}

	public int getITimeStamp() {
		return iTimeStamp;
	}

	public void setITimeStamp(int iTimeStamp) {
		this.iTimeStamp = iTimeStamp;
	}

	public int getIValidTime() {
		return iValidTime;
	}

	public void setIValidTime(int iValidTime) {
		this.iValidTime = iValidTime;
	}

	public TSigInfo() {
	}

	public TSigInfo(String sProtoSecretKey, String sOpenID, int iTimeStamp, int iValidTime) {
		this.sProtoSecretKey = sProtoSecretKey;
		this.sOpenID = sOpenID;
		this.iTimeStamp = iTimeStamp;
		this.iValidTime = iValidTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(sProtoSecretKey);
		result = prime * result + TarsUtil.hashCode(sOpenID);
		result = prime * result + TarsUtil.hashCode(iTimeStamp);
		result = prime * result + TarsUtil.hashCode(iValidTime);
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
		if (!(obj instanceof TSigInfo)) {
			return false;
		}
		TSigInfo other = (TSigInfo) obj;
		return (
			TarsUtil.equals(sProtoSecretKey, other.sProtoSecretKey) &&
			TarsUtil.equals(sOpenID, other.sOpenID) &&
			TarsUtil.equals(iTimeStamp, other.iTimeStamp) &&
			TarsUtil.equals(iValidTime, other.iValidTime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != sProtoSecretKey) {
			_os.write(sProtoSecretKey, 0);
		}
		if (null != sOpenID) {
			_os.write(sOpenID, 1);
		}
		_os.write(iTimeStamp, 2);
		_os.write(iValidTime, 3);
	}


	public void readFrom(TarsInputStream _is) {
		this.sProtoSecretKey = _is.readString(0, false);
		this.sOpenID = _is.readString(1, false);
		this.iTimeStamp = _is.read(iTimeStamp, 2, false);
		this.iValidTime = _is.read(iValidTime, 3, false);
	}

}
