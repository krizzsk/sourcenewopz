package com.didichuxing.ditest.agent.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavedState {
    private final String PREFERENCE_FILE_PREFIX = "com.didichuxing.omegasdk.alpha.android.agent.v1_";
    private final SharedPreferences.Editor editor;
    private final Lock lock = new ReentrantLock();
    private final SharedPreferences prefs;

    public SavedState(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, getPreferenceFileName(context.getPackageName()), 0);
        this.prefs = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public void save(final String str, final String str2) {
        if (!OmegaConfig.SWITCH_SAVED_STATE_SYNC) {
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
        this.lock.lock();
        try {
            this.editor.putString(str, str2);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(final String str, final boolean z) {
        if (!OmegaConfig.SWITCH_SAVED_STATE_SYNC) {
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
        this.lock.lock();
        try {
            this.editor.putBoolean(str, z);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(final String str, final int i) {
        if (!OmegaConfig.SWITCH_SAVED_STATE_SYNC) {
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
        this.lock.lock();
        try {
            this.editor.putInt(str, i);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(final String str, final long j) {
        if (!OmegaConfig.SWITCH_SAVED_STATE_SYNC) {
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
        this.lock.lock();
        try {
            this.editor.putLong(str, j);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(final String str, final float f) {
        if (!OmegaConfig.SWITCH_SAVED_STATE_SYNC) {
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
        this.lock.lock();
        try {
            this.editor.putFloat(str, f);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public String getString(String str) {
        if (!this.prefs.contains(str)) {
            return null;
        }
        return this.prefs.getString(str, (String) null);
    }

    public boolean getBoolean(String str) {
        return this.prefs.getBoolean(str, false);
    }

    public long getLong(String str) {
        return this.prefs.getLong(str, 0);
    }

    public int getInt(String str) {
        return this.prefs.getInt(str, 0);
    }

    public Float getFloat(String str) {
        if (!this.prefs.contains(str)) {
            return null;
        }
        return Float.valueOf(((float) ((int) (this.prefs.getFloat(str, 0.0f) * 100.0f))) / 100.0f);
    }

    private String getPreferenceFileName(String str) {
        return "com.didichuxing.omegasdk.alpha.android.agent.v1_" + str;
    }
}
