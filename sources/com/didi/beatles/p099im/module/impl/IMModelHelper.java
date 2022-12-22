package com.didi.beatles.p099im.module.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.didi.beatles.im.module.impl.IMModelHelper */
public class IMModelHelper {

    /* renamed from: com.didi.beatles.im.module.impl.IMModelHelper$ClassifyValue */
    public interface ClassifyValue<K, V> {
        K getKey(V v);
    }

    /* renamed from: com.didi.beatles.im.module.impl.IMModelHelper$FilterValue */
    public interface FilterValue<T> {
        boolean isFilter(T t);
    }

    /* renamed from: com.didi.beatles.im.module.impl.IMModelHelper$WrapperValue */
    public interface WrapperValue<V, N> {
        N wrapper(V v);
    }

    public static <K, V> Map<K, Collection<V>> classifyCollection(Collection<V> collection, ClassifyValue<K, V> classifyValue) {
        HashMap hashMap = new HashMap();
        if (!(collection == null || collection.size() == 0 || classifyValue == null)) {
            for (V next : collection) {
                K key = classifyValue.getKey(next);
                Collection collection2 = (Collection) hashMap.get(key);
                if (collection2 == null) {
                    collection2 = new LinkedList();
                    hashMap.put(key, collection2);
                }
                collection2.add(next);
            }
        }
        return hashMap;
    }

    public static <T> Collection<T> filterCollection(Collection<T> collection, FilterValue<T> filterValue) {
        LinkedList linkedList = new LinkedList();
        if (!(collection == null || collection.size() == 0 || filterValue == null)) {
            for (T next : collection) {
                if (filterValue.isFilter(next)) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    public static <V, N> Collection<N> wrapperCollection(Collection<V> collection, WrapperValue<V, N> wrapperValue) {
        LinkedList linkedList = new LinkedList();
        if (!(collection == null || collection.size() == 0 || wrapperValue == null)) {
            for (V wrapper : collection) {
                linkedList.add(wrapperValue.wrapper(wrapper));
            }
        }
        return linkedList;
    }

    public static <V, N> Map<V, N> wrapperCollectionMap(Collection<V> collection, WrapperValue<V, N> wrapperValue) {
        HashMap hashMap = new HashMap();
        if (!(collection == null || collection.size() == 0 || wrapperValue == null)) {
            for (V next : collection) {
                hashMap.put(next, wrapperValue.wrapper(next));
            }
        }
        return hashMap;
    }
}
