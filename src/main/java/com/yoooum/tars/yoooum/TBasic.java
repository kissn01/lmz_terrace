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
public class TBasic {

	@TarsStructProperty(order = 0, isRequire = false)
	public String sName = "";
	@TarsStructProperty(order = 1, isRequire = false)
	public byte Geneder = (byte)0;
	@TarsStructProperty(order = 2, isRequire = false)
	public String sHeadUrl = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public long uCoins = 0L;
	@TarsStructProperty(order = 4, isRequire = false)
	public long uDiamonds = 0L;
	@TarsStructProperty(order = 5, isRequire = false)
	public long uDiamonAmt = 0L;
	@TarsStructProperty(order = 6, isRequire = false)
	public short nLevel = (short)0;
	@TarsStructProperty(order = 7, isRequire = false)
	public long nExperince = 0L;

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public byte getGeneder() {
		return Geneder;
	}

	public void setGeneder(byte Geneder) {
		this.Geneder = Geneder;
	}

	public String getSHeadUrl() {
		return sHeadUrl;
	}

	public void setSHeadUrl(String sHeadUrl) {
		this.sHeadUrl = sHeadUrl;
	}

	public long getUCoins() {
		return uCoins;
	}

	public void setUCoins(long uCoins) {
		this.uCoins = uCoins;
	}

	public long getUDiamonds() {
		return uDiamonds;
	}

	public void setUDiamonds(long uDiamonds) {
		this.uDiamonds = uDiamonds;
	}

	public long getUDiamonAmt() {
		return uDiamonAmt;
	}

	public void setUDiamonAmt(long uDiamonAmt) {
		this.uDiamonAmt = uDiamonAmt;
	}

	public short getNLevel() {
		return nLevel;
	}

	public void setNLevel(short nLevel) {
		this.nLevel = nLevel;
	}

	public long getNExperince() {
		return nExperince;
	}

	public void setNExperince(long nExperince) {
		this.nExperince = nExperince;
	}

	public TBasic() {
	}

	public TBasic(String sName, byte Geneder, String sHeadUrl, long uCoins, long uDiamonds, long uDiamonAmt, short nLevel, long nExperince) {
		this.sName = sName;
		this.Geneder = Geneder;
		this.sHeadUrl = sHeadUrl;
		this.uCoins = uCoins;
		this.uDiamonds = uDiamonds;
		this.uDiamonAmt = uDiamonAmt;
		this.nLevel = nLevel;
		this.nExperince = nExperince;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(sName);
		result = prime * result + TarsUtil.hashCode(Geneder);
		result = prime * result + TarsUtil.hashCode(sHeadUrl);
		result = prime * result + TarsUtil.hashCode(uCoins);
		result = prime * result + TarsUtil.hashCode(uDiamonds);
		result = prime * result + TarsUtil.hashCode(uDiamonAmt);
		result = prime * result + TarsUtil.hashCode(nLevel);
		result = prime * result + TarsUtil.hashCode(nExperince);
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
		if (!(obj instanceof TBasic)) {
			return false;
		}
		TBasic other = (TBasic) obj;
		return (
			TarsUtil.equals(sName, other.sName) &&
			TarsUtil.equals(Geneder, other.Geneder) &&
			TarsUtil.equals(sHeadUrl, other.sHeadUrl) &&
			TarsUtil.equals(uCoins, other.uCoins) &&
			TarsUtil.equals(uDiamonds, other.uDiamonds) &&
			TarsUtil.equals(uDiamonAmt, other.uDiamonAmt) &&
			TarsUtil.equals(nLevel, other.nLevel) &&
			TarsUtil.equals(nExperince, other.nExperince) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != sName) {
			_os.write(sName, 0);
		}
		_os.write(Geneder, 1);
		if (null != sHeadUrl) {
			_os.write(sHeadUrl, 2);
		}
		_os.write(uCoins, 3);
		_os.write(uDiamonds, 4);
		_os.write(uDiamonAmt, 5);
		_os.write(nLevel, 6);
		_os.write(nExperince, 7);
	}


	public void readFrom(TarsInputStream _is) {
		this.sName = _is.readString(0, false);
		this.Geneder = _is.read(Geneder, 1, false);
		this.sHeadUrl = _is.readString(2, false);
		this.uCoins = _is.read(uCoins, 3, false);
		this.uDiamonds = _is.read(uDiamonds, 4, false);
		this.uDiamonAmt = _is.read(uDiamonAmt, 5, false);
		this.nLevel = _is.read(nLevel, 6, false);
		this.nExperince = _is.read(nExperince, 7, false);
	}

}