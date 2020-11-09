package com.yoooum.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @创建人: ${kiss}
 * @时间: 2019/9/25 11:23
 * @描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Item
{
    private  Integer levelId;
    private  int     userNum;
}
