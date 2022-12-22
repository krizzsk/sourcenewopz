package com.didi.dimina.starbox.module.jsbridge.performance.perfs;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.DiminaEngine;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IDataProvider;
import com.didi.dimina.starbox.module.jsbridge.performance.base.IPerformance;
import com.didi.dimina.starbox.p107ui.windowpop.GlobalDispatcher;
import com.didi.dimina.starbox.util.AppCtxProvider;
import com.didi.dimina.starbox.util.ForegroundChecker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryProvider implements IPerformance<JSONObject>, ForegroundChecker.OnForegroundChange, Runnable {
    public static String TAG_TOTAL_MEMORY = "total";
    public static String TAG_V8_MEMORY = "v8_memory";

    /* renamed from: a */
    private IDataProvider<JSONObject> f18087a;

    /* renamed from: b */
    private final JSONObject f18088b = new JSONObject();

    /* renamed from: c */
    private final String f18089c;

    /* renamed from: d */
    private final Debug.MemoryInfo f18090d = new Debug.MemoryInfo();

    /* renamed from: e */
    private final int[] f18091e = {Process.myPid()};

    /* renamed from: f */
    private Method f18092f;

    /* renamed from: g */
    private String f18093g = "0m";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f18094h;

    /* renamed from: i */
    private V8MemoryTask f18095i;

    public MemoryProvider(String str) {
        this.f18089c = str;
    }

    public void registerProvider(IDataProvider<JSONObject> iDataProvider) {
        this.f18087a = iDataProvider;
        GlobalDispatcher.post(this);
    }

    public void run() {
        m13510c();
        try {
            this.f18088b.put(TAG_TOTAL_MEMORY, m13508a());
            this.f18088b.put(TAG_V8_MEMORY, (double) this.f18094h);
            this.f18087a.onProvide(this.f18088b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GlobalDispatcher.postDelay(this, 1000);
    }

    /* renamed from: a */
    private String m13508a() {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT < 29 && (activityManager = (ActivityManager) AppCtxProvider.getApp().getSystemService("activity")) != null) {
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(this.f18091e);
            if (processMemoryInfo.length > 0) {
                return (((float) processMemoryInfo[0].getTotalPss()) / 1024.0f) + "m";
            }
        }
        String lowerCase = C7745a.m13513a("RES").toLowerCase(Locale.US);
        if (lowerCase.startsWith("0")) {
            return this.f18093g;
        }
        this.f18093g = lowerCase;
        return lowerCase;
    }

    /* renamed from: b */
    private float m13509b() {
        int totalPss;
        try {
            if (this.f18092f == null) {
                Method declaredMethod = Debug.class.getDeclaredMethod("getMemoryInfo", new Class[]{Integer.TYPE, Debug.MemoryInfo.class});
                this.f18092f = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            this.f18092f.invoke(Debug.class, new Object[]{Integer.valueOf(Process.myPid()), this.f18090d});
            totalPss = this.f18090d.getTotalPss();
        } catch (Exception e) {
            e.printStackTrace();
            Debug.getMemoryInfo(this.f18090d);
            LogUtil.m13408d("MemoryInfo", C7745a.m13513a("RES") + "  " + this.f18090d);
            totalPss = this.f18090d.getTotalPss();
        }
        return ((float) totalPss) / 1024.0f;
    }

    /* renamed from: c */
    private void m13510c() {
        DMMina findDMMinaByAppId = DMMinaPool.findDMMinaByAppId(this.f18089c);
        if (findDMMinaByAppId != null) {
            V8MemoryTask v8MemoryTask = this.f18095i;
            if (v8MemoryTask == null || v8MemoryTask.dmMina != findDMMinaByAppId) {
                JSEngineWrapper jSEngine = findDMMinaByAppId.getJSEngine();
                try {
                    Field declaredField = JSEngineWrapper.class.getDeclaredField("b");
                    declaredField.setAccessible(true);
                    DiminaEngine diminaEngine = (DiminaEngine) declaredField.get(jSEngine);
                    Field declaredField2 = DiminaEngine.class.getDeclaredField("mV8Runtime");
                    declaredField2.setAccessible(true);
                    V8MemoryTask v8MemoryTask2 = new V8MemoryTask(findDMMinaByAppId, new Handler(diminaEngine.getLooper()), (C7781V8) declaredField2.get(diminaEngine));
                    this.f18095i = v8MemoryTask2;
                    v8MemoryTask2.track();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                this.f18095i.track();
            }
        }
    }

    class V8MemoryTask implements Runnable {
        final DMMina dmMina;
        final Handler handler;

        /* renamed from: v8 */
        final C7781V8 f18096v8;

        V8MemoryTask(DMMina dMMina, Handler handler2, C7781V8 v8) {
            this.dmMina = dMMina;
            this.handler = handler2;
            this.f18096v8 = v8;
        }

        public void run() {
            for (String str : this.f18096v8.heapRecordStats().split(";")) {
                if (!str.isEmpty()) {
                    LogUtil.m13408d("JSMemoryInfo", str);
                    if (str.startsWith("total_heap_size-")) {
                        float unused = MemoryProvider.this.f18094h = ((((float) Integer.parseInt(str.split("-", 2)[1])) + 0.0f) / 1024.0f) / 1024.0f;
                    }
                }
            }
        }

        public void track() {
            this.handler.post(this);
        }
    }

    public void onChange(boolean z) {
        GlobalDispatcher.removeCallbacks(this);
        if (z) {
            GlobalDispatcher.post(this);
        }
    }
}
