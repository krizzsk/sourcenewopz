package com.wallet.flutter.wallet_flutter.http;

import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import java.io.IOException;
import kotlin.Metadata;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/http/WalletFlutterHttpChannel$getCallback$1", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpc$Callback;", "onFailure", "", "request", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "e", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterHttpChannel.kt */
public final class WalletFlutterHttpChannel$getCallback$1 implements HttpRpc.Callback {
    final /* synthetic */ MethodChannel.Result $result;
    final /* synthetic */ WalletFlutterHttpChannel this$0;

    WalletFlutterHttpChannel$getCallback$1(WalletFlutterHttpChannel walletFlutterHttpChannel, MethodChannel.Result result) {
        this.this$0 = walletFlutterHttpChannel;
        this.$result = result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r10) {
        /*
            r9 = this;
            java.lang.String r0 = "data"
            if (r10 != 0) goto L_0x0012
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel r1 = r9.this$0
            io.flutter.plugin.common.MethodChannel$Result r2 = r9.$result
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = "response is null"
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel.onFail$default(r1, r2, r3, r4, r5, r6)
            goto L_0x0115
        L_0x0012:
            boolean r1 = r10.isSuccessful()
            if (r1 != 0) goto L_0x0028
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel r2 = r9.this$0
            io.flutter.plugin.common.MethodChannel$Result r3 = r9.$result
            java.lang.String r4 = r10.getReason()
            r5 = 0
            r6 = 4
            r7 = 0
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel.onFail$default(r2, r3, r4, r5, r6, r7)
            goto L_0x0115
        L_0x0028:
            com.wallet.flutter.wallet_flutter.base.FlutterHelper$Companion r1 = com.wallet.flutter.wallet_flutter.base.FlutterHelper.Companion     // Catch:{ Exception -> 0x0106 }
            com.google.gson.Gson r1 = r1.getGson()     // Catch:{ Exception -> 0x0106 }
            com.didichuxing.foundation.net.http.HttpEntity r2 = r10.getEntity()     // Catch:{ Exception -> 0x0106 }
            java.io.InputStream r2 = r2.getContent()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = "response.entity.content"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0106 }
            byte[] r2 = kotlin.p245io.ByteStreamsKt.readBytes(r2)     // Catch:{ Exception -> 0x0106 }
            com.didichuxing.foundation.net.http.HttpEntity r10 = r10.getEntity()     // Catch:{ Exception -> 0x0106 }
            java.nio.charset.Charset r10 = r10.getCharset()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = "response.entity.charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0106 }
            r3.<init>(r2, r10)     // Catch:{ Exception -> 0x0106 }
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1$onSuccess$1 r10 = new com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1$onSuccess$1     // Catch:{ Exception -> 0x0106 }
            r10.<init>()     // Catch:{ Exception -> 0x0106 }
            java.lang.reflect.Type r10 = r10.getType()     // Catch:{ Exception -> 0x0106 }
            java.lang.Object r10 = r1.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r10)     // Catch:{ Exception -> 0x0106 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Exception -> 0x0106 }
            if (r10 != 0) goto L_0x0070
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel r1 = r9.this$0     // Catch:{ Exception -> 0x0106 }
            io.flutter.plugin.common.MethodChannel$Result r2 = r9.$result     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = "Gson format with null"
            r4 = 0
            r5 = 4
            r6 = 0
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel.onFail$default(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0115
        L_0x0070:
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel r1 = r9.this$0     // Catch:{ Exception -> 0x0106 }
            io.flutter.plugin.common.MethodChannel$Result r2 = r9.$result     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = "errno"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ Exception -> 0x0106 }
            boolean r4 = r3 instanceof java.lang.Number     // Catch:{ Exception -> 0x0106 }
            r5 = 0
            if (r4 == 0) goto L_0x0082
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x0106 }
            goto L_0x0083
        L_0x0082:
            r3 = r5
        L_0x0083:
            if (r3 != 0) goto L_0x0087
            r3 = -1
            goto L_0x008b
        L_0x0087:
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0106 }
        L_0x008b:
            java.lang.String r4 = "errmsg"
            java.lang.Object r4 = r10.get(r4)     // Catch:{ Exception -> 0x0106 }
            boolean r6 = r4 instanceof java.lang.String     // Catch:{ Exception -> 0x0106 }
            if (r6 == 0) goto L_0x0098
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0106 }
            goto L_0x0099
        L_0x0098:
            r4 = r5
        L_0x0099:
            if (r4 != 0) goto L_0x009d
            java.lang.String r4 = ""
        L_0x009d:
            if (r3 == 0) goto L_0x00a3
            r1.onFail(r2, r4, r3)     // Catch:{ Exception -> 0x0106 }
            return
        L_0x00a3:
            com.wallet.flutter.wallet_flutter.base.FlutterHelper$Companion r1 = com.wallet.flutter.wallet_flutter.base.FlutterHelper.Companion     // Catch:{ Exception -> 0x0106 }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0106 }
            android.os.Looper r7 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0106 }
            java.lang.Thread r7 = r7.getThread()     // Catch:{ Exception -> 0x0106 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0106 }
            if (r6 == 0) goto L_0x00f7
            r1 = 4
            kotlin.Pair[] r1 = new kotlin.Pair[r1]     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "platformError"
            r7 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r7)     // Catch:{ Exception -> 0x0106 }
            kotlin.Pair r6 = kotlin.TuplesKt.m42317to(r6, r8)     // Catch:{ Exception -> 0x0106 }
            r1[r7] = r6     // Catch:{ Exception -> 0x0106 }
            r6 = 1
            java.lang.String r7 = "errorCode"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0106 }
            kotlin.Pair r3 = kotlin.TuplesKt.m42317to(r7, r3)     // Catch:{ Exception -> 0x0106 }
            r1[r6] = r3     // Catch:{ Exception -> 0x0106 }
            r3 = 2
            java.lang.String r6 = "errorMsg"
            kotlin.Pair r4 = kotlin.TuplesKt.m42317to(r6, r4)     // Catch:{ Exception -> 0x0106 }
            r1[r3] = r4     // Catch:{ Exception -> 0x0106 }
            r3 = 3
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Exception -> 0x0106 }
            boolean r4 = r10 instanceof java.util.Map     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x00e9
            r5 = r10
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0106 }
        L_0x00e9:
            kotlin.Pair r10 = kotlin.TuplesKt.m42317to(r0, r5)     // Catch:{ Exception -> 0x0106 }
            r1[r3] = r10     // Catch:{ Exception -> 0x0106 }
            java.util.Map r10 = kotlin.collections.MapsKt.mutableMapOf(r1)     // Catch:{ Exception -> 0x0106 }
            r2.success(r10)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0105
        L_0x00f7:
            android.os.Handler r0 = r1.getHandler()     // Catch:{ Exception -> 0x0106 }
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1$onSuccess$lambda-1$$inlined$runOnMain$1 r1 = new com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1$onSuccess$lambda-1$$inlined$runOnMain$1     // Catch:{ Exception -> 0x0106 }
            r1.<init>(r2, r3, r4, r10)     // Catch:{ Exception -> 0x0106 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ Exception -> 0x0106 }
            r0.post(r1)     // Catch:{ Exception -> 0x0106 }
        L_0x0105:
            return
        L_0x0106:
            r10 = move-exception
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel r0 = r9.this$0
            io.flutter.plugin.common.MethodChannel$Result r1 = r9.$result
            java.lang.String r2 = r10.getMessage()
            r3 = 0
            r4 = 4
            r5 = 0
            com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel.onFail$default(r0, r1, r2, r3, r4, r5)
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1.onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):void");
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
        WalletFlutterHttpChannel.onFail$default(this.this$0, this.$result, iOException == null ? null : iOException.getMessage(), 0, 4, (Object) null);
    }
}
