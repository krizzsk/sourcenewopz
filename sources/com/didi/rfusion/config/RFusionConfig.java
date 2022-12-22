package com.didi.rfusion.config;

import android.app.Application;
import java.util.Locale;
import java.util.Map;

public class RFusionConfig {

    /* renamed from: a */
    private Application f33194a;

    /* renamed from: b */
    private IRFusionLogger f33195b;

    /* renamed from: c */
    private IRFusionTracker f33196c;

    /* renamed from: d */
    private Locale f33197d;

    /* renamed from: e */
    private RFFontDelegate f33198e;

    public interface IRFusionLogger {
        void debug(String str, String str2);

        void info(String str, String str2);
    }

    public interface IRFusionTracker {
        void track(String str, Map<String, Object> map);
    }

    private RFusionConfig(Builder builder) {
        this.f33194a = builder.mApplication;
        this.f33195b = builder.mLogger;
        this.f33196c = builder.mTracker;
        this.f33197d = builder.mLocale;
        this.f33198e = builder.mFontDelegate;
    }

    public Application getApplication() {
        return this.f33194a;
    }

    public IRFusionLogger getLogger() {
        return this.f33195b;
    }

    public IRFusionTracker getTracker() {
        return this.f33196c;
    }

    public Locale getLocale() {
        return this.f33197d;
    }

    public RFFontDelegate getFontDelegate() {
        return this.f33198e;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Application mApplication;
        /* access modifiers changed from: private */
        public RFFontDelegate mFontDelegate;
        /* access modifiers changed from: private */
        public Locale mLocale;
        /* access modifiers changed from: private */
        public IRFusionLogger mLogger;
        /* access modifiers changed from: private */
        public IRFusionTracker mTracker;

        public Builder(Application application) {
            this.mApplication = application;
        }

        public Builder setLogger(IRFusionLogger iRFusionLogger) {
            this.mLogger = iRFusionLogger;
            return this;
        }

        public Builder setTracker(IRFusionTracker iRFusionTracker) {
            this.mTracker = iRFusionTracker;
            return this;
        }

        public Builder setLocale(Locale locale) {
            this.mLocale = locale;
            return this;
        }

        public Builder setFontDelegate(RFFontDelegate rFFontDelegate) {
            this.mFontDelegate = rFFontDelegate;
            return this;
        }

        public RFusionConfig build() {
            return new RFusionConfig(this);
        }
    }
}
