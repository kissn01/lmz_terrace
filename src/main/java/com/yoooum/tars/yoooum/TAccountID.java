// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.yoooum.tars.yoooum;


import com.qq.tars.protocol.tars.annotation.*;
import lombok.Data;

@Data
@TarsStruct
public class TAccountID {

    @TarsStructProperty(order = 0, isRequire = true)
    public long uuin = 0;
    @TarsStructProperty(order = 1, isRequire = true)
    public String sopenID = "";
    @TarsStructProperty(order = 2, isRequire = true)
    public int iopenPlatType = 0;
    @TarsStructProperty(order = 3, isRequire = true)
    public int iosType = 0;
    @TarsStructProperty(order = 4, isRequire = true)
    public int izoneId = 0;


}