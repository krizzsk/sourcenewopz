package com.didi.global.fintech.cashier.core.interceptor;

import android.content.Intent;
import com.didi.drouter.router.RouterCallback;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/interceptor/PrivacyPolicyInterceptor$intercept$2$1", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrivacyPolicyInterceptor.kt */
public final class PrivacyPolicyInterceptor$intercept$2$1 extends RouterCallback.ActivityCallback {
    final /* synthetic */ Function0<Unit>[] $interceptCallback;

    PrivacyPolicyInterceptor$intercept$2$1(Function0<Unit>[] function0Arr) {
        this.$interceptCallback = function0Arr;
    }

    public void onActivityResult(int i, Intent intent) {
        Function0<Unit> function0;
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onActivityResult: ", Integer.valueOf(i)), (Throwable) null, "com.didi.global.fintech.cashier.core.interceptor.PrivacyPolicyInterceptor$intercept$2$1", 42);
        PrivacyPolicyInterceptor$intercept$2$1 privacyPolicyInterceptor$intercept$2$1 = this;
        PrivacyPolicyInterceptor$intercept$2$1 privacyPolicyInterceptor$intercept$2$12 = null;
        PrivacyPolicyInterceptor$intercept$2$1 privacyPolicyInterceptor$intercept$2$13 = i == -1 ? this : null;
        if (privacyPolicyInterceptor$intercept$2$13 != null) {
            Function0<Unit> function02 = this.$interceptCallback[1];
            if (function02 != null) {
                function02.invoke();
            }
            privacyPolicyInterceptor$intercept$2$12 = privacyPolicyInterceptor$intercept$2$13;
        }
        if (privacyPolicyInterceptor$intercept$2$12 == null && (function0 = this.$interceptCallback[0]) != null) {
            function0.invoke();
        }
    }
}
