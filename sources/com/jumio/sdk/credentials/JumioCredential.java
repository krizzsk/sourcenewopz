package com.jumio.sdk.credentials;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.ArrayList;
import jumio.core.C21360j0;
import jumio.core.C21365l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b4\u00105J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u000f\u0010\u000b\u001a\u00020\bH\u0010¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0012\u0010\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u001a\u001a\u00020\u00158\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0010R\"\u0010$\u001a\u00020!8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u00020(8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u00020!8F@\u0006¢\u0006\u0006\u001a\u0004\b-\u0010%R#\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00020.j\b\u0012\u0004\u0012\u00020\u0002`/8F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u00020!8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010%¨\u00066"}, mo175978d2 = {"Lcom/jumio/sdk/credentials/JumioCredential;", "", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "initScanPart", "", "start$jumio_core_release", "()V", "start", "finish", "cancel", "scanPart", "finishScanPart$jumio_core_release", "(Lcom/jumio/sdk/scanpart/JumioScanPart;)V", "finishScanPart", "persist$jumio_core_release", "persist", "getAddonPart", "Lcom/jumio/core/Controller;", "a", "Lcom/jumio/core/Controller;", "getController$jumio_core_release", "()Lcom/jumio/core/Controller;", "controller", "c", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "getActiveScanPart$jumio_core_release", "()Lcom/jumio/sdk/scanpart/JumioScanPart;", "setActiveScanPart$jumio_core_release", "activeScanPart", "", "e", "Z", "isValid", "()Z", "setValid", "(Z)V", "Ljumio/core/l;", "data", "Ljumio/core/l;", "getData$jumio_core_release", "()Ljumio/core/l;", "isComplete", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getScanSides", "()Ljava/util/ArrayList;", "scanSides", "isConfigured", "<init>", "(Lcom/jumio/core/Controller;Ljumio/core/l;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioCredential.kt */
public abstract class JumioCredential {

    /* renamed from: a */
    public final Controller f55073a;

    /* renamed from: b */
    public final C21365l f55074b;

    /* renamed from: c */
    public JumioScanPart f55075c;

    /* renamed from: d */
    public JumioScanPart f55076d;

    /* renamed from: e */
    public boolean f55077e = true;

    /* renamed from: com.jumio.sdk.credentials.JumioCredential$a */
    /* compiled from: JumioCredential.kt */
    public static final class C20098a extends Lambda implements Function1<JumioScanPart, Unit> {

        /* renamed from: a */
        public final /* synthetic */ JumioCredential f55078a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20098a(JumioCredential jumioCredential) {
            super(1);
            this.f55078a = jumioCredential;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
            r0 = r0.getScanPart$jumio_core_release();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo163560a(com.jumio.sdk.scanpart.JumioScanPart r3) {
            /*
                r2 = this;
                com.jumio.sdk.credentials.JumioCredential r0 = r2.f55078a
                r0.f55076d = r3
                com.jumio.sdk.credentials.JumioCredential r3 = r2.f55078a
                com.jumio.sdk.scanpart.JumioScanPart r0 = r3.f55076d
                r3.setActiveScanPart$jumio_core_release(r0)
                com.jumio.sdk.credentials.JumioCredential r3 = r2.f55078a
                jumio.core.l r3 = r3.getData$jumio_core_release()
                com.jumio.sdk.credentials.JumioCredential r0 = r2.f55078a
                com.jumio.sdk.scanpart.JumioScanPart r0 = r0.f55076d
                r1 = 0
                if (r0 != 0) goto L_0x001e
                goto L_0x0024
            L_0x001e:
                com.jumio.core.scanpart.ScanPart r0 = r0.getScanPart$jumio_core_release()
                if (r0 != 0) goto L_0x0026
            L_0x0024:
                r0 = r1
                goto L_0x002a
            L_0x0026:
                com.jumio.core.models.ScanPartModel r0 = r0.getScanPartModel()
            L_0x002a:
                r3.mo175830a((com.jumio.core.models.ScanPartModel) r0)
                com.jumio.sdk.credentials.JumioCredential r3 = r2.f55078a
                jumio.core.l r3 = r3.getData$jumio_core_release()
                com.jumio.sdk.credentials.JumioCredential r0 = r2.f55078a
                com.jumio.sdk.scanpart.JumioScanPart r0 = r0.getActiveScanPart$jumio_core_release()
                if (r0 != 0) goto L_0x003c
                goto L_0x004e
            L_0x003c:
                com.jumio.core.scanpart.ScanPart r0 = r0.getScanPart$jumio_core_release()
                if (r0 != 0) goto L_0x0043
                goto L_0x004e
            L_0x0043:
                com.jumio.core.models.ScanPartModel r0 = r0.getScanPartModel()
                if (r0 != 0) goto L_0x004a
                goto L_0x004e
            L_0x004a:
                com.jumio.sdk.enums.JumioScanSide r1 = r0.getSide()
            L_0x004e:
                r3.mo175831a((com.jumio.sdk.enums.JumioScanSide) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.sdk.credentials.JumioCredential.C20098a.mo163560a(com.jumio.sdk.scanpart.JumioScanPart):void");
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163560a((JumioScanPart) obj);
            return Unit.INSTANCE;
        }
    }

    public JumioCredential(Controller controller, C21365l lVar) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(lVar, "data");
        this.f55073a = controller;
        this.f55074b = lVar;
    }

    public void cancel() throws SDKNotConfiguredException {
        if (this.f55077e) {
            JumioScanPart jumioScanPart = this.f55075c;
            if (jumioScanPart != null) {
                jumioScanPart.cancel();
            }
            ((C21360j0) this.f55073a.getDataManager().get(C21360j0.class)).mo175818b(getData$jumio_core_release().mo175835e());
            this.f55073a.finishCredential$jumio_core_release(this);
            this.f55077e = false;
            ((C21360j0) this.f55073a.getDataManager().get(C21360j0.class)).mo175816a(this.f55074b.mo175835e());
            Analytics.Companion.add(MobileEvents.userAction$default("cancel_credential", (JumioScanStep) null, this.f55074b.mo175835e(), 2, (Object) null));
            return;
        }
        throw new SDKNotConfiguredException("Credential is not active".toString());
    }

    public void finish() throws SDKNotConfiguredException, IllegalArgumentException {
        if (!this.f55077e) {
            throw new SDKNotConfiguredException("Credential is not active".toString());
        } else if (isComplete()) {
            this.f55073a.finishCredential$jumio_core_release(this);
            this.f55077e = false;
            ((C21360j0) this.f55073a.getDataManager().get(C21360j0.class)).mo175816a(this.f55074b.mo175835e());
            Analytics.Companion.add(MobileEvents.userAction$default("finish_credential", (JumioScanStep) null, this.f55074b.mo175835e(), 2, (Object) null));
        } else {
            throw new IllegalArgumentException("Workflow is not completed".toString());
        }
    }

    public final synchronized void finishScanPart$jumio_core_release(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        JumioScanPart jumioScanPart2 = this.f55075c;
        if (jumioScanPart == jumioScanPart2) {
            if (jumioScanPart2 != null) {
                ScanPart<?> scanPart$jumio_core_release = jumioScanPart2.getScanPart$jumio_core_release();
                if (scanPart$jumio_core_release != null) {
                    scanPart$jumio_core_release.checkForAddon(new C20098a(this));
                }
            }
        }
    }

    public final JumioScanPart getActiveScanPart$jumio_core_release() {
        return this.f55075c;
    }

    public final JumioScanPart getAddonPart() {
        return this.f55076d;
    }

    public final Controller getController$jumio_core_release() {
        return this.f55073a;
    }

    public final C21365l getData$jumio_core_release() {
        return this.f55074b;
    }

    public final ArrayList<JumioScanSide> getScanSides() {
        return new ArrayList<>(this.f55074b.mo175836f().keySet());
    }

    public abstract JumioScanPart initScanPart(JumioScanSide jumioScanSide, JumioScanPartInterface jumioScanPartInterface);

    public final boolean isComplete() {
        return this.f55074b.mo175837g();
    }

    public abstract boolean isConfigured();

    public final boolean isValid() {
        return this.f55077e;
    }

    public final void persist$jumio_core_release() {
        ScanPart<?> scanPart$jumio_core_release;
        JumioScanPart jumioScanPart = this.f55075c;
        if (jumioScanPart != null && (scanPart$jumio_core_release = jumioScanPart.getScanPart$jumio_core_release()) != null) {
            scanPart$jumio_core_release.persist();
        }
    }

    public final void setActiveScanPart$jumio_core_release(JumioScanPart jumioScanPart) {
        this.f55075c = jumioScanPart;
    }

    public final void setValid(boolean z) {
        this.f55077e = z;
    }

    public void start$jumio_core_release() {
        ((C21360j0) this.f55073a.getDataManager().get(C21360j0.class)).mo175820c(this.f55074b.mo175835e());
        Analytics.Companion.add(MobileEvents.userAction$default("start_credential", (JumioScanStep) null, this.f55074b.mo175835e(), 2, (Object) null));
    }
}
