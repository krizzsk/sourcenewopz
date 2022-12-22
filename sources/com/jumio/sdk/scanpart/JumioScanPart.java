package com.jumio.sdk.scanpart;

import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\b\u0000\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR \u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\r8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0016\u001a\u00020\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u001a\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, mo175978d2 = {"Lcom/jumio/sdk/scanpart/JumioScanPart;", "Ljava/io/Serializable;", "", "start", "Lcom/jumio/sdk/retry/JumioRetryReason;", "reason", "retry", "fallback", "cancel", "finish", "Lcom/jumio/sdk/views/JumioAnimationView;", "animationView", "getHelpAnimation", "Lcom/jumio/core/scanpart/ScanPart;", "a", "Lcom/jumio/core/scanpart/ScanPart;", "getScanPart$jumio_core_release", "()Lcom/jumio/core/scanpart/ScanPart;", "scanPart", "", "getHasFallback", "()Z", "hasFallback", "Lcom/jumio/sdk/enums/JumioScanMode;", "getScanMode", "()Lcom/jumio/sdk/enums/JumioScanMode;", "scanMode", "<init>", "(Lcom/jumio/core/scanpart/ScanPart;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioScanPart.kt */
public final class JumioScanPart implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final ScanPart<?> f55127a;

    /* renamed from: b */
    public boolean f55128b = true;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/sdk/scanpart/JumioScanPart$Companion;", "", "", "SCAN_PART_EXPIRED_MESSAGE", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioScanPart.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JumioScanPart(ScanPart<?> scanPart) {
        Intrinsics.checkNotNullParameter(scanPart, "scanPart");
        this.f55127a = scanPart;
    }

    public final void cancel() throws SDKNotConfiguredException {
        if (!this.f55128b) {
            throw new SDKNotConfiguredException("This part can not be used anymore".toString());
        } else if (this.f55127a.isCancelable()) {
            this.f55127a.cancel();
            this.f55127a.getCredential().finishScanPart$jumio_core_release(this);
            this.f55128b = false;
        } else {
            throw new SDKNotConfiguredException("This part is not cancelable at the moment".toString());
        }
    }

    public final void fallback() throws SDKNotConfiguredException {
        if (this.f55128b) {
            this.f55127a.fallback();
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final void finish() throws SDKNotConfiguredException {
        if (!this.f55128b) {
            throw new SDKNotConfiguredException("This part can not be used anymore".toString());
        } else if (this.f55127a.isComplete()) {
            this.f55127a.finish();
            this.f55127a.getCredential().finishScanPart$jumio_core_release(this);
            this.f55128b = false;
        } else {
            throw new IllegalArgumentException("This part is not yet finished".toString());
        }
    }

    public final boolean getHasFallback() {
        return this.f55127a.getHasFallback();
    }

    public final void getHelpAnimation(JumioAnimationView jumioAnimationView) throws SDKNotConfiguredException {
        Intrinsics.checkNotNullParameter(jumioAnimationView, "animationView");
        if (this.f55128b) {
            this.f55127a.getHelpAnimation(jumioAnimationView);
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final JumioScanMode getScanMode() {
        return this.f55127a.getScanMode();
    }

    public final ScanPart<?> getScanPart$jumio_core_release() {
        return this.f55127a;
    }

    public final void retry(JumioRetryReason jumioRetryReason) throws SDKNotConfiguredException {
        Intrinsics.checkNotNullParameter(jumioRetryReason, "reason");
        if (this.f55128b) {
            this.f55127a.retry(jumioRetryReason);
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }

    public final void start() throws SDKNotConfiguredException {
        if (this.f55128b) {
            this.f55127a.start();
            return;
        }
        throw new SDKNotConfiguredException("This part can not be used anymore".toString());
    }
}
