package com.didi.wallet.dimina.rpc;

import android.content.Context;
import com.didi.wallet.dimina.rpc.PreLoadAppIdsEntity;
import com.didi.wallet.dimina.util.WalletDiminaUtilKt;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/wallet/dimina/rpc/WalletPreLoad$loadPreLoadList$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletPreLoad.kt */
public final class WalletPreLoad$loadPreLoadList$1 implements RpcService.Callback<PreLoadAppIdsEntity> {
    final /* synthetic */ Context $context;
    final /* synthetic */ WalletPreLoad this$0;

    WalletPreLoad$loadPreLoadList$1(WalletPreLoad walletPreLoad, Context context) {
        this.this$0 = walletPreLoad;
        this.$context = context;
    }

    public void onSuccess(PreLoadAppIdsEntity preLoadAppIdsEntity) {
        PreLoadAppIdsEntity.PreLoadAppIdEntity data;
        List<String> appIds;
        PreLoadAppIdsEntity.PreLoadAppIdEntity data2;
        List<String> appIds2;
        Integer num = null;
        if (!(preLoadAppIdsEntity == null || (data2 = preLoadAppIdsEntity.getData()) == null || (appIds2 = data2.getAppIds()) == null)) {
            num = Integer.valueOf(appIds2.size());
        }
        WalletDiminaUtilKt.logWD(Intrinsics.stringPlus("preLoad appIds size = ", num));
        if (preLoadAppIdsEntity != null && (data = preLoadAppIdsEntity.getData()) != null && (appIds = data.getAppIds()) != null) {
            WalletPreLoad walletPreLoad = this.this$0;
            Context context = this.$context;
            for (String str : appIds) {
                walletPreLoad.m32453a(context, str);
                WalletDiminaUtilKt.logWD(Intrinsics.stringPlus("preLoad appId = ", str));
            }
        }
    }

    public void onFailure(IOException iOException) {
        WalletDiminaUtilKt.logWD(Intrinsics.stringPlus("preLoad fail exception = ", iOException));
    }
}
