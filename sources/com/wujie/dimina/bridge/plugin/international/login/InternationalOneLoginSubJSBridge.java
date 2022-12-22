package com.wujie.dimina.bridge.plugin.international.login;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.unifylogin.api.ILoginActionApi;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/wujie/dimina/bridge/plugin/international/login/InternationalOneLoginSubJSBridge;", "Lcom/didi/dimina/container/messager/jsmodule/BaseServiceModule;", "mDMMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "dmLoginListener", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "mLoginDoingStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "mLoginStatusNotifyListener", "mLogoutDoingStatus", "mLogoutStatusNotifyListener", "Lcom/didi/unifylogin/listener/LoginListeners$LoginOutListener;", "passportCallbacks", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "doPassportLogin", "", "paras", "Lorg/json/JSONObject;", "callback", "execOnFail", "msg", "", "execOnSucc", "getUserInfo", "login", "logout", "onDestroy", "passportLogin", "bridge-international-login_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
@DMServiceSubBridgeModule(level = 0, preCreateInstance = true)
/* compiled from: InternationalOneLoginSubJSBridge.kt */
public final class InternationalOneLoginSubJSBridge extends BaseServiceModule {
    /* access modifiers changed from: private */
    public LoginListeners.LoginListener dmLoginListener;
    /* access modifiers changed from: private */
    public final DMMina mDMMina;
    /* access modifiers changed from: private */
    public final AtomicInteger mLoginDoingStatus = new AtomicInteger(0);
    private final LoginListeners.LoginListener mLoginStatusNotifyListener = new InternationalOneLoginSubJSBridge$mLoginStatusNotifyListener$1(this);
    /* access modifiers changed from: private */
    public final AtomicInteger mLogoutDoingStatus = new AtomicInteger(0);
    private final LoginListeners.LoginOutListener mLogoutStatusNotifyListener = new InternationalOneLoginSubJSBridge$mLogoutStatusNotifyListener$1(this);
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<CallbackFunction> passportCallbacks = new LinkedBlockingQueue<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternationalOneLoginSubJSBridge(DMMina dMMina) {
        super(dMMina);
        Intrinsics.checkParameterIsNotNull(dMMina, "mDMMina");
        this.mDMMina = dMMina;
        if (OneLoginFacade.getFunction() != null) {
            OneLoginFacade.getFunction().addLoginListener(this.mLoginStatusNotifyListener);
            OneLoginFacade.getFunction().addLoginOutListener(this.mLogoutStatusNotifyListener);
        }
        LogUtil.m13411i("OneLoginSubJSBridge init");
    }

    @JsInterface({"passportLogin"})
    public final void passportLogin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "paras");
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        doPassportLogin(jSONObject, callbackFunction);
    }

    @JsInterface({"login"})
    public final void login(JSONObject jSONObject, CallbackFunction callbackFunction) {
        execOnFail("登陆失败", callbackFunction);
    }

    private final void doPassportLogin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mLoginDoingStatus.getAndIncrement();
        if (OneLoginFacade.getStore() == null) {
            execOnFail("OneLogin未初始化", callbackFunction);
            this.mLoginDoingStatus.getAndDecrement();
            return;
        }
        synchronized (InternationalOneLoginSubJSBridge.class) {
            this.passportCallbacks.add(callbackFunction);
        }
        if (this.dmLoginListener == null) {
            this.dmLoginListener = new InternationalOneLoginSubJSBridge$doPassportLogin$2(this);
            OneLoginFacade.getFunction().addLoginListener(this.dmLoginListener);
            ILoginActionApi action = OneLoginFacade.getAction();
            FragmentActivity activity = this.mDMMina.getActivity();
            Intrinsics.checkExpressionValueIsNotNull(activity, "mDMMina.activity");
            action.go2Login(activity.getApplicationContext());
        }
    }

    @JsInterface({"logout"})
    public final void logout(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mLogoutDoingStatus.getAndIncrement();
        if (OneLoginFacade.getStore() == null) {
            execOnFail("OneLogin未初始化", callbackFunction);
            this.mLogoutDoingStatus.getAndDecrement();
            return;
        }
        try {
            OneLoginFacade.getAction().loginOut(this.mDMMina.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        execOnSucc(callbackFunction);
        this.mLogoutDoingStatus.getAndDecrement();
    }

    @JsInterface({"getUserInfo"})
    public final void getUserInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (OneLoginFacade.getStore() == null) {
            execOnFail("OneLogin未初始化", callbackFunction);
            return;
        }
        ILoginStoreApi store = OneLoginFacade.getStore();
        Intrinsics.checkExpressionValueIsNotNull(store, "OneLoginFacade.getStore()");
        if (store.isLoginNow()) {
            ILoginStoreApi store2 = OneLoginFacade.getStore();
            Intrinsics.checkExpressionValueIsNotNull(store2, "OneLoginFacade.getStore()");
            String token = store2.getToken();
            ILoginStoreApi store3 = OneLoginFacade.getStore();
            Intrinsics.checkExpressionValueIsNotNull(store3, "OneLoginFacade.getStore()");
            String uid = store3.getUid();
            ILoginStoreApi store4 = OneLoginFacade.getStore();
            Intrinsics.checkExpressionValueIsNotNull(store4, "OneLoginFacade.getStore()");
            String phone = store4.getPhone();
            Map hashMap = new HashMap();
            if (TextUtils.isEmpty(token)) {
                token = "";
            }
            Intrinsics.checkExpressionValueIsNotNull(token, "if (TextUtils.isEmpty(token)) \"\" else token");
            hashMap.put("token", token);
            if (TextUtils.isEmpty(uid)) {
                uid = "";
            }
            Intrinsics.checkExpressionValueIsNotNull(uid, "if (TextUtils.isEmpty(uid)) \"\" else uid");
            hashMap.put("uid", uid);
            if (TextUtils.isEmpty(phone)) {
                phone = "";
            }
            Intrinsics.checkExpressionValueIsNotNull(phone, "if (TextUtils.isEmpty(phone)) \"\" else phone");
            hashMap.put("phone", phone);
            CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "success", true);
        JSONUtil.put(jSONObject2, "data", (Object) new JSONObject());
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    public void onDestroy() {
        if (OneLoginFacade.getFunction() != null) {
            OneLoginFacade.getFunction().removeLoginListener(this.mLoginStatusNotifyListener);
            OneLoginFacade.getFunction().removeLoginOutListener(this.mLogoutStatusNotifyListener);
        }
    }

    public final void execOnFail(String str, CallbackFunction callbackFunction) {
        CallBackUtil.onFail((JSONObject) null, str, callbackFunction);
    }

    public final void execOnSucc(CallbackFunction callbackFunction) {
        CallBackUtil.onSuccess((JSONObject) null, callbackFunction);
    }
}
