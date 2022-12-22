package com.didi.map.sdk.nav.inertia;

public class SctxStateInfo {

    /* renamed from: a */
    private SctxStateEnum f28468a;

    /* renamed from: b */
    private boolean f28469b = false;

    public SctxStateEnum getState() {
        return this.f28468a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77866a(SctxStateEnum sctxStateEnum) {
        this.f28468a = sctxStateEnum;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77867a(boolean z) {
        this.f28469b = z;
    }

    public boolean isExceptionState() {
        return this.f28469b;
    }

    public String toString() {
        return "SctxStateInfo{state=" + this.f28468a + ", isExceptionState=" + this.f28469b + '}';
    }
}
