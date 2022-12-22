package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginModule extends BaseHybridModule {
    public static final String KEY_LNG = "key_lng";
    public static final String KEY_lAT = "key_lat";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_SUSIGN = "susig";
    public static final String PARAM_SUUID = "suuid";
    public static final String PARAM_TICKET = "ticket";
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UUID = "uuid";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f35999a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WebView f36000b;

    public LoginModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f35999a = hybridableContainer.getActivity();
        this.f36000b = hybridableContainer.getWebView();
    }

    @Deprecated
    @JsInterface({"callNativeLogin"})
    public void callNativeLogin(CallbackFunction callbackFunction) {
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                OneLoginFacade.getFunction().removeLoginListener(this);
                Intent intent = new Intent(LoginModule.this.f35999a, BaseWebActivity.class);
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.url = LoginModule.this.f36000b.getUrl();
                intent.putExtra("web_view_model", webViewModel);
                LoginModule.this.f35999a.startActivity(intent);
            }

            public void onCancel() {
                OneLoginFacade.getFunction().removeLoginListener(this);
            }
        });
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        Bundle bundle = new Bundle();
        if (didiLocation != null) {
            bundle.putString(KEY_lAT, String.valueOf(didiLocation.getLatitude()));
            bundle.putString(KEY_LNG, String.valueOf(didiLocation.getLongitude()));
        }
        OneLoginFacade.getAction().go2Login(this.f35999a);
        this.f35999a.finish();
        callbackFunction.onCallBack(new JSONObject());
    }

    @JsInterface({"requestLogin", "callNativeLoginWithCallback"})
    public void callNativeLoginWithCallback(final CallbackFunction callbackFunction) {
        Activity activity = this.f35999a;
        if (activity instanceof BaseWebActivity) {
            ((BaseWebActivity) activity).onHandleDialog(true);
        }
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                OneLoginFacade.getFunction().removeLoginListener(this);
                onFinish(true);
            }

            public void onCancel() {
                OneLoginFacade.getFunction().removeLoginListener(this);
                onFinish(false);
            }

            private void onFinish(boolean z) {
                if (LoginModule.this.f35999a instanceof BaseWebActivity) {
                    ((BaseWebActivity) LoginModule.this.f35999a).onHandleDialog(false);
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
                    jSONObject2.put("phone", loginInfo.getPhone());
                    jSONObject2.put("token", loginInfo.getToken());
                    jSONObject2.put("uuid", SecurityUtil.getUUID());
                    jSONObject2.put("suuid", SecurityUtil.getSUUID());
                    jSONObject2.put("susig", SecurityUtil.getSUSIGN());
                    jSONObject2.put("ticket", loginInfo.getKDToken());
                    if (z) {
                        jSONObject.put("login_result", 0);
                    } else {
                        jSONObject.put("login_result", 1);
                    }
                    jSONObject.put("userInfo", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackFunction.onCallBack(jSONObject);
            }
        });
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        Bundle bundle = new Bundle();
        if (didiLocation != null) {
            bundle.putString(KEY_lAT, String.valueOf(didiLocation.getLatitude()));
            bundle.putString(KEY_LNG, String.valueOf(didiLocation.getLongitude()));
        }
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                OneLoginFacade.getFunction().removeLoginListener(this);
            }

            public void onCancel() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("login_result", 2);
                    jSONObject.put("userInfo", "");
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException unused) {
                }
                if (LoginModule.this.f35999a instanceof BaseWebActivity) {
                    ((BaseWebActivity) LoginModule.this.f35999a).onHandleDialog(false);
                }
                OneLoginFacade.getFunction().removeLoginListener(this);
            }
        });
        OneLoginFacade.getAction().go2Login(this.f35999a);
    }
}
