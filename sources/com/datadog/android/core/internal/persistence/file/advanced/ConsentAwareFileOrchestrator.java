package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.NoOpFileOrchestrator;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.privacy.TrackingConsentProviderCallback;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "Lcom/datadog/android/privacy/TrackingConsentProviderCallback;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "pendingOrchestrator", "grantedOrchestrator", "dataMigrator", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;)V", "delegateOrchestrator", "getAllFiles", "", "Ljava/io/File;", "getFlushableFiles", "getReadableFile", "excludeFiles", "", "getRootDir", "getWritableFile", "dataSize", "", "handleConsentChange", "", "previousConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "newConsent", "onConsentUpdated", "resolveDelegateOrchestrator", "consent", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ConsentAwareFileOrchestrator.kt */
public class ConsentAwareFileOrchestrator implements FileOrchestrator, TrackingConsentProviderCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final FileOrchestrator f3524e = new NoOpFileOrchestrator();

    /* renamed from: a */
    private final FileOrchestrator f3525a;

    /* renamed from: b */
    private final FileOrchestrator f3526b;

    /* renamed from: c */
    private final DataMigrator f3527c;

    /* renamed from: d */
    private FileOrchestrator f3528d;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ConsentAwareFileOrchestrator.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrackingConsent.values().length];
            iArr[TrackingConsent.PENDING.ordinal()] = 1;
            iArr[TrackingConsent.GRANTED.ordinal()] = 2;
            iArr[TrackingConsent.NOT_GRANTED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public File getRootDir() {
        return null;
    }

    public ConsentAwareFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator fileOrchestrator, FileOrchestrator fileOrchestrator2, DataMigrator dataMigrator) {
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(fileOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(fileOrchestrator2, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
        this.f3525a = fileOrchestrator;
        this.f3526b = fileOrchestrator2;
        this.f3527c = dataMigrator;
        m2341a((TrackingConsent) null, consentProvider.getConsent());
        consentProvider.registerCallback(this);
    }

    public File getWritableFile(int i) {
        FileOrchestrator fileOrchestrator = this.f3528d;
        if (fileOrchestrator != null) {
            return fileOrchestrator.getWritableFile(i);
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegateOrchestrator");
        throw null;
    }

    public File getReadableFile(Set<? extends File> set) {
        Intrinsics.checkNotNullParameter(set, "excludeFiles");
        return this.f3526b.getReadableFile(set);
    }

    public List<File> getAllFiles() {
        return CollectionsKt.plus(this.f3525a.getAllFiles(), this.f3526b.getAllFiles());
    }

    public List<File> getFlushableFiles() {
        return this.f3526b.getFlushableFiles();
    }

    public void onConsentUpdated(TrackingConsent trackingConsent, TrackingConsent trackingConsent2) {
        Intrinsics.checkNotNullParameter(trackingConsent, "previousConsent");
        Intrinsics.checkNotNullParameter(trackingConsent2, "newConsent");
        m2341a(trackingConsent, trackingConsent2);
    }

    /* renamed from: a */
    private final void m2341a(TrackingConsent trackingConsent, TrackingConsent trackingConsent2) {
        FileOrchestrator a = m2340a(trackingConsent);
        FileOrchestrator a2 = m2340a(trackingConsent2);
        this.f3527c.migrateData(trackingConsent, a, trackingConsent2, a2);
        this.f3528d = a2;
    }

    /* renamed from: a */
    private final FileOrchestrator m2340a(TrackingConsent trackingConsent) {
        int i = trackingConsent == null ? -1 : WhenMappings.$EnumSwitchMapping$0[trackingConsent.ordinal()];
        if (i == -1 || i == 1) {
            return this.f3525a;
        }
        if (i == 2) {
            return this.f3526b;
        }
        if (i == 3) {
            return f3524e;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator$Companion;", "", "()V", "NO_OP_ORCHESTRATOR", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getNO_OP_ORCHESTRATOR$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ConsentAwareFileOrchestrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileOrchestrator getNO_OP_ORCHESTRATOR$dd_sdk_android_release() {
            return ConsentAwareFileOrchestrator.f3524e;
        }
    }
}
