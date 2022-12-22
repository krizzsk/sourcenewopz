package com.didi.payment.kycservice.key.create.p131vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.key.create.response.PixKeyCreateResp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/vm/CreateKeyByCpfVM$create$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CreateKeyByCpfVM$create$1 */
/* compiled from: CreateKeyByCpfVM.kt */
public final class CreateKeyByCpfVM$create$1 extends WNetCallback<PixKeyCreateResp> {
    final /* synthetic */ CreateKeyByCpfVM this$0;

    CreateKeyByCpfVM$create$1(CreateKeyByCpfVM createKeyByCpfVM) {
        this.this$0 = createKeyByCpfVM;
    }

    public void onStart() {
        super.onStart();
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        super.onComplete();
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(PixKeyCreateResp pixKeyCreateResp) {
        Intrinsics.checkNotNullParameter(pixKeyCreateResp, "response");
        super.onSuccess(pixKeyCreateResp);
        this.this$0.isFinish().setValue(true);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isNetError().setValue(true);
    }
}
