package com.didi.component.safetoolkit.api;

import com.didi.component.common.model.SafeToolkitBean;
import com.didi.safetoolkit.net.SfGsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface SafeToolkitRequestService extends RpcService {
    @Get
    @Path("gulfstream/passenger/v2/other/pBubbleButton")
    @Deserialization(SfGsonDeserializer.class)
    void queryStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafeToolkitBean> callback);
}
