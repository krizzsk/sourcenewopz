package com.didi.sdk.webview;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.router.GlobalRouter;
import com.didi.component.common.util.UIUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.fusionbridge.module.ContactModule;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.fusionbridge.module.LoginModule;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.p146ad.AdUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.permission.PermissionActivity;
import com.didi.sdk.util.permission.PermissionCallback;
import com.didi.sdk.webview.InterceptGoBackMgr;
import com.didi.sdk.webview.WebBackInterceptor;
import com.didi.sdk.webview.tool.ContactModel;
import com.didi.sdk.webview.tool.WebEncryptUtil;
import com.didi.sdk.webview.tool.WebPermissionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.google.gson.Gson;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFusionBridgeModule extends FusionBridgeModule {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f38378a = LoggerFactory.getLogger("ExtendFusionBridgeModule");

    /* renamed from: b */
    private CallbackFunction f38379b;

    public ExtendFusionBridgeModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
    }

    @JsInterface({"getAppUIInfo"})
    public void getAppUIInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(ServerParam.PARAM_TOP_BAR_HEIGHT, FusionUtil.getTopBarHeight());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Logger logger = f38378a;
        logger.debugEvent("getAppUIInfo jo = " + jSONObject2.toString(), new Object[0]);
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"requestLogin"})
    public void requestLogin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LoginModule loginModule = (LoginModule) this.mFusionWebView.getExportModuleInstance(LoginModule.class);
        if (loginModule != null) {
            loginModule.callNativeLoginWithCallback(callbackFunction);
        }
    }

    @JsInterface({"interceptGoback"})
    public void interceptGoback(JSONObject jSONObject, CallbackFunction callbackFunction) {
        InterceptGoBackMgr.setData((InterceptGoBackMgr.InterceptGoBackBridgeParams) new Gson().fromJson(jSONObject.toString(), InterceptGoBackMgr.InterceptGoBackBridgeParams.class));
    }

    @JsInterface({"faceRecognition"})
    public void faceRecognition(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        final String optString = jSONObject.optString("session_id");
        String optString2 = jSONObject.optString("bizcode");
        DiFaceParam diFaceParam = new DiFaceParam();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.mContext != null) {
                if (!(DIDILocationManager.getInstance(this.mContext) == null || DIDILocationManager.getInstance(this.mContext).getLastKnownLocation() == null)) {
                    jSONObject2.put("lat", DIDILocationManager.getInstance(this.mContext).getLastKnownLocation().getLatitude());
                    jSONObject2.put("lng", DIDILocationManager.getInstance(this.mContext).getLastKnownLocation().getLongitude());
                }
                jSONObject2.put("ip", SystemUtil.getIPAddress(this.mContext));
            }
            IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
            if (iA3Manager != null) {
                jSONObject2.put("a3", iA3Manager.getToken(this.mContext));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diFaceParam.setData(jSONObject2.toString());
        diFaceParam.setSessionId(optString);
        diFaceParam.setBizCode(Integer.parseInt(optString2));
        if (!(NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLoginInfo() == null)) {
            diFaceParam.setToken(NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        }
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public void onResult(DiFaceResult diFaceResult) {
                if (diFaceResult != null) {
                    Logger a = ExtendFusionBridgeModule.f38378a;
                    a.infoEvent("face result: " + diFaceResult.getCode() + " " + diFaceResult.getMsg(), new Object[0]);
                    JSONObject jSONObject = new JSONObject();
                    if (diFaceResult != null) {
                        try {
                            jSONObject.put("result", diFaceResult.getCode());
                            jSONObject.put("session_id", optString);
                            jSONObject.put("msg", diFaceResult.getMsg());
                        } catch (JSONException e) {
                            ExtendFusionBridgeModule.f38378a.debugEvent(e.toString(), new Object[0]);
                        }
                    }
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(jSONObject);
                    }
                }
            }
        });
    }

    @JsInterface({"closePage", "web_page_close", "page_close"})
    public void closeContainerActivity(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject == null || !jSONObject.optBoolean("needs_intercept") || !(this.mContext instanceof WebActivity) || !InterceptGoBackMgr.checkToIntercept((WebActivity) this.mContext, new InterceptGoBackMgr.GoBackCallback() {
            public void goBack() {
                ExtendFusionBridgeModule.super.closeContainerActivity(jSONObject, callbackFunction);
            }
        })) {
            super.closeContainerActivity(jSONObject, callbackFunction);
            InterceptGoBackMgr.cleanData();
        }
    }

    @JsInterface({"goToMarket"})
    public void goToMarket(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Application appContext = DIDIApplication.getAppContext();
        String packageName = appContext.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.addFlags(268435456);
            try {
                appContext.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @JsInterface({"openUrl"})
    public void openUrl(Object obj, CallbackFunction callbackFunction) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj instanceof JSONObject ? ((JSONObject) obj).optString("url") : "";
        }
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            try {
                DIDIApplication.getAppContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @JsInterface({"setHelpCenterNavBtn"})
    public void setHelpCenterNavBtn(Object obj, CallbackFunction callbackFunction) {
        if (obj != null && (obj instanceof JSONObject) && (this.mContext instanceof WebActivity)) {
            JSONObject jSONObject = (JSONObject) obj;
            final String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("hidden");
            WebActivity webActivity = (WebActivity) this.mContext;
            if (optBoolean) {
                webActivity.removeViewFromTitleBar(911911);
                return;
            }
            Button button = new Button(this.mContext);
            button.setTag(911911);
            button.setBackground(this.mContext.getResources().getDrawable(R.drawable.help_center));
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (ExtendFusionBridgeModule.this.mContext != null) {
                        Intent intent = new Intent(ExtendFusionBridgeModule.this.mContext, WebActivity.class);
                        intent.putExtra("url", optString);
                        ExtendFusionBridgeModule.this.mContext.startActivity(intent);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UIUtils.dip2pxInt(this.mContext, 20.0f), UIUtils.dip2pxInt(this.mContext, 20.0f));
            layoutParams.addRule(15, -1);
            layoutParams.addRule(21);
            layoutParams.rightMargin = UIUtils.dip2pxInt(this.mContext, 11.0f);
            layoutParams.setMarginEnd(UIUtils.dip2pxInt(this.mContext, 11.0f));
            webActivity.addViewToTitleBar(button, layoutParams);
        }
    }

    @JsInterface({"requestPermission"})
    public void requestPermission(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        try {
            final String string = jSONObject.getString("type");
            String permissionConvert = WebPermissionUtil.permissionConvert(string);
            if (Build.VERSION.SDK_INT >= 23) {
                C132894 r1 = new PermissionCallback() {
                    public void onPermissionGranted() {
                        if (callbackFunction != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(string, 1);
                            JSONObject jSONObject = new JSONObject(hashMap);
                            callbackFunction.onCallBack(jSONObject);
                        }
                    }

                    public void onPermissionReject(String str) {
                        if (callbackFunction != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(string, 2);
                            JSONObject jSONObject = new JSONObject(hashMap);
                            callbackFunction.onCallBack(jSONObject);
                        }
                    }
                };
                if (this.mContext instanceof WebActivity) {
                    ((WebActivity) this.mContext).request(new String[]{permissionConvert}, r1);
                    return;
                }
                PermissionActivity.request(this.mContext, new String[]{permissionConvert}, r1);
            } else if (callbackFunction != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(string, 1);
                callbackFunction.onCallBack(new JSONObject(hashMap));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JsInterface({"permissionCheck"})
    public void permissionCheck(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            HashMap hashMap = new HashMap();
            for (String str : arrayList) {
                try {
                    hashMap.put(str, Integer.valueOf(WebPermissionUtil.permissionGrantedConvert(ActivityCompat.checkSelfPermission(this.mContext, WebPermissionUtil.permissionConvert(str)))));
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
            callbackFunction.onCallBack(new JSONObject(hashMap));
        }
    }

    @JsInterface({"setNavigationBarStyle"})
    public void setNavigationBarStyle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("bgColor", "");
            String optString2 = jSONObject.optString("titleColor", "");
            int optInt = jSONObject.optInt("navStyle", 0);
            int optInt2 = jSONObject.optInt("shadowHidden", 0);
            if (this.mContext instanceof WebActivity) {
                ((WebActivity) this.mContext).updateTitleBar(optString, optString2, optInt, optInt2);
            }
        }
    }

    @JsInterface({"getAllContacts"})
    public void getAllContacts(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        HandlerThread handlerThread = new HandlerThread("getAllContacts");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() {
            public void run() {
                try {
                    JSONObject d = ExtendFusionBridgeModule.this.m27139b();
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(d);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public JSONObject m27139b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Gson gson = new Gson();
        String str = "";
        if (ActivityCompat.checkSelfPermission(this.mContext, Permission.READ_CONTACTS) == 0) {
            List a = m27134a((Context) this.mContext);
            if (a == null) {
                a = new ArrayList();
            }
            JSONArray jSONArray = new JSONArray(gson.toJson((Object) a));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("list", jSONArray);
            String jSONObject3 = jSONObject2.toString();
            SystemUtils.log(6, "tag", jSONObject3, (Throwable) null, "com.didi.sdk.webview.ExtendFusionBridgeModule", 446);
            if (!a.isEmpty()) {
                str = WebEncryptUtil.aesEncrypt(jSONObject3);
            }
            jSONObject.put("content", str);
            jSONObject.put("permitted", 1);
        } else {
            jSONObject.put("content", str);
            jSONObject.put("permitted", 2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private List<ContactModel> m27134a(Context context) {
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "mimetype", "data1", "data2", "data5", "data3"}, "mimetype in ( ? , ?)", new String[]{"vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name"}, (String) null);
            HashMap hashMap = new HashMap();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("contact_id"));
                ContactModel contactModel = (ContactModel) hashMap.get(string);
                if (contactModel == null) {
                    contactModel = new ContactModel();
                    hashMap.put(string, contactModel);
                }
                int columnIndex = query.getColumnIndex("mimetype");
                char c = 65535;
                if (columnIndex != -1) {
                    String string2 = query.getString(columnIndex);
                    int hashCode = string2.hashCode();
                    if (hashCode != -1079224304) {
                        if (hashCode == 684173810) {
                            if (string2.equals("vnd.android.cursor.item/phone_v2")) {
                                c = 0;
                            }
                        }
                    } else if (string2.equals("vnd.android.cursor.item/name")) {
                        c = 1;
                    }
                    if (c == 0) {
                        List list = contactModel.phoneNum;
                        if (list == null) {
                            list = new ArrayList(4);
                            contactModel.phoneNum = list;
                        }
                        list.add(query.getString(query.getColumnIndex("data1")));
                    } else if (c == 1) {
                        contactModel.name = query.getString(query.getColumnIndex("data1"));
                        contactModel.firstName = query.getString(query.getColumnIndex("data2"));
                        contactModel.middleName = query.getString(query.getColumnIndex("data5"));
                        contactModel.lastName = query.getString(query.getColumnIndex("data3"));
                    }
                }
            }
            query.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            arrayList.addAll(hashMap.values());
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @JsInterface({"openUniPay"})
    public void openUniPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("order_id")) {
                    DRouter.build("globalOneTravel" + HWMapConstant.HTTP.SEPARATOR + "one" + GlobalRouter.PAYMENT + "?oid=" + URLEncoder.encode(jSONObject.optString("order_id"), "utf-8") + "&pid=" + jSONObject.optString("product_id")).start(this.mContext);
                    return;
                }
                if (jSONObject.has(Const.PayParams.BIZ_CONTENT_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.BIZ_CONTENT, jSONObject.opt(Const.PayParams.BIZ_CONTENT_UNDERLINE));
                }
                if (jSONObject.has(Const.PayParams.SIGN_TYPE_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.SIGN_TYPE, jSONObject.opt(Const.PayParams.SIGN_TYPE_UNDERLINE));
                }
                if (jSONObject.has("out_trade_id")) {
                    jSONObject.put(Const.PayParams.OUT_TRADE_ID, jSONObject.opt("out_trade_id"));
                }
                this.f38379b = callbackFunction;
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setPackage(this.mContext.getPackageName());
                intent.setAction("com.didi.global.unifiedPay.entrance");
                bundle.putSerializable("uni_pay_param", jSONObject.toString());
                intent.putExtras(bundle);
                ((Request) DRouter.build("").putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).start(this.mContext, new RouterCallback.ActivityCallback() {
                    public void onActivityResult(int i, Intent intent) {
                        ExtendFusionBridgeModule.this.m27135a(intent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JsInterface({"jumpToBindCardPage"})
    public void jumpToBindCardPage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 0;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(this.mContext, 111, addCardParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27135a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (intent != null) {
                int intExtra = intent.getIntExtra("code", 0);
                String stringExtra = intent.getStringExtra("message");
                jSONObject.put("code", intExtra);
                jSONObject.put("message", stringExtra);
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "");
            }
            if (this.f38379b != null) {
                this.f38379b.onCallBack(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsInterface({"openAddressBook"})
    public void openAddressBook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ContactModule contactModule = (ContactModule) this.mFusionWebView.getExportModuleInstance(ContactModule.class);
        if (contactModule != null) {
            contactModule.openAddressBook(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"openVamos"})
    public void openVamos(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString(PayBaseWebActivity.EXTRA_URL, "");
            if (!TextUtils.isEmpty(optString)) {
                if (ConfProxy.getInstance().isContainsGroupType(BusinessConstants.TYPE_VAMOS)) {
                    DRouter.build(AppUtils.isBrazilApp(this.mContext) ? "taxis99OneTravel://ride/backhome" : "globalOneTravel://ride/backhome").start(this.mContext, new RouterCallback() {
                        public void onResult(Result result) {
                            UiThreadHandler.postDelayed(new Runnable() {
                                public void run() {
                                    DRouter.build(optString).start(ExtendFusionBridgeModule.this.mContext, new RouterCallback() {
                                        public void onResult(Result result) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
                                            hashMap.put("is_in_index", Boolean.valueOf(AdUtil.INSTANCE.isInRideEntrance()));
                                            AdUtil.INSTANCE.track("tech_carona_h5_jump_app_such5", AdUtil.INSTANCE.getDdlType(), hashMap);
                                        }
                                    });
                                }
                            }, 500);
                        }
                    });
                    return;
                }
                this.mContext.finish();
                HashMap hashMap = new HashMap();
                hashMap.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
                hashMap.put("is_in_index", Boolean.valueOf(AdUtil.INSTANCE.isInRideEntrance()));
                AdUtil.INSTANCE.track("tech_carona_h5_jump_app_failh5", AdUtil.INSTANCE.getDdlType(), hashMap);
                ToastHelper.showLongInfo((Context) DIDIApplication.getAppContext(), ResourcesHelper.getString(DIDIApplication.getAppContext(), R.string.GRider_data_Please_restart_hhoR, ResourcesHelper.getString(this.mContext, R.string.GRider_Track_Brazilian_Hitch_VklT)));
            }
        }
    }

    @JsInterface({"requestBackPressedControl"})
    public void requestBackPressedControl(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        C132958 r2 = new WebBackInterceptor.BackClickInterceptor() {
            public void onInterceptor() {
                callbackFunction.onCallBack(new Object[0]);
            }
        };
        if (this.mContext instanceof BaseWebActivity) {
            ((BaseWebActivity) this.mContext).setBackClickInterceptor(r2);
            return;
        }
        Fragment currentFragment = WebUtil.INSTANCE.getCurrentFragment();
        if (currentFragment != null && (currentFragment instanceof WebFragment)) {
            ((WebFragment) currentFragment).setBackClickInterceptor(r2);
        }
    }

    @JsInterface({"cancelBackPressedControl"})
    public void cancelBackPressedControl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.mContext instanceof BaseWebActivity) {
            ((BaseWebActivity) this.mContext).setBackClickInterceptor((WebBackInterceptor.BackClickInterceptor) null);
            return;
        }
        Fragment currentFragment = WebUtil.INSTANCE.getCurrentFragment();
        if (currentFragment != null && (currentFragment instanceof WebFragment)) {
            ((WebFragment) currentFragment).setBackClickInterceptor((WebBackInterceptor.BackClickInterceptor) null);
        }
    }
}
