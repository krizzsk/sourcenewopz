package com.didiglobal.travel.util;

import androidx.core.util.Supplier;
import java.util.Objects;

public class ArrayUtils {
    public static <E> E getOrNull(E[] eArr, int i) {
        if (!isNullOrEmpty(eArr) && i >= 0 && i < ((Object[]) Objects.requireNonNull(eArr)).length) {
            return eArr[i];
        }
        return null;
    }

    public static <E> E getOrDefault(E[] eArr, int i, Supplier<E> supplier) {
        E orNull = getOrNull(eArr, i);
        return Preconditions.nonNull(orNull) ? orNull : ((Supplier) Objects.requireNonNull(supplier)).get();
    }

    public static <E> boolean isNullOrEmpty(E[] eArr) {
        return Preconditions.isNull(eArr) || eArr.length == 0;
    }
}
