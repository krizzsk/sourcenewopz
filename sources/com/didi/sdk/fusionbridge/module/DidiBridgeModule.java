package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.didi.app.delegate.BffInitManager;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.ChooseImageReq;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.log.Logger;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.CacheSharedPreferences;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.sdk.webview.image.ImageCallback;
import com.didi.sdk.webview.image.ImageHelper;
import com.didi.sdk.webview.image.ImageUploadCallback;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.facebook.internal.AnalyticsEvents;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class DidiBridgeModule extends BaseHybridModule {
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
    public static final String UI_TARGET_WEB_TITLE = "web_title";

    /* renamed from: a */
    private ImageHelper f35984a;
    protected Activity mContext;
    protected FusionWebView mFusionWebView;
    protected WebViewJavascriptBridge mJavascriptBridge;

    @JsInterface({"commonAuthorize"})
    public void commonAuthorize(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"commonPay"})
    public void commonPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"launchNav"})
    public void launchNav(Object obj, CallbackFunction callbackFunction) {
    }

    @JsInterface({"openUniPay"})
    public void openUniPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"payByAli"})
    public void payByAli(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"payByWX"})
    public void payByWX(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"onePay"})
    public void payByonePay(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    @JsInterface({"showProgressHUD"})
    public void showProgressHUD(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    public DidiBridgeModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mFusionWebView = hybridableContainer.getWebView();
        this.mContext = hybridableContainer.getActivity();
        this.mJavascriptBridge = hybridableContainer.getWebView().getJavascriptBridge();
    }

    @JsInterface({"callHandler"})
    public Object callHandler(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        FusionBridgeModule.Function function = ((FusionBridgeModule) m25457a(FusionBridgeModule.class)).getFunction(str);
        if (function != null) {
            function.setJsCallback(callbackFunction);
            JSONObject execute = function.execute(jSONObject);
            if (execute == null) {
                return execute;
            }
            callbackFunction.onCallBack(execute);
            return execute;
        }
        Method a = m25458a(str);
        if (a != null) {
            try {
                return a.invoke(this, new Object[]{jSONObject, callbackFunction});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private Method m25458a(String str) {
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
        FusionWebView fusionWebView;
        if (!(this.mContext == null || (fusionWebView = this.mFusionWebView) == null)) {
            if (!WebConfigStore.getInstance().isWhiteUrl(fusionWebView.getWebView().getUrl(), this.mContext)) {
                return new JSONObject();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
            jSONObject2.put("phone", loginInfo.getPhone());
            jSONObject2.put("token", loginInfo.getToken());
            jSONObject2.put("uuid", SecurityUtil.getUUID());
            jSONObject2.put("suuid", SecurityUtil.getSUUID());
            jSONObject2.put("susig", SecurityUtil.getSUSIGN());
            jSONObject2.put("ticket", loginInfo.getKDToken());
            jSONObject2.put("uid", loginInfo.getUid());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
        return jSONObject2;
    }

    @JsInterface({"getLocationInfo"})
    public JSONObject getLocationInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
            String str2 = "";
            if (didiLocation != null) {
                String str3 = didiLocation.getLongitude() + str2;
                str = didiLocation.getLatitude() + str2;
                str2 = str3;
            } else {
                str = str2;
            }
            String cityId = NationTypeUtil.getNationComponentData().getCityId();
            String cityName = NationTypeUtil.getNationComponentData().getCityName();
            jSONObject2.put("lng", str2);
            jSONObject2.put("lat", str);
            jSONObject2.put("city_id", cityId);
            jSONObject2.put("area", cityName);
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
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
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
            if (r0 == 0) goto L_0x0100
            if (r0 == r6) goto L_0x00e7
            if (r0 == r5) goto L_0x006e
            java.lang.String r0 = "title"
            java.lang.String r8 = r8.optString(r0)
            com.didi.sdk.webview.WebViewModel r0 = new com.didi.sdk.webview.WebViewModel
            r0.<init>()
            r0.url = r1
            r0.title = r8
            android.content.Intent r8 = new android.content.Intent
            android.app.Activity r1 = r7.mContext
            java.lang.Class<com.didi.sdk.webview.BaseWebActivity> r2 = com.didi.sdk.webview.BaseWebActivity.class
            r8.<init>(r1, r2)
            java.lang.String r1 = "web_view_model"
            r8.putExtra(r1, r0)
            android.app.Activity r0 = r7.mContext
            r0.startActivity(r8)
            goto L_0x0105
        L_0x006e:
            android.net.Uri r8 = android.net.Uri.parse(r1)
            java.lang.String r0 = "orderId"
            java.lang.String r1 = r8.getQueryParameter(r0)
            java.lang.String r2 = "sid"
            java.lang.String r8 = r8.getQueryParameter(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto L_0x008d
            android.app.Activity r8 = r7.mContext
            r0 = 2131955529(0x7f130f49, float:1.9547588E38)
            com.didi.sdk.util.ToastHelper.showShortError((android.content.Context) r8, (int) r0)
            goto L_0x0105
        L_0x008d:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.xiaojukeji.action.ON_THE_WAY"
            r2.setAction(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "OneReceiver://"
            r3.append(r5)
            r3.append(r8)
            java.lang.String r5 = "/ontheway"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r2.setData(r3)
            r2.putExtra(r0, r1)
            android.app.Activity r0 = r7.mContext
            com.didi.sdk.app.IBroadcastSender r0 = com.didi.sdk.app.BroadcastSender.getInstance(r0)
            r0.sendBroadcast(r2)
            android.content.Intent r0 = new android.content.Intent
            android.app.Activity r1 = r7.mContext
            java.lang.Class<com.didi.sdk.app.MainActivity> r2 = com.didi.sdk.app.MainActivity.class
            r0.<init>(r1, r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "OneTravel://"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.setData(r8)
            android.app.Activity r8 = r7.mContext
            r8.startActivity(r0)
            goto L_0x0105
        L_0x00e7:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r8.<init>(r0)
            java.lang.String r0 = "android.intent.category.BROWSABLE"
            r8.addCategory(r0)
            android.net.Uri r0 = android.net.Uri.parse(r1)
            r8.setData(r0)
            android.app.Activity r0 = r7.mContext
            r0.startActivity(r8)
            goto L_0x0105
        L_0x0100:
            com.didi.onehybrid.container.FusionWebView r8 = r7.mFusionWebView
            r8.loadUrl(r1)
        L_0x0105:
            if (r9 == 0) goto L_0x0113
            java.lang.Object[] r8 = new java.lang.Object[r6]
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r8[r4] = r0
            r9.onCallBack(r8)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fusionbridge.module.DidiBridgeModule.openPage(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
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

    @JsInterface({"resizeImage"})
    public void resizeImage(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        Activity activity = this.mContext;
        if (activity instanceof BaseWebActivity) {
            final BaseWebActivity baseWebActivity = (BaseWebActivity) activity;
            Logger.easylog("FuncResizeImage", "execute: " + jSONObject);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                int optInt3 = jSONObject.optInt(CollectionConstant.APOLLO_PARAM_QUALITY);
                ImageHelper imageHelper = new ImageHelper(this.mContext);
                this.f35984a = imageHelper;
                imageHelper.handleImageChoose(optInt, optInt2, optInt3, new ImageHelper.IImg2StrListener() {
                    public void onResult(String str) {
                        Logger.easylog("FuncResizeImage", "onResult: " + str);
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = "javascript:resultBackFromJava('" + str + "')";
                            if (baseWebActivity.getWebView() != null) {
                                baseWebActivity.getWebView().loadUrl(str2);
                            }
                        }
                        CallbackFunction callbackFunction = callbackFunction;
                        if (callbackFunction != null) {
                            callbackFunction.onCallBack(new JSONObject());
                        }
                    }
                });
                return;
            }
            return;
        }
        throw new RuntimeException("Can't be invoked in any activity except BaseWebActivity");
    }

    public void handleChooseImageResult(int i, int i2, Intent intent) {
        ImageHelper imageHelper = this.f35984a;
        if (imageHelper != null) {
            imageHelper.handleActivityResult(i, i2, intent);
        }
    }

    @JsInterface({"viewIsBackground"})
    public void viewIsBackground(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.mHybridContainer.getUpdateUIHandler();
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(ShareEntranceModule.UI_TARGET_ISBACKGROUND, callbackFunction);
        }
    }

    @JsInterface({"gotoAlipay"})
    public void gotoAlipay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.mHybridContainer.getUpdateUIHandler();
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(ShareEntranceModule.UI_TARGET_GOTOALIPAY, callbackFunction, jSONObject);
        }
    }

    @JsInterface({"init_entrance", "initEntrance"})
    public void initEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareEntranceModule shareEntranceModule = (ShareEntranceModule) this.mFusionWebView.getExportModuleInstance(ShareEntranceModule.class);
        if (shareEntranceModule != null) {
            shareEntranceModule.initEntrance(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"show_entrance", "showEntrance"})
    public void showEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareEntranceModule shareEntranceModule = (ShareEntranceModule) this.mFusionWebView.getExportModuleInstance(ShareEntranceModule.class);
        if (shareEntranceModule != null) {
            shareEntranceModule.showEntrance(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"invoke_entrance", "invokeEntrance"})
    public void invokeEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareEntranceModule shareEntranceModule = (ShareEntranceModule) this.mFusionWebView.getExportModuleInstance(ShareEntranceModule.class);
        if (shareEntranceModule != null) {
            shareEntranceModule.invokeEntrance(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"hide_entrance", "hideEntrance"})
    public void hideEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareEntranceModule shareEntranceModule = (ShareEntranceModule) this.mFusionWebView.getExportModuleInstance(ShareEntranceModule.class);
        if (shareEntranceModule != null) {
            shareEntranceModule.hideEntrance(callbackFunction);
        }
    }

    @JsInterface({"share_weixin_appmsg", "shareWeixinAppmsg"})
    public void shareWeixinAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareWeixinAppmsg(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"share_weixin_timeline", "shareWeixinTimeline"})
    public void shareWeixinTimeline(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareWeixinTimeline(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"share_qq_appmsg", "shareQqAppmsg"})
    public void shareQqAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareQqAppmsg(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"share_qzone", "shareQzone"})
    public void shareQzone(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareQzone(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"share_alipay_friend", "shareAlipayFriend"})
    public void shareAlipayFriend(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareAlipayFriend(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"share_alipay_life", "shareAlipayLife"})
    public void shareAlipayLife(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ShareModule shareModule = (ShareModule) this.mFusionWebView.getExportModuleInstance(ShareModule.class);
        if (shareModule != null) {
            shareModule.shareAlipayLife(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"shareFacebook"})
    public void shareFacebook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareFacebook(jSONObject, callbackFunction);
    }

    @JsInterface({"shareFBMessenger"})
    public void shareFBMessenger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareFBMessenger(jSONObject, callbackFunction);
    }

    @JsInterface({"shareWhatsApp"})
    public void shareWhatsApp(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareWhatsApp(jSONObject, callbackFunction);
    }

    @JsInterface({"shareLine"})
    public void shareLine(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareLine(jSONObject, callbackFunction);
    }

    @JsInterface({"shareTwitter"})
    public void shareTwitter(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareTwitter(jSONObject, callbackFunction);
    }

    @JsInterface({"shareEmail"})
    public void shareEmail(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareEmail(jSONObject, callbackFunction);
    }

    @JsInterface({"shareSMS"})
    public void shareSMS(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ShareModule) m25457a(ShareModule.class)).shareSMS(jSONObject, callbackFunction);
    }

    @JsInterface({"getContacts"})
    public void getContacts(JSONObject jSONObject, CallbackFunction callbackFunction) {
        OperationModule operationModule = (OperationModule) this.mFusionWebView.getExportModuleInstance(OperationModule.class);
        if (operationModule != null) {
            operationModule.getContacts(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"apolloGetToggle"})
    public void apolloGetToggle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        OperationModule operationModule = (OperationModule) this.mFusionWebView.getExportModuleInstance(OperationModule.class);
        if (operationModule != null) {
            operationModule.apolloGetToggle(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"traceLog"})
    public void traceLog(JSONObject jSONObject, CallbackFunction callbackFunction) {
        TraceLogModule traceLogModule = (TraceLogModule) this.mFusionWebView.getExportModuleInstance(TraceLogModule.class);
        if (traceLogModule != null) {
            traceLogModule.traceLog(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"callNativeLogin"})
    public void callNativeLogin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LoginModule loginModule = (LoginModule) this.mFusionWebView.getExportModuleInstance(LoginModule.class);
        if (loginModule != null) {
            loginModule.callNativeLogin(callbackFunction);
        }
    }

    @JsInterface({"requestLogin", "callNativeLoginWithCallback"})
    public void callNativeLoginWithCallback(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LoginModule loginModule = (LoginModule) this.mFusionWebView.getExportModuleInstance(LoginModule.class);
        if (loginModule != null) {
            loginModule.callNativeLoginWithCallback(callbackFunction);
        }
    }

    @JsInterface({"uploadUserLog", "upload_user_log"})
    public void uploadUserLog(CallbackFunction callbackFunction) {
        TraceLogModule traceLogModule = (TraceLogModule) this.mFusionWebView.getExportModuleInstance(TraceLogModule.class);
        if (traceLogModule != null) {
            traceLogModule.uploadUserLog(callbackFunction);
        }
    }

    @JsInterface({"openVerifyComponent"})
    public void openVerifyComponent(JSONObject jSONObject, CallbackFunction callbackFunction) {
        OperationModule operationModule = (OperationModule) this.mFusionWebView.getExportModuleInstance(OperationModule.class);
        if (operationModule != null) {
            operationModule.openVerifyComponent(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"getSelectedCouponID"})
    public void getSelectedCouponID(JSONObject jSONObject, CallbackFunction callbackFunction) {
        OperationModule operationModule = (OperationModule) this.mFusionWebView.getExportModuleInstance(OperationModule.class);
        if (operationModule != null) {
            operationModule.getSelectedCouponID(jSONObject, callbackFunction);
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
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = optString;
            webViewModel.title = optString2;
            Intent intent = new Intent(this.mContext, BaseWebActivity.class);
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("web_view_model", webViewModel);
            this.mContext.startActivity(intent);
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"callbackImageLiteratureReview"})
    public void callbackImageLiteratureReview(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                ImageHelper imageHelper = new ImageHelper(this.mContext);
                this.f35984a = imageHelper;
                imageHelper.handleImageChoose(new ImageHelper.IImg2StrListener() {
                    public void onResult(String str) {
                        if (!TextUtils.isEmpty(str) && callbackFunction != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("data", str);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            callbackFunction.onCallBack(jSONObject);
                        }
                    }
                });
                return;
            }
            Intent intent = new Intent(this.mContext, PicUploadActivity.class);
            intent.putExtra(PicUploadActivity.UPLOAD_URL_KEY, jSONObject.optString("url"));
            intent.putExtra(PicUploadActivity.DATA_PARAMS_KEY, jSONObject.toString());
            intent.putExtra("width", jSONObject.optString("outputWidth"));
            intent.putExtra("height", jSONObject.optString("outputHeight"));
            intent.putExtra("type", "");
            PicUploadActivity.setImageUploadCallback(new ImageUploadCallback() {
                public void onSuccess(String str) {
                    FusionWebView fusionWebView = DidiBridgeModule.this.mFusionWebView;
                    fusionWebView.loadUrl("javascript:" + optString + "('" + ("{\"data\":" + str + "}") + "');");
                }
            });
            this.mContext.startActivity(intent);
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"callbackImageLiteratureReviewTakeCamera"})
    public void callbackImageLiteratureReviewTakeCamera(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("callback");
            Intent intent = new Intent(this.mContext, PicUploadActivity.class);
            intent.putExtra(PicUploadActivity.UPLOAD_URL_KEY, jSONObject.optString("url"));
            intent.putExtra(PicUploadActivity.DATA_PARAMS_KEY, jSONObject.toString());
            intent.putExtra("width", jSONObject.optString("outputWidth"));
            intent.putExtra("height", jSONObject.optString("outputHeight"));
            intent.putExtra("type", "camera");
            PicUploadActivity.setImageUploadCallback(new ImageUploadCallback() {
                public void onSuccess(String str) {
                    FusionWebView fusionWebView = DidiBridgeModule.this.mFusionWebView;
                    fusionWebView.loadUrl("javascript:" + optString + "('" + ("{\"data\":" + str + "}") + "');");
                }
            });
            this.mContext.startActivity(intent);
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"callbackImageLiteratureReviewPhotoLibrary"})
    public void callbackImageLiteratureReviewPhotoLibrary(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("callback");
            Intent intent = new Intent(this.mContext, PicUploadActivity.class);
            intent.putExtra(PicUploadActivity.UPLOAD_URL_KEY, jSONObject.optString("url"));
            intent.putExtra(PicUploadActivity.DATA_PARAMS_KEY, jSONObject.toString());
            intent.putExtra("width", jSONObject.optString("outputWidth"));
            intent.putExtra("height", jSONObject.optString("outputHeight"));
            intent.putExtra("type", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            PicUploadActivity.setImageUploadCallback(new ImageUploadCallback() {
                public void onSuccess(String str) {
                    FusionWebView fusionWebView = DidiBridgeModule.this.mFusionWebView;
                    fusionWebView.loadUrl("javascript:" + optString + "('" + ("{\"data\":" + str + "}") + "');");
                }
            });
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

    @JsInterface({"getHydraData"})
    public void getHydraData(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            int productId = BffInitManager.getProductId(ConfProxy.getInstance().getSelectedType());
            jSONObject2.put("Cityid", NationTypeUtil.getNationComponentData().getCityId());
            jSONObject2.put("Productid", String.valueOf(productId));
        } catch (Exception e) {
            e.printStackTrace();
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

    @JsInterface({"photograph"})
    public void photograph(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        Intent intent = new Intent(this.mContext, PicUploadActivity.class);
        intent.putExtra("width", jSONObject.optString("width"));
        intent.putExtra("height", jSONObject.optString("height"));
        intent.putExtra("cut", jSONObject.optBoolean("cut"));
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString(CollectionConstant.APOLLO_PARAM_QUALITY);
        if ("photograph".equals(optString)) {
            optString = "camera";
        } else if (ChooseImageReq.SOURCE_TYPE_ALBUM.equals(optString)) {
            optString = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if ("choice".equals(optString)) {
            optString = "";
        }
        intent.putExtra("type", optString);
        intent.putExtra(CollectionConstant.APOLLO_PARAM_QUALITY, optString2);
        PicUploadActivity.setImageUploadCallback(new ImageUploadCallback() {
            public void onSuccess(String str) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", 0);
                    jSONObject.put("image", str);
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$6", 839);
                }
            }
        });
        PicUploadActivity.setImageCallback(new ImageCallback() {
            public void onSuccess(String str) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", 0);
                    jSONObject.put("image", str);
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$7", 854);
                }
            }

            public void onSuccess(String str, String str2, String str3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", 0);
                    jSONObject.put("image", str);
                    jSONObject.put("type", str2);
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$7", 867);
                }
            }

            public void onFail() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", 1);
                    jSONObject.put("image", "");
                    jSONObject.put("type", "");
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$7", 880);
                }
            }

            public void onCancel() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", 2);
                    jSONObject.put("image", "");
                    jSONObject.put("type", "");
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$7", 893);
                }
            }

            public void onPermissionFail() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("photograph_result", -1);
                    jSONObject.put("image", "");
                    jSONObject.put("type", "");
                    callbackFunction.onCallBack(jSONObject);
                } catch (JSONException e) {
                    SystemUtils.log(3, "FuncPhotograph", e.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule$7", 906);
                }
            }
        });
        this.mContext.startActivity(intent);
    }

    @JsInterface({"openAddressBook"})
    public void openAddressBook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ContactModule contactModule = (ContactModule) this.mFusionWebView.getExportModuleInstance(ContactModule.class);
        if (contactModule != null) {
            contactModule.openAddressBook(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"toBizEntranceFromCoupon"})
    public void toBizEntranceFromCoupon(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("navi_url", "");
        final String host = !TextUtils.isEmpty(optString) ? Uri.parse(optString).getHost() : "flash";
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(DidiBridgeModule.this.mContext, MainActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(View.STATUS_BAR_TRANSIENT);
                DidiBridgeModule.this.mContext.startActivity(intent);
            }
        }, 200);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                intent.setData(Uri.parse("OneReceiver://" + host + "/entrance"));
                intent.setAction("com.xiaojukeji.action.SWITCH_CONTEXT");
                BroadcastSender.getInstance(DidiBridgeModule.this.mContext).sendBroadcast(intent);
            }
        }, 300);
    }

    @JsInterface({"faceRecognize", "faceRecognize"})
    public void faceRecognize(JSONObject jSONObject, CallbackFunction callbackFunction) {
        new FaceRecognizeModel(this.mContext).faceRecognize(jSONObject, callbackFunction);
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
        SystemUtils.log(3, "FusionBridge", "isAliPay jo = " + jSONObject2.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.module.DidiBridgeModule", 975);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    /* renamed from: a */
    private <T> T m25457a(Class<T> cls) {
        return this.mFusionWebView.getExportModuleInstance(cls);
    }
}
