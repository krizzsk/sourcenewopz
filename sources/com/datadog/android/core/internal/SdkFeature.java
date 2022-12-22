package com.datadog.android.core.internal;

import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Configuration.Feature;
import com.datadog.android.core.internal.data.upload.DataUploadScheduler;
import com.datadog.android.core.internal.data.upload.NoOpUploadScheduler;
import com.datadog.android.core.internal.data.upload.UploadScheduler;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.net.NoOpDataUploader;
import com.datadog.android.core.internal.persistence.NoOpPersistenceStrategy;
import com.datadog.android.core.internal.persistence.PersistenceStrategy;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.plugin.DatadogPlugin;
import com.datadog.android.plugin.DatadogPluginConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010!\u001a\u00020\"J#\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0001H&¢\u0006\u0002\u0010'J\u0015\u0010(\u001a\u00020\u001c2\u0006\u0010&\u001a\u00028\u0001H&¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\"J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,J\u001b\u0010-\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0001¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u000200J\u001d\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010.J\u0010\u00102\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\b\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\"H\u0016J&\u00105\u001a\u00020\"2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0015\u0010;\u001a\u00020\"2\u0006\u0010&\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010<J\u0006\u0010=\u001a\u00020\"J\b\u0010>\u001a\u00020\"H\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006?"}, mo175978d2 = {"Lcom/datadog/android/core/internal/SdkFeature;", "T", "", "C", "Lcom/datadog/android/core/configuration/Configuration$Feature;", "()V", "featurePlugins", "", "Lcom/datadog/android/plugin/DatadogPlugin;", "getFeaturePlugins$dd_sdk_android_release", "()Ljava/util/List;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "persistenceStrategy", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "getPersistenceStrategy$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "setPersistenceStrategy$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;)V", "uploadScheduler", "Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "getUploadScheduler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "setUploadScheduler$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/data/upload/UploadScheduler;)V", "uploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "getUploader$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/DataUploader;", "setUploader$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/net/DataUploader;)V", "clearAllData", "", "createPersistenceStrategy", "context", "Landroid/content/Context;", "configuration", "(Landroid/content/Context;Lcom/datadog/android/core/configuration/Configuration$Feature;)Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "createUploader", "(Lcom/datadog/android/core/configuration/Configuration$Feature;)Lcom/datadog/android/core/internal/net/DataUploader;", "flushStoredData", "getPlugins", "", "initialize", "(Landroid/content/Context;Lcom/datadog/android/core/configuration/Configuration$Feature;)V", "isInitialized", "", "onInitialize", "onPostInitialized", "onPostStopped", "onStop", "registerPlugins", "plugins", "config", "Lcom/datadog/android/plugin/DatadogPluginConfig;", "trackingConsentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "setupUploader", "(Lcom/datadog/android/core/configuration/Configuration$Feature;)V", "stop", "unregisterPlugins", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SdkFeature.kt */
public abstract class SdkFeature<T, C extends Configuration.Feature> {

    /* renamed from: a */
    private final AtomicBoolean f3439a = new AtomicBoolean(false);

    /* renamed from: b */
    private PersistenceStrategy<T> f3440b = new NoOpPersistenceStrategy();

    /* renamed from: c */
    private DataUploader f3441c = new NoOpDataUploader();

    /* renamed from: d */
    private UploadScheduler f3442d = new NoOpUploadScheduler();

    /* renamed from: e */
    private final List<DatadogPlugin> f3443e = new ArrayList();

    public abstract PersistenceStrategy<T> createPersistenceStrategy(Context context, C c);

    public abstract DataUploader createUploader(C c);

    public void onInitialize(Context context, C c) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(c, "configuration");
    }

    public void onPostInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onPostStopped() {
    }

    public void onStop() {
    }

    public final AtomicBoolean getInitialized$dd_sdk_android_release() {
        return this.f3439a;
    }

    public final PersistenceStrategy<T> getPersistenceStrategy$dd_sdk_android_release() {
        return this.f3440b;
    }

    public final void setPersistenceStrategy$dd_sdk_android_release(PersistenceStrategy<T> persistenceStrategy) {
        Intrinsics.checkNotNullParameter(persistenceStrategy, "<set-?>");
        this.f3440b = persistenceStrategy;
    }

    public final DataUploader getUploader$dd_sdk_android_release() {
        return this.f3441c;
    }

    public final void setUploader$dd_sdk_android_release(DataUploader dataUploader) {
        Intrinsics.checkNotNullParameter(dataUploader, "<set-?>");
        this.f3441c = dataUploader;
    }

    public final UploadScheduler getUploadScheduler$dd_sdk_android_release() {
        return this.f3442d;
    }

    public final void setUploadScheduler$dd_sdk_android_release(UploadScheduler uploadScheduler) {
        Intrinsics.checkNotNullParameter(uploadScheduler, "<set-?>");
        this.f3442d = uploadScheduler;
    }

    public final List<DatadogPlugin> getFeaturePlugins$dd_sdk_android_release() {
        return this.f3443e;
    }

    public final void initialize(Context context, C c) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(c, "configuration");
        if (!this.f3439a.get()) {
            this.f3440b = createPersistenceStrategy(context, c);
            m2304a(c);
            m2305a(c.getPlugins(), new DatadogPluginConfig(context, CoreFeature.INSTANCE.getEnvName$dd_sdk_android_release(), CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release(), CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release().getConsent()), CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release());
            onInitialize(context, c);
            this.f3439a.set(true);
            onPostInitialized(context);
        }
    }

    public final boolean isInitialized() {
        return this.f3439a.get();
    }

    public final void clearAllData() {
        this.f3440b.getReader().dropAll();
    }

    public final void stop() {
        if (this.f3439a.get()) {
            m2303a();
            this.f3442d.stopScheduling();
            this.f3440b = new NoOpPersistenceStrategy();
            this.f3442d = new NoOpUploadScheduler();
            onStop();
            this.f3439a.set(false);
            onPostStopped();
        }
    }

    public final List<DatadogPlugin> getPlugins() {
        return this.f3443e;
    }

    public final void flushStoredData() {
        this.f3440b.getFlusher().flush(this.f3441c);
    }

    /* renamed from: a */
    private final void m2305a(List<? extends DatadogPlugin> list, DatadogPluginConfig datadogPluginConfig, ConsentProvider consentProvider) {
        for (DatadogPlugin datadogPlugin : list) {
            getFeaturePlugins$dd_sdk_android_release().add(datadogPlugin);
            datadogPlugin.register(datadogPluginConfig);
            consentProvider.registerCallback(datadogPlugin);
        }
    }

    /* renamed from: a */
    private final void m2303a() {
        for (DatadogPlugin unregister : this.f3443e) {
            unregister.unregister();
        }
        this.f3443e.clear();
    }

    /* renamed from: a */
    private final void m2304a(C c) {
        UploadScheduler uploadScheduler;
        if (CoreFeature.INSTANCE.isMainProcess$dd_sdk_android_release()) {
            this.f3441c = createUploader(c);
            uploadScheduler = new DataUploadScheduler(this.f3440b.getReader(), this.f3441c, CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getSystemInfoProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getUploadFrequency$dd_sdk_android_release(), CoreFeature.INSTANCE.getUploadExecutorService$dd_sdk_android_release());
        } else {
            uploadScheduler = new NoOpUploadScheduler();
        }
        this.f3442d = uploadScheduler;
        uploadScheduler.startScheduling();
    }
}
