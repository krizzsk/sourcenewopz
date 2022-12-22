package com.didichuxing.omega.sdk.uicomponents.floatingview;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavedState {
    private String PREFERENCE_FILE_PREFIX;
    private final SharedPreferences.Editor editor;
    private final Lock lock = new ReentrantLock();
    private final SharedPreferences prefs;

    public SavedState(Context context) {
        this.PREFERENCE_FILE_PREFIX = context.getPackageName() + "_ui_components";
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, getPreferenceFileName(context.getPackageName()), 0);
        this.prefs = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public void save(String str, String str2) {
        this.lock.lock();
        try {
            this.editor.putString(str, str2);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, boolean z) {
        this.lock.lock();
        try {
            this.editor.putBoolean(str, z);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, int i) {
        this.lock.lock();
        try {
            this.editor.putInt(str, i);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, long j) {
        this.lock.lock();
        try {
            this.editor.putLong(str, j);
            this.editor.commit();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, float f) {
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
        return this.PREFERENCE_FILE_PREFIX + str;
    }
}
