package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.util.LogcatUtil;
import java.util.Iterator;
import java.util.LinkedList;

public class LimitUpdateList<T> {
    int limit;
    LinkedList<T> maps = new LinkedList<>();

    public LimitUpdateList(int i) {
        this.limit = i;
    }

    /* access modifiers changed from: package-private */
    public void putParams(T t) {
        int size = this.maps.size();
        int i = this.limit;
        if (size >= i) {
            this.maps.remove(i - 1);
        }
        Object params = getParams(t);
        if (params != null) {
            this.maps.remove(params);
        }
        this.maps.add(0, t);
    }

    /* access modifiers changed from: package-private */
    public void removeParams(T t) {
        this.maps.remove(t);
    }

    /* access modifiers changed from: package-private */
    public T getParams(T t) {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.maps.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (equals(next, t)) {
                LogcatUtil.m35795e(NetworkCache.TAG, "getParams耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean equals(T t, T t2) {
        return t2.equals(t);
    }
}
