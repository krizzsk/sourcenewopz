package com.adyen.checkout.redirect;

import android.content.pm.ResolveInfo;

final class ResolveResult {

    /* renamed from: a */
    private final Type f959a;

    /* renamed from: b */
    private final ResolveInfo f960b;

    public enum Type {
        RESOLVER_ACTIVITY,
        DEFAULT_BROWSER,
        APPLICATION,
        UNKNOWN
    }

    ResolveResult(Type type, ResolveInfo resolveInfo) {
        this.f959a = type;
        this.f960b = resolveInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Type mo14745a() {
        return this.f959a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ResolveInfo mo14746b() {
        return this.f960b;
    }
}
