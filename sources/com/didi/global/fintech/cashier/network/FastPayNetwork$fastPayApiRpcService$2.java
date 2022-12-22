package com.didi.global.fintech.cashier.network;

import com.didi.global.fintech.cashier.network.api.FastPayApiRpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/api/FastPayApiRpcService;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetwork.kt */
final class FastPayNetwork$fastPayApiRpcService$2 extends Lambda implements Function0<FastPayApiRpcService> {
    final /* synthetic */ FastPayNetwork this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayNetwork$fastPayApiRpcService$2(FastPayNetwork fastPayNetwork) {
        super(0);
        this.this$0 = fastPayNetwork;
    }

    public final FastPayApiRpcService invoke() {
        return (FastPayApiRpcService) new RpcServiceFactory(this.this$0.f21632a).newRpcService(FastPayApiRpcService.class, Url.CASHIER_BASE_URL);
    }
}
