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
public class TExtData1 {

	@TarsStructProperty(order = 0, isRequire = false)
	public TActiveCodeDb stActiveCodeDb = null;
	@TarsStructProperty(order = 1, isRequire = false)
	public java.util.Map<java.lang.Integer, TBuyStatusDb> mBuyItemStatDb = null;
	@TarsStructProperty(order = 2, isRequire = false)
	public java.util.Map<java.lang.Integer, TBuyStatusDb> mFirstBuyItemStatDb = null;
	@TarsStructProperty(order = 3, isRequire = false)
	public TDBNewbieData stNewbieData = null;
	@TarsStructProperty(order = 4, isRequire = false)
	public java.util.List<java.lang.Integer> vecAllSvrMailRecord = null;
	@TarsStructProperty(order = 5, isRequire = false)
	public java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>> mChargeStatusDb = null;
	@TarsStructProperty(order = 6, isRequire = false)
	public java.util.Map<java.lang.Byte, TDBWorkshopInfo> mWorkshop = null;

	public TActiveCodeDb getStActiveCodeDb() {
		return stActiveCodeDb;
	}

	public void setStActiveCodeDb(TActiveCodeDb stActiveCodeDb) {
		this.stActiveCodeDb = stActiveCodeDb;
	}

	public java.util.Map<java.lang.Integer, TBuyStatusDb> getMBuyItemStatDb() {
		return mBuyItemStatDb;
	}

	public void setMBuyItemStatDb(java.util.Map<java.lang.Integer, TBuyStatusDb> mBuyItemStatDb) {
		this.mBuyItemStatDb = mBuyItemStatDb;
	}

	public java.util.Map<java.lang.Integer, TBuyStatusDb> getMFirstBuyItemStatDb() {
		return mFirstBuyItemStatDb;
	}

	public void setMFirstBuyItemStatDb(java.util.Map<java.lang.Integer, TBuyStatusDb> mFirstBuyItemStatDb) {
		this.mFirstBuyItemStatDb = mFirstBuyItemStatDb;
	}

	public TDBNewbieData getStNewbieData() {
		return stNewbieData;
	}

	public void setStNewbieData(TDBNewbieData stNewbieData) {
		this.stNewbieData = stNewbieData;
	}

	public java.util.List<java.lang.Integer> getVecAllSvrMailRecord() {
		return vecAllSvrMailRecord;
	}

	public void setVecAllSvrMailRecord(java.util.List<java.lang.Integer> vecAllSvrMailRecord) {
		this.vecAllSvrMailRecord = vecAllSvrMailRecord;
	}

	public java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>> getMChargeStatusDb() {
		return mChargeStatusDb;
	}

	public void setMChargeStatusDb(java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>> mChargeStatusDb) {
		this.mChargeStatusDb = mChargeStatusDb;
	}

	public java.util.Map<java.lang.Byte, TDBWorkshopInfo> getMWorkshop() {
		return mWorkshop;
	}

	public void setMWorkshop(java.util.Map<java.lang.Byte, TDBWorkshopInfo> mWorkshop) {
		this.mWorkshop = mWorkshop;
	}

	public TExtData1() {
	}

	public TExtData1(TActiveCodeDb stActiveCodeDb, java.util.Map<java.lang.Integer, TBuyStatusDb> mBuyItemStatDb, java.util.Map<java.lang.Integer, TBuyStatusDb> mFirstBuyItemStatDb, TDBNewbieData stNewbieData, java.util.List<java.lang.Integer> vecAllSvrMailRecord, java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>> mChargeStatusDb, java.util.Map<java.lang.Byte, TDBWorkshopInfo> mWorkshop) {
		this.stActiveCodeDb = stActiveCodeDb;
		this.mBuyItemStatDb = mBuyItemStatDb;
		this.mFirstBuyItemStatDb = mFirstBuyItemStatDb;
		this.stNewbieData = stNewbieData;
		this.vecAllSvrMailRecord = vecAllSvrMailRecord;
		this.mChargeStatusDb = mChargeStatusDb;
		this.mWorkshop = mWorkshop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(stActiveCodeDb);
		result = prime * result + TarsUtil.hashCode(mBuyItemStatDb);
		result = prime * result + TarsUtil.hashCode(mFirstBuyItemStatDb);
		result = prime * result + TarsUtil.hashCode(stNewbieData);
		result = prime * result + TarsUtil.hashCode(vecAllSvrMailRecord);
		result = prime * result + TarsUtil.hashCode(mChargeStatusDb);
		result = prime * result + TarsUtil.hashCode(mWorkshop);
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
		if (!(obj instanceof TExtData1)) {
			return false;
		}
		TExtData1 other = (TExtData1) obj;
		return (
			TarsUtil.equals(stActiveCodeDb, other.stActiveCodeDb) &&
			TarsUtil.equals(mBuyItemStatDb, other.mBuyItemStatDb) &&
			TarsUtil.equals(mFirstBuyItemStatDb, other.mFirstBuyItemStatDb) &&
			TarsUtil.equals(stNewbieData, other.stNewbieData) &&
			TarsUtil.equals(vecAllSvrMailRecord, other.vecAllSvrMailRecord) &&
			TarsUtil.equals(mChargeStatusDb, other.mChargeStatusDb) &&
			TarsUtil.equals(mWorkshop, other.mWorkshop) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != stActiveCodeDb) {
			_os.write(stActiveCodeDb, 0);
		}
		if (null != mBuyItemStatDb) {
			_os.write(mBuyItemStatDb, 1);
		}
		if (null != mFirstBuyItemStatDb) {
			_os.write(mFirstBuyItemStatDb, 2);
		}
		if (null != stNewbieData) {
			_os.write(stNewbieData, 3);
		}
		if (null != vecAllSvrMailRecord) {
			_os.write(vecAllSvrMailRecord, 4);
		}
		if (null != mChargeStatusDb) {
			_os.write(mChargeStatusDb, 5);
		}
		if (null != mWorkshop) {
			_os.write(mWorkshop, 6);
		}
	}

	static TActiveCodeDb cache_stActiveCodeDb;
	static { 
		cache_stActiveCodeDb = new TActiveCodeDb();
	}
	static java.util.Map<java.lang.Integer, TBuyStatusDb> cache_mBuyItemStatDb;
	static { 
		cache_mBuyItemStatDb = new java.util.HashMap<java.lang.Integer, TBuyStatusDb>();
		int var_11 = 0;
		TBuyStatusDb var_12 = new TBuyStatusDb();
		cache_mBuyItemStatDb.put(var_11 ,var_12);
	}
	static java.util.Map<java.lang.Integer, TBuyStatusDb> cache_mFirstBuyItemStatDb;
	static { 
		cache_mFirstBuyItemStatDb = new java.util.HashMap<java.lang.Integer, TBuyStatusDb>();
		int var_13 = 0;
		TBuyStatusDb var_14 = new TBuyStatusDb();
		cache_mFirstBuyItemStatDb.put(var_13 ,var_14);
	}
	static TDBNewbieData cache_stNewbieData;
	static { 
		cache_stNewbieData = new TDBNewbieData();
	}
	static java.util.List<java.lang.Integer> cache_vecAllSvrMailRecord;
	static { 
		cache_vecAllSvrMailRecord = new java.util.ArrayList<java.lang.Integer>();
		int var_15 = 0;
		cache_vecAllSvrMailRecord.add(var_15);
	}
	static java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>> cache_mChargeStatusDb;
	static { 
		cache_mChargeStatusDb = new java.util.HashMap<java.lang.Integer, java.util.List<TChargeStatusDb>>();
		int var_16 = 0;
		java.util.List<TChargeStatusDb> var_17 = new java.util.ArrayList<TChargeStatusDb>();
		TChargeStatusDb var_18 = new TChargeStatusDb();
		var_17.add(var_18);
		cache_mChargeStatusDb.put(var_16 ,var_17);
	}
	static java.util.Map<java.lang.Byte, TDBWorkshopInfo> cache_mWorkshop;
	static { 
		cache_mWorkshop = new java.util.HashMap<java.lang.Byte, TDBWorkshopInfo>();
		byte var_19 = (byte)0;
		TDBWorkshopInfo var_20 = new TDBWorkshopInfo();
		cache_mWorkshop.put(var_19 ,var_20);
	}

	public void readFrom(TarsInputStream _is) {
		this.stActiveCodeDb = (TActiveCodeDb) _is.read(cache_stActiveCodeDb, 0, false);
		this.mBuyItemStatDb = (java.util.Map<java.lang.Integer, TBuyStatusDb>) _is.read(cache_mBuyItemStatDb, 1, false);
		this.mFirstBuyItemStatDb = (java.util.Map<java.lang.Integer, TBuyStatusDb>) _is.read(cache_mFirstBuyItemStatDb, 2, false);
		this.stNewbieData = (TDBNewbieData) _is.read(cache_stNewbieData, 3, false);
		this.vecAllSvrMailRecord = (java.util.List<java.lang.Integer>) _is.read(cache_vecAllSvrMailRecord, 4, false);
		this.mChargeStatusDb = (java.util.Map<java.lang.Integer, java.util.List<TChargeStatusDb>>) _is.read(cache_mChargeStatusDb, 5, false);
		this.mWorkshop = (java.util.Map<java.lang.Byte, TDBWorkshopInfo>) _is.read(cache_mWorkshop, 6, false);
	}

}
