package com.adyen.checkout.core.util;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/adyen/checkout/core/util/KotlinBase;", "", "()V", "tag", "", "log", "", "checkout-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KotlinBase.kt */
public final class KotlinBase {
    public static final KotlinBase INSTANCE = new KotlinBase();

    /* renamed from: a */
    private static final String f946a;

    private KotlinBase() {
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f946a = tag;
    }

    @JvmStatic
    public static final void log() {
        Logger.m1082v(f946a, "Running Kotlin");
    }
}
