package com.airbnb.lottie;

import java.util.Arrays;

public final class LottieResult<V> {

    /* renamed from: a */
    private final V f1167a;

    /* renamed from: b */
    private final Throwable f1168b;

    public LottieResult(V v) {
        this.f1167a = v;
        this.f1168b = null;
    }

    public LottieResult(Throwable th) {
        this.f1168b = th;
        this.f1167a = null;
    }

    public V getValue() {
        return this.f1167a;
    }

    public Throwable getException() {
        return this.f1168b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (getValue() != null && getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (getException() == null || lottieResult.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
