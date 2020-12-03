package com.yoooum.entity.userinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBehavior
 * @Description TODO
 * @Author kiss
 * @Date 2020/11/26 15:59
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBehavior
{
    private String dateSign;
    private Integer  dau;
    private Integer  loginCount;
    private String gameTime;
    private String planTime;
    private String cityTime;
}
