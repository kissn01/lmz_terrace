package com.yoooum.util;

import java.util.*;

/**
 * @创建人: ${kiss}
 * @时间: 2020/1/2 11:10
 * @描述:
 */
public class CollectionUtil
{

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(1);
        list2.add(3);
        list2.add(4);
        list2.add(2);
        Collection same = CollectionUtil.getSame(list, list2);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(same.size());

    }

    private CollectionUtil() {
    }

    /**
     * 找出两个集合中不同的元素
     *
     * @param collmax
     * @param collmin
     * @return
     */
    public static Collection getDifferent(Collection collmax, Collection collmin) {
        //使用LinkedList防止差异过大时,元素拷贝
        Collection csReturn = new LinkedList();
        Collection max = collmax;
        Collection min = collmin;
        //先比较大小,这样会减少后续map的if判断次数
        if (collmax.size() < collmin.size()) {
            max = collmin;
            min = collmax;
        }
        //直接指定大小,防止再散列
        Map<Object, Integer> map = new HashMap<Object, Integer>(max.size());
        for (Object object : max) {
            map.put(object, 1);
        }
        for (Object object : min) {
            if (map.get(object) == null) {
                csReturn.add(object);
            } else {
                map.put(object, 2);
            }
        }
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                csReturn.add(entry.getKey());
            }
        }
        return csReturn;
    }

    /**
     * 找出两个集合中相同的元素
     *
     * @param collmax
     * @param collmin
     * @return
     */
    public static Collection getSame(Collection collmax, Collection collmin) {
        //使用LinkedList防止差异过大时,元素拷贝
        Collection csReturn = new LinkedList();
        Collection max = collmax;
        Collection min = collmin;
        //先比较大小,这样会减少后续map的if判断次数
        if (collmax.size() < collmin.size()) {
            max = collmin;
            min = collmax;
        }
        //直接指定大小,防止再散列
        Map<Object, Integer> map = new HashMap<Object, Integer>(max.size());
        for (Object object : max) {
            map.put(object, 1);
        }
        for (Object object : min) {
            if (map.get(object) != null) {
                csReturn.add(object);
            }
        }
        return csReturn;
    }

    /**
     * 获取两个集合的不同元素,去除重复
     *
     * @param collmax
     * @param collmin
     * @return
     */
    public static Collection getDiffentNoDuplicate(Collection collmax, Collection collmin) {
        return new HashSet(getDifferent(collmax, collmin));
    }
}
