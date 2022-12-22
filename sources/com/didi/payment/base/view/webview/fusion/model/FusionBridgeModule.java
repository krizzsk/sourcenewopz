package com.didi.payment.base.view.webview.fusion.model;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.CacheSharedPreferences;
import com.didi.sdk.util.SystemUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FusionBridgeModule extends BaseHybridModule {
    public static final String EXPROTNAME = "DidiBridgeAdapter";
    public static final String PARAM_APP_KEY = "appKey";
    public static final String PARAM_APP_VERSION = "appversion";
    public static final String PARAM_CARRIER = "carrier";
    public static final String PARAM_DEVICE_ID = "dviceid";
    public static final String PARAM_DEVICE_ID_NEW = "deviceid";
    public static final String PARAM_IMEI = "imei";
    public static final String PARAM_MODEL = "model";
    public static final String PARAM_NET_TYPE = "net_type";
    public static final String PARAM_OS = "os";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_SUSIGN = "susig";
    public static final String PARAM_SUUID = "suuid";
    public static final String PARAM_TICKET = "ticket";
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UUID = "uuid";
    public static final String PARAM_VCODE = "vcode";
    public static final String P_AREA = "area";
    public static final String P_CITY_ID = "city_id";
    public static final String P_LAT = "lat";
    public static final String P_LNG = "lng";
    public static final String UI_TARGET_HIDDEN_BACK = "hidden_back";
    public static final String UI_TARGET_WEB_TITLE = "web_title";
    private Map<String, Function> handlerMap = new HashMap();
    protected Activity mContext;
    protected FusionWebView mFusionWebView;
    protected WebViewJavascriptBridge mJavascriptBridge;

    @JsInterface({"launchNav"})
    public void launchNav(Object obj, CallbackFunction callbackFunction) {
    }

    @JsInterface({"showProgressHUD"})
    public void showProgressHUD(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    public static abstract class Function {
        private CallbackFunction jsCallback;

        public abstract JSONObject execute(JSONObject jSONObject);

        public void setJsCallback(CallbackFunction callbackFunction) {
            this.jsCallback = callbackFunction;
        }

        public CallbackFunction getJsCallback() {
            return this.jsCallback;
        }
    }

    public FusionBridgeModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mFusionWebView = hybridableContainer.getWebView();
        this.mContext = hybridableContainer.getActivity();
        this.mJavascriptBridge = hybridableContainer.getWebView().getJavascriptBridge();
    }

    public void addFunction(String str, Function function) {
        this.handlerMap.put(str, function);
    }

    public Function getFunction(String str) {
        return this.handlerMap.get(str);
    }

    public void callH5Method(String str, String str2) {
        String str3;
        if (str2 == null) {
            str3 = "javascript:" + str + "()";
        } else {
            str3 = "javascript:" + str + "(" + str2 + ")";
        }
        this.mJavascriptBridge.executeCallJS(str3);
    }

    @JsInterface({"callHandler"})
    public Object callHandler(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        Function function = getFunction(str);
        if (function != null) {
            function.setJsCallback(callbackFunction);
            JSONObject execute = function.execute(jSONObject);
            if (execute == null) {
                return execute;
            }
            callbackFunction.onCallBack(execute);
            return execute;
        }
        Method tryFindEqualMethod = tryFindEqualMethod(str);
        if (tryFindEqualMethod != null) {
            try {
                return tryFindEqualMethod.invoke(this, new Object[]{jSONObject, callbackFunction});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Method tryFindEqualMethod(String str) {
        return this.mJavascriptBridge.getExportModule("DidiBridgeAdapter").getTargetMethod(str);
    }

    @JsInterface({"getSystemInfo"})
    public void getSystemInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appversion", SystemUtil.getVersionName(this.mContext));
            jSONObject2.put("vcode", SystemUtil.getVersionCode() + "");
            jSONObject2.put("dviceid", SecurityUtil.getDeviceId());
            jSONObject2.put("deviceid", SecurityUtil.getDeviceId());
            jSONObject2.put("model", SystemUtil.getModel());
            jSONObject2.put("os", Build.VERSION.RELEASE);
            jSONObject2.put("imei", SystemUtil.getIMEI());
            jSONObject2.put("appKey", "taxiPassengerAndroid");
            jSONObject2.put("net_type", SystemUtil.getNetworkType());
            jSONObject2.put("carrier", SystemUtil.getServiceProvider(this.mContext));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"getUserInfo"})
    public JSONObject getUserInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("phone", PayBaseParamUtil.getStringParam(this.mContext, "phone"));
            jSONObject2.put("token", PayBaseParamUtil.getStringParam(this.mContext, "token"));
            jSONObject2.put("uuid", SecurityUtil.getUUID());
            jSONObject2.put("suuid", SecurityUtil.getSUUID());
            jSONObject2.put("susig", SecurityUtil.getSUSIGN());
            jSONObject2.put("ticket", PayBaseParamUtil.getStringParam(this.mContext, "token"));
            jSONObject2.put("uid", PayBaseParamUtil.getStringParam(this.mContext, "uid"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
        return jSONObject2;
    }

    @JsInterface({"setTitle", "updateNaviTitle"})
    public void setUpdateWebTitle(Object obj, CallbackFunction callbackFunction) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String optString = jSONObject.optString("title");
            str = TextUtils.isEmpty(optString) ? jSONObject.optString("navi_title") : optString;
        } else {
            str = "";
        }
        UpdateUIHandler updateUIHandler = this.mHybridContainer.getUpdateUIHandler();
        if (updateUIHandler != null) {
            updateUIHandler.updateUI("web_title", str);
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @com.didi.onehybrid.jsbridge.JsInterface({"openPage"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openPage(org.json.JSONObject r8, com.didi.onehybrid.jsbridge.CallbackFunction r9) {
        /*
            r7 = this;
            java.lang.String r0 = "target"
            java.lang.String r1 = ""
            java.lang.String r0 = r8.optString(r0, r1)
            java.lang.String r2 = "url"
            java.lang.String r1 = r8.optString(r2, r1)
            int r2 = r0.hashCode()
            r3 = -1052618729(0xffffffffc1425017, float:-12.144553)
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == r3) goto L_0x0039
            r3 = 3526476(0x35cf4c, float:4.941645E-39)
            if (r2 == r3) goto L_0x002f
            r3 = 106006350(0x651874e, float:3.9407937E-35)
            if (r2 == r3) goto L_0x0025
            goto L_0x0043
        L_0x0025:
            java.lang.String r2 = "order"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0043
            r0 = 2
            goto L_0x0044
        L_0x002f:
            java.lang.String r2 = "self"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0043
            r0 = 0
            goto L_0x0044
        L_0x0039:
            java.lang.String r2 = "native"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = -1
        L_0x0044:
            if (r0 == 0) goto L_0x0082
            if (r0 == r6) goto L_0x0069
            if (r0 == r5) goto L_0x0087
            java.lang.String r0 = "title"
            java.lang.String r8 = r8.optString(r0)
            android.content.Intent r0 = new android.content.Intent
            android.app.Activity r2 = r7.mContext
            java.lang.Class<com.didi.payment.base.view.webview.PayBaseWebActivity> r3 = com.didi.payment.base.view.webview.PayBaseWebActivity.class
            r0.<init>(r2, r3)
            com.didi.payment.base.view.webview.WebModel r2 = new com.didi.payment.base.view.webview.WebModel
            r2.<init>((java.lang.String) r1, (java.lang.String) r8)
            java.lang.String r8 = "WEB_MODEL"
            r0.putExtra(r8, r2)
            android.app.Activity r8 = r7.mContext
            r8.startActivity(r0)
            goto L_0x0087
        L_0x0069:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r8.<init>(r0)
            java.lang.String r0 = "android.intent.category.BROWSABLE"
            r8.addCategory(r0)
            android.net.Uri r0 = android.net.Uri.parse(r1)
            r8.setData(r0)
            android.app.Activity r0 = r7.mContext
            r0.startActivity(r8)
            goto L_0x0087
        L_0x0082:
            com.didi.onehybrid.container.FusionWebView r8 = r7.mFusionWebView
            r8.loadUrl(r1)
        L_0x0087:
            if (r9 == 0) goto L_0x0095
            java.lang.Object[] r8 = new java.lang.Object[r6]
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r8[r4] = r0
            r9.onCallBack(r8)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule.openPage(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    @JsInterface({"closePage", "web_page_close", "page_close"})
    public void closeContainerActivity(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mContext.finish();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"refreshPage", "page_refresh"})
    public void refreshPage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FusionWebView fusionWebView = this.mFusionWebView;
        if (fusionWebView != null) {
            fusionWebView.reload();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"hideProgressHUD"})
    public void hideProgressHUD(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mFusionWebView.hiddenLoadProgress();
        callbackFunction.onCallBack(new JSONObject());
    }

    @JsInterface({"openNativeWebPage"})
    public void openNativeWebPage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("title");
            Intent intent = new Intent(this.mContext, PayBaseWebActivity.class);
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, new WebModel(optString2, optString));
            this.mContext.startActivity(intent);
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"setH5Cache"})
    public void setH5Cache(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            try {
                CacheSharedPreferences.getInstance().setNativeCache(jSONObject.getString("key"), jSONObject.getString("value"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"getH5Cache"})
    public void getH5Cache(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("datas", CacheSharedPreferences.getInstance().getNativeCache(jSONObject.getString("key")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        callbackFunction.onCallBack(jSONObject2);
    }

    @JsInterface({"clearCache"})
    public void clearCache(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CookieSyncManager.createInstance(this.mContext);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
        this.mFusionWebView.clearCache(true);
        this.mContext.deleteDatabase("WebView.db");
        this.mContext.deleteDatabase("WebViewCache.db");
        this.mFusionWebView.loadUrl("javascript:window.localStorage.clear()");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("clear_result", "0");
        } catch (JSONException unused) {
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"isAlipay"})
    public void isAliPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        PackageManager packageManager = this.mContext.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("alipays://"));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        boolean z = queryIntentActivities != null && queryIntentActivities.size() > 0;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("msg", z ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SystemUtils.log(3, "FusionBridge", "isAliPay jo = " + jSONObject2.toString(), (Throwable) null, "com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule", 399);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    private <T> T loadExportModule(Class<T> cls) {
        return this.mFusionWebView.getExportModuleInstance(cls);
    }
}
