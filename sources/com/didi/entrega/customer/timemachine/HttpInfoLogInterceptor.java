package com.didi.entrega.customer.timemachine;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcNetworkInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;

@ServiceProvider({RpcInterceptor.class})
public class HttpInfoLogInterceptor implements RpcNetworkInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f20237a = "TimeMachine";

    /* renamed from: b */
    private static final String f20238b = "didi-header-rid";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        String url = request.getUrl();
        if (!TimeMachineEngine.getInstance().checkEngineAvailable()) {
            return rpcChain.proceed(request);
        }
        if (!TmUtil.isIncludeString(url, TimeMachineEngine.getInstance().getTraceDomainList())) {
            return rpcChain.proceed(request);
        }
        String header = request.getHeader(f20238b);
        String str = "";
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create("sailing_c_x_api_traceID").addEventParam("traceID", header != null ? header : str);
        if (url != null) {
            str = url;
        }
        addEventParam.addEventParam("baseUrl", str).addEventParam("pageName", TimeMachineEngine.getInstance().getPageName()).build().track();
        LogUtil.m14761d(f20237a, "PAGE_NAME = " + TimeMachineEngine.getInstance().getPageName() + ", BASE_URL = " + url + ", TRACE_ID = " + header);
        return rpcChain.proceed(request);
    }
}
