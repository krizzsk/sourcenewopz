package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.privacy.TrackingConsent;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "", "migrateData", "", "previousConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "previousFileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "newConsent", "newFileOrchestrator", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataMigrator.kt */
public interface DataMigrator {
    void migrateData(TrackingConsent trackingConsent, FileOrchestrator fileOrchestrator, TrackingConsent trackingConsent2, FileOrchestrator fileOrchestrator2);
}
