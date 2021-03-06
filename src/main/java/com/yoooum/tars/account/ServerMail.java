// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.account;


import com.qq.tars.protocol.tars.annotation.*;
import lombok.Data;

@TarsStruct
@Data
public class ServerMail {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<java.lang.Integer> vecZoneID = null;
	@TarsStructProperty(order = 1, isRequire = false)
	public long lSendTime = 0L;
	@TarsStructProperty(order = 2, isRequire = false)
	public long lOverTime = 0L;
	@TarsStructProperty(order = 3, isRequire = false)
	public String sTitle = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public String sContent = "";
	@TarsStructProperty(order = 5, isRequire = false)
	public java.util.List<TAccessoryItem> vAccessoryItem = null;
	@TarsStructProperty(order = 6, isRequire = false)
	public String sSender = "";


}
