package com.didi.component.homepop.request;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffNetConstant;
import com.didi.component.adalert.AdAlertModel;
import com.didi.component.adalert.HomeAdAlertDialog;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.log.Logger;
import com.didi.sdk.monitor.QualityCheckTrackImpl;
import com.didi.sdk.paxadsdk.AdLoadListenner;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class HomeAdAlertRequest implements HomePopupRequest {

    /* renamed from: a */
    private static final String f14127a = "HomeAdAlertRequest";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f14128b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<Integer, WeakReference<HomeAdAlertDialog>> f14129c = new HashMap();

    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(final Context context, String str) {
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_HOME_AD_ALERT).setCallback(new BffTravelCallbackAdapter(new ResponseListener<AdAlertModel>() {
            public void onSuccess(AdAlertModel adAlertModel) {
                super.onSuccess(adAlertModel);
                Logger.m25808d(HomeAdAlertRequest.f14127a, "request bff ad onSuccess ");
                if (adAlertModel != null && adAlertModel.list != null && adAlertModel.list.size() != 0) {
                    for (int i = 0; i < adAlertModel.list.size(); i++) {
                        HomeAdAlertRequest homeAdAlertRequest = HomeAdAlertRequest.this;
                        homeAdAlertRequest.m9876a(context, adAlertModel.list.get(i), i, homeAdAlertRequest.f14128b + 1);
                    }
                }
            }

            public void onError(AdAlertModel adAlertModel) {
                super.onError(adAlertModel);
                Logger.m25808d(HomeAdAlertRequest.f14127a, "request bff ad onError ");
            }

            public void onFail(AdAlertModel adAlertModel) {
                super.onFail(adAlertModel);
                Logger.m25808d(HomeAdAlertRequest.f14127a, "request bff ad onFail ");
            }
        }, context)).setServiceId(str).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9876a(Context context, AdAlertModel.AdAlertData adAlertData, int i, int i2) {
        AdAlertModel.AdAlertData adAlertData2 = adAlertData;
        if (i2 > 0) {
            final int i3 = i2 - 1;
            GlobalAdManager instance = GlobalAdManager.getInstance();
            String str = adAlertData2.agency;
            NativeAdStyle nativeAdStyle = NativeAdStyle.Dialog;
            String str2 = adAlertData2.adid;
            final AdAlertModel.AdAlertData adAlertData3 = adAlertData;
            final Context context2 = context;
            final int i4 = i;
            instance.loadNativeAD(context, str, nativeAdStyle, str2, new AdLoadListenner() {
                public void onAdClosed() {
                }

                public void onAdLoaded() {
                }

                public void onAdOpened() {
                }

                public void onSuccess(View view) {
                    Logger.m25811i(HomeAdAlertRequest.f14127a, "load ad success ");
                    if (ActivityLifecycleManager.getInstance().getCurrentActivity() instanceof BaseMainActivity) {
                        HomeAdAlertDialog homeAdAlertDialog = new HomeAdAlertDialog();
                        HomeAdAlertDialog.Builder adView = homeAdAlertDialog.build().setAdView(adAlertData3, view);
                        FragmentManager supportFragmentManager = ((FragmentActivity) context2).getSupportFragmentManager();
                        adView.show(supportFragmentManager, "mHomeAdAlertDialog" + i4);
                        HomeAdAlertRequest.this.f14129c.put(Integer.valueOf(i4), new WeakReference(homeAdAlertDialog));
                    }
                }

                public void onFailed(String str, String str2, String str3) {
                    int i;
                    Logger.m25811i(HomeAdAlertRequest.f14127a, "load ad failed " + str3);
                    Logger.m25811i(HomeAdAlertRequest.f14127a, "retry load ad " + i3);
                    HashMap hashMap = new HashMap();
                    hashMap.put("agency", adAlertData3.agency);
                    hashMap.put(Constants.JSON_KEY_ANDID, adAlertData3.adid);
                    hashMap.put("errmsg", str2);
                    hashMap.put(BffNetConstant.ERR_CODE, str);
                    try {
                        i = Integer.parseInt(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        i = -1;
                    }
                    QualityCheckTrackImpl.trackError("tech_admob_resource_sw", i, hashMap);
                    HomeAdAlertRequest.this.m9876a(context2, adAlertData3, i4, i3);
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.util.Map} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onAdClicked() {
                    /*
                        r4 = this;
                        com.didi.component.adalert.AdAlertModel$AdAlertData r0 = r2
                        org.json.JSONObject r0 = r0.mLogData
                        if (r0 == 0) goto L_0x003f
                        com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x003b }
                        r0.<init>()     // Catch:{ Exception -> 0x003b }
                        com.didi.component.adalert.AdAlertModel$AdAlertData r1 = r2     // Catch:{ Exception -> 0x003b }
                        org.json.JSONObject r1 = r1.mLogData     // Catch:{ Exception -> 0x003b }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x003b }
                        com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r1)     // Catch:{ Exception -> 0x003b }
                        com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x003b }
                        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x003b }
                        r1.<init>()     // Catch:{ Exception -> 0x003b }
                        if (r0 == 0) goto L_0x0035
                        com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x003b }
                        r1.<init>()     // Catch:{ Exception -> 0x003b }
                        com.didi.component.homepop.request.HomeAdAlertRequest$2$1 r2 = new com.didi.component.homepop.request.HomeAdAlertRequest$2$1     // Catch:{ Exception -> 0x003b }
                        r2.<init>()     // Catch:{ Exception -> 0x003b }
                        java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x003b }
                        java.lang.Object r0 = r1.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x003b }
                        r1 = r0
                        java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x003b }
                    L_0x0035:
                        java.lang.String r0 = "ibt_gp_commonmodule_btn_ck"
                        com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ Exception -> 0x003b }
                        goto L_0x003f
                    L_0x003b:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x003f:
                        com.didi.component.homepop.request.HomeAdAlertRequest r0 = com.didi.component.homepop.request.HomeAdAlertRequest.this
                        java.util.Map r0 = r0.f14129c
                        int r1 = r4
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        java.lang.Object r0 = r0.get(r1)
                        if (r0 == 0) goto L_0x0095
                        com.didi.component.homepop.request.HomeAdAlertRequest r0 = com.didi.component.homepop.request.HomeAdAlertRequest.this
                        java.util.Map r0 = r0.f14129c
                        int r1 = r4
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        java.lang.Object r0 = r0.get(r1)
                        java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                        java.lang.Object r0 = r0.get()
                        if (r0 == 0) goto L_0x0095
                        com.didi.component.homepop.request.HomeAdAlertRequest r0 = com.didi.component.homepop.request.HomeAdAlertRequest.this
                        java.util.Map r0 = r0.f14129c
                        int r1 = r4
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        java.lang.Object r0 = r0.get(r1)
                        java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                        java.lang.Object r0 = r0.get()
                        com.didi.component.adalert.HomeAdAlertDialog r0 = (com.didi.component.adalert.HomeAdAlertDialog) r0
                        r0.dismiss()
                        com.didi.sdk.paxadsdk.GlobalAdManager r0 = com.didi.sdk.paxadsdk.GlobalAdManager.getInstance()
                        com.didi.component.adalert.AdAlertModel$AdAlertData r1 = r2
                        java.lang.String r1 = r1.agency
                        com.didi.sdk.paxadsdk.NativeAdStyle r2 = com.didi.sdk.paxadsdk.NativeAdStyle.Dialog
                        com.didi.component.adalert.AdAlertModel$AdAlertData r3 = r2
                        java.lang.String r3 = r3.adid
                        r0.release(r1, r2, r3)
                    L_0x0095:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.component.homepop.request.HomeAdAlertRequest.C59632.onAdClicked():void");
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.Map} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onAdImpression() {
                    /*
                        r3 = this;
                        com.didi.component.adalert.AdAlertModel$AdAlertData r0 = r2
                        org.json.JSONObject r0 = r0.mLogData
                        if (r0 == 0) goto L_0x003f
                        com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x003b }
                        r0.<init>()     // Catch:{ Exception -> 0x003b }
                        com.didi.component.adalert.AdAlertModel$AdAlertData r1 = r2     // Catch:{ Exception -> 0x003b }
                        org.json.JSONObject r1 = r1.mLogData     // Catch:{ Exception -> 0x003b }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x003b }
                        com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r1)     // Catch:{ Exception -> 0x003b }
                        com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x003b }
                        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x003b }
                        r1.<init>()     // Catch:{ Exception -> 0x003b }
                        if (r0 == 0) goto L_0x0035
                        com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x003b }
                        r1.<init>()     // Catch:{ Exception -> 0x003b }
                        com.didi.component.homepop.request.HomeAdAlertRequest$2$2 r2 = new com.didi.component.homepop.request.HomeAdAlertRequest$2$2     // Catch:{ Exception -> 0x003b }
                        r2.<init>()     // Catch:{ Exception -> 0x003b }
                        java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x003b }
                        java.lang.Object r0 = r1.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x003b }
                        r1 = r0
                        java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x003b }
                    L_0x0035:
                        java.lang.String r0 = "ibt_gp_commonmodule_sw"
                        com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ Exception -> 0x003b }
                        goto L_0x003f
                    L_0x003b:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x003f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.component.homepop.request.HomeAdAlertRequest.C59632.onAdImpression():void");
                }
            });
        }
    }
}
