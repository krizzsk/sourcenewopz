package com.wujie.dimina.bridge.plugin.international.login;

import android.app.Activity;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.raven.config.RavenKey;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/wujie/dimina/bridge/plugin/international/login/InternationalOneLoginSubJSBridge$doPassportLogin$2", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "s", "", "bridge-international-login_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: InternationalOneLoginSubJSBridge.kt */
public final class InternationalOneLoginSubJSBridge$doPassportLogin$2 implements LoginListeners.LoginListener {
    final /* synthetic */ InternationalOneLoginSubJSBridge this$0;

    InternationalOneLoginSubJSBridge$doPassportLogin$2(InternationalOneLoginSubJSBridge internationalOneLoginSubJSBridge) {
        this.this$0 = internationalOneLoginSubJSBridge;
    }

    public void onSuccess(Activity activity, String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, RavenKey.STACK);
        Map hashMap = new HashMap();
        ILoginStoreApi store = OneLoginFacade.getStore();
        Intrinsics.checkExpressionValueIsNotNull(store, "OneLoginFacade.getStore()");
        String token = store.getToken();
        Intrinsics.checkExpressionValueIsNotNull(token, "OneLoginFacade.getStore().token");
        hashMap.put("token", token);
        ILoginStoreApi store2 = OneLoginFacade.getStore();
        Intrinsics.checkExpressionValueIsNotNull(store2, "OneLoginFacade.getStore()");
        String uid = store2.getUid();
        Intrinsics.checkExpressionValueIsNotNull(uid, "OneLoginFacade.getStore().uid");
        hashMap.put("uid", uid);
        ILoginStoreApi store3 = OneLoginFacade.getStore();
        Intrinsics.checkExpressionValueIsNotNull(store3, "OneLoginFacade.getStore()");
        String phone = store3.getPhone();
        Intrinsics.checkExpressionValueIsNotNull(phone, "OneLoginFacade.getStore().phone");
        hashMap.put("phone", phone);
        synchronized (InternationalOneLoginSubJSBridge.class) {
            while (!this.this$0.passportCallbacks.isEmpty()) {
                CallbackFunction callbackFunction = (CallbackFunction) this.this$0.passportCallbacks.poll();
                if (callbackFunction != null) {
                    CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
                }
                this.this$0.mLoginDoingStatus.getAndDecrement();
            }
            Unit unit = Unit.INSTANCE;
        }
        KeyboardUtils.hideSoftInput(activity);
        OneLoginFacade.getFunction().removeLoginListener(this);
        this.this$0.dmLoginListener = null;
    }

    public void onCancel() {
        synchronized (InternationalOneLoginSubJSBridge.class) {
            while (!this.this$0.passportCallbacks.isEmpty()) {
                CallbackFunction callbackFunction = (CallbackFunction) this.this$0.passportCallbacks.poll();
                if (callbackFunction != null) {
                    this.this$0.execOnFail("用户取消登录", callbackFunction);
                }
                this.this$0.mLoginDoingStatus.getAndDecrement();
            }
            Unit unit = Unit.INSTANCE;
        }
        OneLoginFacade.getFunction().removeLoginListener(this);
        this.this$0.dmLoginListener = null;
    }
}
