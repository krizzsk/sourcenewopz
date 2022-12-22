package com.didi.component.business.busyintercept;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@ServiceProvider({RpcInterceptor.class})
public class SystemBusyIntercept implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private static final String CANCEL_ORDER = "passenger/pCancelOrder";
    private static final String CANCEL_TRIP = "passenger/pCancelTrip";
    private static final String ERROR_JSON = "{\"errno\":\"596\",\"errmsg\":\"\"}";
    private static final String ESTIMATE = "core/pMultiEstimatePrice";
    private static final String NEW_ORDER = "passenger/pNewOrder";
    private String[] urls = {ESTIMATE, NEW_ORDER, "passenger/pCancelOrder", "passenger/pCancelTrip"};

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        if (!isNeedHandle(request)) {
            return rpcChain.proceed(request);
        }
        HttpRpcResponse proceed = rpcChain.proceed(request);
        if (proceed.getStatus() != 596) {
            return proceed;
        }
        final byte[] bytes = ERROR_JSON.getBytes();
        return proceed.newBuilder().setEntity((HttpEntity) new HttpBody() {
            public void close() throws IOException {
            }

            public MimeType getContentType() {
                return MimeType.parse("application/json; charset=utf-8");
            }

            public InputStream getContent() throws IOException {
                return new ByteArrayInputStream(bytes);
            }

            public long getContentLength() throws IOException {
                return (long) bytes.length;
            }
        }).build();
    }

    private boolean isNeedHandle(HttpRpcRequest httpRpcRequest) {
        String url = httpRpcRequest.getUrl();
        for (String contains : this.urls) {
            if (url.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
