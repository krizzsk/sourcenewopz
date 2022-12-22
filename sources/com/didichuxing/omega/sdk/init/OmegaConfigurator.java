package com.didichuxing.omega.sdk.init;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.OmegaSetting;
import com.didichuxing.omega.sdk.common.safe.SafetyEditTextSDK;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.IOmegaApolloService;
import com.didichuxing.omega.sdk.init.impl.IOmegaToggleService;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.handler.IPrismApolloService;
import java.util.concurrent.atomic.AtomicBoolean;

public class OmegaConfigurator {
    private static final String TAG = "OmegaConfigurator";
    private static AtomicBoolean started = new AtomicBoolean(false);

    public static void setHotPatchVersion(long j) {
    }

    private static void initBehavior(Context context, IOmegaToggleService iOmegaToggleService) {
        OmegaSDK.switchFullUIAutoTracker(!iOmegaToggleService.allow("omega_autoui_close"));
        OmegaSDK.switchFullUIAutoEnv(!iOmegaToggleService.allow("omega_fullui_close"));
        OmegaSDK.setAutoEventInputEnable(iOmegaToggleService.allow("omega_event_input"));
        OmegaSDK.switchScreenshot(iOmegaToggleService.allow("omega_picture"));
        OmegaSDK.switchH5Hijack(iOmegaToggleService.allow("omega_http_hijack_check"));
        OmegaSDK.switchPrintTraceLog(iOmegaToggleService.allow("omega_print_trace_log"));
        if (iOmegaToggleService.allow("omega_use_omgu")) {
            OmegaSDK.setUploadHost(OmegaConfig.getUploadHost());
        }
        if (iOmegaToggleService.allow("omega_use_https_android")) {
            OmegaSDK.switchUseHttps(true);
        }
        OmegaSDK.exSwitchBatteryMonitor(iOmegaToggleService.allow("omega_battery"));
        OmegaSDK.exSetLowBatteryThreshold(((Integer) iOmegaToggleService.getParams("omega_mode", "lowbattery", 5)).intValue());
        try {
            SafetyEditTextSDK.SWITCH_TYPING_MONITOR = iOmegaToggleService.allow("omega_safe_typing");
        } catch (Exception unused) {
        }
        CommonUtil.setApolloService(new OmegaApolloService(iOmegaToggleService));
        if (OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            PrismMonitor.getInstance().setApolloService(new PrismApolloService(iOmegaToggleService));
        }
    }

    private static class OmegaApolloService implements IOmegaApolloService {
        private IOmegaToggleService mOmegaToggleService;

        private OmegaApolloService(IOmegaToggleService iOmegaToggleService) {
            this.mOmegaToggleService = iOmegaToggleService;
        }

        public boolean allow(String str) {
            IOmegaToggleService iOmegaToggleService = this.mOmegaToggleService;
            if (iOmegaToggleService == null) {
                return false;
            }
            return iOmegaToggleService.allow(str);
        }

        public <T> T getParams(String str, String str2, T t) {
            IOmegaToggleService iOmegaToggleService = this.mOmegaToggleService;
            if (iOmegaToggleService == null) {
                return t;
            }
            return iOmegaToggleService.getParams(str, str2, t);
        }
    }

    private static class PrismApolloService implements IPrismApolloService {
        private IOmegaToggleService mOmegaToggleService;

        private PrismApolloService(IOmegaToggleService iOmegaToggleService) {
            this.mOmegaToggleService = iOmegaToggleService;
        }

        public boolean allow(String str) {
            IOmegaToggleService iOmegaToggleService = this.mOmegaToggleService;
            if (iOmegaToggleService == null) {
                return false;
            }
            return iOmegaToggleService.allow(str);
        }

        public <T> T getParams(String str, String str2, T t) {
            IOmegaToggleService iOmegaToggleService = this.mOmegaToggleService;
            if (iOmegaToggleService == null) {
                return t;
            }
            return iOmegaToggleService.getParams(str, str2, t);
        }
    }

    public static void setToggleService(Context context, IOmegaToggleService iOmegaToggleService) {
        if (started.get()) {
            SystemUtils.log(5, "OmegaSDK", "omegasdk cannot be initialized repeatedly", (Throwable) null, "com.didichuxing.omega.sdk.init.OmegaConfigurator", 128);
        } else if (context == null || iOmegaToggleService == null) {
            operateErr(context, "Neither the Context nor the IOmegaToggleService can be empty");
        } else if (!started.compareAndSet(false, true)) {
            SystemUtils.log(5, "OmegaSDK", "omegasdk cannot be initialized repeatedly", (Throwable) null, "com.didichuxing.omega.sdk.init.OmegaConfigurator", 138);
        } else {
            OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION = iOmegaToggleService.allow(OmegaSetting.SWITCH_OMEGA_TRACKER_NEWEDITION);
            OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM = iOmegaToggleService.allow(OmegaSetting.SWITCH_OMEGA_ENENT_TRACK_PRISM);
            OmegaSDK.init(context);
            initBehavior(context, iOmegaToggleService);
        }
    }

    private static void operateErr(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null || !isApkInDebug(context)) {
                SystemUtils.log(6, TAG, str, (Throwable) null, "com.didichuxing.omega.sdk.init.OmegaConfigurator", 163);
                return;
            }
            throw new RuntimeException(str);
        }
    }

    public static boolean isApkInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void setTimeOffset(long j) {
        OmegaSDK.setTimeOffset(j);
    }
}
