package com.didi.global.fintech.cashier.core.interceptor;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JA\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\"\u0010\b\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n0\t\"\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/BaseInterceptor;", "T", "", "intercept", "", "context", "Landroid/content/Context;", "data", "interceptCallback", "", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Object;[Lkotlin/jvm/functions/Function0;)V", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseInterceptor.kt */
public interface BaseInterceptor<T> {
    void intercept(Context context, T t, Function0<Unit>... function0Arr);
}
