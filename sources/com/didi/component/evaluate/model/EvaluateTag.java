package com.didi.component.evaluate.model;

public class EvaluateTag {

    /* renamed from: a */
    private String f13308a;

    /* renamed from: b */
    private long f13309b;

    /* renamed from: c */
    private String f13310c;

    public EvaluateTag(String str) {
        this.f13308a = str;
    }

    public EvaluateTag(String str, long j, String str2) {
        this.f13308a = str;
        this.f13309b = j;
        this.f13310c = str2;
    }

    public String getText() {
        return this.f13308a;
    }

    public long getId() {
        return this.f13309b;
    }

    public String getIcon() {
        return this.f13310c;
    }
}
