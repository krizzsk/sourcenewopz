package com.didichuxing.comp.telecom.core.request;

import com.didichuxing.comp.telecom.core.request.model.CallListResponse;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/RequestCallListService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "request", "", "p1", "", "", "", "p2", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallRequest.kt */
public interface RequestCallListService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/cc/voip/ext/session/getinfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    void request(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, RpcService.Callback<CallListResponse> callback);
}
