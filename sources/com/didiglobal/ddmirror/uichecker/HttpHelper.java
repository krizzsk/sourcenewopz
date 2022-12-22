package com.didiglobal.ddmirror.uichecker;

import android.content.Context;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didiglobal.ddmirror.uichecker.model.UiConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/HttpHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mHttpApi", "Lcom/didiglobal/ddmirror/uichecker/HttpApi;", "getUiConfig", "", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HttpHelper.kt */
public final class HttpHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DOMAIN = "http://127.0.0.1";
    private final HttpApi mHttpApi;

    public HttpHelper(Context context) {
        RpcService newRpcService = new RpcServiceFactory(context).newRpcService(HttpApi.class, DOMAIN);
        Intrinsics.checkExpressionValueIsNotNull(newRpcService, "rpcServiceFactory.newRpc…pApi::class.java, DOMAIN)");
        this.mHttpApi = (HttpApi) newRpcService;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/HttpHelper$Companion;", "", "()V", "DOMAIN", "", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: HttpHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void getUiConfig(RpcService.Callback<UiConfig> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map hashMap = new HashMap(3);
        this.mHttpApi.getUiConfig(hashMap, hashMap, callback);
    }
}
