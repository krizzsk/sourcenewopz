package com.didi.safety.god.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.onehybrid.FusionEngine;
import com.didi.safety.god.IClientAppFunction;
import com.didi.safety.god.IClientAppInfo;
import com.didi.safety.god.fusion.GlobalDoorGodSafetyGodModule;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.callback.SafetyGodCallBack;
import com.didi.safety.god.util.Constant;
import com.didi.safety.god2020.p145ui.GlobalCardDetectionAct2;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DebugUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.HashMap;

public class SafetyGod {

    /* renamed from: a */
    private static volatile boolean f34600a;

    /* renamed from: b */
    private static IClientAppInfo f34601b;

    /* renamed from: c */
    private static IClientAppFunction f34602c;

    public static void init(Context context) {
        FusionEngine.export("GlobalDoorGodSafetyGodModule", GlobalDoorGodSafetyGodModule.class);
        WsgSecInfo.init(context);
        f34600a = true;
    }

    public static void init(Context context, IClientAppInfo iClientAppInfo) {
        init(context);
        f34601b = iClientAppInfo;
    }

    public static void launch(Context context, SafetyGodConfig safetyGodConfig, SafetyGodCallBack safetyGodCallBack) {
        if (context == null) {
            if (DebugUtils.isDebug()) {
                throw new NullPointerException(" context should not be null");
            }
        } else if (safetyGodConfig == null) {
            if (DebugUtils.isDebug()) {
                throw new NullPointerException(" config should not be null");
            }
        } else if (f34600a) {
            SGActivityDelegateHolder.setActivityDelegate(safetyGodConfig.getActivityDelegate());
            Intent intent = new Intent();
            intent.putExtra("keeperId", safetyGodConfig.getKeeperId());
            intent.putExtra("bizCode", safetyGodConfig.getBizCode());
            intent.putExtra("token", safetyGodConfig.getToken());
            intent.putExtra("language", safetyGodConfig.getLanguage());
            intent.putExtra("nation", safetyGodConfig.getNation());
            if (safetyGodConfig.hasOffLineEnv()) {
                SystemUtils.log(3, Constant.TAG, "offLineEnv is " + safetyGodConfig.getOffLineEnv(), (Throwable) null, "com.didi.safety.god.manager.SafetyGod", 81);
                intent.putExtra("offLineEnv", safetyGodConfig.getOffLineEnv());
            }
            LogUtils.m33564d(Constant.TAG, "config is " + safetyGodConfig.isDebug());
            intent.putExtra("debug", safetyGodConfig.isDebug());
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("cardsImgCode", safetyGodConfig.getCardArray());
            if (!(safetyGodCallBack == null || GodManager.getInstance().getReturnCallback() == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("cmd", "DOORGOD_ENTER_SDK_REPEAT");
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "Quit SafetyGod sdk successfully");
                SafetyTraceEventHandler.trace(hashMap);
            }
            GodManager.getInstance().setReturnCallback(safetyGodCallBack);
            intent.setClass(context, GlobalCardDetectionAct2.class);
            context.startActivity(intent);
        } else if (DebugUtils.isDebug()) {
            throw new IllegalStateException(" SafetyGod not init");
        }
    }

    public static boolean hasClientAppInfoSet() {
        return f34601b != null;
    }

    public static double getLat() {
        CheckUtils.checkAssert(hasClientAppInfoSet(), "clientAppInfo==null!!!");
        return f34601b.getLat();
    }

    public static double getLng() {
        CheckUtils.checkAssert(hasClientAppInfoSet(), "clientAppInfo==null!!!");
        return f34601b.getLng();
    }

    public static String getA3() {
        CheckUtils.checkAssert(hasClientAppInfoSet(), "clientAppInfo==null!!!");
        return f34601b.getA3();
    }

    public static void setClientAppFunction(IClientAppFunction iClientAppFunction) {
        f34602c = iClientAppFunction;
    }

    public static void openUrl(String str) {
        if (f34602c != null && !TextUtils.isEmpty(str)) {
            f34602c.openUrl(str);
        }
    }

    public static void openCustomerService() {
        IClientAppFunction iClientAppFunction = f34602c;
        if (iClientAppFunction != null) {
            iClientAppFunction.openCustomerService();
        }
    }
}
