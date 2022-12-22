package com.didi.sdk.global.indexbar.data;

@Deprecated
public abstract class BaseGroup {

    /* renamed from: a */
    private String f36179a;

    /* access modifiers changed from: protected */
    public abstract void generateGroup();

    public String getGroup() {
        if (this.f36179a == null) {
            generateGroup();
        }
        return this.f36179a;
    }

    public void setGroup(String str) {
        this.f36179a = str;
    }
}
