package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavedState {

    /* renamed from: a */
    private final String f47893a = "com.didichuxing.massdk.quality.android.agent.v1_";

    /* renamed from: b */
    private final SharedPreferences f47894b;

    /* renamed from: c */
    private final SharedPreferences.Editor f47895c;

    /* renamed from: d */
    private final Lock f47896d = new ReentrantLock();

    public SavedState(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, m34216a(context.getPackageName()), 0);
        this.f47894b = sharedPreferences;
        this.f47895c = sharedPreferences.edit();
    }

    public void save(final String str, final String str2) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveString(str, str2);
                }
            }.start();
        } else {
            saveString(str, str2);
        }
    }

    public void saveString(String str, String str2) {
        this.f47896d.lock();
        try {
            this.f47895c.putString(str, str2);
            this.f47895c.commit();
        } finally {
            this.f47896d.unlock();
        }
    }

    public void save(final String str, final boolean z) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveBoolean(str, z);
                }
            }.start();
        } else {
            saveBoolean(str, z);
        }
    }

    public void saveBoolean(String str, boolean z) {
        this.f47896d.lock();
        try {
            this.f47895c.putBoolean(str, z);
            this.f47895c.commit();
        } finally {
            this.f47896d.unlock();
        }
    }

    public void save(final String str, final int i) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveInt(str, i);
                }
            }.start();
        } else {
            saveInt(str, i);
        }
    }

    public void saveInt(String str, int i) {
        this.f47896d.lock();
        try {
            this.f47895c.putInt(str, i);
            this.f47895c.commit();
        } finally {
            this.f47896d.unlock();
        }
    }

    public void save(final String str, final long j) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveLong(str, j);
                }
            }.start();
        } else {
            saveLong(str, j);
        }
    }

    public void saveLong(String str, long j) {
        this.f47896d.lock();
        try {
            this.f47895c.putLong(str, j);
            this.f47895c.commit();
        } finally {
            this.f47896d.unlock();
        }
    }

    public void save(final String str, final float f) {
        if (!MASConfig.SWITCH_SAVED_STATE_SYNC) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    SavedState.this.saveFloat(str, f);
                }
            }.start();
        } else {
            saveFloat(str, f);
        }
    }

    public void saveFloat(String str, float f) {
        this.f47896d.lock();
        try {
            this.f47895c.putFloat(str, f);
            this.f47895c.commit();
        } finally {
            this.f47896d.unlock();
        }
    }

    public String getString(String str) {
        if (!this.f47894b.contains(str)) {
            return null;
        }
        return this.f47894b.getString(str, (String) null);
    }

    public boolean getBoolean(String str) {
        return this.f47894b.getBoolean(str, false);
    }

    public long getLong(String str) {
        return this.f47894b.getLong(str, 0);
    }

    public int getInt(String str) {
        return this.f47894b.getInt(str, 0);
    }

    public Float getFloat(String str) {
        if (!this.f47894b.contains(str)) {
            return null;
        }
        return Float.valueOf(((float) ((int) (this.f47894b.getFloat(str, 0.0f) * 100.0f))) / 100.0f);
    }

    /* renamed from: a */
    private String m34216a(String str) {
        return "com.didichuxing.massdk.quality.android.agent.v1_" + str;
    }
}
