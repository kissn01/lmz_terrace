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
public class TTaskInfoCfg {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iTaskId = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String sTaskName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public String sTaskDesc = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public int iNpcID = 0;
	@TarsStructProperty(order = 4, isRequire = false)
	public int iMinLvl = 0;
	@TarsStructProperty(order = 5, isRequire = false)
	public int iMaxLvl = 0;
	@TarsStructProperty(order = 6, isRequire = false)
	public short nAwardType = (short)0;
	@TarsStructProperty(order = 7, isRequire = false)
	public java.util.List<java.lang.Integer> vDialog = null;
	@TarsStructProperty(order = 8, isRequire = false)
	public java.util.List<java.lang.Integer> vFinishDialog = null;
	@TarsStructProperty(order = 9, isRequire = false)
	public java.util.List<TTaskDesireCfg> vDesireList = null;
	@TarsStructProperty(order = 10, isRequire = false)
	public java.util.List<TMultipleAwardTypeCfg> vAwardList = null;
	@TarsStructProperty(order = 11, isRequire = false)
	public java.util.List<TTaskAcceptLimitCfg> vecAcceptLimit = null;
	@TarsStructProperty(order = 12, isRequire = false)
	public int iFavorValue = 0;
	@TarsStructProperty(order = 13, isRequire = false)
	public byte TaskType = (byte)0;
	@TarsStructProperty(order = 14, isRequire = false)
	public byte Quality = (byte)0;

	public int getITaskId() {
		return iTaskId;
	}

	public void setITaskId(int iTaskId) {
		this.iTaskId = iTaskId;
	}

	public String getSTaskName() {
		return sTaskName;
	}

	public void setSTaskName(String sTaskName) {
		this.sTaskName = sTaskName;
	}

	public String getSTaskDesc() {
		return sTaskDesc;
	}

	public void setSTaskDesc(String sTaskDesc) {
		this.sTaskDesc = sTaskDesc;
	}

	public int getINpcID() {
		return iNpcID;
	}

	public void setINpcID(int iNpcID) {
		this.iNpcID = iNpcID;
	}

	public int getIMinLvl() {
		return iMinLvl;
	}

	public void setIMinLvl(int iMinLvl) {
		this.iMinLvl = iMinLvl;
	}

	public int getIMaxLvl() {
		return iMaxLvl;
	}

	public void setIMaxLvl(int iMaxLvl) {
		this.iMaxLvl = iMaxLvl;
	}

	public short getNAwardType() {
		return nAwardType;
	}

	public void setNAwardType(short nAwardType) {
		this.nAwardType = nAwardType;
	}

	public java.util.List<java.lang.Integer> getVDialog() {
		return vDialog;
	}

	public void setVDialog(java.util.List<java.lang.Integer> vDialog) {
		this.vDialog = vDialog;
	}

	public java.util.List<java.lang.Integer> getVFinishDialog() {
		return vFinishDialog;
	}

	public void setVFinishDialog(java.util.List<java.lang.Integer> vFinishDialog) {
		this.vFinishDialog = vFinishDialog;
	}

	public java.util.List<TTaskDesireCfg> getVDesireList() {
		return vDesireList;
	}

	public void setVDesireList(java.util.List<TTaskDesireCfg> vDesireList) {
		this.vDesireList = vDesireList;
	}

	public java.util.List<TMultipleAwardTypeCfg> getVAwardList() {
		return vAwardList;
	}

	public void setVAwardList(java.util.List<TMultipleAwardTypeCfg> vAwardList) {
		this.vAwardList = vAwardList;
	}

	public java.util.List<TTaskAcceptLimitCfg> getVecAcceptLimit() {
		return vecAcceptLimit;
	}

	public void setVecAcceptLimit(java.util.List<TTaskAcceptLimitCfg> vecAcceptLimit) {
		this.vecAcceptLimit = vecAcceptLimit;
	}

	public int getIFavorValue() {
		return iFavorValue;
	}

	public void setIFavorValue(int iFavorValue) {
		this.iFavorValue = iFavorValue;
	}

	public byte getTaskType() {
		return TaskType;
	}

	public void setTaskType(byte TaskType) {
		this.TaskType = TaskType;
	}

	public byte getQuality() {
		return Quality;
	}

	public void setQuality(byte Quality) {
		this.Quality = Quality;
	}

	public TTaskInfoCfg() {
	}

	public TTaskInfoCfg(int iTaskId, String sTaskName, String sTaskDesc, int iNpcID, int iMinLvl, int iMaxLvl, short nAwardType, java.util.List<java.lang.Integer> vDialog, java.util.List<java.lang.Integer> vFinishDialog, java.util.List<TTaskDesireCfg> vDesireList, java.util.List<TMultipleAwardTypeCfg> vAwardList, java.util.List<TTaskAcceptLimitCfg> vecAcceptLimit, int iFavorValue, byte TaskType, byte Quality) {
		this.iTaskId = iTaskId;
		this.sTaskName = sTaskName;
		this.sTaskDesc = sTaskDesc;
		this.iNpcID = iNpcID;
		this.iMinLvl = iMinLvl;
		this.iMaxLvl = iMaxLvl;
		this.nAwardType = nAwardType;
		this.vDialog = vDialog;
		this.vFinishDialog = vFinishDialog;
		this.vDesireList = vDesireList;
		this.vAwardList = vAwardList;
		this.vecAcceptLimit = vecAcceptLimit;
		this.iFavorValue = iFavorValue;
		this.TaskType = TaskType;
		this.Quality = Quality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iTaskId);
		result = prime * result + TarsUtil.hashCode(sTaskName);
		result = prime * result + TarsUtil.hashCode(sTaskDesc);
		result = prime * result + TarsUtil.hashCode(iNpcID);
		result = prime * result + TarsUtil.hashCode(iMinLvl);
		result = prime * result + TarsUtil.hashCode(iMaxLvl);
		result = prime * result + TarsUtil.hashCode(nAwardType);
		result = prime * result + TarsUtil.hashCode(vDialog);
		result = prime * result + TarsUtil.hashCode(vFinishDialog);
		result = prime * result + TarsUtil.hashCode(vDesireList);
		result = prime * result + TarsUtil.hashCode(vAwardList);
		result = prime * result + TarsUtil.hashCode(vecAcceptLimit);
		result = prime * result + TarsUtil.hashCode(iFavorValue);
		result = prime * result + TarsUtil.hashCode(TaskType);
		result = prime * result + TarsUtil.hashCode(Quality);
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
		if (!(obj instanceof TTaskInfoCfg)) {
			return false;
		}
		TTaskInfoCfg other = (TTaskInfoCfg) obj;
		return (
			TarsUtil.equals(iTaskId, other.iTaskId) &&
			TarsUtil.equals(sTaskName, other.sTaskName) &&
			TarsUtil.equals(sTaskDesc, other.sTaskDesc) &&
			TarsUtil.equals(iNpcID, other.iNpcID) &&
			TarsUtil.equals(iMinLvl, other.iMinLvl) &&
			TarsUtil.equals(iMaxLvl, other.iMaxLvl) &&
			TarsUtil.equals(nAwardType, other.nAwardType) &&
			TarsUtil.equals(vDialog, other.vDialog) &&
			TarsUtil.equals(vFinishDialog, other.vFinishDialog) &&
			TarsUtil.equals(vDesireList, other.vDesireList) &&
			TarsUtil.equals(vAwardList, other.vAwardList) &&
			TarsUtil.equals(vecAcceptLimit, other.vecAcceptLimit) &&
			TarsUtil.equals(iFavorValue, other.iFavorValue) &&
			TarsUtil.equals(TaskType, other.TaskType) &&
			TarsUtil.equals(Quality, other.Quality) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iTaskId, 0);
		if (null != sTaskName) {
			_os.write(sTaskName, 1);
		}
		if (null != sTaskDesc) {
			_os.write(sTaskDesc, 2);
		}
		_os.write(iNpcID, 3);
		_os.write(iMinLvl, 4);
		_os.write(iMaxLvl, 5);
		_os.write(nAwardType, 6);
		if (null != vDialog) {
			_os.write(vDialog, 7);
		}
		if (null != vFinishDialog) {
			_os.write(vFinishDialog, 8);
		}
		if (null != vDesireList) {
			_os.write(vDesireList, 9);
		}
		if (null != vAwardList) {
			_os.write(vAwardList, 10);
		}
		if (null != vecAcceptLimit) {
			_os.write(vecAcceptLimit, 11);
		}
		_os.write(iFavorValue, 12);
		_os.write(TaskType, 13);
		_os.write(Quality, 14);
	}

	static java.util.List<java.lang.Integer> cache_vDialog;
	static { 
		cache_vDialog = new java.util.ArrayList<java.lang.Integer>();
		int var_65 = 0;
		cache_vDialog.add(var_65);
	}
	static java.util.List<java.lang.Integer> cache_vFinishDialog;
	static { 
		cache_vFinishDialog = new java.util.ArrayList<java.lang.Integer>();
		int var_66 = 0;
		cache_vFinishDialog.add(var_66);
	}
	static java.util.List<TTaskDesireCfg> cache_vDesireList;
	static { 
		cache_vDesireList = new java.util.ArrayList<TTaskDesireCfg>();
		TTaskDesireCfg var_67 = new TTaskDesireCfg();
		cache_vDesireList.add(var_67);
	}
	static java.util.List<TMultipleAwardTypeCfg> cache_vAwardList;
	static { 
		cache_vAwardList = new java.util.ArrayList<TMultipleAwardTypeCfg>();
		TMultipleAwardTypeCfg var_68 = new TMultipleAwardTypeCfg();
		cache_vAwardList.add(var_68);
	}
	static java.util.List<TTaskAcceptLimitCfg> cache_vecAcceptLimit;
	static { 
		cache_vecAcceptLimit = new java.util.ArrayList<TTaskAcceptLimitCfg>();
		TTaskAcceptLimitCfg var_69 = new TTaskAcceptLimitCfg();
		cache_vecAcceptLimit.add(var_69);
	}

	public void readFrom(TarsInputStream _is) {
		this.iTaskId = _is.read(iTaskId, 0, false);
		this.sTaskName = _is.readString(1, false);
		this.sTaskDesc = _is.readString(2, false);
		this.iNpcID = _is.read(iNpcID, 3, false);
		this.iMinLvl = _is.read(iMinLvl, 4, false);
		this.iMaxLvl = _is.read(iMaxLvl, 5, false);
		this.nAwardType = _is.read(nAwardType, 6, false);
		this.vDialog = (java.util.List<java.lang.Integer>) _is.read(cache_vDialog, 7, false);
		this.vFinishDialog = (java.util.List<java.lang.Integer>) _is.read(cache_vFinishDialog, 8, false);
		this.vDesireList = (java.util.List<TTaskDesireCfg>) _is.read(cache_vDesireList, 9, false);
		this.vAwardList = (java.util.List<TMultipleAwardTypeCfg>) _is.read(cache_vAwardList, 10, false);
		this.vecAcceptLimit = (java.util.List<TTaskAcceptLimitCfg>) _is.read(cache_vecAcceptLimit, 11, false);
		this.iFavorValue = _is.read(iFavorValue, 12, false);
		this.TaskType = _is.read(TaskType, 13, false);
		this.Quality = _is.read(Quality, 14, false);
	}

}
