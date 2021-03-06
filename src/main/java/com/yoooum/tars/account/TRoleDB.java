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
public class TRoleDB {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iExp = 0;
	@TarsStructProperty(order = 2, isRequire = false)
	public short nLvl = (short)0;
	@TarsStructProperty(order = 3, isRequire = false)
	public int iCurSkinID = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public java.util.List<java.lang.Integer> vecSkinList = null;
	@TarsStructProperty(order = 5, isRequire = false)
	public java.util.List<com.yoooum.tars.yoooum.TProperty> vecUpgradeProperty = null;

	public int getIID() {
		return iID;
	}

	public void setIID(int iID) {
		this.iID = iID;
	}

	public int getIExp() {
		return iExp;
	}

	public void setIExp(int iExp) {
		this.iExp = iExp;
	}

	public short getNLvl() {
		return nLvl;
	}

	public void setNLvl(short nLvl) {
		this.nLvl = nLvl;
	}

	public int getICurSkinID() {
		return iCurSkinID;
	}

	public void setICurSkinID(int iCurSkinID) {
		this.iCurSkinID = iCurSkinID;
	}

	public java.util.List<java.lang.Integer> getVecSkinList() {
		return vecSkinList;
	}

	public void setVecSkinList(java.util.List<java.lang.Integer> vecSkinList) {
		this.vecSkinList = vecSkinList;
	}

	public java.util.List<com.yoooum.tars.yoooum.TProperty> getVecUpgradeProperty() {
		return vecUpgradeProperty;
	}

	public void setVecUpgradeProperty(java.util.List<com.yoooum.tars.yoooum.TProperty> vecUpgradeProperty) {
		this.vecUpgradeProperty = vecUpgradeProperty;
	}

	public TRoleDB() {
	}

	public TRoleDB(int iID, int iExp, short nLvl, int iCurSkinID, java.util.List<java.lang.Integer> vecSkinList, java.util.List<com.yoooum.tars.yoooum.TProperty> vecUpgradeProperty) {
		this.iID = iID;
		this.iExp = iExp;
		this.nLvl = nLvl;
		this.iCurSkinID = iCurSkinID;
		this.vecSkinList = vecSkinList;
		this.vecUpgradeProperty = vecUpgradeProperty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iID);
		result = prime * result + TarsUtil.hashCode(iExp);
		result = prime * result + TarsUtil.hashCode(nLvl);
		result = prime * result + TarsUtil.hashCode(iCurSkinID);
		result = prime * result + TarsUtil.hashCode(vecSkinList);
		result = prime * result + TarsUtil.hashCode(vecUpgradeProperty);
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
		if (!(obj instanceof TRoleDB)) {
			return false;
		}
		TRoleDB other = (TRoleDB) obj;
		return (
			TarsUtil.equals(iID, other.iID) &&
			TarsUtil.equals(iExp, other.iExp) &&
			TarsUtil.equals(nLvl, other.nLvl) &&
			TarsUtil.equals(iCurSkinID, other.iCurSkinID) &&
			TarsUtil.equals(vecSkinList, other.vecSkinList) &&
			TarsUtil.equals(vecUpgradeProperty, other.vecUpgradeProperty) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iID, 0);
		_os.write(iExp, 1);
		_os.write(nLvl, 2);
		_os.write(iCurSkinID, 3);
		if (null != vecSkinList) {
			_os.write(vecSkinList, 4);
		}
		if (null != vecUpgradeProperty) {
			_os.write(vecUpgradeProperty, 5);
		}
	}

	static java.util.List<java.lang.Integer> cache_vecSkinList;
	static { 
		cache_vecSkinList = new java.util.ArrayList<java.lang.Integer>();
		int var_33 = 0;
		cache_vecSkinList.add(var_33);
	}
	static java.util.List<com.yoooum.tars.yoooum.TProperty> cache_vecUpgradeProperty;
	static { 
		cache_vecUpgradeProperty = new java.util.ArrayList<com.yoooum.tars.yoooum.TProperty>();
		com.yoooum.tars.yoooum.TProperty var_34 = new com.yoooum.tars.yoooum.TProperty();
		cache_vecUpgradeProperty.add(var_34);
	}

	public void readFrom(TarsInputStream _is) {
		this.iID = _is.read(iID, 0, false);
		this.iExp = _is.read(iExp, 1, false);
		this.nLvl = _is.read(nLvl, 2, false);
		this.iCurSkinID = _is.read(iCurSkinID, 3, false);
		this.vecSkinList = (java.util.List<java.lang.Integer>) _is.read(cache_vecSkinList, 4, false);
		this.vecUpgradeProperty = (java.util.List<com.yoooum.tars.yoooum.TProperty>) _is.read(cache_vecUpgradeProperty, 5, false);
	}

}
