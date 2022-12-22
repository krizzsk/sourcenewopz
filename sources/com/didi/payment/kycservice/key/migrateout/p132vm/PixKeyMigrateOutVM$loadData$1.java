package com.didi.payment.kycservice.key.migrateout.p132vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM$loadData$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.migrateout.vm.PixKeyMigrateOutVM$loadData$1 */
/* compiled from: PixKeyMigrateOutVM.kt */
public final class PixKeyMigrateOutVM$loadData$1 extends WNetCallback<PixKeyMigrateOutListResp> {
    final /* synthetic */ PixKeyMigrateOutVM this$0;

    PixKeyMigrateOutVM$loadData$1(PixKeyMigrateOutVM pixKeyMigrateOutVM) {
        this.this$0 = pixKeyMigrateOutVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isNetError().setValue(true);
    }

    public void onSuccess(PixKeyMigrateOutListResp pixKeyMigrateOutListResp) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutListResp, "response");
        super.onSuccess(pixKeyMigrateOutListResp);
        if (pixKeyMigrateOutListResp.getData() != null) {
            PixKeyMigrateOutListResp.Data data = pixKeyMigrateOutListResp.getData();
            Intrinsics.checkNotNull(data);
            if (data.getItems() != null) {
                PixKeyMigrateOutVM pixKeyMigrateOutVM = this.this$0;
                PixKeyMigrateOutListResp.Data data2 = pixKeyMigrateOutListResp.getData();
                Intrinsics.checkNotNull(data2);
                pixKeyMigrateOutVM.setMigrateOutListData(data2);
                if (this.this$0.isFirstLoad()) {
                    this.this$0.setFirstLoad(false);
                    ArrayList<PixKeyMigrateOutListResp.KeyItem> items = this.this$0.getMigrateOutListData().getItems();
                    Intrinsics.checkNotNull(items);
                    int size = items.size();
                    if (size > 1) {
                        this.this$0.getPageSceneLD().setValue(100);
                        return;
                    } else if (size == 1) {
                        this.this$0.getPageSceneLD().setValue(101);
                        return;
                    } else {
                        return;
                    }
                } else {
                    this.this$0.getPageSceneLD().setValue(100);
                    return;
                }
            }
        }
        this.this$0.isNetError().setValue(true);
    }
}
