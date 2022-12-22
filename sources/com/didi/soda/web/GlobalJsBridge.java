package com.didi.soda.web;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.PhotoJsBridgeData;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.tools.SystemUtils;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class GlobalJsBridge extends BaseHybridModule {
    public static final String PARAM_APP_KEY = "appKey";
    public static final String PARAM_APP_VERSION = "appversion";
    public static final String PARAM_CARRIER = "carrier";
    public static final String PARAM_DEVICE_ID_NEW = "deviceid";
    public static final String PARAM_MODEL = "model";
    public static final String PARAM_NET_TYPE = "net_type";
    public static final String PARAM_OS = "os";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_TICKET = "ticket";
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_UID = "uid";
    public static final String P_AREA = "area";
    public static final String P_CITY_ID = "city_id";
    public static final String P_COUNTY_GROUP_ID = "county_group_id";
    public static final String P_COUNTY_ID = "county_id";
    public static final String P_LAT = "lat";
    public static final String P_LNG = "lng";
    public static final String WINDOW_CALL_BACK = "windowCallBack";

    /* renamed from: a */
    private final FusionWebView f43855a;

    /* renamed from: b */
    private final Activity f43856b;

    /* renamed from: c */
    private UpdateUIHandler f43857c;

    /* renamed from: d */
    private final WebViewJavascriptBridge f43858d;

    /* renamed from: e */
    private CallbackFunction f43859e;

    /* access modifiers changed from: protected */
    public abstract String getArea();

    /* access modifiers changed from: protected */
    public abstract int getCityId();

    /* access modifiers changed from: protected */
    public abstract String getCountyGroupId();

    /* access modifiers changed from: protected */
    public abstract String getCountyId();

    /* access modifiers changed from: protected */
    public abstract String getDeviceId();

    /* access modifiers changed from: protected */
    public abstract JSONObject getGlobalParams();

    /* access modifiers changed from: protected */
    public abstract double getLatitude();

    /* access modifiers changed from: protected */
    public abstract double getLongitude();

    /* access modifiers changed from: protected */
    public abstract String getServiceProvider();

    /* access modifiers changed from: protected */
    public abstract JSONObject getUserInfo();

    /* access modifiers changed from: protected */
    public abstract void openPageByPath(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void openTransferPage(String str, PhotoJsBridgeData.GetPhotoData getPhotoData);

    /* access modifiers changed from: protected */
    public abstract void pay(JSONObject jSONObject, CallbackFunction callbackFunction);

    /* access modifiers changed from: protected */
    public abstract void requestLoginJs(JSONObject jSONObject, CallbackFunction callbackFunction);

    /* access modifiers changed from: protected */
    public abstract void requestLogoutJs(JSONObject jSONObject, CallbackFunction callbackFunction);

    /* access modifiers changed from: protected */
    public abstract void shareToPlatform(ShareToolModel shareToolModel, CallbackFunction callbackFunction);

    public GlobalJsBridge(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f43856b = hybridableContainer.getActivity();
        this.f43857c = hybridableContainer.getUpdateUIHandler();
        this.f43855a = hybridableContainer.getWebView();
        this.f43858d = hybridableContainer.getWebView().getJavascriptBridge();
    }

    @JsInterface({"getGlobalParams"})
    public final void globalParams(CallbackFunction callbackFunction) {
        JSONObject globalParams = getGlobalParams();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(globalParams)));
        }
    }

    @JsInterface({"requestLogin"})
    public void requestLogin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        requestLoginJs(jSONObject, callbackFunction);
    }

    @JsInterface({"requestLogout"})
    public void requestLogout(JSONObject jSONObject, CallbackFunction callbackFunction) {
        requestLogoutJs(jSONObject, callbackFunction);
    }

    @JsInterface({"setTitle"})
    public void setTitle(Object obj, CallbackFunction callbackFunction) {
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
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_WEB_TITLE, str);
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"updateNav"})
    public void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_UPDATA_NAV, jSONObject, callbackFunction);
        }
    }

    @JsInterface({"setBackPressListener"})
    public void interceptBackKey(boolean z, CallbackFunction callbackFunction) {
        if (z) {
            this.f43859e = callbackFunction;
            return;
        }
        this.f43859e = null;
        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(2));
    }

    public CallbackFunction getCallbackFunction() {
        return this.f43859e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @com.didi.onehybrid.jsbridge.JsInterface({"openPage"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void openPage(org.json.JSONObject r7, com.didi.onehybrid.jsbridge.CallbackFunction r8) {
        /*
            r6 = this;
            java.lang.String r0 = "target"
            java.lang.String r1 = ""
            java.lang.String r0 = r7.optString(r0, r1)
            java.lang.String r2 = "url"
            java.lang.String r2 = r7.optString(r2, r1)
            java.lang.String r3 = "title"
            java.lang.String r7 = r7.optString(r3, r1)
            int r1 = r0.hashCode()
            r3 = -1052618729(0xffffffffc1425017, float:-12.144553)
            r4 = 0
            r5 = 1
            if (r1 == r3) goto L_0x0042
            r3 = 3526476(0x35cf4c, float:4.941645E-39)
            if (r1 == r3) goto L_0x0037
            r3 = 93819220(0x5979154, float:1.4253357E-35)
            if (r1 == r3) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "blank"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 2
            goto L_0x004d
        L_0x0037:
            java.lang.String r1 = "self"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 0
            goto L_0x004d
        L_0x0042:
            java.lang.String r1 = "native"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = -1
        L_0x004d:
            if (r0 == 0) goto L_0x006e
            if (r0 == r5) goto L_0x0055
            r6.openPageByPath(r2, r7)
            goto L_0x0081
        L_0x0055:
            android.content.Intent r7 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r7.<init>(r0)
            java.lang.String r0 = "android.intent.category.BROWSABLE"
            r7.addCategory(r0)
            android.net.Uri r0 = android.net.Uri.parse(r2)
            r7.setData(r0)
            android.app.Activity r0 = r6.f43856b
            r0.startActivity(r7)
            goto L_0x0081
        L_0x006e:
            com.didi.onehybrid.container.FusionWebView r0 = r6.f43855a
            r0.loadUrl(r2)
            com.didi.onehybrid.container.UpdateUIHandler r0 = r6.f43857c
            if (r0 == 0) goto L_0x0081
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r1[r4] = r7
            java.lang.String r7 = "soda_web_title"
            r0.updateUI(r7, r1)
        L_0x0081:
            if (r8 == 0) goto L_0x00a9
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 == 0) goto L_0x009e
            java.lang.Object[] r7 = new java.lang.Object[r5]
            com.didi.soda.web.model.CallBackModel r0 = new com.didi.soda.web.model.CallBackModel
            r1 = 0
            java.lang.String r2 = "param[url] is empty"
            r0.<init>(r5, r2, r1)
            org.json.JSONObject r0 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r0)
            r7[r4] = r0
            r8.onCallBack(r7)
            goto L_0x00a9
        L_0x009e:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            org.json.JSONObject r0 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((int) r4)
            r7[r4] = r0
            r8.onCallBack(r7)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.GlobalJsBridge.openPage(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    @JsInterface({"closePage"})
    public void closePage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null && (updateUIHandler instanceof UpdateUIHandlerImp)) {
            ((UpdateUIHandlerImp) updateUIHandler).finishPage();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"refreshPage"})
    public void refreshPage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FusionWebView fusionWebView = this.f43855a;
        if (fusionWebView != null) {
            fusionWebView.reload();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"commonPay"})
    public void commonPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        pay(jSONObject, callbackFunction);
    }

    @JsInterface({"getPhoto"})
    public void getPhoto(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int i;
        String optString = jSONObject.optString("type", "");
        boolean optBoolean = jSONObject.optBoolean("cut", true);
        String optString2 = jSONObject.optString("ext", FileUtil.JPG);
        double optDouble = jSONObject.optDouble(CollectionConstant.APOLLO_PARAM_QUALITY, 1.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject(Const.BlockParamConst.RESIZE);
        int i2 = 0;
        if (optJSONObject != null) {
            i2 = optJSONObject.optInt("width");
            i = optJSONObject.optInt("height");
        } else {
            i = 0;
        }
        PhotoJsBridgeData.GetPhotoData getPhotoData = new PhotoJsBridgeData.GetPhotoData();
        getPhotoData.setType(optString);
        getPhotoData.setCut(optBoolean);
        getPhotoData.setExt(optString2);
        getPhotoData.setQuality((float) optDouble);
        PhotoJsBridgeData.GetPhotoData.PicSize picSize = new PhotoJsBridgeData.GetPhotoData.PicSize();
        picSize.setWidth(i2);
        picSize.setHeight(i);
        getPhotoData.setResize(picSize);
        WebFusionCallback.getInstance().bindCallbackWithName(WebConstant.BridgeMethod.GET_PHOTO, callbackFunction);
        openTransferPage(WebConstant.Transfer.TRANSFER_PAGE_DATA, getPhotoData);
    }

    @JsInterface({"getSystemInfo"})
    public void getSystemInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appKey", m31204a());
            jSONObject2.put("appversion", SystemUtils.getVersionName(this.f43856b));
            jSONObject2.put("deviceid", getDeviceId());
            jSONObject2.put("model", SystemUtils.getModel());
            jSONObject2.put("os", Build.VERSION.RELEASE);
            jSONObject2.put("net_type", SystemUtils.getNetworkTypeString(this.f43856b));
            jSONObject2.put("carrier", getServiceProvider());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(jSONObject2)));
        }
    }

    @JsInterface({"getUserInfo"})
    public void getUserInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject userInfo = getUserInfo();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(userInfo)));
        }
    }

    @JsInterface({"getLocationInfo"})
    public void getLocationInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("lat", getLatitude());
            jSONObject2.put("lng", getLongitude());
            jSONObject2.put("city_id", getCityId());
            jSONObject2.put(P_COUNTY_ID, getCountyId());
            jSONObject2.put(P_COUNTY_GROUP_ID, getCountyGroupId());
            jSONObject2.put("area", getArea());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(jSONObject2)));
        }
    }

    @JsInterface({"launchScan"})
    public void launchScan(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null && (updateUIHandler instanceof UpdateUIHandlerImp)) {
            ((UpdateUIHandlerImp) updateUIHandler).launchScan(callbackFunction);
        }
    }

    @JsInterface({"goBack"})
    public void goBack(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FusionWebView fusionWebView = this.f43855a;
        if (fusionWebView instanceof SodaWebView) {
            ((SodaWebView) fusionWebView).doBack();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x013b  */
    @com.didi.onehybrid.jsbridge.JsInterface({"initEntrance"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initEntrance(org.json.JSONObject r21, com.didi.onehybrid.jsbridge.CallbackFunction r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            if (r1 == 0) goto L_0x0184
            java.lang.String r6 = "buttons"
            org.json.JSONArray r1 = r1.optJSONArray(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r1 == 0) goto L_0x015b
            r7 = 0
        L_0x0016:
            int r8 = r1.length()
            if (r7 >= r8) goto L_0x015b
            com.didi.soda.web.model.ShareToolModel r8 = new com.didi.soda.web.model.ShareToolModel
            r8.<init>()
            org.json.JSONObject r9 = r1.optJSONObject(r7)
            if (r9 == 0) goto L_0x0153
            java.lang.String r10 = "type"
            java.lang.String r11 = ""
            java.lang.String r12 = r9.optString(r10, r11)
            r8.type = r12
            java.lang.String r12 = "name"
            java.lang.String r12 = r9.optString(r12, r11)
            r8.customName = r12
            java.lang.String r12 = "data"
            org.json.JSONObject r9 = r9.optJSONObject(r12)
            if (r9 == 0) goto L_0x014d
            java.lang.String r12 = "share_url"
            java.lang.String r13 = r9.optString(r12, r11)
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0057
            java.lang.String r12 = "url"
            java.lang.String r12 = r9.optString(r12, r11)
            goto L_0x005b
        L_0x0057:
            java.lang.String r12 = r9.optString(r12, r11)
        L_0x005b:
            java.lang.String r13 = "share_icon_url"
            java.lang.String r14 = r9.optString(r13, r11)
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 == 0) goto L_0x006a
            java.lang.String r13 = "icon"
        L_0x006a:
            java.lang.String r13 = r9.optString(r13, r11)
            java.lang.String r14 = "share_img_url"
            java.lang.String r15 = r9.optString(r14, r11)
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0082
            java.lang.String r14 = "img"
            java.lang.String r14 = r9.optString(r14, r11)
            goto L_0x0086
        L_0x0082:
            java.lang.String r14 = r9.optString(r14, r11)
        L_0x0086:
            java.lang.String r15 = "share_title"
            java.lang.String r16 = r9.optString(r15, r11)
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 == 0) goto L_0x009b
            java.lang.String r15 = "title"
            java.lang.String r15 = r9.optString(r15, r11)
            goto L_0x009f
        L_0x009b:
            java.lang.String r15 = r9.optString(r15, r11)
        L_0x009f:
            java.lang.String r3 = "share_content"
            java.lang.String r17 = r9.optString(r3, r11)
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r4 = "content"
            if (r17 == 0) goto L_0x00b3
            java.lang.String r3 = r9.optString(r4, r11)
            goto L_0x00b7
        L_0x00b3:
            java.lang.String r3 = r9.optString(r3, r11)
        L_0x00b7:
            java.lang.String r5 = "sms_message"
            java.lang.String r18 = r9.optString(r5, r11)
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 == 0) goto L_0x00c9
            java.lang.String r4 = r9.optString(r4, r11)
            goto L_0x00cd
        L_0x00c9:
            java.lang.String r4 = r9.optString(r5, r11)
        L_0x00cd:
            java.lang.String r5 = r9.optString(r10)
            java.lang.String r10 = "image"
            java.lang.String r11 = r9.optString(r10)
            r21 = r1
            java.lang.String r1 = "ext"
            org.json.JSONObject r1 = r9.optJSONObject(r1)
            if (r1 == 0) goto L_0x00fe
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r18 = r11
            java.lang.String r11 = "appId"
            r19 = r12
            java.lang.String r12 = r1.optString(r11)
            r9.put(r11, r12)
            java.lang.String r11 = "path"
            java.lang.String r1 = r1.optString(r11)
            r9.put(r11, r1)
            goto L_0x0103
        L_0x00fe:
            r18 = r11
            r19 = r12
            r9 = 0
        L_0x0103:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x0131
            boolean r1 = r10.equals(r5)
            if (r1 == 0) goto L_0x0131
            java.lang.String r1 = r8.getPlatFrom()
            java.lang.String r5 = "ALIPAY_FRIENDS"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x012c
            java.lang.String r1 = r8.getPlatFrom()
            java.lang.String r5 = "ALIPAY_TIMELINE"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0128
            goto L_0x012c
        L_0x0128:
            r13 = r18
            r14 = r13
            goto L_0x0131
        L_0x012c:
            r12 = r18
            r13 = r12
            r14 = r13
            goto L_0x0133
        L_0x0131:
            r12 = r19
        L_0x0133:
            r8.url = r12
            boolean r1 = android.text.TextUtils.isEmpty(r13)
            if (r1 == 0) goto L_0x013c
            r13 = r14
        L_0x013c:
            r8.imageUrl = r13
            r8.title = r15
            r8.content = r3
            r8.smsMessage = r4
            java.lang.String r1 = r8.getPlatFrom()
            r8.platformStr = r1
            r8.extra = r9
            goto L_0x014f
        L_0x014d:
            r21 = r1
        L_0x014f:
            r6.add(r8)
            goto L_0x0155
        L_0x0153:
            r21 = r1
        L_0x0155:
            int r7 = r7 + 1
            r1 = r21
            goto L_0x0016
        L_0x015b:
            com.didi.onehybrid.container.UpdateUIHandler r1 = r0.f43857c
            if (r1 == 0) goto L_0x0174
            int r1 = r6.size()
            if (r1 == 0) goto L_0x0174
            com.didi.onehybrid.container.UpdateUIHandler r1 = r0.f43857c
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r6
            java.lang.String r6 = "soda_init_entrance"
            r1.updateUI(r6, r4)
            goto L_0x0176
        L_0x0174:
            r3 = 1
            r5 = 0
        L_0x0176:
            if (r2 == 0) goto L_0x019c
            java.lang.Object[] r1 = new java.lang.Object[r3]
            org.json.JSONObject r3 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((int) r5)
            r1[r5] = r3
            r2.onCallBack(r1)
            goto L_0x019c
        L_0x0184:
            r3 = 1
            r5 = 0
            if (r2 == 0) goto L_0x019c
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.didi.soda.web.model.CallBackModel r4 = new com.didi.soda.web.model.CallBackModel
            java.lang.String r6 = "param[buttons] is null"
            r7 = 0
            r4.<init>(r3, r6, r7)
            org.json.JSONObject r3 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r4)
            r1[r5] = r3
            r2.onCallBack(r1)
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.GlobalJsBridge.initEntrance(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    @JsInterface({"showEntrance"})
    public void showEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str = null;
        if (jSONObject != null) {
            String optString = jSONObject.optString("windowCallBack");
            initEntrance(jSONObject, (CallbackFunction) null);
            str = optString;
        }
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_SHOW_ENTRANCE, callbackFunction, str);
        }
    }

    @JsInterface({"shareSystemEntrance"})
    public void shareSystemEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_SHOW_SYSTEM_ENTRANCE, parseShareJson((String) null, jSONObject), callbackFunction);
        }
    }

    @JsInterface({"hideEntrance"})
    public void hideEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_HIDE_ENTRANCE, new Object[0]);
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"invokeEntrance"})
    public void invokeEntrance(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UpdateUIHandler updateUIHandler = this.f43857c;
        if (updateUIHandler != null) {
            updateUIHandler.updateUI(WebConstant.UI_TARGET_INVOKE_ENTRANCE, callbackFunction);
        }
    }

    @JsInterface({"shareWeixinTimeline"})
    public void shareWeixinTimeline(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.WXMOMENTS_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareWeixinAppmsg"})
    public void shareWeixinAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.WXCHAT_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareQqAppmsg"})
    public void shareQqAppmsg(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.QQ_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareQzone"})
    public void shareQzone(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.QZONE_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareAlipayFriend"})
    public void shareAlipayFriend(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a("ALIPAY_FRIENDS", jSONObject, callbackFunction);
    }

    @JsInterface({"shareAlipayLife"})
    public void shareAlipayLife(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a("ALIPAY_TIMELINE", jSONObject, callbackFunction);
    }

    @JsInterface({"shareFacebook"})
    public void shareFacebook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.FACEBOOK_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareFBMessenger"})
    public void shareFBMessenger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.MESSENGER_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareWhatsApp"})
    public void shareWhatsApp(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.WHATSAPP_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareTelegram"})
    public void shareTelegram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.TELEGRAM_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareLine"})
    public void shareLine(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.LINE_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareTwitter"})
    public void shareTwitter(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.TWITTER_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareSMS"})
    public void shareSMS(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.SYSTEM_MESSAGE, jSONObject, callbackFunction);
    }

    @JsInterface({"shareEmail"})
    public void shareEmail(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.EMAIL_PLATFORM, jSONObject, callbackFunction);
    }

    @JsInterface({"shareCopyLink"})
    public void shareCopyLink(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m31205a(WebConstant.COPY_LINK_PLATFORM, jSONObject, callbackFunction);
    }

    /* renamed from: a */
    private void m31205a(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        shareToPlatform(parseShareJson(str, jSONObject), callbackFunction);
    }

    public static ShareToolModel parseShareJson(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (TextUtils.isEmpty(jSONObject.optString("share_url", ""))) {
            str2 = jSONObject.optString("url", "");
        } else {
            str2 = jSONObject.optString("share_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_icon_url", ""))) {
            str3 = jSONObject.optString("icon", "");
        } else {
            str3 = jSONObject.optString("share_icon_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_img_url", ""))) {
            str4 = jSONObject.optString("img", "");
        } else {
            str4 = jSONObject.optString("share_img_url", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_title", ""))) {
            str5 = jSONObject.optString("title", "");
        } else {
            str5 = jSONObject.optString("share_title", "");
        }
        if (TextUtils.isEmpty(jSONObject.optString("share_content", ""))) {
            str6 = jSONObject.optString("content", "");
        } else {
            str6 = jSONObject.optString("share_content", "");
        }
        HashMap<String, String> hashMap = null;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("image");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null) {
            hashMap = new HashMap<>();
            hashMap.put("appId", optJSONObject.optString("appId"));
            hashMap.put("path", optJSONObject.optString("path"));
        }
        if (!TextUtils.isEmpty(optString) && "image".equals(optString)) {
            if ("ALIPAY_FRIENDS".equals(str) || "ALIPAY_TIMELINE".equals(str)) {
                str2 = optString2;
                str7 = str2;
            } else {
                str7 = optString2;
            }
            str4 = str3;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
        ShareToolModel shareToolModel = new ShareToolModel();
        shareToolModel.platformStr = str;
        shareToolModel.title = str5;
        shareToolModel.content = str6;
        if (TextUtils.isEmpty(str3)) {
            str3 = str4;
        }
        shareToolModel.imageUrl = str3;
        shareToolModel.url = str2;
        shareToolModel.type = optString;
        shareToolModel.extra = hashMap;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            shareToolModel.recipients = arrayList;
        }
        return shareToolModel;
    }

    public static void createResultJson(String str, CallbackFunction callbackFunction, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", getChannelName(str));
        } catch (JSONException unused) {
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(i, jSONObject)));
        }
    }

    public static String getChannelName(String str) {
        if (WebConstant.WXCHAT_PLATFORM.equals(str)) {
            return "wechat";
        }
        if (WebConstant.WXMOMENTS_PLATFORM.equals(str)) {
            return "wechat_timeline";
        }
        if (WebConstant.QQ_PLATFORM.equals(str)) {
            return "qq";
        }
        if (WebConstant.QZONE_PLATFORM.equals(str)) {
            return "qq_zone";
        }
        if ("ALIPAY_FRIENDS".equals(str)) {
            return "alipay_friends";
        }
        if ("ALIPAY_TIMELINE".equals(str)) {
            return "alipay_timeline";
        }
        return WebConstant.EMAIL_PLATFORM.equals(str) ? "email" : str;
    }

    /* renamed from: a */
    private String m31204a() {
        if (SodaFusionEngine.getBusinessAgent() == null) {
            return null;
        }
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if (!(businessAgent instanceof BizAgent)) {
            return "taxiPassengeriOS";
        }
        String appUserAgent = ((BizAgent) businessAgent).getAppUserAgent();
        if (TextUtils.isEmpty(appUserAgent)) {
            return "SodaEmbedCustomerAndroid";
        }
        char c = 65535;
        switch (appUserAgent.hashCode()) {
            case -405268840:
                if (appUserAgent.equals(BizAgent.TYPE_MANAGER)) {
                    c = 3;
                    break;
                }
                break;
            case -306995139:
                if (appUserAgent.equals(BizAgent.TYPE_MERCHANT)) {
                    c = 1;
                    break;
                }
                break;
            case 804476499:
                if (appUserAgent.equals("Soda.Customer")) {
                    c = 0;
                    break;
                }
                break;
            case 1877048357:
                if (appUserAgent.equals(BizAgent.TYPE_DELIVERY)) {
                    c = 2;
                    break;
                }
                break;
            case 1998402690:
                if (appUserAgent.equals("Soda.EmbedCustomer")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            return "SodaCustomerAndroid";
        }
        if (c == 1) {
            return "SodaMerchantAndroid";
        }
        if (c == 2) {
            return "SodaRiderAndroid";
        }
        if (c == 3) {
            return "SodaManagerAndroid";
        }
        if (c == 4) {
            return "taxiPassengeriOS";
        }
        throw new IllegalArgumentException("user agent muster be Soda.Customer,Soda.Merchant,Soda.Delivery");
    }
}
