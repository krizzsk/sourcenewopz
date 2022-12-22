package com.didi.payment.base.finResource;

import android.content.Context;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/payment/base/finResource/FinResourceRequest;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "service", "Lcom/didi/payment/base/finResource/FinResourceRequest$FinResourceRpcService;", "getService", "()Lcom/didi/payment/base/finResource/FinResourceRequest$FinResourceRpcService;", "setService", "(Lcom/didi/payment/base/finResource/FinResourceRequest$FinResourceRpcService;)V", "notifyRecord", "", "resourceId", "", "planId", "activityId", "type", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "FinResourceRpcService", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinResourceRequest.kt */
public final class FinResourceRequest {

    /* renamed from: a */
    private final Context f29901a;

    /* renamed from: b */
    private FinResourceRpcService f29902b;

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0001\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH'¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/base/finResource/FinResourceRequest$FinResourceRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "notifyRecord", "", "params", "", "", "body", "callBack", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: FinResourceRequest.kt */
    public interface FinResourceRpcService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/resource/record")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object notifyRecord(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<Object> callback);
    }

    public FinResourceRequest(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29901a = context;
        RpcService newRpcService = new RpcServiceFactory(context).newRpcService(FinResourceRpcService.class, "https://wallet.didiglobal.com");
        Intrinsics.checkNotNullExpressionValue(newRpcService, "RpcServiceFactory(contex…didiglobal.com\"\n        )");
        this.f29902b = (FinResourceRpcService) newRpcService;
    }

    public final Context getContext() {
        return this.f29901a;
    }

    public final FinResourceRpcService getService() {
        return this.f29902b;
    }

    public final void setService(FinResourceRpcService finResourceRpcService) {
        Intrinsics.checkNotNullParameter(finResourceRpcService, "<set-?>");
        this.f29902b = finResourceRpcService;
    }

    public static /* synthetic */ void notifyRecord$default(FinResourceRequest finResourceRequest, String str, String str2, String str3, String str4, RpcService.Callback callback, int i, Object obj) {
        String str5 = (i & 1) != 0 ? null : str;
        String str6 = (i & 2) != 0 ? null : str2;
        String str7 = (i & 4) != 0 ? null : str3;
        if ((i & 8) != 0) {
            str4 = "expose";
        }
        finResourceRequest.notifyRecord(str5, str6, str7, str4, callback);
    }

    public final void notifyRecord(String str, String str2, String str3, String str4, RpcService.Callback<Object> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put(InvitationPageActivity.RESOURCE_ID, str);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("planId", str2);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("activityId", str3);
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put("type", str4);
        this.f29902b.notifyRecord(PayBaseParamUtil.getHttpBaseParams(this.f29901a), linkedHashMap, callback);
    }
}
