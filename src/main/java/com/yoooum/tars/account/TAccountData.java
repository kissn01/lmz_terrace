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
public class TAccountData {

	@TarsStructProperty(order = 0, isRequire = true)
	public com.yoooum.tars.yoooum.TAccountID stAccountID = null;
	@TarsStructProperty(order = 1, isRequire = true)
	public TUserBaseInfo stUserBaseInfo = null;
	@TarsStructProperty(order = 2, isRequire = true)
	public long lLastLoginTm = 0L;
	@TarsStructProperty(order = 3, isRequire = true)
	public long lCreateTime = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public long lLastLogoutTm = 0L;
	@TarsStructProperty(order = 5, isRequire = false)
	public short nBan = (short)0;
	@TarsStructProperty(order = 6, isRequire = false)
	public long lBanTime = 0L;
	@TarsStructProperty(order = 7, isRequire = false)
	public TEquipmentInfo stEquipmentData = null;
	@TarsStructProperty(order = 8, isRequire = false)
	public TDBBagInfo stBagInfo = null;
	@TarsStructProperty(order = 9, isRequire = false)
	public TRoleInfo stRoleInfo = null;
	@TarsStructProperty(order = 10, isRequire = false)
	public TExtData1 stExtData1 = null;
	@TarsStructProperty(order = 11, isRequire = false)
	public TFarmData stFarmData = null;
	@TarsStructProperty(order = 12, isRequire = false)
	public TDBAchiData stAchiData = null;
	@TarsStructProperty(order = 13, isRequire = false)
	public TNpcDBInfo stNpcDbInfo = null;
	@TarsStructProperty(order = 14, isRequire = false)
	public TDBTaskData stTaskData = null;

	public com.yoooum.tars.yoooum.TAccountID getStAccountID() {
		return stAccountID;
	}

	public void setStAccountID(com.yoooum.tars.yoooum.TAccountID stAccountID) {
		this.stAccountID = stAccountID;
	}

	public TUserBaseInfo getStUserBaseInfo() {
		return stUserBaseInfo;
	}

	public void setStUserBaseInfo(TUserBaseInfo stUserBaseInfo) {
		this.stUserBaseInfo = stUserBaseInfo;
	}

	public long getLLastLoginTm() {
		return lLastLoginTm;
	}

	public void setLLastLoginTm(long lLastLoginTm) {
		this.lLastLoginTm = lLastLoginTm;
	}

	public long getLCreateTime() {
		return lCreateTime;
	}

	public void setLCreateTime(long lCreateTime) {
		this.lCreateTime = lCreateTime;
	}

	public long getLLastLogoutTm() {
		return lLastLogoutTm;
	}

	public void setLLastLogoutTm(long lLastLogoutTm) {
		this.lLastLogoutTm = lLastLogoutTm;
	}

	public short getNBan() {
		return nBan;
	}

	public void setNBan(short nBan) {
		this.nBan = nBan;
	}

	public long getLBanTime() {
		return lBanTime;
	}

	public void setLBanTime(long lBanTime) {
		this.lBanTime = lBanTime;
	}

	public TEquipmentInfo getStEquipmentData() {
		return stEquipmentData;
	}

	public void setStEquipmentData(TEquipmentInfo stEquipmentData) {
		this.stEquipmentData = stEquipmentData;
	}

	public TDBBagInfo getStBagInfo() {
		return stBagInfo;
	}

	public void setStBagInfo(TDBBagInfo stBagInfo) {
		this.stBagInfo = stBagInfo;
	}

	public TRoleInfo getStRoleInfo() {
		return stRoleInfo;
	}

	public void setStRoleInfo(TRoleInfo stRoleInfo) {
		this.stRoleInfo = stRoleInfo;
	}

	public TExtData1 getStExtData1() {
		return stExtData1;
	}

	public void setStExtData1(TExtData1 stExtData1) {
		this.stExtData1 = stExtData1;
	}

	public TFarmData getStFarmData() {
		return stFarmData;
	}

	public void setStFarmData(TFarmData stFarmData) {
		this.stFarmData = stFarmData;
	}

	public TDBAchiData getStAchiData() {
		return stAchiData;
	}

	public void setStAchiData(TDBAchiData stAchiData) {
		this.stAchiData = stAchiData;
	}

	public TNpcDBInfo getStNpcDbInfo() {
		return stNpcDbInfo;
	}

	public void setStNpcDbInfo(TNpcDBInfo stNpcDbInfo) {
		this.stNpcDbInfo = stNpcDbInfo;
	}

	public TDBTaskData getStTaskData() {
		return stTaskData;
	}

	public void setStTaskData(TDBTaskData stTaskData) {
		this.stTaskData = stTaskData;
	}

	public TAccountData() {
	}

	public TAccountData(com.yoooum.tars.yoooum.TAccountID stAccountID, TUserBaseInfo stUserBaseInfo, long lLastLoginTm, long lCreateTime, long lLastLogoutTm, short nBan, long lBanTime, TEquipmentInfo stEquipmentData, TDBBagInfo stBagInfo, TRoleInfo stRoleInfo, TExtData1 stExtData1, TFarmData stFarmData, TDBAchiData stAchiData, TNpcDBInfo stNpcDbInfo, TDBTaskData stTaskData) {
		this.stAccountID = stAccountID;
		this.stUserBaseInfo = stUserBaseInfo;
		this.lLastLoginTm = lLastLoginTm;
		this.lCreateTime = lCreateTime;
		this.lLastLogoutTm = lLastLogoutTm;
		this.nBan = nBan;
		this.lBanTime = lBanTime;
		this.stEquipmentData = stEquipmentData;
		this.stBagInfo = stBagInfo;
		this.stRoleInfo = stRoleInfo;
		this.stExtData1 = stExtData1;
		this.stFarmData = stFarmData;
		this.stAchiData = stAchiData;
		this.stNpcDbInfo = stNpcDbInfo;
		this.stTaskData = stTaskData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(stAccountID);
		result = prime * result + TarsUtil.hashCode(stUserBaseInfo);
		result = prime * result + TarsUtil.hashCode(lLastLoginTm);
		result = prime * result + TarsUtil.hashCode(lCreateTime);
		result = prime * result + TarsUtil.hashCode(lLastLogoutTm);
		result = prime * result + TarsUtil.hashCode(nBan);
		result = prime * result + TarsUtil.hashCode(lBanTime);
		result = prime * result + TarsUtil.hashCode(stEquipmentData);
		result = prime * result + TarsUtil.hashCode(stBagInfo);
		result = prime * result + TarsUtil.hashCode(stRoleInfo);
		result = prime * result + TarsUtil.hashCode(stExtData1);
		result = prime * result + TarsUtil.hashCode(stFarmData);
		result = prime * result + TarsUtil.hashCode(stAchiData);
		result = prime * result + TarsUtil.hashCode(stNpcDbInfo);
		result = prime * result + TarsUtil.hashCode(stTaskData);
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
		if (!(obj instanceof TAccountData)) {
			return false;
		}
		TAccountData other = (TAccountData) obj;
		return (
			TarsUtil.equals(stAccountID, other.stAccountID) &&
			TarsUtil.equals(stUserBaseInfo, other.stUserBaseInfo) &&
			TarsUtil.equals(lLastLoginTm, other.lLastLoginTm) &&
			TarsUtil.equals(lCreateTime, other.lCreateTime) &&
			TarsUtil.equals(lLastLogoutTm, other.lLastLogoutTm) &&
			TarsUtil.equals(nBan, other.nBan) &&
			TarsUtil.equals(lBanTime, other.lBanTime) &&
			TarsUtil.equals(stEquipmentData, other.stEquipmentData) &&
			TarsUtil.equals(stBagInfo, other.stBagInfo) &&
			TarsUtil.equals(stRoleInfo, other.stRoleInfo) &&
			TarsUtil.equals(stExtData1, other.stExtData1) &&
			TarsUtil.equals(stFarmData, other.stFarmData) &&
			TarsUtil.equals(stAchiData, other.stAchiData) &&
			TarsUtil.equals(stNpcDbInfo, other.stNpcDbInfo) &&
			TarsUtil.equals(stTaskData, other.stTaskData) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(stAccountID, 0);
		_os.write(stUserBaseInfo, 1);
		_os.write(lLastLoginTm, 2);
		_os.write(lCreateTime, 3);
		_os.write(lLastLogoutTm, 4);
		_os.write(nBan, 5);
		_os.write(lBanTime, 6);
		if (null != stEquipmentData) {
			_os.write(stEquipmentData, 7);
		}
		if (null != stBagInfo) {
			_os.write(stBagInfo, 8);
		}
		if (null != stRoleInfo) {
			_os.write(stRoleInfo, 9);
		}
		if (null != stExtData1) {
			_os.write(stExtData1, 10);
		}
		if (null != stFarmData) {
			_os.write(stFarmData, 11);
		}
		if (null != stAchiData) {
			_os.write(stAchiData, 12);
		}
		if (null != stNpcDbInfo) {
			_os.write(stNpcDbInfo, 13);
		}
		if (null != stTaskData) {
			_os.write(stTaskData, 14);
		}
	}

	static com.yoooum.tars.yoooum.TAccountID cache_stAccountID;
	static { 
		cache_stAccountID = new com.yoooum.tars.yoooum.TAccountID();
	}
	static TUserBaseInfo cache_stUserBaseInfo;
	static { 
		cache_stUserBaseInfo = new TUserBaseInfo();
	}
	static TEquipmentInfo cache_stEquipmentData;
	static { 
		cache_stEquipmentData = new TEquipmentInfo();
	}
	static TDBBagInfo cache_stBagInfo;
	static { 
		cache_stBagInfo = new TDBBagInfo();
	}
	static TRoleInfo cache_stRoleInfo;
	static { 
		cache_stRoleInfo = new TRoleInfo();
	}
	static TExtData1 cache_stExtData1;
	static { 
		cache_stExtData1 = new TExtData1();
	}
	static TFarmData cache_stFarmData;
	static { 
		cache_stFarmData = new TFarmData();
	}
	static TDBAchiData cache_stAchiData;
	static { 
		cache_stAchiData = new TDBAchiData();
	}
	static TNpcDBInfo cache_stNpcDbInfo;
	static { 
		cache_stNpcDbInfo = new TNpcDBInfo();
	}
	static TDBTaskData cache_stTaskData;
	static { 
		cache_stTaskData = new TDBTaskData();
	}

	public void readFrom(TarsInputStream _is) {
		this.stAccountID = (com.yoooum.tars.yoooum.TAccountID) _is.read(cache_stAccountID, 0, true);
		this.stUserBaseInfo = (TUserBaseInfo) _is.read(cache_stUserBaseInfo, 1, true);
		this.lLastLoginTm = _is.read(lLastLoginTm, 2, true);
		this.lCreateTime = _is.read(lCreateTime, 3, true);
		this.lLastLogoutTm = _is.read(lLastLogoutTm, 4, false);
		this.nBan = _is.read(nBan, 5, false);
		this.lBanTime = _is.read(lBanTime, 6, false);
		this.stEquipmentData = (TEquipmentInfo) _is.read(cache_stEquipmentData, 7, false);
		this.stBagInfo = (TDBBagInfo) _is.read(cache_stBagInfo, 8, false);
		this.stRoleInfo = (TRoleInfo) _is.read(cache_stRoleInfo, 9, false);
		this.stExtData1 = (TExtData1) _is.read(cache_stExtData1, 10, false);
		this.stFarmData = (TFarmData) _is.read(cache_stFarmData, 11, false);
		this.stAchiData = (TDBAchiData) _is.read(cache_stAchiData, 12, false);
		this.stNpcDbInfo = (TNpcDBInfo) _is.read(cache_stNpcDbInfo, 13, false);
		this.stTaskData = (TDBTaskData) _is.read(cache_stTaskData, 14, false);
	}

}
