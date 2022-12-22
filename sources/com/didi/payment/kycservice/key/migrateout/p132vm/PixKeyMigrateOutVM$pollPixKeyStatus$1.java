package com.didi.payment.kycservice.key.migrateout.p132vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM$pollPixKeyStatus$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.migrateout.vm.PixKeyMigrateOutVM$pollPixKeyStatus$1 */
/* compiled from: PixKeyMigrateOutVM.kt */
public final class PixKeyMigrateOutVM$pollPixKeyStatus$1 extends WNetCallback<PollStatusResp> {
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ PixKeyMigrateOutVM this$0;

    PixKeyMigrateOutVM$pollPixKeyStatus$1(PixKeyMigrateOutVM pixKeyMigrateOutVM, int i, String str) {
        this.this$0 = pixKeyMigrateOutVM;
        this.$keyType = i;
        this.$keyVal = str;
    }

    public void onSuccess(PollStatusResp pollStatusResp) {
        Intrinsics.checkNotNullParameter(pollStatusResp, "response");
        super.onSuccess(pollStatusResp);
        if (pollStatusResp.errno != 60201) {
            this.this$0.isLoading().setValue(false);
            this.this$0.getMigrateOutRespLD().setValue(this.this$0.f30727h);
        } else if (this.this$0.f30725f <= 5) {
            this.this$0.f30726g.schedule(new Runnable(this.$keyType, this.$keyVal) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    PixKeyMigrateOutVM$pollPixKeyStatus$1.m46547onSuccess$lambda0(PixKeyMigrateOutVM.this, this.f$1, this.f$2);
                }
            }, 1, TimeUnit.SECONDS);
        } else {
            this.this$0.isLoading().setValue(false);
            this.this$0.getMigrateOutRespLD().setValue(pollStatusResp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m46547onSuccess$lambda0(PixKeyMigrateOutVM pixKeyMigrateOutVM, int i, String str) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutVM, "this$0");
        Intrinsics.checkNotNullParameter(str, "$keyVal");
        pixKeyMigrateOutVM.m21594a(i, str);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isLoading().setValue(false);
    }
}
