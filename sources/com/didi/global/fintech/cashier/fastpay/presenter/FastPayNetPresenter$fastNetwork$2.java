package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.network.FastPayNetwork;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/FastPayNetwork;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetPresenter.kt */
final class FastPayNetPresenter$fastNetwork$2 extends Lambda implements Function0<FastPayNetwork> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayNetPresenter$fastNetwork$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final FastPayNetwork invoke() {
        return (FastPayNetwork) FastPayNetwork.Companion.getInstance(this.$context);
    }
}
