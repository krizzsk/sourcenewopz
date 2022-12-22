package com.didi.travel.psnger.core.model.request;

import com.didi.travel.psnger.common.net.base.BaseParams;
import java.util.Map;

public class OrderStatusParams extends BaseParams {

    /* renamed from: a */
    private String f44173a;

    /* renamed from: b */
    private int f44174b;

    /* renamed from: c */
    private int f44175c;

    /* renamed from: d */
    private int f44176d;

    /* access modifiers changed from: protected */
    public Map<String, Object> convertBean2Map() {
        return null;
    }

    public String getOid() {
        return this.f44173a;
    }

    public void setOid(String str) {
        this.f44173a = str;
    }

    public int getType() {
        return this.f44174b;
    }

    public void setType(int i) {
        this.f44174b = i;
    }

    public int getCurrentStatus() {
        return this.f44175c;
    }

    public void setCurrentStatus(int i) {
        this.f44175c = i;
    }

    public int getCurrentSubStatus() {
        return this.f44176d;
    }

    public void setCurrentSubStatus(int i) {
        this.f44176d = i;
    }
}
