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
public class TRS2RPackage {

	@TarsStructProperty(order = 0, isRequire = true)
	public TRouterHead stRouterHead = null;
	@TarsStructProperty(order = 1, isRequire = true)
	public TRPackage stRPkg = null;

	public TRouterHead getStRouterHead() {
		return stRouterHead;
	}

	public void setStRouterHead(TRouterHead stRouterHead) {
		this.stRouterHead = stRouterHead;
	}

	public TRPackage getStRPkg() {
		return stRPkg;
	}

	public void setStRPkg(TRPackage stRPkg) {
		this.stRPkg = stRPkg;
	}

	public TRS2RPackage() {
	}

	public TRS2RPackage(TRouterHead stRouterHead, TRPackage stRPkg) {
		this.stRouterHead = stRouterHead;
		this.stRPkg = stRPkg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(stRouterHead);
		result = prime * result + TarsUtil.hashCode(stRPkg);
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
		if (!(obj instanceof TRS2RPackage)) {
			return false;
		}
		TRS2RPackage other = (TRS2RPackage) obj;
		return (
			TarsUtil.equals(stRouterHead, other.stRouterHead) &&
			TarsUtil.equals(stRPkg, other.stRPkg) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(stRouterHead, 0);
		_os.write(stRPkg, 1);
	}

	static TRouterHead cache_stRouterHead;
	static { 
		cache_stRouterHead = new TRouterHead();
	}
	static TRPackage cache_stRPkg;
	static { 
		cache_stRPkg = new TRPackage();
	}

	public void readFrom(TarsInputStream _is) {
		this.stRouterHead = (TRouterHead) _is.read(cache_stRouterHead, 0, true);
		this.stRPkg = (TRPackage) _is.read(cache_stRPkg, 1, true);
	}

}
