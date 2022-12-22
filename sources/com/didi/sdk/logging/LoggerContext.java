package com.didi.sdk.logging;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.logging.util.Debug;
import java.io.File;

public class LoggerContext {

    /* renamed from: h */
    private static LoggerContext f36503h;

    /* renamed from: a */
    private String f36504a;

    /* renamed from: b */
    private File f36505b;

    /* renamed from: c */
    private File f36506c;

    /* renamed from: d */
    private File f36507d;

    /* renamed from: e */
    private File f36508e;

    /* renamed from: f */
    private boolean f36509f;

    /* renamed from: g */
    private boolean f36510g;

    private LoggerContext() {
    }

    public synchronized void init(Context context) {
        if (!this.f36509f) {
            boolean z = true;
            this.f36509f = true;
            this.f36504a = context.getPackageName();
            File filesDir = context.getFilesDir();
            this.f36508e = filesDir.getParentFile();
            File file = new File(filesDir, "logging");
            this.f36506c = file;
            if (!file.exists()) {
                this.f36506c.mkdirs();
            }
            File file2 = new File(filesDir, "logging-cache");
            this.f36507d = file2;
            if (!file2.exists()) {
                this.f36507d.mkdirs();
            }
            if ((context.getApplicationInfo().flags & 2) == 0) {
                z = false;
            }
            this.f36510g = z;
        }
    }

    public synchronized void update(LoggerConfig loggerConfig) {
        File logDir = loggerConfig.getLogDir();
        if (logDir != null) {
            this.f36505b = logDir;
        }
    }

    public static LoggerContext getDefault() {
        if (f36503h == null) {
            f36503h = new LoggerContext();
        }
        return f36503h;
    }

    public boolean isInitial() {
        return this.f36509f;
    }

    public String getPackageName() {
        return this.f36504a;
    }

    public File getSecondaryLogPathDir() {
        File file = this.f36505b;
        if (file != null && !TextUtils.equals(file.getPath(), this.f36506c.getPath())) {
            return this.f36506c;
        }
        return null;
    }

    public synchronized File getMainLogPathDir() {
        if (this.f36505b == null) {
            return this.f36506c;
        }
        try {
            if (!this.f36505b.exists() && !this.f36505b.mkdirs()) {
                return this.f36506c;
            } else if (!this.f36505b.exists()) {
                return this.f36506c;
            } else {
                if (!this.f36505b.canWrite() || !this.f36505b.canRead()) {
                    return this.f36506c;
                }
                return this.f36505b;
            }
        } catch (Exception e) {
            Debug.logOrThrow("check log dir " + this.f36505b + "failed", e);
        }
    }

    public File getLogCacheDir() {
        return this.f36507d;
    }

    public File getAppRootDir() {
        return this.f36508e;
    }

    public boolean isAppDebuggable() {
        return this.f36510g;
    }
}
