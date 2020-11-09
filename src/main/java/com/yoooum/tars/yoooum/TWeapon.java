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
public class TWeapon {

	@TarsStructProperty(order = 0, isRequire = false)
	public int iWeaponID = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public int iAccesoryID = 0;

	public int getIWeaponID() {
		return iWeaponID;
	}

	public void setIWeaponID(int iWeaponID) {
		this.iWeaponID = iWeaponID;
	}

	public int getIAccesoryID() {
		return iAccesoryID;
	}

	public void setIAccesoryID(int iAccesoryID) {
		this.iAccesoryID = iAccesoryID;
	}

	public TWeapon() {
	}

	public TWeapon(int iWeaponID, int iAccesoryID) {
		this.iWeaponID = iWeaponID;
		this.iAccesoryID = iAccesoryID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(iWeaponID);
		result = prime * result + TarsUtil.hashCode(iAccesoryID);
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
		if (!(obj instanceof TWeapon)) {
			return false;
		}
		TWeapon other = (TWeapon) obj;
		return (
			TarsUtil.equals(iWeaponID, other.iWeaponID) &&
			TarsUtil.equals(iAccesoryID, other.iAccesoryID) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(iWeaponID, 0);
		_os.write(iAccesoryID, 1);
	}


	public void readFrom(TarsInputStream _is) {
		this.iWeaponID = _is.read(iWeaponID, 0, false);
		this.iAccesoryID = _is.read(iAccesoryID, 1, false);
	}

}