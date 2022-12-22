package com.didi.payment.pix.qrcode.p138vm;

import android.text.TextUtils;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.net.response.PixQrChannelResp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/pix/qrcode/vm/PixQrChannelVM$loadData$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/pix/net/response/PixQrChannelResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.qrcode.vm.PixQrChannelVM$loadData$1 */
/* compiled from: PixQrChannelVM.kt */
public final class PixQrChannelVM$loadData$1 extends WNetCallback<PixQrChannelResp> {
    final /* synthetic */ PixQrChannelVM this$0;

    PixQrChannelVM$loadData$1(PixQrChannelVM pixQrChannelVM) {
        this.this$0 = pixQrChannelVM;
    }

    public void onSuccess(PixQrChannelResp pixQrChannelResp) {
        Intrinsics.checkNotNullParameter(pixQrChannelResp, "value");
        super.onSuccess(pixQrChannelResp);
        if (pixQrChannelResp.errno == 0) {
            this.this$0.getQrChannel().postValue(pixQrChannelResp.getData());
        } else {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), pixQrChannelResp.errmsg);
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        if (iOException != null && TextUtils.isEmpty(iOException.getMessage())) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), iOException.getMessage());
        }
    }

    public void onComplete() {
        super.onComplete();
        this.this$0.isLoading().setValue(false);
    }

    public void onStart() {
        super.onStart();
        this.this$0.isLoading().setValue(true);
    }
}
