package com.google.android.gms.ads.rewarded;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class ServerSideVerificationOptions {
    private final String zzear;
    private final String zzeas;

    private ServerSideVerificationOptions(Builder builder) {
        this.zzear = builder.zzear;
        this.zzeas = builder.zzeas;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public String zzear = "";
        /* access modifiers changed from: private */
        public String zzeas = "";

        public final Builder setUserId(String str) {
            this.zzear = str;
            return this;
        }

        public final Builder setCustomData(String str) {
            this.zzeas = str;
            return this;
        }

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }
    }

    public String getUserId() {
        return this.zzear;
    }

    public String getCustomData() {
        return this.zzeas;
    }
}
