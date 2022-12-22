package com.datadog.android.core.internal.privacy;

import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/datadog/android/core/internal/privacy/TrackingConsentProvider;", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "consent", "Lcom/datadog/android/privacy/TrackingConsent;", "(Lcom/datadog/android/privacy/TrackingConsent;)V", "callbacks", "Ljava/util/LinkedList;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "getConsent", "notifyCallbacks", "", "previous", "new", "registerCallback", "callback", "setConsent", "unregisterAllCallbacks", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TrackingConsentProvider.kt */
public final class TrackingConsentProvider implements ConsentProvider {

    /* renamed from: a */
    private final LinkedList<TrackingConsentProviderCallback> f3578a;

    /* renamed from: b */
    private volatile TrackingConsent f3579b;

    public TrackingConsentProvider() {
        this((TrackingConsent) null, 1, (DefaultConstructorMarker) null);
    }

    public TrackingConsentProvider(TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(trackingConsent, "consent");
        this.f3578a = new LinkedList<>();
        this.f3579b = trackingConsent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrackingConsentProvider(TrackingConsent trackingConsent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TrackingConsent.PENDING : trackingConsent);
    }

    public TrackingConsent getConsent() {
        return this.f3579b;
    }

    public synchronized void setConsent(TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(trackingConsent, "consent");
        if (trackingConsent != this.f3579b) {
            TrackingConsent trackingConsent2 = this.f3579b;
            this.f3579b = trackingConsent;
            m2363a(trackingConsent2, trackingConsent);
        }
    }

    public synchronized void registerCallback(TrackingConsentProviderCallback trackingConsentProviderCallback) {
        Intrinsics.checkNotNullParameter(trackingConsentProviderCallback, "callback");
        this.f3578a.add(trackingConsentProviderCallback);
    }

    public synchronized void unregisterAllCallbacks() {
        this.f3578a.clear();
    }

    /* renamed from: a */
    private final void m2363a(TrackingConsent trackingConsent, TrackingConsent trackingConsent2) {
        for (TrackingConsentProviderCallback onConsentUpdated : this.f3578a) {
            onConsentUpdated.onConsentUpdated(trackingConsent, trackingConsent2);
        }
    }
}
