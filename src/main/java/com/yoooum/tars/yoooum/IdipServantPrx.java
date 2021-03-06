// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;

import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.annotation.*;
import com.qq.tars.common.support.Holder;

@Servant
public interface IdipServantPrx {
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	 int PlatSendMail(java.util.List<com.yoooum.tars.yoooum.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsHolder Holder<java.util.List<com.yoooum.tars.yoooum.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.yoooum.TAccountID>> vecFailAccountID);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	 int PlatSendMail(java.util.List<com.yoooum.tars.yoooum.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsHolder Holder<java.util.List<com.yoooum.tars.yoooum.TAccountID>> vecSuccAccountID, @TarsHolder Holder<java.util.List<com.yoooum.tars.yoooum.TAccountID>> vecFailAccountID, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	 void async_PlatSendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.yoooum.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName);
	/**
	 * 发送邮件
	 * @param(input), vecAccountID 用户名
	 * @param(input), stMailItem 邮件信息
	 * @param(input), sSendName 发送者的名字
	 * @param(output),  邮件
	 * @返回值：返回 0 成功,   其它 失败
	 */
	 void async_PlatSendMail(@TarsCallback IdipServantPrxCallback callback, java.util.List<com.yoooum.tars.yoooum.TAccountID> vecAccountID, com.yoooum.tars.account.TMailItem stMailItem, String sSendName, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送全服邮件
	 * @param(input), stServerMailData 邮件信息
	 */
	 int SendServerMail(com.yoooum.tars.account.ServerMail stServerMailData);
	/**
	 * 发送全服邮件
	 * @param(input), stServerMailData 邮件信息
	 */
	 int SendServerMail(com.yoooum.tars.account.ServerMail stServerMailData, @TarsContext java.util.Map<String, String> ctx);
	/**
	 * 发送全服邮件
	 * @param(input), stServerMailData 邮件信息
	 */
	 void async_SendServerMail(@TarsCallback IdipServantPrxCallback callback, com.yoooum.tars.account.ServerMail stServerMailData);
	/**
	 * 发送全服邮件
	 * @param(input), stServerMailData 邮件信息
	 */
	 void async_SendServerMail(@TarsCallback IdipServantPrxCallback callback, com.yoooum.tars.account.ServerMail stServerMailData, @TarsContext java.util.Map<String, String> ctx);
}
