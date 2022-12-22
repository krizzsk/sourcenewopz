package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.p208ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "()V", "ELIGIBLE_EVENTS_KEY", "", "PRODUCTION_EVENTS_KEY", "eligibleEvents", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "productionEvents", "enable", "", "initialize", "isEligibleEvents", "", "event", "isEligibleEvents$facebook_core_release", "isEnabled", "isProductionEvents", "isProductionEvents$facebook_core_release", "populateEventsFromRawJsonString", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "trackActivity", "activity", "Landroid/app/Activity;", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuggestedEventsManager.kt */
public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final Set<String> eligibleEvents = new LinkedHashSet();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new LinkedHashSet();

    private SuggestedEventsManager() {
    }

    @JvmStatic
    public static final synchronized void enable() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute($$Lambda$SuggestedEventsManager$bPTNKB1roqNzalSpP7WmTIMErc.INSTANCE);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m47341enable$lambda0() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.get()) {
                    enabled.set(true);
                    INSTANCE.initialize();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && (suggestedEventsSetting = queryAppSettings.getSuggestedEventsSetting()) != null) {
                    populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
                    if ((!productionEvents.isEmpty()) || (!eligibleEvents.isEmpty())) {
                        ModelManager modelManager = ModelManager.INSTANCE;
                        File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                        if (ruleFile != null) {
                            FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                            FeatureExtractor.initialize(ruleFile);
                            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                            if (currentActivity != null) {
                                trackActivity(currentActivity);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r9 = r2.getJSONArray(ELIGIBLE_EVENTS_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void populateEventsFromRawJsonString$facebook_core_release(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "eligible_for_prediction_events"
            java.lang.String r1 = "production_events"
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            boolean r9 = r2.has(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r3 = "jsonArray.getString(i)"
            r4 = 0
            if (r9 == 0) goto L_0x0037
            org.json.JSONArray r9 = r2.getJSONArray(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            int r1 = r9.length()     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r1 <= 0) goto L_0x0037
            r5 = 0
        L_0x0024:
            int r6 = r5 + 1
            java.util.Set<java.lang.String> r7 = productionEvents     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r7.add(r5)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r6 < r1) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r5 = r6
            goto L_0x0024
        L_0x0037:
            boolean r9 = r2.has(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r9 == 0) goto L_0x005e
            org.json.JSONArray r9 = r2.getJSONArray(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            int r0 = r9.length()     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r0 <= 0) goto L_0x005e
        L_0x0047:
            int r1 = r4 + 1
            java.util.Set<java.lang.String> r2 = eligibleEvents     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            r2.add(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005a }
            if (r1 < r0) goto L_0x0058
            goto L_0x005e
        L_0x0058:
            r4 = r1
            goto L_0x0047
        L_0x005a:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.SuggestedEventsManager.populateEventsFromRawJsonString$facebook_core_release(java.lang.String):void");
    }

    @JvmStatic
    public static final void trackActivity(Activity activity) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    if (enabled.get()) {
                        FeatureExtractor featureExtractor = FeatureExtractor.INSTANCE;
                        if (FeatureExtractor.isInitialized() && (!productionEvents.isEmpty() || !eligibleEvents.isEmpty())) {
                            ViewObserver.Companion.startTrackingActivity(activity);
                            return;
                        }
                    }
                    ViewObserver.Companion.stopTrackingActivity(activity);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final boolean isEnabled() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isProductionEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "event");
            return productionEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isEligibleEvents$facebook_core_release(String str) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "event");
            return eligibleEvents.contains(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
