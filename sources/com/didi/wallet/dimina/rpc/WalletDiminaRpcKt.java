package com.didi.wallet.dimina.rpc;

import android.content.Context;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo175978d2 = {"walletDiminaRpcService", "Lcom/didi/wallet/dimina/rpc/WalletDiminaService;", "Landroid/content/Context;", "wallet-service-dimina_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaRpc.kt */
public final class WalletDiminaRpcKt {
    public static final WalletDiminaService walletDiminaRpcService(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        RpcService newRpcService = new RpcServiceFactory(context).newRpcService(WalletDiminaService.class, "https://wallet.didiglobal.com");
        Intrinsics.checkNotNullExpressionValue(newRpcService, "RpcServiceFactory(this).…let.didiglobal.com\"\n    )");
        return (WalletDiminaService) newRpcService;
    }
}
