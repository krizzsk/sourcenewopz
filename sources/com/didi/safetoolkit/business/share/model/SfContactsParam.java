package com.didi.safetoolkit.business.share.model;

import com.didi.safetoolkit.model.ISfBaseObject;

public class SfContactsParam implements ISfBaseObject {

    /* renamed from: a */
    private String f34442a;

    /* renamed from: b */
    private int f34443b;

    /* renamed from: c */
    private int f34444c = Integer.MAX_VALUE;

    public SfContactsParam setOrderId(String str) {
        this.f34442a = str;
        return this;
    }

    public SfContactsParam setTarget(int i) {
        this.f34443b = i;
        return this;
    }

    public SfContactsParam setThreshold(int i) {
        this.f34444c = i;
        return this;
    }

    public String getOrderId() {
        return this.f34442a;
    }

    public int getTarget() {
        return this.f34443b;
    }

    public int getThreshold() {
        return this.f34444c;
    }
}
