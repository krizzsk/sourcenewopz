package global.didi.pay.threeds.network.callback;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcService;
import global.didi.pay.threeds.network.model.ThreedsBaseResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"global/didi/pay/threeds/network/callback/ThreedsNetCallbackKt$getBaseResponseCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsNetCallback.kt */
public final class ThreedsNetCallbackKt$getBaseResponseCallback$1 implements RpcService.CallbackV2<ThreedsBaseResponse<T>> {
    final /* synthetic */ ThreedsNetCallback<T> $callback;

    public ThreedsNetCallbackKt$getBaseResponseCallback$1(ThreedsNetCallback<T> threedsNetCallback) {
        this.$callback = threedsNetCallback;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy<global.didi.pay.threeds.network.model.ThreedsBaseResponse<T>> r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000b
        L_0x0005:
            java.lang.Object r1 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r1 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r1
        L_0x000b:
            java.lang.String r2 = "onSuccess: "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r6 = 0
            r8 = 26
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            r1 = 4
            java.lang.String r3 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r1, r3)
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r8 = 27
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            r1 = 0
            if (r10 != 0) goto L_0x0036
            goto L_0x0046
        L_0x0036:
            java.lang.Object r3 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r3 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r3
            if (r3 != 0) goto L_0x003f
            goto L_0x0046
        L_0x003f:
            int r3 = r3.getErrNo()
            if (r3 != 0) goto L_0x0046
            r1 = 1
        L_0x0046:
            if (r1 != 0) goto L_0x0094
            global.didi.pay.threeds.network.callback.ThreedsNetCallback<T> r1 = r9.$callback
            global.didi.pay.threeds.network.model.ThreedsError$Companion r2 = global.didi.pay.threeds.network.model.ThreedsError.Companion
            global.didi.pay.threeds.network.model.ThreedsError r2 = r2.getSERVER_ERROR()
            global.didi.pay.threeds.network.model.ThreedsError r2 = (global.didi.pay.threeds.network.model.ThreedsError) r2
            if (r10 != 0) goto L_0x0056
        L_0x0054:
            r3 = r0
            goto L_0x0067
        L_0x0056:
            java.lang.Object r3 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r3 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r3
            if (r3 != 0) goto L_0x005f
            goto L_0x0054
        L_0x005f:
            int r3 = r3.getErrNo()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0067:
            if (r3 != 0) goto L_0x006e
            int r3 = r2.getCode()
            goto L_0x0072
        L_0x006e:
            int r3 = r3.intValue()
        L_0x0072:
            r2.setCode(r3)
            if (r10 != 0) goto L_0x0078
            goto L_0x0085
        L_0x0078:
            java.lang.Object r10 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r10 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r10
            if (r10 != 0) goto L_0x0081
            goto L_0x0085
        L_0x0081:
            java.lang.String r0 = r10.getErrMsg()
        L_0x0085:
            if (r0 != 0) goto L_0x008b
            java.lang.String r0 = r2.getMessage()
        L_0x008b:
            r2.setMessage(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r1.onFailure(r2)
            goto L_0x0100
        L_0x0094:
            java.lang.Object r1 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r1 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r1
            if (r1 != 0) goto L_0x009e
            r1 = r0
            goto L_0x00a2
        L_0x009e:
            java.lang.Object r1 = r1.getData()
        L_0x00a2:
            if (r1 == 0) goto L_0x00e0
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Object r3 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r3 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r3
            if (r3 != 0) goto L_0x00b3
            r3 = r0
            goto L_0x00b7
        L_0x00b3:
            java.lang.Object r3 = r3.getData()
        L_0x00b7:
            java.lang.String r1 = r1.toJson((java.lang.Object) r3)
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            r3 = 4
            r6 = 0
            r8 = 39
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            global.didi.pay.threeds.network.callback.ThreedsNetCallback<T> r1 = r9.$callback
            java.lang.Object r10 = r10.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r10 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r10
            if (r10 != 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            java.lang.Object r0 = r10.getData()
        L_0x00d9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.onSuccess(r0)
            goto L_0x0100
        L_0x00e0:
            r2 = 4
            r5 = 0
            r7 = 43
            java.lang.String r3 = "Arirus"
            java.lang.String r4 = "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX1"
            java.lang.String r6 = "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            r10.<init>()
            r10.printStackTrace()
            global.didi.pay.threeds.network.callback.ThreedsNetCallback<T> r10 = r9.$callback
            global.didi.pay.threeds.network.model.ThreedsError$Companion r0 = global.didi.pay.threeds.network.model.ThreedsError.Companion
            global.didi.pay.threeds.network.model.ThreedsError r0 = r0.getNET_ERROR()
            r10.onFailure(r0)
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1.onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy):void");
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        String str;
        SystemUtils.log(4, "Arirus", "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX2", (Throwable) null, "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1", 53);
        if (rpcRequest == null) {
            str = null;
        } else {
            str = rpcRequest.getUrl();
        }
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("NET_ERROR: ", str), (Throwable) null, "global.didi.pay.threeds.network.callback.ThreedsNetCallbackKt$getBaseResponseCallback$1", 54);
        if (iOException != null) {
            iOException.printStackTrace();
        }
        this.$callback.onFailure(ThreedsError.Companion.getNET_ERROR());
    }
}
