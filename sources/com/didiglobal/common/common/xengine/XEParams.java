package com.didiglobal.common.common.xengine;

public class XEParams {

    /* renamed from: a */
    private static volatile XEParams f49741a;

    /* renamed from: b */
    private int f49742b = 0;

    /* renamed from: c */
    private int f49743c = 0;

    private XEParams() {
    }

    public static XEParams getInstance() {
        if (f49741a == null) {
            synchronized (XEParams.class) {
                if (f49741a == null) {
                    f49741a = new XEParams();
                }
            }
        }
        return f49741a;
    }

    public int getLastOrderSubStatus() {
        return this.f49743c;
    }

    public void setLastOrderSubStatus(int i) {
        this.f49743c = i;
    }

    public int getLastOrderStatus() {
        return this.f49742b;
    }

    public void setLastOrderStatus(int i) {
        this.f49742b = i;
    }
}
