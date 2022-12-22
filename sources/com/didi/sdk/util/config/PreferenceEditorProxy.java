package com.didi.sdk.util.config;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

public class PreferenceEditorProxy {

    /* renamed from: a */
    private static final int f37715a = 5;

    /* renamed from: b */
    private static final int f37716b = 0;

    /* renamed from: c */
    private static final int f37717c = 1;

    /* renamed from: d */
    private static final int f37718d = 2;

    /* renamed from: e */
    private static final int f37719e = 3;

    /* renamed from: f */
    private static final int f37720f = 4;

    /* renamed from: g */
    private static PreferenceEditorProxy f37721g;

    /* renamed from: h */
    private SharedPreferences.Editor f37722h;

    /* renamed from: i */
    private ConcurrentHashMap<String, Object> f37723i;

    /* renamed from: j */
    private ConcurrentHashMap<String, Integer> f37724j = new ConcurrentHashMap<>();

    /* renamed from: k */
    private Handler f37725k;

    public interface PerferenceListener {
        void onCommit();
    }

    private PreferenceEditorProxy() {
        HandlerThread handlerThread = new HandlerThread(PreferenceEditorProxy.class.getSimpleName());
        handlerThread.start();
        this.f37725k = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                PreferenceEditorProxy.this.m26737a();
                Object obj = message.obj;
                if (obj != null) {
                    ((PerferenceListener) obj).onCommit();
                }
            }
        };
    }

    public static PreferenceEditorProxy getInstance() {
        PreferenceEditorProxy preferenceEditorProxy = f37721g;
        if (preferenceEditorProxy != null) {
            return preferenceEditorProxy;
        }
        synchronized (PreferenceEditorProxy.class) {
            if (f37721g == null) {
                f37721g = new PreferenceEditorProxy();
            }
        }
        return f37721g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96661a(SharedPreferences.Editor editor) {
        this.f37722h = editor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96662a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        this.f37723i = concurrentHashMap;
    }

    public void clear() {
        this.f37722h.clear();
        this.f37722h.apply();
    }

    public void putString(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.f37723i.put(str, str2);
        this.f37724j.put(str, 3);
    }

    public void putLong(String str, long j) {
        this.f37723i.put(str, Long.valueOf(j));
        this.f37724j.put(str, 1);
    }

    public void putInt(String str, int i) {
        this.f37723i.put(str, Integer.valueOf(i));
        this.f37724j.put(str, 0);
    }

    public void putBoolean(String str, boolean z) {
        this.f37723i.put(str, Boolean.valueOf(z));
        this.f37724j.put(str, 4);
    }

    public void putFloat(String str, float f) {
        this.f37723i.put(str, Float.valueOf(f));
        this.f37724j.put(str, 2);
    }

    public void commit() {
        if (this.f37724j.size() >= 5) {
            this.f37725k.sendEmptyMessage(0);
        }
    }

    public void commitCur() {
        this.f37722h.commit();
    }

    public void putStringCur(String str, String str2) {
        SharedPreferences.Editor editor = this.f37722h;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public void putIntCur(String str, int i) {
        SharedPreferences.Editor editor = this.f37722h;
        if (editor != null) {
            editor.putInt(str, i);
        }
    }

    public void commitImmediately(PerferenceListener perferenceListener) {
        Handler handler = this.f37725k;
        handler.sendMessage(Message.obtain(handler, 0, perferenceListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26737a() {
        for (String next : this.f37724j.keySet()) {
            m26739a(next, this.f37723i.get(next), this.f37724j.remove(next).intValue());
        }
        this.f37722h.apply();
    }

    /* renamed from: a */
    private void m26739a(String str, Object obj, int i) {
        if (i == 0) {
            this.f37722h.putInt(str, Integer.parseInt(String.valueOf(obj)));
        } else if (i == 1) {
            this.f37722h.putLong(str, Long.parseLong(String.valueOf(obj)));
        } else if (i == 2) {
            this.f37722h.putFloat(str, Float.parseFloat(String.valueOf(obj)));
        } else if (i == 3) {
            this.f37722h.putString(str, String.valueOf(obj));
        } else if (i == 4) {
            this.f37722h.putBoolean(str, Boolean.parseBoolean(String.valueOf(obj)));
        }
    }
}
