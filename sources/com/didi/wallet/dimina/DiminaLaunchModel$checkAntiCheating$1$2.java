package com.didi.wallet.dimina;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.payment.base.utils.WalletToast;
import com.didi.wallet.dimina.rpc.AntiCheatingEntity;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/wallet/dimina/DiminaLaunchModel$checkAntiCheating$1$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiminaLaunchModel.kt */
public final class DiminaLaunchModel$checkAntiCheating$1$2 implements RpcService.Callback<AntiCheatingEntity> {
    final /* synthetic */ Function1<Boolean, Unit> $launchEvent;
    final /* synthetic */ Fragment $this_apply;

    DiminaLaunchModel$checkAntiCheating$1$2(Function1<? super Boolean, Unit> function1, Fragment fragment) {
        this.$launchEvent = function1;
        this.$this_apply = fragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r3.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.wallet.dimina.rpc.AntiCheatingEntity r3) {
        /*
            r2 = this;
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1 = 0
            if (r3 != 0) goto L_0x000a
        L_0x0008:
            r3 = 0
            goto L_0x0019
        L_0x000a:
            com.didi.wallet.dimina.rpc.AntiCheatingEntity$AntiCheatingDataEntity r3 = r3.getData()
            if (r3 != 0) goto L_0x0011
            goto L_0x0008
        L_0x0011:
            java.lang.Boolean r3 = r3.getAccessFlag()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
        L_0x0019:
            if (r3 == 0) goto L_0x0021
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r2.$launchEvent
            r3.invoke(r0)
            goto L_0x003d
        L_0x0021:
            androidx.fragment.app.Fragment r3 = r2.$this_apply
            android.content.Context r3 = r3.getContext()
            if (r3 != 0) goto L_0x002a
            goto L_0x0034
        L_0x002a:
            r0 = 2131955391(0x7f130ebf, float:1.9547308E38)
            java.lang.String r0 = r3.getString(r0)
            com.didi.payment.base.utils.WalletToast.showFailedMsg(r3, r0)
        L_0x0034:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r2.$launchEvent
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r3.invoke(r0)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.wallet.dimina.DiminaLaunchModel$checkAntiCheating$1$2.onSuccess(com.didi.wallet.dimina.rpc.AntiCheatingEntity):void");
    }

    public void onFailure(IOException iOException) {
        String message;
        Context context;
        if (!(iOException == null || (message = iOException.getMessage()) == null || (context = this.$this_apply.getContext()) == null)) {
            WalletToast.showFailedMsg(context, message);
        }
        this.$launchEvent.invoke(false);
    }
}
