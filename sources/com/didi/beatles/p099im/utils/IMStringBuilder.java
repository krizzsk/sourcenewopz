package com.didi.beatles.p099im.utils;

import java.lang.ref.SoftReference;

/* renamed from: com.didi.beatles.im.utils.IMStringBuilder */
public final class IMStringBuilder {

    /* renamed from: b */
    private static final int f9792b = 256;

    /* renamed from: c */
    private static final ThreadLocal<SoftReference<IMStringBuilder>> f9793c = new ThreadLocal<SoftReference<IMStringBuilder>>() {
        /* access modifiers changed from: protected */
        public SoftReference<IMStringBuilder> initialValue() {
            return new SoftReference<>(new IMStringBuilder());
        }
    };

    /* renamed from: a */
    private StringBuilder f9794a;

    private IMStringBuilder() {
        this.f9794a = new StringBuilder(256);
    }

    /* renamed from: of */
    public static IMStringBuilder m6646of() {
        IMStringBuilder iMStringBuilder;
        SoftReference softReference = f9793c.get();
        if (softReference != null && (iMStringBuilder = (IMStringBuilder) softReference.get()) != null) {
            return iMStringBuilder;
        }
        IMStringBuilder iMStringBuilder2 = new IMStringBuilder();
        SoftReference softReference2 = new SoftReference(iMStringBuilder2);
        f9793c.set(softReference2);
        if (softReference2.get() == null) {
            IMLog.m6632e("new BtsStringBuilder from softReference is null.", new Object[0]);
        }
        return iMStringBuilder2;
    }

    public IMStringBuilder append(String str) {
        this.f9794a.append(str);
        return this;
    }

    public IMStringBuilder append(Object obj) {
        this.f9794a.append(obj);
        return this;
    }

    public IMStringBuilder append(boolean z) {
        this.f9794a.append(z);
        return this;
    }

    public IMStringBuilder append(char c) {
        this.f9794a.append(c);
        return this;
    }

    public IMStringBuilder append(char[] cArr) {
        this.f9794a.append(cArr);
        return this;
    }

    public IMStringBuilder append(int i) {
        this.f9794a.append(i);
        return this;
    }

    public IMStringBuilder append(long j) {
        this.f9794a.append(j);
        return this;
    }

    public IMStringBuilder append(double d) {
        this.f9794a.append(d);
        return this;
    }

    public IMStringBuilder append(float f) {
        this.f9794a.append(f);
        return this;
    }

    public IMStringBuilder append(CharSequence charSequence) {
        this.f9794a.append(charSequence);
        return this;
    }

    public IMStringBuilder appendAll(Object... objArr) {
        if (objArr == null) {
            return this;
        }
        for (Object append : objArr) {
            this.f9794a.append(append);
        }
        return this;
    }

    public int length() {
        return this.f9794a.length();
    }

    public String toString() {
        String sb = this.f9794a.toString();
        m6645a();
        return sb;
    }

    /* renamed from: a */
    private void m6645a() {
        this.f9794a.setLength(0);
    }

    public void clear() {
        f9793c.remove();
    }
}
