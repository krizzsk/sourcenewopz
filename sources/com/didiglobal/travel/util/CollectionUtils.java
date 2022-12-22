package com.didiglobal.travel.util;

import androidx.collection.ArrayMap;
import androidx.core.util.Supplier;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return Preconditions.isNull(collection) || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return Preconditions.isNull(map) || map.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return Preconditions.nonNull(collection) && !collection.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return Preconditions.nonNull(map) && !map.isEmpty();
    }

    public static int sizeOf(Collection<?> collection) {
        if (Preconditions.isNull(collection)) {
            return 0;
        }
        return collection.size();
    }

    public static int sizeOf(Map<?, ?> map) {
        if (Preconditions.isNull(map)) {
            return 0;
        }
        return map.size();
    }

    public static <T> T getOrNull(List<T> list, int i) {
        if (!isEmpty((Collection<?>) list) && i >= 0 && i < ((List) Objects.requireNonNull(list)).size()) {
            return list.get(i);
        }
        return null;
    }

    public static <T> T getOrDefault(List<T> list, int i, Supplier<T> supplier) {
        T orNull = getOrNull(list, i);
        return Preconditions.nonNull(orNull) ? orNull : supplier.get();
    }

    public static <T> boolean contains(List<T> list, T t) {
        if (Preconditions.isNull(t) || isEmpty((Collection<?>) list)) {
            return false;
        }
        return ((List) Objects.requireNonNull(list)).contains(t);
    }

    public static <K, V> Map<K, V> lightMapOf(K[] kArr, V[] vArr) {
        Objects.requireNonNull(kArr);
        Objects.requireNonNull(vArr);
        int length = kArr.length;
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], ArrayUtils.getOrNull(vArr, 0));
        }
        ArrayMap arrayMap = new ArrayMap(length);
        for (int i = 0; i < length; i++) {
            arrayMap.put(ArrayUtils.getOrNull(kArr, i), ArrayUtils.getOrNull(vArr, i));
        }
        return arrayMap;
    }

    public static <K, V> Map<K, V> mutableMapOf(Map<K, V> map) {
        Objects.requireNonNull(map);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(map);
        return arrayMap;
    }
}
