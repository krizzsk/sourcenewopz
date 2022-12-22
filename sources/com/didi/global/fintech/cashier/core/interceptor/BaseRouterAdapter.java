package com.didi.global.fintech.cashier.core.interceptor;

import com.didi.drouter.router.Request;
import com.didi.soda.blocks.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/BaseRouterAdapter;", "T", "", "data", "router", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getRouter", "()Ljava/lang/String;", "assemble", "Lcom/didi/drouter/router/Request;", "src", "open", "", "requestCode", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RouterOpenInterceptor.kt */
public abstract class BaseRouterAdapter<T> {

    /* renamed from: a */
    private final T f21427a;

    /* renamed from: b */
    private final String f21428b;

    public Request assemble(Request request) {
        Intrinsics.checkNotNullParameter(request, Const.BlockParamConst.SRC);
        return request;
    }

    public abstract boolean open();

    public int requestCode() {
        return 10086;
    }

    public BaseRouterAdapter(T t, String str) {
        Intrinsics.checkNotNullParameter(str, "router");
        this.f21427a = t;
        this.f21428b = str;
    }

    public final T getData() {
        return this.f21427a;
    }

    public final String getRouter() {
        return this.f21428b;
    }
}
