package com.didi.reactive.tracker;

public class AssertResult {

    /* renamed from: OK */
    public static AssertResult f33125OK = new AssertResult(true, (String) null);

    /* renamed from: a */
    private boolean f33126a;

    /* renamed from: b */
    private String f33127b;

    public AssertResult(boolean z, String str) {
        this.f33126a = z;
        this.f33127b = str;
    }

    public boolean isPass() {
        return this.f33126a;
    }

    public String getMessage() {
        return this.f33127b;
    }
}
