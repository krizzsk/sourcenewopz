package com.didi.global.fintech.cashier.network.callback;

import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/global/fintech/cashier/network/callback/CashierNetCallbackKt$getBaseResponseCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/global/fintech/cashier/model/net/response/CashierBaseResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierNetCallback.kt */
public final class CashierNetCallbackKt$getBaseResponseCallback$1 implements RpcService.CallbackV2<CashierBaseResponse<T>> {
    final /* synthetic */ CashierNetCallback<T> $callback;

    public CashierNetCallbackKt$getBaseResponseCallback$1(CashierNetCallback<T> cashierNetCallback) {
        this.$callback = cashierNetCallback;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy<com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse<T>> r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000b
        L_0x0005:
            java.lang.Object r1 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r1 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r1
        L_0x000b:
            java.lang.String r2 = "onSuccess: "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r6 = 0
            r8 = 26
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            r1 = 4
            java.lang.String r3 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r1, r3)
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r8 = 27
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            r1 = 0
            if (r10 != 0) goto L_0x0037
            goto L_0x0047
        L_0x0037:
            java.lang.Object r3 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x0040
            goto L_0x0047
        L_0x0040:
            int r3 = r3.getErrno()
            if (r3 != 0) goto L_0x0047
            r1 = 1
        L_0x0047:
            if (r1 != 0) goto L_0x00af
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback<T> r1 = r9.$callback
            com.didi.global.fintech.cashier.model.CashierError$Companion r2 = com.didi.global.fintech.cashier.model.CashierError.Companion
            com.didi.global.fintech.cashier.model.CashierError r2 = r2.getSERVER_ERROR()
            com.didi.global.fintech.cashier.model.CashierError r2 = (com.didi.global.fintech.cashier.model.CashierError) r2
            if (r10 != 0) goto L_0x0057
        L_0x0055:
            r3 = r0
            goto L_0x0068
        L_0x0057:
            java.lang.Object r3 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x0060
            goto L_0x0055
        L_0x0060:
            int r3 = r3.getErrno()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0068:
            if (r3 != 0) goto L_0x006f
            int r3 = r2.getCode()
            goto L_0x0073
        L_0x006f:
            int r3 = r3.intValue()
        L_0x0073:
            r2.setCode(r3)
            if (r10 != 0) goto L_0x007a
        L_0x0078:
            r3 = r0
            goto L_0x0087
        L_0x007a:
            java.lang.Object r3 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x0083
            goto L_0x0078
        L_0x0083:
            java.lang.String r3 = r3.getErrmsg()
        L_0x0087:
            if (r3 != 0) goto L_0x008d
            java.lang.String r3 = r2.getMessage()
        L_0x008d:
            r2.setMessage(r3)
            if (r10 != 0) goto L_0x0093
            goto L_0x00a0
        L_0x0093:
            java.lang.Object r10 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r10 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r10
            if (r10 != 0) goto L_0x009c
            goto L_0x00a0
        L_0x009c:
            java.lang.String r0 = r10.getErrtitle()
        L_0x00a0:
            if (r0 != 0) goto L_0x00a6
            java.lang.String r0 = r2.getTitle()
        L_0x00a6:
            r2.setTitle(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r1.onFailure(r2)
            goto L_0x011b
        L_0x00af:
            java.lang.Object r1 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r1 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r1
            if (r1 != 0) goto L_0x00b9
            r1 = r0
            goto L_0x00bd
        L_0x00b9:
            java.lang.Object r1 = r1.getData()
        L_0x00bd:
            if (r1 == 0) goto L_0x00fb
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Object r3 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r3 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r3
            if (r3 != 0) goto L_0x00ce
            r3 = r0
            goto L_0x00d2
        L_0x00ce:
            java.lang.Object r3 = r3.getData()
        L_0x00d2:
            java.lang.String r1 = r1.toJson((java.lang.Object) r3)
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r6 = 0
            r8 = 40
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback<T> r1 = r9.$callback
            java.lang.Object r10 = r10.getContent()
            com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse r10 = (com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse) r10
            if (r10 != 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            java.lang.Object r0 = r10.getData()
        L_0x00f4:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.onSuccess(r0)
            goto L_0x011b
        L_0x00fb:
            r2 = 4
            r5 = 0
            r7 = 44
            java.lang.String r3 = "Arirus"
            java.lang.String r4 = "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX1"
            java.lang.String r6 = "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            r10.<init>()
            r10.printStackTrace()
            com.didi.global.fintech.cashier.network.callback.CashierNetCallback<T> r10 = r9.$callback
            com.didi.global.fintech.cashier.model.CashierError$Companion r0 = com.didi.global.fintech.cashier.model.CashierError.Companion
            com.didi.global.fintech.cashier.model.CashierError r0 = r0.getNET_ERROR()
            r10.onFailure(r0)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1.onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy):void");
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        String str;
        SystemUtils.log(4, "Arirus", "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX2", (Throwable) null, "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1", 54);
        if (rpcRequest == null) {
            str = null;
        } else {
            str = rpcRequest.getUrl();
        }
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("NET_ERROR: ", str), (Throwable) null, "com.didi.global.fintech.cashier.network.callback.CashierNetCallbackKt$getBaseResponseCallback$1", 55);
        if (iOException != null) {
            iOException.printStackTrace();
        }
        this.$callback.onFailure(CashierError.Companion.getNET_ERROR());
    }
}
