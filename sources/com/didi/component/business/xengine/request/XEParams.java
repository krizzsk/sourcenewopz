package com.didi.component.business.xengine.request;

public class XEParams {

    /* renamed from: a */
    private static volatile XEParams f11413a;

    /* renamed from: b */
    private int f11414b = 0;

    /* renamed from: c */
    private int f11415c = 0;

    private XEParams() {
    }

    public static XEParams getInstance() {
        if (f11413a == null) {
            synchronized (XEParams.class) {
                if (f11413a == null) {
                    f11413a = new XEParams();
                }
            }
        }
        return f11413a;
    }

    public int getLastOrderSubStatus() {
        return this.f11415c;
    }

    public void setLastOrderSubStatus(int i) {
        this.f11415c = i;
    }

    public int getLastOrderStatus() {
        return this.f11414b;
    }

    public void setLastOrderStatus(int i) {
        this.f11414b = i;
    }
}
