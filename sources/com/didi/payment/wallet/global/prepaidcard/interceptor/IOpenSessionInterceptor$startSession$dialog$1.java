package com.didi.payment.wallet.global.prepaidcard.interceptor;

import android.view.View;
import com.didi.payment.wallet.global.wallet.view.widget.ICommonBottomListener;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/prepaidcard/interceptor/IOpenSessionInterceptor$startSession$dialog$1", "Lcom/didi/payment/wallet/global/wallet/view/widget/ICommonBottomListener;", "onCancelClick", "", "v", "Landroid/view/View;", "onConfirmClick", "", "(Landroid/view/View;)Ljava/lang/Boolean;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IOpenSessionInterceptor.kt */
public final class IOpenSessionInterceptor$startSession$dialog$1 implements ICommonBottomListener {
    public void onCancelClick(View view) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
    }

    IOpenSessionInterceptor$startSession$dialog$1() {
    }

    public Boolean onConfirmClick(View view) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        return true;
    }
}
