package com.didi.payment.wallet.password;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.commonsdk.net.WNetModel;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/wallet/password/CertificationRequest;", "Lcom/didi/payment/commonsdk/net/WNetModel;", "Lcom/didi/payment/wallet/password/CertificationRequest$CertificationRpcService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkAccountStatus", "", "callBack", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/password/FullKycStatus;", "CertificationRpcService", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CertificationRequest.kt */
public final class CertificationRequest extends WNetModel<CertificationRpcService> {

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0001\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/wallet/password/CertificationRequest$CertificationRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "checkAccountStatus", "", "params", "", "", "callBack", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/password/FullKycStatus;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: CertificationRequest.kt */
    public interface CertificationRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/status")
        @Deserialization(GsonDeserializer.class)
        Object checkAccountStatus(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<FullKycStatus> callback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CertificationRequest(Context context) {
        super(context, CertificationRpcService.class);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void checkAccountStatus(RpcService.Callback<FullKycStatus> callback) {
        Intrinsics.checkNotNullParameter(callback, "callBack");
        ((CertificationRpcService) getService()).checkAccountStatus(getCommonParam(getContext()), callback);
    }
}
