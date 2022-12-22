package com.datadog.android.plugin;

import android.content.Context;
import com.datadog.android.privacy.TrackingConsent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/datadog/android/plugin/DatadogPluginConfig;", "", "context", "Landroid/content/Context;", "envName", "", "serviceName", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/privacy/TrackingConsent;)V", "getContext", "()Landroid/content/Context;", "getEnvName", "()Ljava/lang/String;", "getServiceName", "getTrackingConsent", "()Lcom/datadog/android/privacy/TrackingConsent;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogPluginConfig.kt */
public final class DatadogPluginConfig {

    /* renamed from: a */
    private final Context f3656a;

    /* renamed from: b */
    private final String f3657b;

    /* renamed from: c */
    private final String f3658c;

    /* renamed from: d */
    private final TrackingConsent f3659d;

    public DatadogPluginConfig(Context context, String str, String str2, TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "envName");
        Intrinsics.checkNotNullParameter(str2, "serviceName");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        this.f3656a = context;
        this.f3657b = str;
        this.f3658c = str2;
        this.f3659d = trackingConsent;
    }

    public final Context getContext() {
        return this.f3656a;
    }

    public final String getEnvName() {
        return this.f3657b;
    }

    public final String getServiceName() {
        return this.f3658c;
    }

    public final TrackingConsent getTrackingConsent() {
        return this.f3659d;
    }
}
