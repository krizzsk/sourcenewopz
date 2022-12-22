package com.didiglobal.ddmirror.uichecker;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didiglobal.ddmirror.uichecker.model.UiConfig;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/HttpApi;", "Lcom/didichuxing/foundation/rpc/RpcService;", "getUiConfig", "", "querys", "", "", "", "params", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: HttpApi.kt */
public interface HttpApi extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/uiconfig")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    void getUiConfig(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread RpcService.Callback<UiConfig> callback);
}
