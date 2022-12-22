package com.didi.component.common.voip;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK;
import com.didichuxing.comp.telecom.biz.p176ui.calllist.PhoneClickCallback;
import com.didichuxing.comp.telecom.biz.p176ui.calllist.VoipClickCallback;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class VoipComponentImpl {
    public static void onPushClick(Context context, String str) {
        if (m8047a()) {
            VoipBusinessSDK.displayInComingCall(context, str, 2);
        }
    }

    public static void onPushMsg(Context context, String str) {
        if (m8047a()) {
            VoipBusinessSDK.displayInComingCall(context, str, 1);
        }
    }

    public static void showCallMethodDialog(Activity activity, Map<String, Object> map, PhoneClickCallback phoneClickCallback, VoipClickCallback voipClickCallback) {
        if (m8047a()) {
            VoipBusinessSDK.showCallMethodDialog(activity, map, phoneClickCallback, voipClickCallback);
        }
    }

    /* renamed from: a */
    private static boolean m8047a() {
        final Application appContext = DIDIApplication.getAppContext();
        if (appContext == null) {
            return false;
        }
        if (VoipBusinessSDK.INSTANCE.isInitialized()) {
            return true;
        }
        VoipBusinessSDK.init(appContext, CallManagerAssist.CallManagerConfig.builder().env(3).hostProvider(new CallManagerAssist.HostProvider() {
            public String getCallApiHost() {
                return "https://ccvoip.didiglobal.com";
            }

            @Deprecated
            public /* synthetic */ String getVoipHost() {
                return CallManagerAssist.HostProvider.CC.$default$getVoipHost(this);
            }
        }).paramsProvider(new CallManagerAssist.ParamsProvider() {
            public /* synthetic */ String getPlatform() {
                return CallManagerAssist.ParamsProvider.CC.$default$getPlatform(this);
            }

            public String getAppVersion() {
                return SystemUtil.getVersionName(appContext);
            }

            public String getToken() {
                return NationComponentDataUtil.getToken();
            }

            public String getTerminalId() {
                return NationTypeUtil.getNationComponentData().getTerminal_id();
            }

            public String getCountryCode() {
                return NationComponentDataUtil.getLocCountry();
            }

            public String getAppPushType() {
                try {
                    return String.valueOf(SystemUtils.getApplicationInfo(appContext.getPackageManager(), appContext.getPackageName(), 128).metaData.getInt(EventKeys.APP_FCM_APPKEY));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return "";
                }
            }
        }).appServiceProvider(new CallManagerAssist.AppServiceProvider() {
            private Boolean openAnalyse = null;

            public long serverTime() {
                return TimeServiceManager.getInstance().getNTPCurrenTimeMillis();
            }

            public boolean isForeGround() {
                return Utils.isAppFront();
            }

            public void tickEvent(String str, Map<String, Object> map) {
                OmegaSDKAdapter.trackEvent(str, map);
            }

            public void log(String str, String str2) {
                if (this.openAnalyse == null) {
                    this.openAnalyse = Boolean.valueOf(Apollo.getToggle("ibt_call_voip_log_analyse").allow());
                }
                if (this.openAnalyse.booleanValue()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("append_log_msg", str + " " + str2);
                    OmegaSDKAdapter.trackEvent("gd_omega_diagnose_track_event", (Map<String, Object>) hashMap);
                }
                GLog.m7971i(str, str2);
            }
        }).build());
        return true;
    }
}
