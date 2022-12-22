package com.didi.dimina.container.secondparty.trace.inner;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.container.secondparty.bundle.DiminaHelper;
import com.didi.dimina.container.secondparty.trace.inner.net.LogNetManager;
import com.didi.dimina.container.secondparty.trace.inner.net.LogWebSocketStatus;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.webview.util.WsgSafeUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.google.ads.AdRequest;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0010\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010*J\b\u0010+\u001a\u00020\u001eH\u0007J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020\bH\u0007J\u0010\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010#J\u0015\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3J\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u001e2\b\b\u0001\u00107\u001a\u00020\u0018J\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010*R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00069"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogManager;", "", "()V", "MMKV_KEY_SEND_FILE", "", "MMKV_KEY_TEMP_FILE", "TAG", "mIsMainProcess", "", "getMIsMainProcess", "()Ljava/lang/Boolean;", "setMIsMainProcess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mRecordDataPath", "getMRecordDataPath", "()Ljava/lang/String;", "setMRecordDataPath", "(Ljava/lang/String;)V", "mRecordRootPath", "getMRecordRootPath", "setMRecordRootPath", "mUniqueId", "mWebsocketStatus", "", "getMWebsocketStatus", "()I", "setMWebsocketStatus", "(I)V", "copyTempFileNameToUpload", "", "getBundleLogs", "fileName", "logs", "Ljava/util/LinkedList;", "Lorg/json/JSONObject;", "getJssdkVersionCode", "mina", "Lcom/didi/dimina/container/DMMina;", "getNetWorkType", "getUniqueId", "httpPubBody", "Ljava/util/HashMap;", "init", "initNet", "isUseWebsocket", "isWebSocketAvailable", "onUploadSuccess", "dataJObj", "printIsNotMainProcess", "msg", "printIsNotMainProcess$2party_impl_release", "saveUniqueId", "uniqueId", "setWebSocketStatus", "websocketStatus", "wssHeaders", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogManager.kt */
public final class LogManager {
    public static final LogManager INSTANCE = new LogManager();
    public static final String MMKV_KEY_SEND_FILE = "log_mmkv_key_send_file";
    public static final String MMKV_KEY_TEMP_FILE = "log_mmkv_key_temp_file";
    public static final String TAG = "LogManager";

    /* renamed from: a */
    private static String f17467a;

    /* renamed from: b */
    private static String f17468b;

    /* renamed from: c */
    private static Boolean f17469c;

    /* renamed from: d */
    private static int f17470d = -1;

    /* renamed from: e */
    private static String f17471e;

    private LogManager() {
    }

    public final String getMRecordRootPath() {
        return f17467a;
    }

    public final void setMRecordRootPath(String str) {
        f17467a = str;
    }

    public final String getMRecordDataPath() {
        return f17468b;
    }

    public final void setMRecordDataPath(String str) {
        f17468b = str;
    }

    public final Boolean getMIsMainProcess() {
        return f17469c;
    }

    public final void setMIsMainProcess(Boolean bool) {
        f17469c = bool;
    }

    @JvmStatic
    public static final void init() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkExpressionValueIsNotNull(app, "context");
        File filesDir = app.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append(DMSandboxHelper.DIMINA);
        sb.append(File.separator);
        sb.append("trace");
        f17467a = sb.toString();
        f17468b = f17467a + File.separator + "cache";
        if (TextUtils.isEmpty(MMKV.getRootDir())) {
            File filesDir2 = app.getFilesDir();
            Intrinsics.checkExpressionValueIsNotNull(filesDir2, "context.filesDir");
            MMKV.initialize(filesDir2.getAbsolutePath());
        }
        INSTANCE.m12986a();
        Dimina.Config config2 = Dimina4Di.getConfig();
        if (!(config2 instanceof Dimina4Di.Config)) {
            config2 = null;
        }
        Dimina4Di.Config config3 = (Dimina4Di.Config) config2;
        boolean z = false;
        INSTANCE.m12987a(config3 != null ? config3.isTraceWebSocket() : false);
        LogCollectThread.INSTANCE.startCollect();
        LogFileSendThread.INSTANCE.startSend();
        String packageName = WsgSecInfo.packageName(app);
        String str = null;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            try {
                Object invoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke != null) {
                    str = (String) invoke;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                Object systemService = app.getSystemService("activity");
                if (systemService != null) {
                    for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) systemService).getRunningAppProcesses()) {
                        if (next.pid == myPid) {
                            str = next.processName;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
                }
            } catch (Exception unused) {
            }
        }
        CharSequence charSequence = str;
        if (TextUtils.equals(packageName, charSequence) || TextUtils.isEmpty(charSequence)) {
            z = true;
        }
        f17469c = Boolean.valueOf(z);
    }

    public final void printIsNotMainProcess$2party_impl_release(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Boolean bool = f17469c;
        if (bool == null || Intrinsics.areEqual((Object) bool, (Object) false)) {
            SystemUtils.log(6, "LogManager-MMKV", "mIsMainProcess: " + f17469c + " | method: " + str, (Throwable) null, "com.didi.dimina.container.secondparty.trace.inner.LogManager", 92);
        }
    }

    /* renamed from: a */
    private final void m12986a() {
        synchronized (LogTracker.INSTANCE.getClass()) {
            INSTANCE.printIsNotMainProcess$2party_impl_release("copyTempFileNameToUpload");
            MMKV mmkvWithID = MMKV.mmkvWithID(MMKV_KEY_TEMP_FILE, f17467a);
            MMKV mmkvWithID2 = MMKV.mmkvWithID(MMKV_KEY_SEND_FILE, f17467a);
            String[] allKeys = mmkvWithID != null ? mmkvWithID.allKeys() : null;
            if (allKeys != null) {
                if (!(allKeys.length == 0)) {
                    for (String str : allKeys) {
                        if (mmkvWithID2 != null) {
                            mmkvWithID2.encode(str, " ");
                        }
                    }
                }
            }
            if (mmkvWithID != null) {
                mmkvWithID.clearAll();
            }
            if (mmkvWithID2 != null) {
                mmkvWithID2.trim();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final int getMWebsocketStatus() {
        return f17470d;
    }

    public final void setMWebsocketStatus(int i) {
        f17470d = i;
    }

    public final void setWebSocketStatus(@LogWebSocketStatus int i) {
        f17470d = i;
    }

    @JvmStatic
    public static final boolean isWebSocketAvailable() {
        return f17470d == 2;
    }

    /* renamed from: a */
    private final void m12987a(boolean z) {
        if (z) {
            LogUtil.iRelease(TAG, "数据平台： apollo use websocket");
            LogNetManager.INSTANCE.createWebSocket();
            LogNetManager.INSTANCE.registerNetChangeListener();
            return;
        }
        LogUtil.iRelease(TAG, "数据平台： apollo use http");
        LogNetManager.INSTANCE.getConfig();
    }

    public final HashMap<String, Object> httpPubBody() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        HashMap<String, Object> hashMap = new HashMap<>();
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        Map map = hashMap;
        map.put("pub_env", Integer.valueOf(config2.isDebug() ^ true ? 1 : 0));
        StringBuilder sb = new StringBuilder();
        Context context = app;
        sb.append(WsgSafeUtil.getBrand(context));
        sb.append('_');
        sb.append(WsgSafeUtil.getModel(context));
        map.put("pub_phone_type", sb.toString());
        map.put("pub_os_type", "android");
        map.put("pub_os_version", WsgSafeUtil.getOsVersion(context));
        return hashMap;
    }

    public final HashMap<String, Object> wssHeaders() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        HashMap<String, Object> hashMap = new HashMap<>();
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        Map map = hashMap;
        map.put("pub-env", Integer.valueOf(config2.isDebug() ^ true ? 1 : 0));
        StringBuilder sb = new StringBuilder();
        Context context = app;
        sb.append(WsgSafeUtil.getBrand(context));
        sb.append('_');
        sb.append(WsgSafeUtil.getModel(context));
        map.put("pub-phone-type", sb.toString());
        map.put("pub-os-type", "android");
        map.put("pub-os-version", WsgSafeUtil.getOsVersion(context));
        map.put("pub-sdk-version", Dimina.getVersion());
        return hashMap;
    }

    public final String getNetWorkType() {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        String networkType = WsgSafeUtil.getNetworkType(config.getApp());
        Intrinsics.checkExpressionValueIsNotNull(networkType, "WsgSafeUtil.getNetworkType(Dimina.getConfig().app)");
        if (networkType != null) {
            String lowerCase = networkType.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final synchronized void saveUniqueId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "uniqueId");
        if (!TextUtil.isEmpty(f17471e)) {
            LogUtil.iRelease(TAG, "uniqueId already set " + f17471e);
            return;
        }
        LogUtil.iRelease(TAG, "receive a new uniqueId " + str);
        f17471e = str;
    }

    public final String getUniqueId() {
        String str = f17471e;
        return str != null ? str : "";
    }

    public final void onUploadSuccess(JSONObject jSONObject) {
        String optString;
        if (jSONObject != null && (optString = jSONObject.optString("seq")) != null) {
            LogUtil.iRelease(TAG, "filename:" + optString + " has been sent");
            String[] allMkKey = LogCollectThread.INSTANCE.getAllMkKey();
            if (allMkKey != null) {
                if (!(allMkKey.length == 0)) {
                    for (String str : allMkKey) {
                        if (Intrinsics.areEqual((Object) str, (Object) optString)) {
                            LogUtil.iRelease(TAG, "delete send filename:" + str);
                            LogCollectThread.INSTANCE.deleteFile(optString);
                            LogCollectThread.INSTANCE.remove(str);
                        }
                    }
                }
            }
        }
    }

    public final String getBundleLogs(String str, LinkedList<JSONObject> linkedList) {
        Intrinsics.checkParameterIsNotNull(str, "fileName");
        Intrinsics.checkParameterIsNotNull(linkedList, "logs");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (JSONObject put : linkedList) {
            jSONArray.put(put);
        }
        jSONObject.put("seq", str);
        jSONObject.put("trackData", jSONArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final String getJssdkVersionCode(DMMina dMMina) {
        String jsSdkVersionCode = DiminaHelper.getJsSdkVersionCode(dMMina);
        return jsSdkVersionCode != null ? jsSdkVersionCode : AdRequest.VERSION;
    }
}
