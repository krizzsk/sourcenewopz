package com.didi.unifylogin.flutter.request;

import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FInterceptLogin$request$1", "Lcom/didi/unifylogin/listener/LoginListeners$InterceptorCallback;", "onFailed", "", "errno", "", "errmsg", "", "onSuccess", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FInterceptLogin.kt */
public final class FInterceptLogin$request$1 implements LoginListeners.InterceptorCallback {
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ FInterceptLogin this$0;

    FInterceptLogin$request$1(FInterceptLogin fInterceptLogin, JSONObject jSONObject) {
        this.this$0 = fInterceptLogin;
        this.$json = jSONObject;
    }

    public void onSuccess() {
        this.$json.put("intercepted", false);
        this.this$0.resultSuccess(this.$json.toString());
    }

    public void onFailed(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "errmsg");
        this.$json.put("intercepted", true);
        this.$json.put("errmsg", str);
        this.this$0.resultSuccess(this.$json.toString());
    }
}
