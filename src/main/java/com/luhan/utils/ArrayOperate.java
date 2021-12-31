package com.luhan.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 求两个集合之间的并集、交集、差集
 * <p>类描述</p>
 *
 * @author luHan
 * @create 2020/6/18 15:37
 * @since 1.0.0
 */
public class ArrayOperate {

    /**
     * 求两个集合的并集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> union(List<T> list1, List<T> list2) {
        List<T> localList1 = new ArrayList<>(list1);
        localList1.addAll(new ArrayList<>(list2));
        return localList1;
    }

    /**
     * 求两个集合的交集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> localList1 = new ArrayList<>(list1);
        localList1.retainAll(list2);
        return localList1;
    }

    /**
     * 求两个集合的差集
     *
     * @param list1
     * @param list2
     * @return
     */
    public static <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> localList1 = new ArrayList<>(list1);
        localList1.removeAll(list2);
        return localList1;
    }
}
