package com.didi.global.fintech.cashier.core.interceptor;

import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005JG\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00150\u0014\"\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;", "Lcom/didi/global/fintech/cashier/core/interceptor/BaseInterceptor;", "Lcom/didi/global/fintech/cashier/core/interceptor/BaseRouterAdapter;", "uniqueId", "", "(Ljava/lang/String;)V", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getCashierParam", "()Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "setCashierParam", "(Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "getUniqueId", "()Ljava/lang/String;", "intercept", "", "context", "Landroid/content/Context;", "data", "interceptCallback", "", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/core/interceptor/BaseRouterAdapter;[Lkotlin/jvm/functions/Function0;)V", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RouterOpenInterceptor.kt */
public final class RouterOpenInterceptor implements BaseInterceptor<BaseRouterAdapter<?>> {

    /* renamed from: a */
    private final String f21434a;

    /* renamed from: b */
    private CashierParam f21435b;

    public RouterOpenInterceptor() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public RouterOpenInterceptor(String str) {
        this.f21434a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RouterOpenInterceptor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getUniqueId() {
        return this.f21434a;
    }

    public final CashierParam getCashierParam() {
        return this.f21435b;
    }

    public final void setCashierParam(CashierParam cashierParam) {
        this.f21435b = cashierParam;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void intercept(android.content.Context r7, com.didi.global.fintech.cashier.core.interceptor.BaseRouterAdapter<?> r8, kotlin.jvm.functions.Function0<kotlin.Unit>... r9) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "interceptCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r6
            com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor r0 = (com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor) r0
            r0 = 0
            r1 = 1
            if (r8 != 0) goto L_0x0012
            goto L_0x0019
        L_0x0012:
            boolean r2 = r8.open()
            if (r2 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2 = 0
            if (r0 == 0) goto L_0x001e
            r0 = r6
            goto L_0x001f
        L_0x001e:
            r0 = r2
        L_0x001f:
            com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor r0 = (com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor) r0
            if (r0 != 0) goto L_0x0024
            goto L_0x0076
        L_0x0024:
            if (r8 != 0) goto L_0x0028
            r3 = r2
            goto L_0x002c
        L_0x0028:
            java.lang.String r3 = r8.getRouter()
        L_0x002c:
            com.didi.drouter.router.Request r3 = com.didi.drouter.api.DRouter.build((java.lang.String) r3)
            java.lang.String r4 = r0.getUniqueId()
            java.lang.String r5 = "args_unique_id"
            java.lang.Object r3 = r3.putExtra((java.lang.String) r5, (java.lang.String) r4)
            com.didi.drouter.router.Request r3 = (com.didi.drouter.router.Request) r3
            com.didi.global.fintech.cashier.user.model.CashierParam r4 = r0.getCashierParam()
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r5 = "args_param"
            java.lang.Object r3 = r3.putExtra((java.lang.String) r5, (java.io.Serializable) r4)
            com.didi.drouter.router.Request r3 = (com.didi.drouter.router.Request) r3
            if (r8 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            java.lang.String r4 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r8.assemble(r3)
        L_0x0056:
            if (r8 != 0) goto L_0x0059
            goto L_0x0061
        L_0x0059:
            int r8 = r8.requestCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
        L_0x0061:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r8 = "DRouter_start_activity_request_code"
            java.lang.Object r8 = r3.putExtra((java.lang.String) r8, (java.io.Serializable) r2)
            com.didi.drouter.router.Request r8 = (com.didi.drouter.router.Request) r8
            com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor$intercept$2$1 r2 = new com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor$intercept$2$1
            r2.<init>(r9)
            com.didi.drouter.router.RouterCallback r2 = (com.didi.drouter.router.RouterCallback) r2
            r8.start(r7, r2)
            r2 = r0
        L_0x0076:
            if (r2 != 0) goto L_0x0080
            r7 = r9[r1]
            if (r7 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r7.invoke()
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor.intercept(android.content.Context, com.didi.global.fintech.cashier.core.interceptor.BaseRouterAdapter, kotlin.jvm.functions.Function0[]):void");
    }
}
