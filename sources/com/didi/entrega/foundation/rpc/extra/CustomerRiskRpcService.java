package com.didi.entrega.foundation.rpc.extra;

import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH'¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/foundation/rpc/extra/CustomerRiskRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "uploadFacebookToken", "", "params", "Ljava/util/HashMap;", "", "", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerRiskRpcService.kt */
public interface CustomerRiskRpcService extends RpcService {
    @Path("shepherd/api/fb/risk")
    @Post
    @Deserialization(StringDeserializer.class)
    void uploadFacebookToken(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
