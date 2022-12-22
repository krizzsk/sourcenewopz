package com.didi.wallet.dimina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.BridgeModule;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet_ui.WalletToast;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.wallet.dimina.rpc.FastPayCashierEnvStringBody;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@BridgeModule(name = "DiminaWalletModule")
public class DiminaWalletModule extends BaseServiceModule {
    public static CallbackFunction mCallbackFunction;

    public static void callbackFromH5(JSONObject jSONObject) {
        CallbackFunction callbackFunction;
        if (jSONObject == null || (callbackFunction = mCallbackFunction) == null) {
            mCallbackFunction = null;
            return;
        }
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
        mCallbackFunction = null;
    }

    public DiminaWalletModule(DMMina dMMina) {
        super(dMMina);
    }

    @JsInterface({"diminaScanCode"})
    public void diminaScanCode(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int optInt = jSONObject.optInt("showGuide");
        int optInt2 = jSONObject.optInt("isFromDa");
        Bundle bundle = new Bundle();
        bundle.putInt("showGuide", optInt);
        bundle.putInt("isFromDa", optInt2);
        UiThreadHandler.post(new Runnable(bundle, callbackFunction) {
            public final /* synthetic */ Bundle f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DiminaWalletModule.this.lambda$diminaScanCode$0$DiminaWalletModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$diminaScanCode$0$DiminaWalletModule(Bundle bundle, final CallbackFunction callbackFunction) {
        ((Request) DRouter.build("99pay://one/consume/scan").putExtras(bundle)).start(this.mDimina.getActivity(), new RouterCallback.ActivityCallback() {
            public void onActivityResult(int i, Intent intent) {
                String stringExtra;
                if (intent != null && (stringExtra = intent.getStringExtra("result")) != null && !TextUtils.isEmpty(stringExtra)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", stringExtra);
                    CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
                }
            }
        });
    }

    @JsInterface({"diminaGetAppInfo"})
    public void diminaGetAppInfo(JSONObject jSONObject, CallbackFunction callbackFunction) throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("appversion", SystemUtil.getVersionName(this.mDimina.getActivity()));
        String lang = WalletCommonParamsUtil.getLang(this.mDimina.getActivity());
        if (TextUtils.isEmpty(lang)) {
            lang = Locale.getDefault().getLanguage();
        }
        hashMap.put("lang", lang);
        hashMap.put("platform", "Android");
        CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, callbackFunction);
        getPrepayParamsForFastPay(jSONObject, callbackFunction);
    }

    @JsInterface({"diminaOpenUrl"})
    public void diminaOpenUrl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("linkUrl");
        if (!optString.isEmpty()) {
            DRouter.build(optString).start(this.mDimina.getActivity());
        }
        mCallbackFunction = callbackFunction;
    }

    @JsInterface({"openMobileBrowser"})
    public void toBrowser(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
        if (!optString.isEmpty()) {
            this.mDimina.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(optString)));
        }
    }

    @JsInterface({"toastUsingNative"})
    public void toastUsingNative(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("message");
        if (!optString.isEmpty() && !optString2.isEmpty()) {
            if (optString.equals("info")) {
                WalletToast.Companion.toastSuccess(this.mDimina.getActivity(), optString2);
            } else {
                WalletToast.Companion.toastFail(this.mDimina.getActivity(), optString2);
            }
        }
    }

    @JsInterface({"getPrepayParamsForFastpay"})
    public void getPrepayParamsForFastPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        try {
            FastPayCashierEnv cashierEnv = FastPayFacade.getInstance().cashierEnv();
            String str2 = "";
            if (cashierEnv != null) {
                String json = cashierEnv.getThird_party() != null ? new Gson().toJson((Object) cashierEnv.getThird_party()) : str2;
                if (cashierEnv.getThird_party_ability() != null) {
                    str2 = new Gson().toJson((Object) cashierEnv.getThird_party_ability());
                }
                str = str2;
                str2 = json;
            } else {
                str = str2;
            }
            CallBackUtil.onSuccess(new JSONObject(new Gson().toJson((Object) new FastPayCashierEnvStringBody(str2, str))), callbackFunction);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
