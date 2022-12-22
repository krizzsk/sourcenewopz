package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/TempAndPermanentFreezeStrategy;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/IFreezeStrategy;", "()V", "executeStrategy", "", "status", "", "(Ljava/lang/Integer;)Z", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.TempAndPermanentFreezeStrategy */
/* compiled from: FreezeInterceptor.kt */
public final class TempAndPermanentFreezeStrategy implements IFreezeStrategy {
    public boolean executeStrategy(Integer num) {
        if (num != null && num.intValue() == 1) {
            return true;
        }
        if (num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }
}
