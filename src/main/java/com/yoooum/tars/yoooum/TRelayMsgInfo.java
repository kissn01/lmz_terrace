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
public class TRelayMsgInfo {

	@TarsStructProperty(order = 0, isRequire = true)
	public int iMsgID = 0;
	@TarsStructProperty(order = 1, isRequire = true)
	public String sMsgSrc = "";
	@TarsStructProperty(order = 2, isRequire = true)
	public int sMsgSeq = 0;
	@TarsStructProperty(order = 3, isRequire = true)
	public byte[] sMsgData = null;
	@TarsStructProperty(order = 4, isRequire = false)
	public TAccountID stAccountID = null;

	public int getIMsgID() {
		return iMsgID;
	}

	public void setIMsgID(int iMsgID) {
		this.iMsgID = iMsgID;
	}

	public String getSMsgSrc() {
		return sMsgSrc;
	}

	public void setSMsgSrc(String sMsgSrc) {
		this.sMsgSrc = sMsgSrc;
	}

	public int getSMsgSeq() {
		return sMsgSeq;
	}

	public void setSMsgSeq(int sMsgSeq) {
		this.sMsgSeq = sMsgSeq;
	}

	public byte[] getSMsgData() {
		return sMsgData;
	}

	public void setSMsgData(byte[] sMsgData) {
		this.sMsgData = sMsgData;
	}

	public TAccountID getStAccountID() {
		return stAccountID;
	}

	public void setStAccountID(TAccountID stAccountID) {
		this.stAccountID = stAccountID;
	}

	public TRelayMsgInfo() {
	}

	public TRelayMsgInfo(int iMsgID, String sMsgSrc, int sMsgSeq, byte[] sMsgData, TAccountID stAccountID) {
		this.iMsgID = iMsgID;
		this.sMsgSrc = sMsgSrc;
		this.sMsgSeq = sMsgSeq;
		this.sMsgData = sMsgData;
		this.stAccountID = stAccountID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iMsgID);
		result = prime * result + TarsUtil.hashCode(sMsgSrc);
		result = prime * result + TarsUtil.hashCode(sMsgSeq);
		result = prime * result + TarsUtil.hashCode(sMsgData);
		result = prime * result + TarsUtil.hashCode(stAccountID);
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
		if (!(obj instanceof TRelayMsgInfo)) {
			return false;
		}
		TRelayMsgInfo other = (TRelayMsgInfo) obj;
		return (
			TarsUtil.equals(iMsgID, other.iMsgID) &&
			TarsUtil.equals(sMsgSrc, other.sMsgSrc) &&
			TarsUtil.equals(sMsgSeq, other.sMsgSeq) &&
			TarsUtil.equals(sMsgData, other.sMsgData) &&
			TarsUtil.equals(stAccountID, other.stAccountID) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iMsgID, 0);
		_os.write(sMsgSrc, 1);
		_os.write(sMsgSeq, 2);
		_os.write(sMsgData, 3);
		if (null != stAccountID) {
			_os.write(stAccountID, 4);
		}
	}

	static byte[] cache_sMsgData;
	static { 
		cache_sMsgData = new byte[1];
		byte var_60 = (byte)0;
		cache_sMsgData[0] = var_60;
	}
	static TAccountID cache_stAccountID;
	static { 
		cache_stAccountID = new TAccountID();
	}

	public void readFrom(TarsInputStream _is) {
		this.iMsgID = _is.read(iMsgID, 0, true);
		this.sMsgSrc = _is.readString(1, true);
		this.sMsgSeq = _is.read(sMsgSeq, 2, true);
		this.sMsgData = (byte[]) _is.read(cache_sMsgData, 3, true);
		this.stAccountID = (TAccountID) _is.read(cache_stAccountID, 4, false);
	}

}