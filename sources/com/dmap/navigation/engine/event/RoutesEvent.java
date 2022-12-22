package com.dmap.navigation.engine.event;

import com.dmap.navigation.jni.swig.LongList;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RoutesEvent extends NaviEvent {

    /* renamed from: a */
    private final List<BigInteger> f51953a;

    /* renamed from: b */
    private final BigInteger f51954b;

    /* renamed from: c */
    private final int f51955c;

    /* renamed from: d */
    private String f51956d;

    /* renamed from: e */
    private int f51957e = -1;

    public RoutesEvent(LongList longList, BigInteger bigInteger, int i) {
        this.f51955c = i;
        this.f51954b = bigInteger;
        int size = (int) longList.size();
        if (size > 0) {
            this.f51953a = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f51953a.add(longList.get(i2));
            }
            return;
        }
        this.f51953a = null;
    }

    public String toString() {
        return "RoutesEvent{allRouteIds=" + this.f51953a + ", currentRouteId=" + this.f51954b + ", reason=" + this.f51955c + '}';
    }

    public List<BigInteger> getAllRouteIds() {
        return this.f51953a;
    }

    public int getReason() {
        return this.f51955c;
    }

    public BigInteger getCurrentRouteId() {
        return this.f51954b;
    }

    public String getText() {
        return this.f51956d;
    }

    public void setText(String str) {
        this.f51956d = str;
    }

    public int getType() {
        return this.f51957e;
    }

    public void setType(int i) {
        this.f51957e = i;
    }
}
