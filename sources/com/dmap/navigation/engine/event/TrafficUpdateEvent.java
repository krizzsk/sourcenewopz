package com.dmap.navigation.engine.event;

import java.math.BigInteger;
import java.util.ArrayList;

public class TrafficUpdateEvent extends NaviEvent {

    /* renamed from: a */
    private final BigInteger f51971a;

    /* renamed from: b */
    private final ArrayList<Integer> f51972b;

    public TrafficUpdateEvent(BigInteger bigInteger, ArrayList<Integer> arrayList) {
        this.f51971a = bigInteger;
        this.f51972b = arrayList;
    }

    public ArrayList<Integer> getTrafficIndex() {
        return this.f51972b;
    }

    public BigInteger getRouteId() {
        return this.f51971a;
    }
}
