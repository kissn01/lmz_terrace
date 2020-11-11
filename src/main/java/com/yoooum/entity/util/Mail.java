package com.yoooum.entity.util;

import lombok.Data;


/**
 * @ClassName Mail
 * @Description TODO
 * @Author kiss
 * @Date 2020/11/6 17:12
 * @Version 1.0
 */
@Data
public class Mail
{
    private Integer environmentId;
    private Integer region;
    private String  userList;
    private Integer emailId;
    private String  emailTitle;
    private String  emailDesc;
    private String  itemList;
    private String  sendTime;
    private String  endTime;

}
