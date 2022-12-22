package com.didi.global.fintech.cashier.network;

import android.util.Log;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo175978d2 = {"com/didi/global/fintech/cashier/network/callback/CashierNetCallbackKt$getBaseResponseCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/global/fintech/cashier/model/net/response/CashierBaseResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierNetCallback.kt */
public final class CashierNetwork$getPayStatus$$inlined$getBaseResponseCallback$1 implements RpcService.CallbackV2<CashierBaseResponse<PayStatusResponse>> {
    final /* synthetic */ CashierNetCallback $callback;

    public CashierNetwork$getPayStatus$$inlined$getBaseResponseCallback$1(CashierNetCallback cashierNetCallback) {
        this.$callback = cashierNetCallback;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy<com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse<com.didi.global.fintech.cashier.model.net.response.PayStatusResponse>> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000b
        L_0x0005:
            java.lang.Object r1 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r1 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r1
        L_0x000b:
            java.lang.String r2 = "onSuccess: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.String r3 = "Arirus"
            android.util.Log.i(r3, r1)
            java.lang.Class<com.didi.global.fintech.cashier.model.net.response.PayStatusResponse> r1 = com.didi.global.fintech.cashier.model.net.response.PayStatusResponse.class
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            android.util.Log.i(r3, r1)
            r1 = 0
            if (r6 != 0) goto L_0x0024
            goto L_0x0034
        L_0x0024:
            java.lang.Object r4 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r4 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r4
            if (r4 != 0) goto L_0x002d
            goto L_0x0034
        L_0x002d:
            int r4 = r4.getErrno()
            if (r4 != 0) goto L_0x0034
            r1 = 1
        L_0x0034:
            if (r1 != 0) goto L_0x009a
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback r1 = r5.$callback
            com.didi.global.fintech.cashier.model.CashierError$Companion r2 = com.didi.global.fintech.cashier.model.CashierError.Companion
            com.didi.global.fintech.cashier.model.CashierError r2 = r2.getSERVER_ERROR()
            if (r6 != 0) goto L_0x0042
        L_0x0040:
            r3 = r0
            goto L_0x0053
        L_0x0042:
            java.lang.Object r3 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x004b
            goto L_0x0040
        L_0x004b:
            int r3 = r3.getErrno()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0053:
            if (r3 != 0) goto L_0x005a
            int r3 = r2.getCode()
            goto L_0x005e
        L_0x005a:
            int r3 = r3.intValue()
        L_0x005e:
            r2.setCode(r3)
            if (r6 != 0) goto L_0x0065
        L_0x0063:
            r3 = r0
            goto L_0x0072
        L_0x0065:
            java.lang.Object r3 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x006e
            goto L_0x0063
        L_0x006e:
            java.lang.String r3 = r3.getErrmsg()
        L_0x0072:
            if (r3 != 0) goto L_0x0078
            java.lang.String r3 = r2.getMessage()
        L_0x0078:
            r2.setMessage(r3)
            if (r6 != 0) goto L_0x007e
            goto L_0x008b
        L_0x007e:
            java.lang.Object r6 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r6 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r6
            if (r6 != 0) goto L_0x0087
            goto L_0x008b
        L_0x0087:
            java.lang.String r0 = r6.getErrtitle()
        L_0x008b:
            if (r0 != 0) goto L_0x0091
            java.lang.String r0 = r2.getTitle()
        L_0x0091:
            r2.setTitle(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r1.onFailure(r2)
            goto L_0x00f6
        L_0x009a:
            java.lang.Object r1 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r1 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r1
            if (r1 != 0) goto L_0x00a4
            r1 = r0
            goto L_0x00a8
        L_0x00a4:
            java.lang.Object r1 = r1.getData()
        L_0x00a8:
            if (r1 == 0) goto L_0x00de
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Object r4 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r4 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r4
            if (r4 != 0) goto L_0x00b9
            r4 = r0
            goto L_0x00bd
        L_0x00b9:
            java.lang.Object r4 = r4.getData()
        L_0x00bd:
            java.lang.String r1 = r1.toJson((java.lang.Object) r4)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            android.util.Log.i(r3, r1)
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback r1 = r5.$callback
            java.lang.Object r6 = r6.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r6 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r6
            if (r6 != 0) goto L_0x00d3
            goto L_0x00d7
        L_0x00d3:
            java.lang.Object r0 = r6.getData()
        L_0x00d7:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.onSuccess(r0)
            goto L_0x00f6
        L_0x00de:
            java.lang.String r6 = "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX1"
            android.util.Log.i(r3, r6)
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>()
            r6.printStackTrace()
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback r6 = r5.$callback
            com.didi.global.fintech.cashier.model.CashierError$Companion r0 = com.didi.global.fintech.cashier.model.CashierError.Companion
            com.didi.global.fintech.cashier.model.CashierError r0 = r0.getNET_ERROR()
            r6.onFailure(r0)
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.network.CashierNetwork$getPayStatus$$inlined$getBaseResponseCallback$1.onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy):void");
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        String str;
        Log.i("Arirus", "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX2");
        if (rpcRequest == null) {
            str = null;
        } else {
            str = rpcRequest.getUrl();
        }
        Log.i("Arirus", Intrinsics.stringPlus("NET_ERROR: ", str));
        if (iOException != null) {
            iOException.printStackTrace();
        }
        this.$callback.onFailure(CashierError.Companion.getNET_ERROR());
    }
}
