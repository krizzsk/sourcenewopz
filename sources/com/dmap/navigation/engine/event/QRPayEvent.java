package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class QRPayEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51951a;

    /* renamed from: b */
    private final BigInteger f51952b;

    public QRPayEvent(int i, BigInteger bigInteger) {
        this.f51951a = i;
        this.f51952b = bigInteger;
    }

    public String toString() {
        return "QRPayEvent{updateType=" + this.f51951a + ", linkId=" + this.f51952b + '}';
    }

    public int getUpdateType() {
        return this.f51951a;
    }

    public BigInteger getLinkId() {
        return this.f51952b;
    }
}
