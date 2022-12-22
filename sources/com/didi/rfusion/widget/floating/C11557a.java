package com.didi.rfusion.widget.floating;

import android.util.SparseArray;

/* renamed from: com.didi.rfusion.widget.floating.a */
/* compiled from: RFFloatingController */
class C11557a {

    /* renamed from: a */
    private SparseArray<C11558b> f33578a = new SparseArray<>();

    /* renamed from: b */
    private Integer f33579b;

    C11557a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87891a(int i) {
        this.f33579b = Integer.valueOf(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo87893b(int i) {
        if (!m23661e(i)) {
            this.f33578a.put(i, new C11558b(true));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo87894c(int i) {
        if (m23661e(i)) {
            this.f33578a.remove(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87892a(int i, boolean z) {
        C11558b f = m23662f(i);
        if (f != null) {
            f.f33580a = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo87895d(int i) {
        C11558b f = m23662f(i);
        if (f == null) {
            return false;
        }
        return f.f33580a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer mo87890a() {
        return this.f33579b;
    }

    /* renamed from: e */
    private boolean m23661e(int i) {
        return this.f33578a.indexOfKey(i) >= 0;
    }

    /* renamed from: f */
    private C11558b m23662f(int i) {
        return this.f33578a.get(i);
    }
}
