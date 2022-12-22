package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.ads.zzzs;
import com.google.android.gms.internal.ads.zzzw;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Settings {
        private final zzzw zzadt = new zzzw();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzzs.zzry().zza(context, str, (OnInitializationCompleteListener) null);
    }

    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzzs.zzry().zza(context, (String) null, onInitializationCompleteListener);
    }

    @Deprecated
    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzzs.zzry().getRewardedVideoAdInstance(context);
    }

    public static void setAppVolume(float f) {
        zzzs.zzry().setAppVolume(f);
    }

    public static void setAppMuted(boolean z) {
        zzzs.zzry().setAppMuted(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzzs.zzry().openDebugMenu(context, str);
    }

    public static String getVersionString() {
        return zzzs.zzry().getVersionString();
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzzs.zzry().registerRtbAdapter(cls);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzzs.zzry().getInitializationStatus();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzzs.zzry().getRequestConfiguration();
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzzs.zzry().setRequestConfiguration(requestConfiguration);
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzzs.zzry().disableMediationAdapterInitialization(context);
    }
}
