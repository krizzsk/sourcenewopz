package com.didichuxing.diface;

import android.content.Context;

public class DiFaceConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f46959a;

    /* renamed from: b */
    private String f46960b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f46961c;

    /* renamed from: d */
    private int f46962d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f46963e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f46964f;

    /* renamed from: g */
    private boolean f46965g;

    /* renamed from: h */
    private boolean f46966h;

    private DiFaceConfig() {
        this.f46962d = 2;
        this.f46965g = false;
    }

    public boolean isDebug() {
        return this.f46959a;
    }

    public String getDebugEnv() {
        return this.f46960b;
    }

    public Context getAppContext() {
        return this.f46961c;
    }

    public String getFacePicName() {
        if (this.f46964f == null) {
            this.f46964f = "DFFace.jpg";
        }
        return this.f46964f;
    }

    public int getMaxBioassayRetryCount() {
        return this.f46962d;
    }

    public boolean isForceCaptureVideo() {
        return this.f46965g;
    }

    public void setForceCaptureVideo(boolean z) {
        this.f46965g = z;
    }

    public void setForceUseBackCamera(boolean z) {
        this.f46966h = z;
    }

    public boolean getForceUseBackCamera() {
        return this.f46966h;
    }

    public static class Builder {
        private DiFaceConfig config = new DiFaceConfig();

        public Builder setDebug(boolean z) {
            boolean unused = this.config.f46959a = z;
            return this;
        }

        public Builder setAppContext(Context context) {
            Context unused = this.config.f46961c = context;
            return this;
        }

        public Builder setFacePicDir(String str) {
            String unused = this.config.f46963e = str;
            return this;
        }

        public Builder setFacePicName(String str) {
            String unused = this.config.f46964f = str;
            return this;
        }

        public DiFaceConfig create() {
            return this.config;
        }
    }
}
