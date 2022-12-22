package com.datadog.android.core.internal.privacy;

import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "", "getConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "registerCallback", "", "callback", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "setConsent", "consent", "unregisterAllCallbacks", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ConsentProvider.kt */
public interface ConsentProvider {
    TrackingConsent getConsent();

    void registerCallback(TrackingConsentProviderCallback trackingConsentProviderCallback);

    void setConsent(TrackingConsent trackingConsent);

    void unregisterAllCallbacks();
}
