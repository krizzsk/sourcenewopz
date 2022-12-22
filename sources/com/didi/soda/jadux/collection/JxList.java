package com.didi.soda.jadux.collection;

import com.didi.soda.jadux.function.JxFunction0;
import java.util.List;
import p242io.reactivex.functions.BiFunction;

public interface JxList<T> extends List<T> {
    JxList<T> copy();

    JxList<T> filter(JxFunction0<T, Boolean> jxFunction0);

    JxList<T> forEach(JxFunction0<T, T> jxFunction0);

    <R> JxList<R> map(JxFunction0<T, R> jxFunction0);

    T reduce(BiFunction<T, T, T> biFunction) throws Exception;
}
