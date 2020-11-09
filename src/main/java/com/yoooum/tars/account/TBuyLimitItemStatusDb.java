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
public class TBuyLimitItemStatusDb {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iSaleId = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long lCreateTime = 0L;

	public int getISaleId() {
		return iSaleId;
	}

	public void setISaleId(int iSaleId) {
		this.iSaleId = iSaleId;
	}

	public long getLCreateTime() {
		return lCreateTime;
	}

	public void setLCreateTime(long lCreateTime) {
		this.lCreateTime = lCreateTime;
	}

	public TBuyLimitItemStatusDb() {
	}

	public TBuyLimitItemStatusDb(int iSaleId, long lCreateTime) {
		this.iSaleId = iSaleId;
		this.lCreateTime = lCreateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iSaleId);
		result = prime * result + TarsUtil.hashCode(lCreateTime);
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
		if (!(obj instanceof TBuyLimitItemStatusDb)) {
			return false;
		}
		TBuyLimitItemStatusDb other = (TBuyLimitItemStatusDb) obj;
		return (
			TarsUtil.equals(iSaleId, other.iSaleId) &&
			TarsUtil.equals(lCreateTime, other.lCreateTime) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iSaleId, 0);
		_os.write(lCreateTime, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.iSaleId = _is.read(iSaleId, 0, false);
		this.lCreateTime = _is.read(lCreateTime, 1, false);
	}

}