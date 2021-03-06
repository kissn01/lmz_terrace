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
public class TShowAchiInfo {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iPos = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iAchiID = 0;

	public int getIPos() {
		return iPos;
	}

	public void setIPos(int iPos) {
		this.iPos = iPos;
	}

	public int getIAchiID() {
		return iAchiID;
	}

	public void setIAchiID(int iAchiID) {
		this.iAchiID = iAchiID;
	}

	public TShowAchiInfo() {
	}

	public TShowAchiInfo(int iPos, int iAchiID) {
		this.iPos = iPos;
		this.iAchiID = iAchiID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iPos);
		result = prime * result + TarsUtil.hashCode(iAchiID);
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
		if (!(obj instanceof TShowAchiInfo)) {
			return false;
		}
		TShowAchiInfo other = (TShowAchiInfo) obj;
		return (
			TarsUtil.equals(iPos, other.iPos) &&
			TarsUtil.equals(iAchiID, other.iAchiID) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iPos, 0);
		_os.write(iAchiID, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.iPos = _is.read(iPos, 0, false);
		this.iAchiID = _is.read(iAchiID, 1, false);
	}

}
