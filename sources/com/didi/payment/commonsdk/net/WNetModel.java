package com.didi.payment.commonsdk.net;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/net/WNetModel;", "T", "Lcom/didichuxing/foundation/rpc/RpcService;", "", "context", "Landroid/content/Context;", "javaClzz", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/Class;)V", "getContext", "()Landroid/content/Context;", "service", "getService", "()Lcom/didichuxing/foundation/rpc/RpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "transferService", "getTransferService", "getCommonParam", "Ljava/util/HashMap;", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WNetModel.kt */
public class WNetModel<T extends RpcService> {

    /* renamed from: a */
    private final Context f30164a;

    /* renamed from: b */
    private final T f30165b;

    /* renamed from: c */
    private final T f30166c;

    public WNetModel(Context context, Class<T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "javaClzz");
        this.f30164a = context;
        T newRpcService = new RpcServiceFactory(context).newRpcService(cls, "https://wallet.didiglobal.com");
        Intrinsics.checkNotNullExpressionValue(newRpcService, "RpcServiceFactory(contex…onst.Net.BASE_SERVER_URL)");
        this.f30165b = newRpcService;
        T newRpcService2 = new RpcServiceFactory(this.f30164a).newRpcService(cls, "https://wallet.didiglobal.com");
        Intrinsics.checkNotNullExpressionValue(newRpcService2, "RpcServiceFactory(contex…onst.Net.BASE_SERVER_URL)");
        this.f30166c = newRpcService2;
    }

    public final Context getContext() {
        return this.f30164a;
    }

    /* access modifiers changed from: protected */
    public final T getService() {
        return this.f30165b;
    }

    /* access modifiers changed from: protected */
    public final T getTransferService() {
        return this.f30166c;
    }

    /* access modifiers changed from: protected */
    public final HashMap<String, Object> getCommonParam(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap<String, Object> httpBaseParams = PayBaseParamUtil.getHttpBaseParams(context);
        Intrinsics.checkNotNullExpressionValue(httpBaseParams, "getHttpBaseParams(context)");
        return httpBaseParams;
    }
}
