package com.luhan.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Stream流相关的工具类
 *
 * @author luHan
 * @create 2021/12/31 下午1:08
 * @since 1.0.0
 */
public class StreamUtils {

    /**
     * 将List转为Map
     *
     * @param list         原集合数据
     * @param keyExtractor key的抽取规则
     * @param <K>          key
     * @param <V>          value
     * @return
     */
    public static <K, V> Map<K, V> listToMap(List<V> list, Function<V, K> keyExtractor) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.toMap(keyExtractor, Function.identity(), (v1, v2) -> v2));
    }

    /**
     * 将List中的每个元素转成R类型的数据
     *
     * @param list   原集合数据
     * @param mapper 将原类型的数据转换成指定R类型的数据的转换方法
     * @param <V>    原类型
     * @param <R>    目标类型
     * @return
     */
    public static <V, R> List<R> listMap(List<V> list, Function<V, R> mapper) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 将List中的数据按照一定的规则进行分组
     *
     * @param list        原集合数据
     * @param groupMapper 分组规则
     * @param <K>         key
     * @param <V>         value
     * @return
     */
    public static <K, V> Map<K, List<V>> listGroupBy(List<V> list, Function<V, K> groupMapper) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.groupingBy(groupMapper));
    }
}
