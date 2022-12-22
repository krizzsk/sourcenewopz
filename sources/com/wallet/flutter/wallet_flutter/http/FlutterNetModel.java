package com.wallet.flutter.wallet_flutter.http;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.commonsdk.net.WNetModel;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J4\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0011"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/http/FlutterNetModel;", "Lcom/didi/payment/commonsdk/net/WNetModel;", "Lcom/wallet/flutter/wallet_flutter/http/FlutterNetModel$FlutterNetService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createPixTopUpOrder", "", "map", "Ljava/util/HashMap;", "", "", "passwordToken", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/wallet/flutter/wallet_flutter/http/PixOrderCreateRespEntity;", "FlutterNetService", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterNetModel.kt */
public final class FlutterNetModel extends WNetModel<FlutterNetService> {

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'¨\u0006\u000b"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/http/FlutterNetModel$FlutterNetService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "orderCreate", "", "commonParam", "Ljava/util/HashMap;", "", "bodyParam", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/wallet/flutter/wallet_flutter/http/PixOrderCreateRespEntity;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: FlutterNetModel.kt */
    public interface FlutterNetService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object orderCreate(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixOrderCreateRespEntity> callback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterNetModel(Context context) {
        super(context, FlutterNetService.class);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void createPixTopUpOrder$default(FlutterNetModel flutterNetModel, HashMap hashMap, String str, RpcService.Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        flutterNetModel.createPixTopUpOrder(hashMap, str, callback);
    }

    public final void createPixTopUpOrder(HashMap<String, Object> hashMap, String str, RpcService.Callback<PixOrderCreateRespEntity> callback) {
        Intrinsics.checkNotNullParameter(hashMap, "map");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (str != null) {
            hashMap.put("passwordToken", str);
        }
        hashMap.put("orderType", 0);
        ((FlutterNetService) getService()).orderCreate(getCommonParam(getContext()), hashMap, callback);
    }
}
