package com.didichuxing.diface.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.dfbasesdk.ILogReporter;
import com.didichuxing.dfbasesdk.LogReporter;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.PermissionUtils;
import com.didichuxing.dfbasesdk.video_capture.PathUtils;
import com.didichuxing.diface.BuildConfig;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceConfig;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.upload_capture.UploadCaptureModel;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.upload_capture.UploadCaptureResult;
import com.didichuxing.diface.biz.permission.PermissionActivity;
import com.didichuxing.diface.biz.preguide.DFPreGuideAct;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.GDfApi;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.SystemUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.facebook.appevents.UserDataStore;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class DiFaceFacade {
    public static final String[] PERMISSIONS_FACE = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", Permission.CAMERA};

    /* renamed from: c */
    private static volatile DiFaceFacade f47483c = null;

    /* renamed from: d */
    private static String[] f47484d = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", Permission.CAMERA, Permission.RECORD_AUDIO};

    /* renamed from: j */
    private static final String f47485j = "dd_face_global_report_sdk_data";

    /* renamed from: a */
    private String f47486a;

    /* renamed from: b */
    private String f47487b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiFaceConfig f47488e;

    /* renamed from: f */
    private boolean f47489f = false;

    /* renamed from: g */
    private boolean f47490g = false;

    /* renamed from: h */
    private boolean f47491h = false;

    /* renamed from: i */
    private DiFace.IDiFaceCallback f47492i;

    /* renamed from: k */
    private boolean f47493k = false;

    /* renamed from: l */
    private DiFace.IDiFaceCallback f47494l;

    private DiFaceFacade() {
    }

    public boolean isInitialized() {
        return this.f47489f;
    }

    public static DiFaceFacade getInstance() {
        if (f47483c == null) {
            synchronized (DiFaceFacade.class) {
                if (f47483c == null) {
                    f47483c = new DiFaceFacade();
                }
            }
        }
        return f47483c;
    }

    public void initialize(DiFaceConfig diFaceConfig) {
        if (this.f47489f) {
            return;
        }
        if (diFaceConfig == null || diFaceConfig.getAppContext() == null) {
            throw new RuntimeException("you can't initialize the diface sdk with empty config and context");
        }
        this.f47488e = diFaceConfig;
        SystemUtil.init(diFaceConfig.getAppContext());
        GDfApi.addExtraParam("sdkVersion", BuildConfig.VERSION_NAME);
        GDfApi.addExtraParam("clientOS", "Android " + Build.VERSION.RELEASE);
        this.f47489f = true;
    }

    public void report(String str, HashMap<String, Object> hashMap) {
        report(str, hashMap, (HashMap<String, Object>) null);
    }

    public void report(String str, JSONObject jSONObject) {
        report(str, jSONObject, (JSONObject) null);
    }

    public void reportSeriousErrorLog(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("desc", str);
        report(ILogReporter.EVENT_ID_SERIOUS_ERROR_LOG, (HashMap<String, Object>) null, (HashMap<String, Object>) hashMap);
    }

    public void report(String str) {
        ILogReporter logReporter = DFAppConfig.getInstance().logReporter();
        if (logReporter != null) {
            if ("1".equals(str)) {
                logReporter.enter();
            }
            logReporter.report(str);
            if (DiFaceLogger.EVENT_ID_EXIT_SDK.equals(str)) {
                logReporter.exit();
            }
        }
    }

    public void report(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        ILogReporter logReporter = DFAppConfig.getInstance().logReporter();
        if (logReporter != null) {
            if ("1".equals(str)) {
                logReporter.enter();
            }
            logReporter.report(str, jSONObject, jSONObject2);
            if (DiFaceLogger.EVENT_ID_EXIT_SDK.equals(str)) {
                logReporter.exit();
            }
        }
    }

    public void report(String str, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        ILogReporter logReporter = DFAppConfig.getInstance().logReporter();
        if (logReporter != null) {
            if ("1".equals(str)) {
                logReporter.enter();
            }
            logReporter.report(str, (Map<String, Object>) hashMap, (Map<String, Object>) hashMap2);
            if (DiFaceLogger.EVENT_ID_EXIT_SDK.equals(str)) {
                logReporter.exit();
            }
        }
    }

    public void reportException(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("desc", exc.getMessage());
        hashMap.put(UserDataStore.STATE, Log.getStackTraceString(exc));
        report(DiFaceLogger.EVENT_ID_LOG_EXCEPTION, (HashMap<String, Object>) null, (HashMap<String, Object>) hashMap);
    }

    public void reportEventWithCode(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(i));
        report(str, (HashMap<String, Object>) hashMap, (HashMap<String, Object>) null);
    }

    public DiFaceConfig getConfig() {
        return this.f47488e;
    }

    public Context getAppContext() {
        return getConfig().getAppContext();
    }

    public boolean isDebug() {
        return getConfig().isDebug();
    }

    public boolean isCaptureUploaded() {
        return this.f47490g;
    }

    public void uploadCapture(String str, ArrayList<String> arrayList, ArrayList<File> arrayList2) {
        if (this.f47488e != null && !this.f47490g) {
            this.f47490g = true;
            final File file = arrayList2.get(0);
            UploadCaptureModel.getInstance(this.f47488e.getAppContext()).upload(str, arrayList, arrayList2, new AbsHttpCallback<UploadCaptureResult>() {
                public void onSuccess(UploadCaptureResult uploadCaptureResult) {
                    if (DiFaceFacade.this.f47488e != null && DiFaceFacade.this.isDebug()) {
                        Context appContext = DiFaceFacade.this.f47488e.getAppContext();
                        ToastHelper.showShortInfo(appContext, "u s " + (file.length() / 1024));
                    }
                    file.delete();
                }

                public void onFailed(int i, String str) {
                    if (DiFaceFacade.this.f47488e != null && DiFaceFacade.this.isDebug()) {
                        ToastHelper.showShortInfo(DiFaceFacade.this.f47488e.getAppContext(), "u f");
                    }
                    file.delete();
                }
            });
        }
    }

    public void faceRecognition(DiFaceParam diFaceParam, DiFace.IDiFaceCallback iDiFaceCallback) {
        LogUtils.m33569i("start faceRecognition, isInitialized====" + this.f47489f + ", isFaceRecognizing=" + this.f47491h);
        if (this.f47491h) {
            notifyCallback(new DiFaceResult(106, "isFaceRecognizing : " + this.f47491h));
            return;
        }
        this.f47491h = true;
        this.f47492i = iDiFaceCallback;
        m34005a(diFaceParam);
        DFileUtils.deleteDir(PathUtils.getUnitedTempDir(getAppContext()));
        Context appContext = this.f47488e.getAppContext();
        Locale locale = appContext.getResources().getConfiguration().locale;
        if (TextUtils.isEmpty(locale.getCountry())) {
            this.f47487b = locale.getLanguage();
        } else {
            this.f47487b = locale.getLanguage() + "-" + locale.getCountry();
        }
        diFaceParam.setLanguage(this.f47487b);
        if (PermissionUtils.checkGranted(appContext, PERMISSIONS_FACE)) {
            DFPreGuideAct.start(appContext, diFaceParam);
        } else {
            PermissionActivity.start(appContext, diFaceParam);
        }
    }

    /* renamed from: a */
    private void m34005a(DiFaceParam diFaceParam) {
        String valueOf = String.valueOf(diFaceParam.getBizCode());
        String token = diFaceParam.getToken();
        String sessionId = diFaceParam.getSessionId();
        this.f47486a = sessionId;
        DFAppConfig.getInstance().setLogReporter(new LogReporter(valueOf, token, sessionId, HttpUtils.getNewFinalUrl(f47485j), BuildConfig.VERSION_NAME));
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        Context appContext = this.f47488e.getAppContext();
        hashMap.put("netType", SystemUtils.getNetworkType(appContext));
        hashMap.putAll(diFaceParam.getAllData(appContext));
        report("1", (HashMap<String, Object>) null, (HashMap<String, Object>) hashMap);
    }

    public String getSessionId() {
        return this.f47486a;
    }

    public String getLanguage() {
        return this.f47487b;
    }

    public void notifyCallback(DiFaceResult diFaceResult) {
        this.f47491h = false;
        this.f47490g = false;
        DiFace.IDiFaceCallback iDiFaceCallback = this.f47492i;
        if (iDiFaceCallback != null) {
            iDiFaceCallback.onResult(diFaceResult);
            this.f47492i = null;
        }
        if (!(getConfig() == null || getConfig().getAppContext() == null)) {
            DFileUtils.deleteDir(PathUtils.getUnitedTempDir(getAppContext()));
        }
        LogUtils.m33569i("exit sdk, face result code====" + diFaceResult.getCode());
        reportEventWithCode(DiFaceLogger.EVENT_ID_EXIT_SDK, diFaceResult.getCode());
    }

    public void appeal(Activity activity, AppealParam appealParam, int i) {
        if (!this.f47493k) {
            this.f47493k = true;
        }
    }

    public void appeal(AppealParam appealParam, DiFace.IDiFaceCallback iDiFaceCallback) {
        if (!this.f47493k) {
            this.f47493k = true;
            this.f47494l = iDiFaceCallback;
        }
    }

    public void notifyAppealCallback(DiFaceResult diFaceResult) {
        this.f47493k = false;
        DiFace.IDiFaceCallback iDiFaceCallback = this.f47494l;
        if (iDiFaceCallback != null) {
            iDiFaceCallback.onResult(diFaceResult);
            this.f47494l = null;
        }
    }
}
