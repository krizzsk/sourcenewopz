package com.didi.payment.wallet.global.riskcontrol;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.riskcontrol.resp.FaceResultResp;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/RiskControlModel;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "service", "Lcom/didi/payment/wallet/global/riskcontrol/RiskControlModel$RiskControlService;", "getCommonParam", "Ljava/util/HashMap;", "", "getFaceResult", "Lcom/didi/payment/wallet/global/riskcontrol/resp/FaceResultResp;", "sessionId", "scene", "RiskControlService", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskControlModel.kt */
public final class RiskControlModel {

    /* renamed from: a */
    private Context f31786a;

    /* renamed from: b */
    private RiskControlService f31787b;

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\ba\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0018\b\u0001\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005H'¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/RiskControlModel$RiskControlService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "queryFaceResult", "Lcom/didi/payment/wallet/global/riskcontrol/resp/FaceResultResp;", "params", "", "", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: RiskControlModel.kt */
    public interface RiskControlService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/face/result")
        @Deserialization(GsonDeserializer.class)
        FaceResultResp queryFaceResult(@QueryParameter("") Map<String, ? extends Object> map);
    }

    public RiskControlModel(Context context) {
        Context context2;
        if (context == null) {
            context2 = null;
        } else {
            context2 = context.getApplicationContext();
        }
        this.f31786a = context2;
        this.f31787b = (RiskControlService) new RpcServiceFactory(context).newRpcService(RiskControlService.class, "https://wallet.didiglobal.com");
    }

    /* renamed from: a */
    private final HashMap<String, Object> m22542a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public final FaceResultResp getFaceResult(String str, String str2) {
        HashMap<String, Object> a = m22542a(this.f31786a);
        if (a != null) {
            a.put("sessionId", str);
        }
        if (a != null) {
            a.put("scene", str2);
        }
        RiskControlService riskControlService = this.f31787b;
        if (riskControlService == null) {
            return null;
        }
        return riskControlService.queryFaceResult(a);
    }
}
