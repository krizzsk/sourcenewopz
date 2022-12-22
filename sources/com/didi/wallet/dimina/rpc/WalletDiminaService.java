package com.didi.wallet.dimina.rpc;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\b\u0001\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH'J.\u0010\u000b\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH'¨\u0006\r"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/WalletDiminaService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "checkAntiCheating", "", "params", "", "", "", "callBack", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity;", "preloadList", "Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity;", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Interception({RequestMonitorInterceptor.class})
@Timeout(connectTimeout = 30000)
/* compiled from: WalletDiminaRpc.kt */
public interface WalletDiminaService extends RpcService {
    @Get
    @Serialization(GsonSerializer.class)
    @Path("/api/v0/didipay/antiCheating")
    @Deserialization(GsonDeserializer.class)
    void checkAntiCheating(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AntiCheatingEntity> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/api/v1/home/get/appId")
    @Deserialization(GsonDeserializer.class)
    void preloadList(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PreLoadAppIdsEntity> callback);
}
