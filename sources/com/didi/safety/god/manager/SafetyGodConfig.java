package com.didi.safety.god.manager;

public class SafetyGodConfig {

    /* renamed from: a */
    private boolean f34603a;

    /* renamed from: b */
    private int f34604b;

    /* renamed from: c */
    private String f34605c;

    /* renamed from: d */
    private String f34606d;

    /* renamed from: e */
    private String f34607e;

    /* renamed from: f */
    private String f34608f;

    /* renamed from: g */
    private String f34609g;

    /* renamed from: h */
    private String f34610h;

    /* renamed from: i */
    private SafetyGodActivityDelegate f34611i;

    private SafetyGodConfig(Builder builder) {
        this.f34608f = "";
        this.f34604b = builder.bizCode;
        this.f34603a = builder.debug;
        this.f34605c = builder.token;
        this.f34606d = builder.keeperId;
        this.f34608f = builder.offLineEnv;
        this.f34607e = builder.cardArray;
        this.f34609g = builder.mNation;
        this.f34610h = builder.mLanguage;
        this.f34611i = builder.activityDelegate;
    }

    public void setNation(String str) {
        this.f34609g = str;
    }

    public String getNation() {
        return this.f34609g;
    }

    public void setLanguage(String str) {
        this.f34610h = str;
    }

    public String getLanguage() {
        return this.f34610h;
    }

    public boolean isDebug() {
        return this.f34603a;
    }

    public String getToken() {
        return this.f34605c;
    }

    public int getBizCode() {
        return this.f34604b;
    }

    public String getKeeperId() {
        return this.f34606d;
    }

    public String getCardArray() {
        return this.f34607e;
    }

    public boolean hasOffLineEnv() {
        String str = this.f34608f;
        return str != null && !str.equals("");
    }

    public String getOffLineEnv() {
        return this.f34608f;
    }

    public SafetyGodActivityDelegate getActivityDelegate() {
        return this.f34611i;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public SafetyGodActivityDelegate activityDelegate;
        /* access modifiers changed from: private */
        public int bizCode;
        /* access modifiers changed from: private */
        public String cardArray;
        /* access modifiers changed from: private */
        public boolean debug;
        /* access modifiers changed from: private */
        public String keeperId;
        /* access modifiers changed from: private */
        public String mLanguage;
        /* access modifiers changed from: private */
        public String mNation;
        /* access modifiers changed from: private */
        public String offLineEnv;
        /* access modifiers changed from: private */
        public String token;

        public Builder setCardArray(String str) {
            this.cardArray = str;
            return this;
        }

        public Builder setKeeperId(String str) {
            this.keeperId = str;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setBizCode(int i) {
            this.bizCode = i;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setActivityDelegate(SafetyGodActivityDelegate safetyGodActivityDelegate) {
            this.activityDelegate = safetyGodActivityDelegate;
            return this;
        }

        public Builder setOffLineEnv(String str) {
            this.offLineEnv = str;
            return this;
        }

        public Builder setNation(String str) {
            this.mNation = str;
            return this;
        }

        public Builder setLanguage(String str) {
            this.mLanguage = str;
            return this;
        }

        public SafetyGodConfig builder() {
            return new SafetyGodConfig(this);
        }
    }
}
