package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.enums.DrtcSvcStatus;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.didichuxing.mlcp.drtc.interfaces.DrtcSDKInitializeListener;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.models.LogModel;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;
import com.didichuxing.mlcp.drtc.utils.MetricReporter;
import java.lang.ref.WeakReference;
import org.apache.commons.lang3.StringUtils;

public class DrtcSDK {

    /* renamed from: c */
    private static boolean f48389c = false;

    /* renamed from: d */
    private static DrtcSDK f48390d;

    /* renamed from: a */
    DrtcPluginHandle f48391a;

    /* renamed from: b */
    DrtcAudioManager f48392b;

    /* renamed from: e */
    private WeakReference<Context> f48393e;

    /* renamed from: f */
    private DrtcSDKInitializeListener f48394f;

    /* renamed from: g */
    private CallingService f48395g = null;

    /* renamed from: h */
    private InCallingService f48396h = null;

    /* renamed from: i */
    private final Boolean f48397i = true;

    /* renamed from: j */
    private String f48398j = null;

    private DrtcSDK() {
        f48389c = false;
    }

    public static Boolean IsSDKOnUsing() {
        boolean z = false;
        if (f48390d == null) {
            return false;
        }
        if (C15910a.m34616a() != DrtcSvcStatus.idle) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static synchronized DrtcSDK getInstance() {
        DrtcSDK drtcSDK;
        synchronized (DrtcSDK.class) {
            if (f48390d == null) {
                f48390d = new DrtcSDK();
            }
            drtcSDK = f48390d;
        }
        return drtcSDK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Context mo119023a() {
        return (Context) this.f48393e.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo119026b() {
        return this.f48398j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo119027c() {
        this.f48398j = "";
    }

    public CallingService getCallingService() {
        if (!f48389c) {
            mo119024a("[W] Try to get calling svc,but sdk did't initialized");
            return null;
        }
        if (this.f48395g == null) {
            this.f48395g = new C15910a(this);
        }
        return this.f48395g;
    }

    public InCallingService getInCallingService() {
        if (!f48389c) {
            mo119024a("[W] Try to get In-calling svc,but sdk did't initialized");
            return null;
        }
        if (this.f48396h == null) {
            this.f48396h = new DrtcInCallingServiceImpl(this);
        }
        return this.f48396h;
    }

    public void initializeSDK(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, DrtcEnvType drtcEnvType) {
        m34608a(context, drtcSDKInitializeListener, drtcEnvType, (String) null);
    }

    public boolean isInitialized() {
        return f48389c;
    }

    public void releaseSDK() {
        if (f48389c) {
            mo119024a("[I] SDK on releasing...");
            f48389c = false;
            this.f48392b.mo119044a();
            this.f48392b = null;
            this.f48391a = null;
            this.f48394f = null;
            this.f48395g = null;
            this.f48396h = null;
            f48390d = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo119025a(int i) {
        this.f48398j = String.valueOf(i);
        return SDKConsts.getSysConfig().mo118991a(i);
    }

    public void initializeSDK(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, String str) {
        if (!StringUtils.isEmpty(str)) {
            m34608a(context, drtcSDKInitializeListener, DrtcEnvType.ENV_CUSTOM, str);
            return;
        }
        throw new NullPointerException("Domain uri can't be null");
    }

    /* renamed from: a */
    private void m34608a(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, DrtcEnvType drtcEnvType, String str) {
        if (context == null) {
            throw new NullPointerException("Application Ctx can't be null");
        } else if (drtcSDKInitializeListener == null) {
            throw new NullPointerException("Init listener can't be null");
        } else if (drtcEnvType != DrtcEnvType.ENV_CUSTOM || !StringUtils.isEmpty(str)) {
            MetricReporter.getInstance().Clear();
            this.f48398j = null;
            if (!f48389c) {
                if (drtcEnvType == DrtcEnvType.ENV_CUSTOM) {
                    SDKConsts.Set_Sys_Config_Custom(str);
                } else {
                    SDKConsts.Set_Sys_Config(drtcEnvType);
                }
                WeakReference<Context> weakReference = new WeakReference<>(context);
                this.f48393e = weakReference;
                this.f48394f = drtcSDKInitializeListener;
                DrtcAudioManager a = DrtcAudioManager.m34713a((Context) weakReference.get());
                this.f48392b = a;
                a.mo119045a((DrtcAudioManager.C15915a) null);
                mo119024a("[I] SDK Initialize Beginning");
            } else {
                mo119024a("[W] SDK Initialized Twice");
            }
            f48389c = true;
            drtcSDKInitializeListener.onSDKInitializeResult(0);
        } else {
            throw new NullPointerException("Domain Uri can't be null while custom env");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo119024a(String str) {
        if (this.f48394f != null && !StringUtils.isEmpty(str)) {
            this.f48394f.onSDKLogMessage(str);
            if (this.f48397i.booleanValue()) {
                SystemUtils.log(3, "DRTCLOG", "SDK invoke system report", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcSDK", 58);
                MetricReporter.getInstance().systemLogReporter(LogModel.m34537d(this.f48398j).mo118969a(str));
            }
        }
    }
}
