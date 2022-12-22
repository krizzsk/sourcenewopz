package com.didi.payment.pix.home;

import android.content.Intent;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/pix/home/PixChannelHomeActivity$initObserver$3$2", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "onResult", "result", "Lcom/didi/drouter/router/Result;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChannelHomeActivity.kt */
public final class PixChannelHomeActivity$initObserver$3$2 extends RouterCallback.ActivityCallback {
    final /* synthetic */ PixChannelHomeActivity this$0;

    PixChannelHomeActivity$initObserver$3$2(PixChannelHomeActivity pixChannelHomeActivity) {
        this.this$0 = pixChannelHomeActivity;
    }

    public void onActivityResult(int i, Intent intent) {
        PixChannelHomeActivity.access$getVm(this.this$0).refreshData(true);
    }

    public void onResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        super.onResult(result);
    }
}
