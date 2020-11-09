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
public class TSessionData {

	@TarsStructProperty(order = 0, isRequire = false)
	public int tm = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public long uin = 0L;
	@TarsStructProperty(order = 2, isRequire = false)
	public String openid = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public String token = "";

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public long getUin() {
		return uin;
	}

	public void setUin(long uin) {
		this.uin = uin;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TSessionData() {
	}

	public TSessionData(int tm, long uin, String openid, String token) {
		this.tm = tm;
		this.uin = uin;
		this.openid = openid;
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(tm);
		result = prime * result + TarsUtil.hashCode(uin);
		result = prime * result + TarsUtil.hashCode(openid);
		result = prime * result + TarsUtil.hashCode(token);
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
		if (!(obj instanceof TSessionData)) {
			return false;
		}
		TSessionData other = (TSessionData) obj;
		return (
			TarsUtil.equals(tm, other.tm) &&
			TarsUtil.equals(uin, other.uin) &&
			TarsUtil.equals(openid, other.openid) &&
			TarsUtil.equals(token, other.token) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(tm, 0);
		_os.write(uin, 1);
		if (null != openid) {
			_os.write(openid, 2);
		}
		if (null != token) {
			_os.write(token, 3);
		}
	}


	public void readFrom(TarsInputStream _is) {
		this.tm = _is.read(tm, 0, false);
		this.uin = _is.read(uin, 1, false);
		this.openid = _is.readString(2, false);
		this.token = _is.readString(3, false);
	}

}
