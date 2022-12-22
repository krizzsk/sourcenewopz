package com.dmap.navigation.simple;

import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.location.IOrderPassPoint;

public class SimpleOrderPassPoint implements IOrderPassPoint {

    /* renamed from: a */
    private final INaviPoi f52037a;

    /* renamed from: b */
    private final long f52038b;

    /* renamed from: c */
    private final int f52039c;

    /* renamed from: d */
    private final int f52040d;

    public SimpleOrderPassPoint(INaviPoi iNaviPoi, long j, int i, int i2) {
        this.f52037a = iNaviPoi;
        this.f52038b = j;
        this.f52039c = i;
        this.f52040d = i2;
    }

    public String toString() {
        return "SimpleOrderPassPoint{poi=" + this.f52037a + ", orderId=" + this.f52038b + ", orderType=" + this.f52039c + ", pointType=" + this.f52040d + '}';
    }

    public INaviPoi getPoi() {
        return this.f52037a;
    }

    public long getOrderId() {
        return this.f52038b;
    }

    public int getOrderType() {
        return this.f52039c;
    }

    public int getPointType() {
        return this.f52040d;
    }
}
