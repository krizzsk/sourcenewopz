package global.didi.pay.threeds.network;

import android.util.Log;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcService;
import global.didi.pay.threeds.network.callback.ThreedsNetCallback;
import global.didi.pay.threeds.network.model.ThreedsBaseResponse;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0018\u00010\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo175978d2 = {"global/didi/pay/threeds/network/callback/ThreedsNetCallbackKt$getBaseResponseCallback$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lglobal/didi/pay/threeds/network/model/ThreedsBaseResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: global.didi.pay.threeds.network.ThreedsNetwork$channelInfo3DSVerify$$inlined$getBaseResponseCallback$1 */
/* compiled from: ThreedsNetCallback.kt */
public final class C20959x53dbf474 implements RpcService.CallbackV2<ThreedsBaseResponse<ThreedsCybsResultResponse>> {
    final /* synthetic */ ThreedsNetCallback $callback;

    public C20959x53dbf474(ThreedsNetCallback threedsNetCallback) {
        this.$callback = threedsNetCallback;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy<global.didi.pay.threeds.network.model.ThreedsBaseResponse<global.didi.pay.threeds.network.model.ThreedsCybsResultResponse>> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000b
        L_0x0005:
            java.lang.Object r1 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r1 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r1
        L_0x000b:
            java.lang.String r2 = "onSuccess: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            java.lang.String r3 = "Arirus"
            android.util.Log.i(r3, r1)
            java.lang.Class<global.didi.pay.threeds.network.model.ThreedsCybsResultResponse> r1 = global.didi.pay.threeds.network.model.ThreedsCybsResultResponse.class
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            android.util.Log.i(r3, r1)
            r1 = 0
            if (r6 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            java.lang.Object r4 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r4 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r4
            if (r4 != 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            int r4 = r4.getErrNo()
            if (r4 != 0) goto L_0x0033
            r1 = 1
        L_0x0033:
            if (r1 != 0) goto L_0x007f
            global.didi.pay.threeds.network.callback.ThreedsNetCallback r1 = r5.$callback
            global.didi.pay.threeds.network.model.ThreedsError$Companion r2 = global.didi.pay.threeds.network.model.ThreedsError.Companion
            global.didi.pay.threeds.network.model.ThreedsError r2 = r2.getSERVER_ERROR()
            if (r6 != 0) goto L_0x0041
        L_0x003f:
            r3 = r0
            goto L_0x0052
        L_0x0041:
            java.lang.Object r3 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r3 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r3
            if (r3 != 0) goto L_0x004a
            goto L_0x003f
        L_0x004a:
            int r3 = r3.getErrNo()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0052:
            if (r3 != 0) goto L_0x0059
            int r3 = r2.getCode()
            goto L_0x005d
        L_0x0059:
            int r3 = r3.intValue()
        L_0x005d:
            r2.setCode(r3)
            if (r6 != 0) goto L_0x0063
            goto L_0x0070
        L_0x0063:
            java.lang.Object r6 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r6 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r6
            if (r6 != 0) goto L_0x006c
            goto L_0x0070
        L_0x006c:
            java.lang.String r0 = r6.getErrMsg()
        L_0x0070:
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = r2.getMessage()
        L_0x0076:
            r2.setMessage(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r1.onFailure(r2)
            goto L_0x00db
        L_0x007f:
            java.lang.Object r1 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r1 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r1
            if (r1 != 0) goto L_0x0089
            r1 = r0
            goto L_0x008d
        L_0x0089:
            java.lang.Object r1 = r1.getData()
        L_0x008d:
            if (r1 == 0) goto L_0x00c3
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Object r4 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r4 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r4
            if (r4 != 0) goto L_0x009e
            r4 = r0
            goto L_0x00a2
        L_0x009e:
            java.lang.Object r4 = r4.getData()
        L_0x00a2:
            java.lang.String r1 = r1.toJson((java.lang.Object) r4)
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
            android.util.Log.i(r3, r1)
            global.didi.pay.threeds.network.callback.ThreedsNetCallback r1 = r5.$callback
            java.lang.Object r6 = r6.getContent()
            global.didi.pay.threeds.network.model.ThreedsBaseResponse r6 = (global.didi.pay.threeds.network.model.ThreedsBaseResponse) r6
            if (r6 != 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            java.lang.Object r0 = r6.getData()
        L_0x00bc:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.onSuccess(r0)
            goto L_0x00db
        L_0x00c3:
            java.lang.String r6 = "NET_ERROR: XXXXXXXXXXXXXXXXXXXXXXX1"
            android.util.Log.i(r3, r6)
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>()
            r6.printStackTrace()
            global.didi.pay.threeds.network.callback.ThreedsNetCallback r6 = r5.$callback
            global.didi.pay.threeds.network.model.ThreedsError$Companion r0 = global.didi.pay.threeds.network.model.ThreedsError.Companion
            global.didi.pay.threeds.network.model.ThreedsError r0 = r0.getNET_ERROR()
            r6.onFailure(r0)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.threeds.network.C20959x53dbf474.onSuccess(com.didichuxing.foundation.rpc.RpcResponseProxy):void");
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
        this.$callback.onFailure(ThreedsError.Companion.getNET_ERROR());
    }
}
